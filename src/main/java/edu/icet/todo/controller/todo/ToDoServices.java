package edu.icet.todo.controller.todo;

import edu.icet.todo.model.TodoItem;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ToDoServices {
    boolean addToDoItem(TodoItem todoItem) throws SQLException;
    ArrayList<TodoItem> getToDoList() throws SQLException;
    boolean deleteToDoItem(String todo) throws SQLException;
    TodoItem getToDoItem(String todo) throws SQLException;
    TodoItem getToDoItemByDate(String todo) throws SQLException;
    boolean addToDoItemToCompletedTable(TodoItem todoItem) throws SQLException;
    ArrayList<TodoItem> getCompletedTodos() throws SQLException;
    boolean clearAllFromCompletedTodoTable() throws SQLException;
}
