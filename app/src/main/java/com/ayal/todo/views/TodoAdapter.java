package com.ayal.todo.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayal.todo.R;
import com.ayal.todo.data.DataManager;
import com.ayal.todo.classes.Todo;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    ArrayList<Todo> tasks;
    ViewGroup parent;
    public TodoAdapter() {
        tasks = DataManager.getTodos();
    }

    public void setTasks(ArrayList<Todo> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_layout, parent, false);
        this.parent = parent;
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoViewHolder holder, final int position) {
        holder.taskCell.setTaskInfo(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    public class TodoViewHolder extends RecyclerView.ViewHolder {
        TaskCell taskCell;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            taskCell = itemView.findViewById(R.id.todo_list_layout);
        }
    }
}

