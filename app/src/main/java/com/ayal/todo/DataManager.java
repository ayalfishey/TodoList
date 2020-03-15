package com.ayal.todo;

import java.util.ArrayList;

public class DataManager {
    private static ArrayList<ToDo> toDos = new ArrayList<>();

    public static void AddToList(ToDo task){
        toDos.add(task);
    }

    public static ArrayList<ToDo> getToDos() {
        return toDos;
    }
}
