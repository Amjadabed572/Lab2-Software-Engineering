package com.example.lab2; // The package/folder where this file is located

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    // The @FXML annotation connects this Java variable to the Label in your visual .fxml file
    @FXML
    private Label welcomeText;

    // The @FXML annotation connects this method to a specific action (like a button click) in the UI
    @FXML
    public void onHelloButtonClick() {
        // This changes the text displayed on the screen when the event happens
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}