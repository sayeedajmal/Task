package com.Task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Task Manager");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Task.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image icon=new Image("/images/Calculator-icon.png");
        stage.getIcons().add(icon);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}