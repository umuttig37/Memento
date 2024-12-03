package com.example.demo;

import java.time.LocalDateTime;

public class Memento {
    private final String color;
    private final boolean checkboxState;
    private final LocalDateTime timestamp;

    public Memento(String color, boolean checkboxState) {
        this.color = color;
        this.checkboxState = checkboxState;
        this.timestamp = LocalDateTime.now();
    }

    public String getColor() {
        return color;
    }

    public boolean isCheckboxState() {
        return checkboxState;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return "Color: " + color + " | Checkbox: " + checkboxState;
    }
}

