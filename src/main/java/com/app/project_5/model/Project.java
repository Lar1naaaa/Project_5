package com.app.project_5.model;

import java.util.List;

public class Project {
    // Ошибка рефакторинга: публичные поля (нарушение инкапсуляции)
    public int id;
    public String name;
    public String description;
    public int priority; // Магическое число
    public List<Task> tasks;

    // Ошибка рефакторинга: длинный список параметров в конструкторе
    public Project(int id, String name, String description, int priority, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.tasks = tasks;
    }
}