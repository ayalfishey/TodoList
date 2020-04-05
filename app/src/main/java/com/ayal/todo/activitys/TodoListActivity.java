package com.ayal.todo.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ayal.todo.data.DataManager;
import com.ayal.todo.classes.HandleTodoFragment;
import com.ayal.todo.data.Progress;
import com.ayal.todo.R;
import com.ayal.todo.classes.Todo;
import com.ayal.todo.views.TodoAdapter;
import com.ayal.todo.fragments.TodoListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TodoListActivity extends AppCompatActivity implements HandleTodoFragment {

    final int R_ID = 23588;
    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        recyclerView = findViewById(R.id.recycle_container);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        FloatingActionButton add = bindButton((FloatingActionButton)findViewById(R.id.addTask));
        DataManager.addToList(new Todo("adhi", "this is a test description"));
        DataManager.addToList(new Todo("sdghn", "trestgrsg"));
        DataManager.addToList(new Todo("43yhs", "rhgiamjnfdh"));
        setViews();
    }

    private void setViews(){
        adapter = new TodoAdapter();
        recyclerView.setAdapter(adapter);

    }

    private FloatingActionButton bindButton (FloatingActionButton button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TodoListActivity.this, AddTodoActivity.class);
                startActivityForResult(intent , R_ID);
            }
        });
        return button;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            setViews();
        }
    }
    @Override
    public void handleTodoFragment(Todo todo){
        TodoListFragment fragment = (TodoListFragment) getSupportFragmentManager().findFragmentByTag("Todo");
        if(fragment == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            Bundle b = new Bundle();
            b.putString("todoName",todo.getTodoName());
            fragment = TodoListFragment.newInstance(b);
            transaction.add(R.id.frag_container, fragment, "Todo");
            transaction.addToBackStack("frag");
            transaction.commit();
        }
        fragment.updateData(todo);
    }

    @Override
    public void updateProgress(Progress progress, String todoName) {
        Todo todo;
        ArrayList<Todo> todos = DataManager.getTodos();
        for (int i = 0; i < DataManager.getTodos().size() ; i++) {
            if(todos.get(i).getTodoName().equals( todoName)){
                todo = todos.get(i);
                todo.setProgress(progress);
                DataManager.setTodo(i , todo);
                adapter.setTasks(DataManager.getTodos());
                return;
            }
        }
    }
}
