// manager/ToDoListManager.java
package manager;

import model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoListManager {
    private List<Task> tasks;

    public ToDoListManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Added task: " + task.getDescription());
    }

    public void deleteTask(String description) {
        tasks.removeIf(task -> task.getDescription().equals(description));
        System.out.println("Deleted task: " + description);
    }

    public void markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.markCompleted();
                System.out.println("Marked task as completed: " + description);
            }
        }
    }

    public Task getTaskByDescription(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                return task;
            }
        }
        return null; // Task not found
    }

    public List<Task> viewTasks(String filter) {
        if ("completed".equalsIgnoreCase(filter)) {
            return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
        } else if ("pending".equalsIgnoreCase(filter)) {
            return tasks.stream().filter(task -> !task.isCompleted()).collect(Collectors.toList());
        } else {
            return tasks;
        }
    }
}
