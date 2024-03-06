package com.example.myapplication.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.myapplication.converter.DateConverter;
import com.example.myapplication.entity.TodoEntity;

@Database(entities = {TodoEntity.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class TodoRoomDatabase extends RoomDatabase {
    public abstract TodoDAO todoDAO();
    private static TodoRoomDatabase INSTANCE = null;
    public static TodoRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TodoRoomDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TodoRoomDatabase.class, "TODO_LIST")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .enableMultiInstanceInvalidation()
                        .build();
            }
        }
        return INSTANCE;
    }
}