package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddToDoFormController implements Initializable {

    @FXML
    private VBox VBoxRight;

    @FXML
    private Label lblDate;

    public String getDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(getDate());
    }
}
