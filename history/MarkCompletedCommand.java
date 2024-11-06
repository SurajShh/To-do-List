// history/MarkCompletedCommand.java
package history;

import manager.ToDoListManager;
import model.Task;

public class MarkCompletedCommand implements Command {
    private ToDoListManager manager;
    private String description;
    private Task taskToComplete;

    public MarkCompletedCommand(ToDoListManager manager, String description) {
        this.manager = manager;
        this.description = description;
    }

    @Override
    public void execute() {
        // Retrieve the task to mark as completed
        taskToComplete = manager.getTaskByDescription(description);
        if (taskToComplete != null && !taskToComplete.isCompleted()) {
            taskToComplete.markCompleted();
            System.out.println("Marked task as completed: " + description);
        } else {
            System.out.println("Task not found or already completed: " + description);
        }
    }

    @Override
    public void undo() {
        if (taskToComplete != null && taskToComplete.isCompleted()) {
            taskToComplete.unmarkCompleted();
            System.out.println("Unmarked task as completed: " + description);
        }
    }
}
