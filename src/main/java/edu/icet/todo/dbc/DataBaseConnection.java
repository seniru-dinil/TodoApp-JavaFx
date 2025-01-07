package edu.icet.todo.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private Connection dbc;

    private DataBaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/TodoManagement";
        String username = "root";
        String password = "1234";
        dbc = DriverManager.getConnection(url, username, password);
    }

    public static  DataBaseConnection getInstance() throws SQLException {
        if(instance==null)instance=new DataBaseConnection();
        return instance;
    }

    public Connection getDbc(){
        return dbc;
    }
}
