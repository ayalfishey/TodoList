package com.ayal.todo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    ArrayList<Todo> tasks;

    TodoAdapter(){
        tasks = DataManager.getTodos();
    }
    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_cell, parent , false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.task.setText(tasks.get(position).getTodo());
        if(position%3 ==2) {
            tasks.get(position).setProgress(Progress.TODO);
        }else if (position%3 == 1) {
            tasks.get(position).setProgress(Progress.IN_PROGRESS);
        } else if (position%3 == 0) {
            tasks.get(position).setProgress(Progress.DONE);
        }
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

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder{
        TextView task;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            task = itemView.findViewById(R.id.taskTV);
        }
    }
}

