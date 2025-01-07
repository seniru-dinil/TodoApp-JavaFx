package edu.icet.todo.controller.todo;

import edu.icet.todo.dbc.DataBaseConnection;
import edu.icet.todo.model.TodoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToDoController implements ToDoServices {

    private static ToDoController instance;

    public static ToDoController getInstance() {
        if (instance == null) instance = new ToDoController();
        return instance;
    }

    private ToDoController() {
    }


    public boolean addToDoItem(TodoItem todo) throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "INSERT INTO PendingTodoItems (UserID,TodoTitle,TodoDescription,TodoType,Date) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        preparedStatement.setInt(1, todo.getUserID());
        preparedStatement.setString(2, todo.getTodoTitle());
        preparedStatement.setString(3, todo.getTodoDescription());
        preparedStatement.setString(4, todo.getTodoType());
        preparedStatement.setString(5, todo.getTodoDate());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public ArrayList<TodoItem> getToDoList() throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "SELECT * FROM PendingTodoItems";
        ResultSet resultSet = dbc.prepareStatement(query).executeQuery();
        ArrayList<TodoItem> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new TodoItem(resultSet.getInt(1), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
        }
        return list;
    }

    @Override
    public boolean deleteToDoItem(String todo) throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "DELETE FROM PendingTodoItems WHERE TodoTitle=?";

        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        preparedStatement.setString(1, todo);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public TodoItem getToDoItem(String todo) throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "SELECT * FROM PendingTodoItems WHERE TodoTitle=?";
        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        preparedStatement.setString(1,todo);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return  new TodoItem(resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
    }

    @Override
    public TodoItem getToDoItemByDate(String date) throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "SELECT * FROM PendingTodoItems WHERE Date?";
        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        preparedStatement.setString(1,date);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return  new TodoItem(resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
    }

    @Override
    public boolean addToDoItemToCompletedTable(TodoItem todo) throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "INSERT INTO completedtodoitems (UserID,TodoTitle,TodoDescription,TodoType,Date) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        preparedStatement.setInt(1, todo.getUserID());
        preparedStatement.setString(2, todo.getTodoTitle());
        preparedStatement.setString(3, todo.getTodoDescription());
        preparedStatement.setString(4, todo.getTodoType());
        preparedStatement.setString(5, todo.getTodoDate());
        return preparedStatement.executeUpdate() > 0;
    }


    @Override
    public ArrayList<TodoItem> getCompletedTodos() throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "SELECT * FROM completedtodoitems";
        ResultSet resultSet = dbc.prepareStatement(query).executeQuery();
        ArrayList<TodoItem> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new TodoItem(resultSet.getInt(1), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
        }
        return list;
    }

    @Override
    public boolean clearAllFromCompletedTodoTable() throws SQLException {
        Connection dbc = DataBaseConnection.getInstance().getDbc();
        String query = "TRUNCATE TABLE completedtodoitems";
        PreparedStatement preparedStatement = dbc.prepareStatement(query);
        return preparedStatement.executeUpdate()>0;
    }


}
