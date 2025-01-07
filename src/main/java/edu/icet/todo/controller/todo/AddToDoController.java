package edu.icet.todo.controller.todo;

import edu.icet.todo.dbc.DataBaseConnection;
import edu.icet.todo.model.TodoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddToDoController implements  AddToDoServices{

    private static AddToDoController instance;

    public static AddToDoController getInstance() {
        if (instance == null) instance = new AddToDoController();
        return instance;
    }

    private AddToDoController() {
    }


    public boolean addToDo(TodoItem todo) throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        System.out.println(dbc);
        String query = "INSERT INTO PendingTodoItems (UserID,TodoTitle,TodoDescription,TodoType,Date) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        preparedStatement.setInt(1, todo.getUserID());
        preparedStatement.setString(2, todo.getTodoTitle());
        preparedStatement.setString(3, todo.getTodoDescription());
        preparedStatement.setString(4, todo.getTodoType());
        preparedStatement.setString(5, todo.getTodoDate());
        return preparedStatement.executeUpdate() > 0;
    }

}
