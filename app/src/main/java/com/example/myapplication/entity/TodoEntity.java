package com.example.myapplication.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.Nullable;

import java.util.Date;

@Entity
public class TodoEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "Todo_ID")
    private int id;

    @ColumnInfo(name = "Todo_Name", index = true)
    @Nullable
    private String name;

    @ColumnInfo(name = "Todo_Completed", defaultValue = "false")
    private boolean completed;

    @ColumnInfo(name = "Todo_Date")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoEntity(int id, @Nullable String name, boolean completed, Date date) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public TodoEntity() {
    }

    public void setDate(Date date) {
        this.date = date;
    }


}