package com.app.project_5.model;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4),
    CRITICAL(5);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Priority fromValue(int value) {
        for (Priority p : Priority.values()) {
            if (p.getValue() == value) {
                return p;
            }
        }
        return MEDIUM;
    }
}