package com.ei.astronautschedule.factory;

import com.ei.astronautschedule.model.Task;

public class TaskFactory {

    // Static factory method to create a new Task
    public static Task createTask(String description, String startTime, String endTime, String priority) {
        // You can add validation here if needed
        return new Task(description, startTime, endTime, priority);
    }
}

