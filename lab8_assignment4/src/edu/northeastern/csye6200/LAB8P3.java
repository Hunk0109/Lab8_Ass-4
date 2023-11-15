package edu.northeastern.csye6200;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LAB8P3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane and set its properties
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);

        // Populate the GridPane with TextFields containing random 0 or 1
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField text = new TextField();
                text.setMaxWidth(Double.MAX_VALUE); // Allow the TextField to expand horizontally
                text.setText(String.valueOf((int) (Math.random() * 2))); // Set random 0 or 1
                pane.add(text, i, j); // Add the TextField to the specified row and column
                GridPane.setHalignment(text, HPos.CENTER); // Center the text horizontally
                GridPane.setValignment(text, VPos.CENTER); // Center the text vertically
            }
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_07"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

	}

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}

