package edu.icet.todo.controller.todo;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.icet.todo.model.TodoItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddToDoFormController implements Initializable {

    @FXML
    private VBox VBoxRight;

    @FXML
    private JFXCheckBox checkBoxHealth;

    @FXML
    private JFXCheckBox checkBoxPersonal;

    @FXML
    private JFXCheckBox checkBoxUrgent;

    @FXML
    private JFXCheckBox checkBoxWork;

    @FXML
    private Label lblDate;

    @FXML
    private JFXTextArea txtToDoDescription;

    @FXML
    private JFXTextField txtToDoTitle;

    @FXML
    void btnAddToDoOnAction(ActionEvent event) throws SQLException {
        JFXCheckBox[] checkBox = {checkBoxHealth,checkBoxPersonal,checkBoxUrgent,checkBoxWork};
        int id = 1;
        String title = txtToDoTitle.getText();
        String description = txtToDoDescription.getText();
        String type = "Personal";
        for(JFXCheckBox i:checkBox){
            if(i.isSelected()){
                type = i.getText();
                break;
            }
        }
        String date = getDate();
        TodoItem todoItem = new TodoItem(id, title, description, type, date);
        System.out.println(todoItem);
        boolean isAdded = AddToDoController.getInstance().addToDo(todoItem);
        if (isAdded){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("ToDo Item Added Successfully!");
            alert.showAndWait();
            emptyFlds();
        }
    }

    public String getDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

    public void emptyFlds(){
        txtToDoDescription.setText("");
        txtToDoTitle.setText("");
        checkBoxUrgent.setSelected(false);
        checkBoxWork.setSelected(false);
        checkBoxPersonal.setSelected(false);
        checkBoxHealth.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(getDate());
    }
}
