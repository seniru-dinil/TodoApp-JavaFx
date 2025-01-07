package edu.icet.todo.controller;

import edu.icet.todo.controller.todo.ToDoController;
import edu.icet.todo.model.TodoItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {

    public Label lblAdminName;
    @FXML
    private VBox VBoxRight;

    @FXML
    void btnLoadAddTodoOnAction(ActionEvent event) throws IOException {
        Object load = FXMLLoader.load(getClass().getResource("/view/addToDoForm.fxml"));
        VBoxRight.getChildren().setAll((Node) load);
    }


    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Object load = FXMLLoader.load(getClass().getResource("/view/addToDoForm.fxml"));
        VBoxRight.getChildren().setAll((Node) load);
    }

    public void btnMyTasksOnAction(ActionEvent actionEvent) throws SQLException, IOException {
        Object load = FXMLLoader.load(getClass().getResource("/view/newToDoForm.fxml"));
        VBoxRight.getChildren().setAll((Node) load);
    }

    public void btnCompletedTaskOnAction(ActionEvent actionEvent) throws IOException {
        Object load = FXMLLoader.load(getClass().getResource("/view/completedTodoForm.fxml"));
        VBoxRight.getChildren().setAll((Node) load);
    }
}
