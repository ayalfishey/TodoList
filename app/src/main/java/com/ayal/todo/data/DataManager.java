package com.ayal.todo.data;

import androidx.room.Room;

import com.ayal.todo.classes.Todo;

import java.util.ArrayList;

public class DataManager {
    private static TodoDaoDatabase db = Room.databaseBuilder(DatabaseInit.getContext(),TodoDaoDatabase.class, "todo-db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build();

    private static ArrayList<Todo> todos;

    public static void addToList(Todo task){

        todos = new ArrayList<Todo>(db.getTodoDao().getAll());
        todos.add(task);
        db.getTodoDao().insertAll(todos);
    }

    public static ArrayList<Todo> getTodos() {
        return new ArrayList<Todo>(db.getTodoDao().getAll());
    }

    public static void setTodo(int pos , Todo todo){
        todos = new ArrayList<Todo>(db.getTodoDao().getAll());
        todos.set(pos , todo);
        db.getTodoDao().insertAll(todos);
    }

    public static Todo getTodoByName(String name){
        todos = new ArrayList<Todo>(db.getTodoDao().getAll());

        for (Todo todo: todos) {
            if (todo.getTodoName().equals(name))
                return todo;
        }
        return null;
    }
}

