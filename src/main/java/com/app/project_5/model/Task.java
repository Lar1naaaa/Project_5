package com.app.project_5.model;

public class Task {
    // Ошибка рефакторинга: публичные поля вместо инкапсуляции
    public int id;
    public int projectId;
    public String title;
    public String description;
    public int status; // Магическое число (например, 1 - новая, 2 - в работе...)
    public int priority; // Магическое число (1-5)

    // Ошибка рефакторинга: длинный список параметров в конструкторе (6 параметров)
    public Task(int id, int projectId, String title, String description, int status, int priority) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }
}