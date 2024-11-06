// Main.java
import model.Task;
import manager.ToDoListManager;
import history.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void main(String[] args) {
        ToDoListManager manager = new ToDoListManager();
        History history = new History();
        Scanner scanner = new Scanner(System.in);

        System.out.println("To-Do List Manager\n");

        while (true) {
            System.out.println("Enter command (add, complete, delete, view, undo, redo, exit):");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine().trim();

                    // Prompt user for due date
                    System.out.print("Enter due date (yyyy-MM-dd) or leave blank: ");
                    String dueDateInput = scanner.nextLine().trim();
                    LocalDate dueDate;

                    if (dueDateInput.isEmpty()) {
                        // Default to the current date if no due date is provided
                        dueDate = LocalDate.now();
                        System.out.println("No due date provided. Setting due date to today: " + dueDate);
                    } else {
                        try {
                            dueDate = LocalDate.parse(dueDateInput, DATE_FORMAT);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                            continue;
                        }
                    }

                    // Build task with or without due date
                    Task task = new Task.Builder(desc)
                            .withDueDate(dueDate)  // Assign the due date if provided
                            .build();

                    Command addTaskCommand = new AddTaskCommand(manager, task);
                    history.execute(addTaskCommand);
                    break;

                case "complete":
                    System.out.print("Enter task to mark complete: ");
                    String completeDesc = scanner.nextLine();
                    Command markComplete = new MarkCompletedCommand(manager, completeDesc);
                    history.execute(markComplete);
                    break;

                case "delete":
                    System.out.print("Enter task to delete: ");
                    String deleteDesc = scanner.nextLine();
                    Command deleteTask = new DeleteTaskCommand(manager, deleteDesc);
                    history.execute(deleteTask);
                    break;

                case "view":
                    System.out.print("Enter filter (all, completed, pending): ");
                    String filter = scanner.nextLine();
                    manager.viewTasks(filter).forEach(System.out::println);
                    break;

                case "undo":
                    history.undo();
                    break;

                case "redo":
                    history.redo();
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid command");
                    //break;
            }
            //scanner.close();
        }
        
    }
}
