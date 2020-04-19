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
import android.widget.Button;
import android.widget.TextView;

import com.ayal.todo.data.DataManager;
import com.ayal.todo.classes.HandleTodoFragment;
import com.ayal.todo.data.Progress;
import com.ayal.todo.R;
import com.ayal.todo.classes.Todo;
import com.ayal.todo.views.TodoAdapter;
import com.ayal.todo.fragments.TodoListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TodoListActivity extends AppCompatActivity implements HandleTodoFragment {

    final int R_ID = 23588;
    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private FloatingActionButton add;
    private Button todoFilterBtn,inProgressFilterBtn, doneFilterBtn;
    private TextView headline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        add = findViewById(R.id.addTask);
        todoFilterBtn = findViewById(R.id.todo_btn);
        inProgressFilterBtn = findViewById(R.id.in_progress_btn);
        doneFilterBtn = findViewById(R.id.done_btn);
        headline = findViewById(R.id.headline);
        bindClickListeners();
        initRecycler();


    }

    private void initRecycler(){
        recyclerView = findViewById(R.id.recycle_container);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new TodoAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void bindClickListeners(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TodoListActivity.this, AddTodoActivity.class);
                startActivityForResult(intent , R_ID);
            }
        });
        todoFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setTasks(DataManager.getTodos(Progress.TODO));
            }
        });
        inProgressFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setTasks(DataManager.getTodos(Progress.IN_PROGRESS));
            }
        });
        doneFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setTasks(DataManager.getTodos(Progress.DONE));
            }
        });
        headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setTasks(DataManager.getTodoList());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            adapter.setTasks(DataManager.getTodoList());
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
        ArrayList<Todo> todos = DataManager.getTodoList();
        for (int i = 0; i < DataManager.getTodoList().size() ; i++) {
            if(todos.get(i).getTodoName().equals( todoName)){
                todo = todos.get(i);
                todo.setProgress(progress);
                DataManager.setTodo(i , todo);
                adapter.setTasks(DataManager.getTodoList());
                return;
            }
        }
    }
}
