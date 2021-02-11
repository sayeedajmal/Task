package com.Task;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.nio.file.Path;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaskController implements Initializable {
    public DatePicker datePicker;
    public TextField textfield;
    public TextArea textarea;

    // For Maintaing! The Forms And Buttons!
    @FXML
    public void add() throws IOException {
        String text = textfield.getText();
        LocalDate date = datePicker.getValue();
        if (!text.isBlank() && !date.toString().isBlank()) {
            FileWriter file = new FileWriter("Task/Save.txt", true);
            String insert = ">: " + datePicker.getValue() + ":    " + textfield.getText() + " .." + "\n";
            textarea.appendText(insert);
            file.append(insert);
            file.close();
            empty();
        } else {
            return;
        }
    }

    // For clearing textfield after submission of Text
    @FXML
    public void empty() {
        textfield.setText(null);
    }

    // For Cleaning the Task!
    @FXML
    public void remove() {
        textarea.setText(null);
    }

    @FXML
    public void show() {
        Path path = FileSystems.getDefault().getPath("Task/Save.txt");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
            String convert = null;
            String real = null;
            while ((convert = reader.readLine()) != null) {
                real += convert + "\n";
                textarea.setText(real);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}