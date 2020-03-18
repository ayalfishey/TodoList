package com.ayal.todo;

public class Todo {
    private String todo;
    private Progress progress;

    public Todo(String todo) {
        this.todo = todo;
        progress = Progress.TODO;
    }

    public String getTodo() {
        return todo;
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
