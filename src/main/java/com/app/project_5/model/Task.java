package com.app.project_5.model;

import java.util.List;

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

//    public String getTitle() {
//        return title;
//    }
//
//    public Priority getPriority() {
//        return this.priority
//    }

//    public boolean isCompleted() {
//
//    }
//
//    public long getDurationMinutes() {
//    }
//
//    public <E> List<E> idProperty() {
//    }
}