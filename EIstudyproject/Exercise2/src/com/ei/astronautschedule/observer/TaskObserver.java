package com.ei.astronautschedule.observer;

import com.ei.astronautschedule.model.Task;

public interface TaskObserver {
    void onTaskAdded(Task task, String message);
}
