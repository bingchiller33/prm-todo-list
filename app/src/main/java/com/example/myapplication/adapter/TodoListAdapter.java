package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Todo;
import com.example.myapplication.entity.TodoEntity;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {
    // ...

    private Context context;
    private List<Todo> todoList;

    public TodoListAdapter(List<Todo> todoList, Context context) {
        this.context = context;
        this.todoList = todoList;
    }

    private int position;


    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.todo_list_item, parent, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.todoTextView.setText(todo.getName());
        // Assuming you have a method isChecked in your todo model
//        holder.todoCheckBox.setChecked(todo.isCompleted());
        this.position = position;
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView todoTextView;
//        public CheckBox todoCheckBox;

        public TodoViewHolder(View itemView) {
            super(itemView);
//            todoCheckBox = itemView.findViewById(R.id.todoCheckBox);
            todoTextView = itemView.findViewById(R.id.todo_tv_name);
        }
    }
}