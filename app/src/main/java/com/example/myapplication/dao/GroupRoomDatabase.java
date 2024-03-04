package com.example.myapplication.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.myapplication.converter.DateConverter;
import com.example.myapplication.entity.GroupEntity;

@Database(entities = {GroupEntity.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class GroupRoomDatabase extends RoomDatabase {
    public abstract GroupDAO groupDAO();
    private static GroupRoomDatabase INSTANCE = null;

    public static GroupRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, GroupRoomDatabase.class, "TODO_LIST")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
