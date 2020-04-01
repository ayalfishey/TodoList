package com.ayal.todo;

import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodoListFragment extends Fragment {

    private TextView todoName, todoDescription;
    private RadioGroup status;
    private Progress progress;

    public TodoListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        todoName = view.findViewById(R.id.task_frag_name);
        todoDescription = view.findViewById(R.id.task_frag_description);
        status = view.findViewById(R.id.status);
        status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.todo_status:
                        progress = Progress.TODO;
                        break;
                    case R.id.in_progress_status:
                        progress = Progress.IN_PROGRESS;
                        break;
                    case R.id.done_status:
                        progress = Progress.DONE;
                        break;
                }
                if(getContext() instanceof HandleTodoFragment){
                    ((HandleTodoFragment)getContext()).updateProgress(progress , todoName.getText().toString());
                }
            }
        });

    }

    public void updateData(Todo todo) {
        if (getView() == null) return;
        todoName.setText(todo.getTodoName());
        todoDescription.setText(todo.getDescription());
        @IdRes int id = 0;
        switch (todo.getProgress()) {
            case TODO:
                id = R.id.todo_status;
                break;
            case IN_PROGRESS:
                id = R.id.in_progress_status;
                break;
            case DONE:
                id = R.id.done_status;
                break;
        }
        status.check(id);
    }
}
