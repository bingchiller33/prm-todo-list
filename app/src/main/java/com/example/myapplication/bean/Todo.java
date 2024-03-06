package com.example.myapplication.bean;

import java.util.Date;

public class Todo {
    private String id;
    private String name;
    private boolean completed;
    private Date date;

    public Todo() {
    }

    public Todo(String id, String name, boolean completed, Date date) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
