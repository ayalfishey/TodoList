package com.ayal.todo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    ArrayList<Todo> tasks;
    ViewGroup parent;
    TodoAdapter() {
        tasks = DataManager.getTodos();
    }

    public void setTasks(ArrayList<Todo> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_cell, parent, false);
        this.parent = parent;
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoViewHolder holder, final int position) {
        holder.task.setText(tasks.get(position).getTodoName());
        setTaskColor(position, holder);
        holder.task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HandleTodoFragment)v.getContext()).handleTodoFragment(tasks.get(position));

            }
        });
    }

    public void setTaskColor(int position , TodoViewHolder holder) {
        switch (tasks.get(position).getProgress()){
            case TODO:
                holder.task.setBackgroundColor(Color.RED);
                break;
            case IN_PROGRESS:
                holder.task.setBackgroundColor(Color.YELLOW);
                break;
            case DONE:
                holder.task.setBackgroundColor(Color.GREEN);
                break;
        }
    }
/*
    private void applyProgress(int position) {
        if(position%3 ==2) {
            tasks.get(position).setProgress(Progress.TODO);
        }else if (position%3 == 1) {
            tasks.get(position).setProgress(Progress.IN_PROGRESS);
        } else if (position%3 == 0) {
            tasks.get(position).setProgress(Progress.DONE);
        }
    }*/


    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView task;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.taskTV);
        }
    }
}

