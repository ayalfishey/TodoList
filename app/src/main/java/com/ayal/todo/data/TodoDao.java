package com.ayal.todo.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ayal.todo.classes.Todo;

import java.util.ArrayList;
import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Query("SELECT * FROM todo WHERE progress = :progressId")
    List<Todo> getTodoByProgress(int progressId);

    @Insert(onConflict = REPLACE)
    void insertAll(ArrayList<Todo> todos);

    @Update
    void updateTask(int taskId);

    @Delete
    void remove(Todo todo);
}
