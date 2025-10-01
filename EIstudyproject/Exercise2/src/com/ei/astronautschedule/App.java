package com.ei.astronautschedule;

import com.ei.astronautschedule.model.Task;
import com.ei.astronautschedule.factory.TaskFactory;
import com.ei.astronautschedule.manager.ScheduleManager;
import com.ei.astronautschedule.observer.TaskNotifier;
import com.ei.astronautschedule.observer.TaskObserver;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        TaskNotifier notifier = new TaskNotifier();

        // Add a simple observer
        notifier.addObserver((task, message) -> System.out.println(message));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Astronaut Daily Schedule ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");

            // Optional feature
            System.out.println("4. Edit Task");              
            
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter start time (HH:mm): ");
                    String start = sc.nextLine();
                    System.out.print("Enter end time (HH:mm): ");
                    String end = sc.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    Task task = TaskFactory.createTask(desc, start, end, priority);
                    // Validate time
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    boolean invalidTime = false;
                    try {
                        LocalTime.parse(task.getStartTime(), formatter);
                        LocalTime.parse(task.getEndTime(), formatter);
                    } catch (Exception e) {
                        invalidTime = true;
                    }
                    if (invalidTime) {
                        notifier.notify(task, "Error: Invalid time format.");
                    } else {
                        Task result = manager.addTask(task);
                        if (result == null) {
                            notifier.notify(task, "Error: Invalid time format.");
                        } else if (result != task) {
                            notifier.notify(task, "Error: Task conflicts with existing task \"" + result.getDescription() + "\".");
                        } else {
                            notifier.notify(task, "Task added successfully. No conflicts.");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Enter task description to remove: ");
                    String removeDesc = sc.nextLine();
                    if (manager.removeTask(removeDesc)) {
                        notifier.notify(null, "Task removed successfully.");
                    } else {
                        notifier.notify(null, "Error: Task not found.");
                    }
                    break;

                case "3":
                    List<Task> tasks = manager.viewTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks scheduled for the day.");
                    } else {
                        System.out.println("\n--- Today's Tasks ---");
                        for (Task t : tasks) {
                            System.out.println(t);
                        }
                    }
                    break;

                
                case "4": // New option for editing
                System.out.print("Enter description of task to edit: ");
                String oldDesc = sc.nextLine();
                System.out.print("Enter new description: ");
                String newDesc = sc.nextLine();
                System.out.print("Enter new start time (HH:mm): ");
                String newStart = sc.nextLine();
                System.out.print("Enter new end time (HH:mm): ");
                String newEnd = sc.nextLine();
                System.out.print("Enter new priority: ");
                String newPriority = sc.nextLine();
                if (manager.editTask(oldDesc, newDesc, newStart, newEnd, newPriority)) {
                    notifier.notify(null, "Task edited successfully.");
                } else {
                    notifier.notify(null, "Error: Cannot edit task (conflict or invalid time).");
                }
                break;

                case "5":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}

