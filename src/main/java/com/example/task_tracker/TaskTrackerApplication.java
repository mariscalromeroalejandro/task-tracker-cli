package com.example.task_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.task_tracker.cli.TaskCLI;

@SpringBootApplication
public class TaskTrackerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TaskTrackerApplication.class, args);
		TaskCLI cli = context.getBean(TaskCLI.class);
		cli.run(args);

	}

}
