package com.ayal.todo.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.ayal.todo.R;
import com.ayal.todo.classes.HandleTodoFragment;
import com.ayal.todo.classes.Todo;

/**
 * TODO: document your custom view class.
 */
public class TaskCell extends LinearLayout {

    private TextView taskNameTV;

    public TaskCell(Context context) {
        super(context);
        init();
    }

    public TaskCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TaskCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TaskCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        ((LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.task_cell, this, true);
        taskNameTV = findViewById(R.id.taskTV);
    }

    public void setTaskInfo(final Todo task){
        taskNameTV.setText(task.getTodoName());
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((HandleTodoFragment)v.getContext()).handleTodoFragment(task);

            }
        });
        switch (task.getProgress()){
            case TODO:
                taskNameTV.setBackgroundColor(Color.RED);
                break;
            case IN_PROGRESS:
                taskNameTV.setBackgroundColor(Color.YELLOW);
                break;
            case DONE:
                taskNameTV.setBackgroundColor(Color.GREEN);
                break;
        }
    }
    public TextView getTextView(){
        return taskNameTV;
    }
}
