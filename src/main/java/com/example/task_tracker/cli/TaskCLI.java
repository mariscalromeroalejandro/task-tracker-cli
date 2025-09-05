package com.example.task_tracker.cli;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.task_tracker.model.Task;
import com.example.task_tracker.service.TaskService;

@Component
public class TaskCLI {
    private final TaskService taskService;

    public TaskCLI(TaskService taskService) {
        this.taskService = taskService;
    }

    public void run(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Provide a task description");
                } else {
                    Task task = taskService.addTask(args[1]);
                    System.out.println("Task added: " + task);
                }
                break;

            case "update":
                if (args.length < 3) {
                    System.out.println(" Usage: update <id> <description>");
                } else {
                    int id = Integer.parseInt(args[1]);
                    boolean updated = taskService.updateTask(id, args[2]);
                    System.out.println(updated ? "Task updated" : "Task not found");
                }
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: delete <id>");
                } else {
                    int id = Integer.parseInt(args[1]);
                    boolean deleted = taskService.deleteTask(id);
                    System.out.println(deleted ? "Task deleted" : "Task not found");
                }
                break;
            case "mark-done":
                markStatus(args, "done");
                break;
            case "mark-in-progress":
                markStatus(args, "in-progress");
                break;
            case "list":
                if (args.length == 1)
                    listAll();
                else
                    listByStatus(args[1]);
                break;

            default:
                System.out.println("Unknown command");
                break;
        }
    }

    private void printHelp() {
        System.out.println("""
                Commands:
                add <description>
                update <id> <description>
                delete <id>
                mark-done <id>
                mark-in-progress <id>
                list [status]
                """);
    };

    private void markStatus(String[] args, String status) {
        if (args.length < 2) {
            System.out.println("Usage: " + status + " <id>");
            return;
        }
        int id = Integer.parseInt((args[1]));
        boolean marked = taskService.markTask(id, status);
        System.out.println(marked ? "Task marked as " + status : "Task not found");
    };

    private void listAll() {
        List<Task> tasks = taskService.listTasks();
        tasks.forEach(System.out::println);
    };

    private void listByStatus(String status) {
        List<Task> tasks = taskService.listTaskByStatus(status);
        tasks.forEach(System.out::println);
    };

}