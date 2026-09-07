package com.app.project_5.model;

public class Task {
    // Публичные поля класса
    public int id;
    public int projectId;
    public String title;
    public String description;
    public int status;
    public int priority;

    public Task(int id, int projectId, String title, String description, int status, int priority) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }
}