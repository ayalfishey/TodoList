package com.ayal.todo.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ayal.todo.classes.Todo;

@Database(entities = {Todo.class}, version = 3)
public abstract class TodoDaoDatabase extends RoomDatabase {
    public abstract TodoDao getTodoDao();
}
