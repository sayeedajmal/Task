package com.Task;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaskController implements Initializable {
    public DatePicker datePicker;
    public TextField textfield;
    public TextArea textarea;
    public Label warn;

    public void add() {
        String text = textfield.getText();
        LocalDate date = datePicker.getValue();
        if (!text.isBlank() && !date.toString().isBlank()) {
            textarea.appendText(">: " + datePicker.getValue() + ":    " + textfield.getText() + " .." + "\n");
            empty();
        } else {
            return;
        }
    }

    public void empty() {
        textfield.setText(null);
    }

    public void remove() {
        textarea.setText(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }
}