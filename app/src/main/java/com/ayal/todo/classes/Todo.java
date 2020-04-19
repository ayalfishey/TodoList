package com.ayal.todo.classes;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ayal.todo.data.Progress;
import com.ayal.todo.data.converters.DateConverter;
import com.ayal.todo.data.converters.ProgressConverter;

import java.util.Date;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@Entity //(tableName = "something")
@TypeConverters({ProgressConverter.class, DateConverter.class})
public class Todo {
    public String getTodo() {
        return todo;
    }



    @PrimaryKey(autoGenerate = true)
    private int id;

    private Date taskDate;
    private String todo;
    private String description;
    private Progress progress;

    @Ignore
    public Todo(String todo) {
        this.todo = todo;
        progress = Progress.TODO;
    }


    public Todo(String todo, String description) {
        this.todo = todo;
        this.description = description;
        progress = Progress.TODO;
        taskDate = new Date();
    }

//    private void setProgressById() {
//        switch (progressId) {
//            case 0:
//                progress = Progress.TODO;
//                break;
//            case 1:
//                progress = Progress.IN_PROGRESS;
//                break;
//            case 2:
//                progress = Progress.DONE;
//                break;
//        }
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
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
