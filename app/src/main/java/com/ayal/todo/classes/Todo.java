package com.ayal.todo.classes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.ayal.todo.data.Progress;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@Entity
public class Todo {
    public String getTodo() {
        return todo;
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    @PrimaryKey
    @NonNull private String todo;
    @NonNull private String description;
    private int progressId;
    @Ignore
    private Progress progress;

    @Ignore
    public Todo(String todo) {
        this.todo = todo;
        progress = Progress.TODO;
        setProgressId();
    }
    @Ignore
    public Todo(String todo, String description) {
        this.todo = todo;
        this.description = description;
        progress = Progress.TODO;
        setProgressId();
    }

    public Todo(String todo, String description, int progressId) {
        this.todo = todo;
        this.description = description;
        this.progressId = progressId;
        setProgressById();
    }

    private void setProgressById(){
        switch (progressId) {
            case 0:
                progress = Progress.TODO;
                break;
            case 1:
                progress = Progress.IN_PROGRESS;
                break;
            case 2:
                progress = Progress.DONE;
                break;
        }
    }

    private void setProgressId(){
        switch (progress) {
            case TODO:
                progressId = 0;
                break;
            case IN_PROGRESS:
                progressId = 1;
                break;
            case DONE:
                progressId = 2;
                break;
        }
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
        setProgressId();
    }

    public Progress getProgress() {
        return progress;
    }

    public static int getProgressId(Progress progress){
        switch (progress) {
            case TODO:
                return 0;
            case IN_PROGRESS:
                return 1;
            case DONE:
                return 2;
        }
        return -1;
    }
}
