// history/DeleteTaskCommand.java
package history;

import manager.ToDoListManager;
import model.Task;

public class DeleteTaskCommand implements Command {
    private ToDoListManager manager;
    private String description;
    private Task deletedTask;

    public DeleteTaskCommand(ToDoListManager manager, String description) {
        this.manager = manager;
        this.description = description;
    }

    @Override
    public void execute() {
        // Store the task before deleting, for undo purposes
        deletedTask = manager.getTaskByDescription(description);
        if (deletedTask != null) {
            manager.deleteTask(description);
            System.out.println("Deleted task: " + description);
        } else {
            System.out.println("Task not found: " + description);
        }
    }

    @Override
    public void undo() {
        if (deletedTask != null) {
            manager.addTask(deletedTask);
            System.out.println("Restored deleted task: " + description);
        }
    }
}
