package history;

import manager.ToDoListManager;
import model.Task;

public class AddTaskCommand implements Command {
    private ToDoListManager manager;
    private Task task;

    public AddTaskCommand(ToDoListManager manager, Task task) {
        this.manager = manager;
        this.task = task;
    }

    @Override
    public void execute() {
        manager.addTask(task);
    }

    @Override
    public void undo() {
        manager.deleteTask(task.getDescription());
    }
}