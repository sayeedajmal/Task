package com.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaskController {
    public DatePicker datePicker;
    public TextField textfield;
    public TextArea textarea;

    // For Maintaing! The Forms And Buttons!
    @FXML
    public void add() throws IOException {
        String text = textfield.getText();
        LocalDate date = datePicker.getValue();
        if (!text.isBlank() && !date.toString().isBlank()) {
            FileWriter file = new FileWriter("Save.txt", true);
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
    File main = new File("Save.txt");

    public void remove() {
        if (main.exists()) {
            main.deleteOnExit();
            textarea.setText("\t\t Cleared !\n\t\t Please Restart Application! for New Entry");
            empty();
        }
    }

    @FXML
    public void show() {
        Path path = FileSystems.getDefault().getPath("Save.txt");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
            String convert;
            String real = null;
            while ((convert = reader.readLine()) != null) {
                real += convert + "\n";
                textarea.setText(real);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}