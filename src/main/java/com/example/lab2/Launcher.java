package com.example.lab2; // The package/folder where this file is located

import javafx.application.Application;

// A separate launcher class is a very common trick used in JavaFX.
// Because this class does not extend "Application" itself, it helps bypass
// some of the strict Java module errors when running the program from an IDE.
public class Launcher {

    // The standard starting point of a Java program
    public static void main(String[] args) {
        // This line simply tells JavaFX to jump over to your HelloApplication class and start the GUI
        Application.launch(HelloApplication.class, args);
    }
}