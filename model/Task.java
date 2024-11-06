package model;

import java.time.LocalDate;

public class Task {

    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private String[] tags;

    private Task(String description, LocalDate dueDate, String[] tags) {
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
        this.tags = tags;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void unmarkCompleted() {
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Inner Builder class
    public static class Builder {
        private String description;
        private LocalDate dueDate;
        private String[] tags;

        public Builder(String description) {
            this.description = description;
        }

        public Builder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder withTags(String[] tags) {
            this.tags = tags;
            return this;
        }

        public Task build() {
            return new Task(description, dueDate, tags);
        }
    }

    @Override
    public String toString() {
        return description + " - " + (completed ? "Completed" : "Pending") +
               (dueDate != null ? ", Due: " + dueDate : "");
    }
}
