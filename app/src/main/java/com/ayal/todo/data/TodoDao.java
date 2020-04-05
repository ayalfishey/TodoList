package com.ayal.todo.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.ayal.todo.classes.Todo;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAll();

//    @Query("SELECT * FROM todo WHERE id = :todoId")
//    void getTodoById(int todoId);

    @Insert(onConflict = REPLACE)
    void insertAll(ArrayList<Todo> todos);

    @Delete
    void remove(Todo todo);
}
