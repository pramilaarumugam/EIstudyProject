package com.ei.astronautschedule.manager;

import com.ei.astronautschedule.model.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ScheduleManager {

    // Singleton instance
    private static ScheduleManager instance;

    // List to store tasks
    private List<Task> tasks;

    // Private constructor
    private ScheduleManager() {
        tasks = new ArrayList<>();
    }
    

// inside ScheduleManager class
private boolean isValidTime(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    try {
        LocalTime.parse(time, formatter);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}


    // Public method to get the singleton instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Add a task
    public Task addTask(Task task) {
    // Validate time
    if (!isValidTime(task.getStartTime()) || !isValidTime(task.getEndTime())) {
        return null; // Invalid time
    }

    Task conflict = getOverlappingTask(task);
    if (conflict != null) {
        return conflict; // Return the conflicting task
    }

    tasks.add(task);
    return task; // Successfully added
}


    // Remove a task by description
    public boolean removeTask(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(t);
                return true;
            }
        }
        return false; // Task not found
    }

    // View all tasks sorted by start time
    public List<Task> viewTasks() {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        Collections.sort(sortedTasks, Comparator.comparing(Task::getStartTime));
        return sortedTasks;
    }

    // Check if a new task overlaps with existing tasks
   // Returns the conflicting task if any, otherwise null
   private Task getOverlappingTask(Task newTask) {
    for (Task t : tasks) {
        if (!(newTask.getEndTime().compareTo(t.getStartTime()) <= 0 ||
              newTask.getStartTime().compareTo(t.getEndTime()) >= 0)) {
            return t; // Found overlapping task
        }
    }
    return null;
}
public boolean editTask(String existingDesc, String newDesc, String newStart, String newEnd, String newPriority) {
    Task taskToEdit = null;

    // Find the task
    for (Task t : tasks) {
        if (t.getDescription().equalsIgnoreCase(existingDesc)) {
            taskToEdit = t;
            break;
        }
    }

    if (taskToEdit == null) return false; // Task not found

    // Validate new times
    if (!isValidTime(newStart) || !isValidTime(newEnd)) return false;

    // Create a temporary task for overlap check
    Task tempTask = new Task(newDesc, newStart, newEnd, newPriority);

    Task conflict = getOverlappingTask(tempTask);
    if (conflict != null && conflict != taskToEdit) return false; // Conflict with another task

    // Update task
    taskToEdit.setDescription(newDesc);
    taskToEdit.setStartTime(newStart);
    taskToEdit.setEndTime(newEnd);
    taskToEdit.setPriority(newPriority);

    return true;
}


}

