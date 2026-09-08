package com.app.project_5.dao;

import com.app.project_5.model.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private final Connection connection;

    // Конструктор принимает открытое соединение из класса Database
    public TaskDAO(Connection connection) {
        this.connection = connection;
    }

    // Метод сохранения задачи
    public void saveTask(Task task, int projectId) throws SQLException {
        // Добавили описание (description) и статус (status) из вашей модели
        String sql = "INSERT INTO tasks (title, priority, project_id, description, status) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setInt(2, task.getPriority());    // Передаем int напрямую
            pstmt.setInt(3, projectId);
            pstmt.setString(4, task.getDescription());
            pstmt.setInt(5, task.getStatus());

            pstmt.executeUpdate();

            // Получаем сгенерированный базой данных ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    // Обновляем ID в JavaFX свойстве объекта Task
                    task.idProperty().set(rs.getInt(1));
                }
            }
        }
    }

    // Метод получения списка задач по ID проекта
    public List<Task> getTasksByProjectId(int projectId) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT id, project_id, title, description, status, priority FROM tasks WHERE project_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, projectId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Создаем объект Task, используя данные из колонок таблицы MySQL
                    Task task = new Task(
                            rs.getInt("id"),
                            rs.getInt("project_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getInt("status"),
                            rs.getInt("priority")
                    );
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }
}
