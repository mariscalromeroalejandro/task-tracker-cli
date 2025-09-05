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
   ./task-cli <command> [arguments]

## Commands
--------
1. Add a new task:
   ```bash
   ./task-cli add "Buy groceries"
   ```

2. Update a task:
   ```bash
   ./task-cli update 1 "Buy groceries and cook dinner"
   ```

3. Delete a task:
   ```bash
   ./task-cli delete 1
   ```

4. Mark a task as in-progress:
   ```bash
   ./task-cli mark-in-progress 2
   ```

5. Mark a task as done:
   ```bash
   ./task-cli mark-done 2
   ```

6. List all tasks:
   ```bash
   ./task-cli list
   ```

7. List tasks by status:
   ```bash
   ./task-cli list todo
   ```
   ```bash
   ./task-cli list in-progress
   ```
   ```bash
   ./task-cli list done
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