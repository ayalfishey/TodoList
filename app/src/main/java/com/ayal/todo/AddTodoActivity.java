package com.ayal.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskET = findViewById(R.id.taskET);
                Todo todo = new Todo(taskET.getText().toString());
                DataManager.addToList(todo);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
