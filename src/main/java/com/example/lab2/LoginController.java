package com.example.lab2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private final ArrayList<User> validUsers = new ArrayList<>();

    // This method runs automatically when the login screen is loaded
    @FXML
    public void initialize() {
        try {
            File file = new File("users.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    try {
                        // Only valid users will be successfully created and added
                        User user = new User(parts[0], parts[1]);
                        validUsers.add(user);
                    } catch (Exception e) {
                        // We ignore invalid users for this lab
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            errorLabel.setText("System Error: users.txt not found");
        }
    }

    // This method runs when the user clicks the "login" button
    @FXML
    void onLoginButtonClick(ActionEvent event) {
        String inputUser = usernameField.getText();
        String inputPass = passwordField.getText();

        boolean isMatch = false;

        // Check if the typed credentials match any valid user
        for (User u : validUsers) {
            if (u.getUsername().equals(inputUser) && u.getPassword().equals(inputPass)) {
                isMatch = true;
                break;
            }
        }

        if (isMatch) {
            try {
                // Credentials match! Load the welcome screen
                Parent welcomeRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcome.fxml")));

                // Get the current window and change its scene
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(welcomeRoot));
                stage.setTitle("Welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Credentials don't match! Show the exact error text requested
            errorLabel.setText("user or password do not match");
        }
    }
}