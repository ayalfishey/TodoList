package com.ayal.todo.data;

import com.ayal.todo.classes.Todo;

import java.util.ArrayList;

public class DataManager {
    private static ArrayList<Todo> todos = new ArrayList<>();

    public static void addToList(Todo task){
        todos.add(task);
    }

    public static ArrayList<Todo> getTodos() {
        return todos;
    }

    public static Todo getTodoByName(String name){
        for (Todo todo: todos) {
            if (todo.getTodoName() == name)
                return todo;
        }
        return null;
    }
}

