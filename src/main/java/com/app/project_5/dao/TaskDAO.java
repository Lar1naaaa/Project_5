package com.app.project_5.dao;

import com.app.project_5.model.Task;
import com.app.project_5.model.Priority;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private final Connection connection;

    public TaskDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveTask(Task task, long projectId) throws SQLException {
        String sql = "INSERT INTO tasks (title, priority, completed, duration_minutes, project_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setInt(2, task.getPriority().getValue());
            pstmt.setBoolean(3, task.isCompleted());
            pstmt.setLong(4, task.getDurationMinutes());
            pstmt.setLong(5, projectId);
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    task.idProperty().set(rs.getLong(1));
                }
            }
        }
    }

    public List<Task> getTasksByProjectId(long projectId) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT id, title, priority, completed, duration_minutes FROM tasks WHERE project_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setLong(1, projectId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    tasks.add(new Task(
                            rs.getLong("id"),
                            rs.getString("title"),
                            Priority.fromValue(rs.getInt("priority")),
                            rs.getBoolean("completed"),
                            rs.getLong("duration_minutes")
                    ));
                }
            }
        }
        return tasks;
    }
}