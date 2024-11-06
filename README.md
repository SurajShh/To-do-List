# To-Do List Manager

## Overview

This is a simple console-based To-Do List Manager that allows users to manage their tasks. Users can add new tasks, mark them as completed, delete tasks, and filter tasks by completion status. The project also demonstrates the use of design patterns including **Memento** (for undo/redo actions) and **Builder** (for flexible task creation).

## Features

- Add new tasks with a description and optional due date.
- Mark tasks as completed.
- Delete tasks.
- View all tasks or filter tasks by 'completed' or 'pending' status.
- Undo and redo actions using the Memento pattern.

## Design Patterns

1. **Behavioral Pattern - Memento**: Allows users to undo and redo actions in the to-do list.
2. **Creational Pattern - Builder**: Used for constructing tasks with optional attributes like due date and tags.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git (for cloning the repository)

## Setup

1. Clone this repository.
   git clone <repository-url>

2. Navigate to the project directory.
    cd todo-list-manager
   
3. Compile the Java files.
    javac *.java

## Running the Application

  java Main.java
