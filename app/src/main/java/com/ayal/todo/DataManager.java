package com.ayal.todo;

import java.util.ArrayList;

public class DataManager {
    private static ArrayList<Todo> todos = new ArrayList<>();

    public static void addToList(Todo task){
        todos.add(task);
    }

    public static ArrayList<Todo> getTodos() {
        return todos;
    }
}
