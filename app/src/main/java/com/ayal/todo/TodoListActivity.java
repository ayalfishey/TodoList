package com.ayal.todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TodoListActivity extends AppCompatActivity{

    final int R_ID = 23588;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        FloatingActionButton add = bindButton((FloatingActionButton)findViewById(R.id.addTask));
    }

    private void setViews(){
        recyclerView = findViewById(R.id.recycle_container);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        TodoAdapter adapter = new TodoAdapter();
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
}
