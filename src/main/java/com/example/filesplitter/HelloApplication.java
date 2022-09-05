package com.example.filesplitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader xml = new FXMLLoader(HelloApplication.class.getResource("21BCM054.fxml"));
        Scene scene = new Scene(xml.load());
        stage.setTitle("21BCM054 Assignment-1 File Splitter");
        stage.setScene(scene);
        stage.show();
    }
}