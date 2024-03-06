package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.adapter.TodoListAdapter;
import com.example.myapplication.bean.Todo;
import com.example.myapplication.entity.TodoEntity;
import com.example.myapplication.fragment.MyDiaglogFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MyDayActivity_HOME extends AppCompatActivity {
    private RecyclerView todoRecyclerView;
    private TodoListAdapter todoListAdapter;
    private List<Todo> todoList = new ArrayList<Todo>();
    ;
    TextView tv_input;

    String enteredText;


    BottomSheetDialog bottomSheetDialog;

    MyDiaglogFragment myDiaglogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_day_home);

        todoListAdapter = new TodoListAdapter(todoList, this);

        todoRecyclerView = findViewById(R.id.myday_recyclerview);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        todoRecyclerView.setAdapter(todoListAdapter);
        registerForContextMenu(todoRecyclerView);

        tv_input = findViewById(R.id.myday_tv_input);
        tv_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDiaglogFragment = new MyDiaglogFragment();
                myDiaglogFragment.show(getSupportFragmentManager(), "MyDialogFragment");
            }
        });

    }


    private void showDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View diaglogView = inflater.inflate(R.layout.fragment_my_day_diaglog, null);
        final EditText editText = diaglogView.findViewById(R.id.dialog_edit_text);

        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(diaglogView);
        dialog.show();

        editText.postDelayed(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 100);

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                enteredText = editText.getText().toString();
            }
        });
        editText.setText(enteredText);
    }


    private void convertTodoEntity(List<TodoEntity> todoEntities) {
        if (todoEntities == null) {
            return;
        }
        todoList.clear();
        for (TodoEntity todoEntity : todoEntities) {
            Todo todo = new Todo();
            todo.setId("" + todoEntity.getId());
            todo.setName(todoEntity.getName());
            todoList.add(todo);
        }
    }
}