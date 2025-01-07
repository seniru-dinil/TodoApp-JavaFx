package edu.icet.todo.controller.todo;

import edu.icet.todo.model.TodoItem;

import java.sql.SQLException;

public interface AddToDoServices {
    boolean addToDo(TodoItem todoItem) throws SQLException;
}
