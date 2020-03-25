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
    Context context;
    TodoAdapter() {
        tasks = DataManager.getTodos();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_cell, parent, false);
        this.parent = parent;
        context = parent.getContext();
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoViewHolder holder, final int position) {
        holder.task.setText(tasks.get(position).getTodo());
        setTaskColor(position, holder);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch (pos) {
                    case 0:
                        tasks.get(position).setProgress(Progress.TODO);
                        break;
                    case 1:
                        tasks.get(position).setProgress(Progress.IN_PROGRESS);
                        break;
                    case 2:
                        tasks.get(position).setProgress(Progress.DONE);
                        break;
                }
                setTaskColor(position, holder);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                setTaskColor(position, holder);
            }
        });
        holder.task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((TodoListActivity)context).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                TodoListFragment fragment = new TodoListFragment();
                transaction.replace(R.id.frag_container, fragment);
                transaction.commit();

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
        Spinner spinner;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.taskTV);
            spinner = itemView.findViewById(R.id.spinner);
        }
    }
}

