package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.entity.TodoEntity;

import java.util.List;

@Dao
public interface TodoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TodoEntity todo);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TodoEntity... todoEntities);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(TodoEntity todo);

    @Delete
    void delete(TodoEntity todo);

    @Query("DELETE FROM TodoEntity WHERE TodoEntity.Todo_ID =:todoId")
    void delete(int todoId);

    @Query("SELECT * FROM TodoEntity T WHERE T.Todo_ID =:id")
    TodoEntity select(int id);

    @Query("SELECT * FROM TodoEntity")
    List<TodoEntity> selectAll();
}