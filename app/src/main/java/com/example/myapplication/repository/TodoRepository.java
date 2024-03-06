package com.example.myapplication.repository;

import android.content.Context;

import com.example.myapplication.dao.TodoDAO;
import com.example.myapplication.dao.TodoRoomDatabase;
import com.example.myapplication.entity.TodoEntity;

import java.util.List;

public class TodoRepository {
    private TodoDAO todoDAO = null;
    public TodoRepository(Context context) {
        TodoRoomDatabase todoRoomDatabase = TodoRoomDatabase.getInstance(context);
        todoDAO = todoRoomDatabase.todoDAO();
    }

    public void createTodo(TodoEntity todo) {
        todoDAO.insert(todo);
    }

    public TodoEntity getTodo(int id) {
        return todoDAO.select(id);
    }

    public List<TodoEntity> getAllTodo() {
        return todoDAO.selectAll();
    }

    public void deleteTodo(int id) {
        todoDAO.delete(id);
    }
}