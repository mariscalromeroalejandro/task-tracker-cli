package com.example.task_tracker.service;

import com.example.task_tracker.model.Task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TaskService {

    private final String FILE_PATH = "tasks.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Task> tasks = new ArrayList<>();

    public TaskService() {
        loadTasks();
    }

    private void loadTasks() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists())
                file.createNewFile();
            tasks = mapper.readValue(file, new TypeReference<List<Task>>() {
            });

        } catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }
    
    private void saveTasks() {
        try {
            mapper.writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getNextId() {
        return tasks.stream().mapToInt(Task::getId).max().orElse(0) + 1;
    }

    public Task addTask(String description) {
        Task task = new Task(getNextId(), description);
        tasks.add(task);
        saveTasks();
        return task;
    }

    public boolean updateTask(int id, String newDesc) {
        Optional<Task> opt = tasks.stream().filter(t -> t.getId() == id).findFirst();
        if (opt.isPresent()) {
            Task task = opt.get();
            task.setDescription(newDesc);
            task.setUpdatedAt(LocalDateTime.now());
            saveTasks();
            return true;
        }
        return false;
    }

    public boolean deleteTask(int id) {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed)
            saveTasks();
        return removed;
    }

    public boolean markTask(int id, String status) {
        Optional<Task> opt = tasks.stream().filter(t -> t.getId() == id).findFirst();
        if (opt.isPresent()) {
            Task task = opt.get();
            task.setStatus(status);
            task.setUpdatedAt(LocalDateTime.now());
            saveTasks();
            return true;
        }
        return false;
    }

    public List<Task> listTasks() {
        return tasks;
    }
    
    public List<Task> listTaskByStatus(String status) {
        return tasks.stream().filter(t -> t.getStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
    }



}