package com.example.prj_12feb_tablelayout.Model;

import android.graphics.Color;

import androidx.annotation.NonNull;

public class Task {
    private int taskId;
    private String taskDescription;
    private int taskColor;

    public Task(int taskId, String taskDescription, int taskColor) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskColor = taskColor;
    }

    public Task(int taskId, String taskDescription) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskColor = Color.BLACK;
    }

    @NonNull
    @Override
    public String toString() {
        return taskDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskColor() {
        return taskColor;
    }

    public void setTaskColor(int taskColor) {
        this.taskColor = taskColor;
    }
}
