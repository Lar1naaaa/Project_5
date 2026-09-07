package com.app.project_5.model;

import java.util.List;

public class Project {
    // Ошибка рефакторинга: публичные поля вместо private и геттеров/сеттеров
    public int id;
    public String name;
    public String description;
    public int priority;
    public List<Task> tasks;

    // Длинный список параметров конструктора (6 параметров вместе с списком)
    public Project(int id, String name, String description, int priority, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.tasks = tasks;
    }
}