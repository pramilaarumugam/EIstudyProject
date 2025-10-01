package com.ei.astronautschedule.observer;

import com.ei.astronautschedule.model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskNotifier {
    private List<TaskObserver> observers = new ArrayList<>();

    // Subscribe an observer
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    // Notify all observers
    public void notify(Task task, String message) {
        for (TaskObserver observer : observers) {
            observer.onTaskAdded(task, message);
        }
    }
}

