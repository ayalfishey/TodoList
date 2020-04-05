package com.ayal.todo.classes;

import com.ayal.todo.data.Progress;

public interface HandleTodoFragment {
    public void handleTodoFragment(Todo todo);
    public void updateProgress(Progress progress, String todoName);
}
