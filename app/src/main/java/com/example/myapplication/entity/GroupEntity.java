package com.example.myapplication.entity;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class GroupEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "id")
    protected int id;
    @ColumnInfo(name = "group_name", index = true)
    @Nullable
    private String name;
    @ColumnInfo(name = "status")
    @Nullable
    private String status;
    @ColumnInfo(name = "createdAt")
    private Date createdAt;
    @ColumnInfo(name = "updateddAt")
    private Date updatedAt;
    @ColumnInfo(name="userId")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    @Nullable
    public String getStatus() {
        return status;
    }

    public void setStatus(@Nullable String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}