package edu.icet.todo.controller.todo;

import com.jfoenix.controls.JFXCheckBox;
import edu.icet.todo.model.TodoItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompletedToDoFormController implements Initializable {

    @FXML
    private VBox todoContainer;


    private VBox createToDoElement(TodoItem todoItem){

        VBox vbox = new VBox();
        vbox.setPrefHeight(49);
        vbox.setPrefWidth(662);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);


        HBox hbox = new HBox();
        hbox.setPrefHeight(58);
        hbox.setPrefWidth(662);
        hbox.setSpacing(20);
        hbox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(0, 4, 0, 15));


        Label label1 = new Label(todoItem.getTodoTitle());
        label1.setPrefHeight(28);
        label1.setPrefWidth(154);
        label1.setTextFill(javafx.scene.paint.Color.WHITE);


        Label label2 = new Label(todoItem.getTodoDescription());
        label2.setPrefHeight(28);
        label2.setPrefWidth(347);
        label2.setTextFill(javafx.scene.paint.Color.WHITE);


        Label label3 = new Label(todoItem.getTodoType());
        label3.setPrefHeight(28);
        label3.setPrefWidth(192);
        label3.setTextFill(javafx.scene.paint.Color.WHITE);




        hbox.getChildren().addAll(label1, label2, label3);


        vbox.getChildren().add(hbox);

        vbox.getStyleClass().addAll("btnAddToDo", "border-radius");

        return vbox;
    }

    public void loadData() throws SQLException {
        todoContainer.getChildren().clear();
        ArrayList<TodoItem> toDoList = ToDoController.getInstance().getCompletedTodos();
        toDoList.forEach(todoItem -> todoContainer.getChildren().add(createToDoElement(todoItem)));
    }

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }

    public void btnClearAllOnAction(ActionEvent actionEvent) throws SQLException {
       ToDoController.getInstance().clearAllFromCompletedTodoTable();
       loadData();
    }
}
