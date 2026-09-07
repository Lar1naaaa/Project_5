package com.app.project_5.dao;

import com.app.project_5.model.Project;
import com.app.project_5.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private Connection connection;

    public ProjectDAO(Connection connection) {
        this.connection = connection;
    }

    // Длинный метод со смешением логики и N+1 проблемой
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            // Ошибка оптимизации: нет пагинации, тянет всё подряд
            ResultSet rs = statement.executeQuery("SELECT * FROM projects");

            while (rs.next()) {
                int id = rs.getInt("project_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int priority = rs.getInt("priority");

                // ОШИБКА N+1: Для КАЖДОГО проекта делается отдельный запрос в БД за задачами внутри цикла!
                List<Task> tasks = new ArrayList<>();
                Statement taskStmt = connection.createStatement();
                // Ошибка оптимизации: Конкатенация строк в SQL (SQL-инъекция)
                ResultSet taskRs = taskStmt.executeQuery("SELECT * FROM tasks WHERE project_id = " + id);

                while (taskRs.next()) {
                    tasks.add(new Task(
                            taskRs.getInt("id"),
                            taskRs.getInt("project_id"),
                            taskRs.getString("title"),
                            taskRs.getString("description"),
                            taskRs.getInt("status"),
                            taskRs.getInt("priority")
                    ));
                }

                projects.add(new Project(id, name, description, priority, tasks));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Пустой обработчик исключений
        }
        return projects;
    }

    // Ошибка оптимизации: SQL-инъекция через конкатенацию строк
    public void addProject(String name, String description, int priority) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO projects (name, description, priority) VALUES ('" + name + "', '" + description + "', " + priority + ")";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}