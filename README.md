# Task Tracker CLI (Spring Boot + Java)

A simple command-line application to track and manage your tasks.
Built with Spring Boot + Java, tasks are stored in a local tasks.json file.

## Features

- Add, Update, and Delete tasks
- Mark tasks as todo, in-progress, or done
- List all tasks
- List tasks filtered by status
- JSON file persistence `(tasks.json)`

## Requirements

- ☕ [Java 17 or higher](https://adoptium.net/)
- 📦 [Maven 3.8 or higher](https://maven.apache.org/download.cgi)

## Setup

1. Clone this repository:
```bash
   git clone https://github.com/your-username/task-tracker.git
   cd task-tracker
```
2. Build the project:
```bash
   mvn clean package
```
## Usage
-----
Run the CLI with:
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar <command> [arguments]

## Commands
--------
1. Add a new task:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar add "Buy groceries"
   ```

2. Update a task:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar update 1 "Buy groceries and cook dinner"
   ```

3. Delete a task:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar delete 1
   ```

4. Mark a task as in-progress:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar mark-in-progress 2
   ```

5. Mark a task as done:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar mark-done 2
   ```

6. List all tasks:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar list
   ```

7. List tasks by status:
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar list todo
   ```
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar list in-progress
   ```
   ```bash
   java -jar target/task-tracker-0.0.1-SNAPSHOT.jar list done
   ```

## Data Storage

Tasks are stored in tasks.json in the project root.

Example:
```json
[
  {
    "id": 1,
    "description": "Buy groceries",
    "status": "done",
    "createdAt": "2025-09-05T10:30:00",
    "updatedAt": "2025-09-05T11:00:00"
  }
]
```

## Error Handling

- If tasks.json does not exist, it is created automatically.
- Invalid commands show a help message.
- Task IDs are auto-incremented and unique.
- Graceful handling for missing IDs or arguments.

## Development
Run the app with Maven (useful while coding):
```bash
   mvn spring-boot:run -Dspring-boot.run.arguments="add 'Do homework'"
```
## Author

Alejandro Marsical
Project URL: https://roadmap.sh/projects/task-tracker