package com.ayal.todo.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayal.todo.data.DataManager;
import com.ayal.todo.R;
import com.ayal.todo.classes.Todo;

public class AddTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(AddTodoActivity.this);
                alert.setTitle("Are you sure?");
                alert.setMessage("Do you want to add this task to your list?");
                alert.setCancelable(false);
                alert.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText taskET = findViewById(R.id.taskET);
                        EditText descriptionET = findViewById(R.id.descriptionET);
                        Todo todo = new Todo(taskET.getText().toString(), descriptionET.getText().toString());
                        DataManager.addToList(todo);
                        setResult(RESULT_OK);
                        finish();
                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AddTodoActivity.this, "Canceled",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });
    }
}
