package com.example.lab2; // The package/folder where this file is located

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// All JavaFX applications must extend the "Application" class
public class HelloApplication extends Application {

    // The start() method is the main entry point for the visual part of a JavaFX app.
    // The "Stage" is the physical window that pops up on your screen.
    @Override
    public void start(Stage stage) throws IOException {

        // This reads your visual layout file (.fxml) and loads it into memory
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // A "Scene" is the content inside the window. Here we set its size to 320x240 pixels.
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Sets the text at the very top of the window frame
        stage.setTitle("Hello!");

        // Puts your content (the Scene) inside the window (the Stage)
        stage.setScene(scene);

        // Finally, this command makes the window visible on your screen
        stage.show();
    }

    // The standard Java main method. It just tells JavaFX to launch the application.
    public static void main(String[] args) {
        launch(args);
    }
}