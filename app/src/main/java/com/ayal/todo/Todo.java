package com.ayal.todo;

public class Todo {
    private String todo, description;
    private Progress progress;

    public Todo(String todo) {
        this.todo = todo;
        progress = Progress.TODO;
    }

    public Todo(String todo, String description) {
        this.todo = todo;
        this.description = description;
        progress = Progress.TODO;
    }

    public String getTodoName() {
        return todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Progress getProgress() {
        return progress;
    }
}
