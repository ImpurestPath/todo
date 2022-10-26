package com.example.demo;

import java.util.Objects;
import java.util.UUID;

public class TodoItem {

    UUID id;
    String name;
    String description;
    Boolean done;


    public TodoItem(UUID id, String name, String description, Boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(name, todoItem.name) && Objects.equals(description, todoItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "com.example.demo.TodoItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
