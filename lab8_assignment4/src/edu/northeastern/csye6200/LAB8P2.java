package edu.northeastern.csye6200;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LAB8P2 extends Application {

    // Constants representing components, their percentages, and corresponding colors
    private static final String[] COMPONENTS = {"Project", "Exams", "Assignments", "Attendance"};
    private static final double[] PERCENTAGES = {35, 30, 30, 5};
    private static final Color[] COLORS = {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE};

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create an HBox to hold the components
        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.BOTTOM_CENTER);

        // Calculate the maximum percentage to normalize the heights of the rectangles
        double max = getMax(PERCENTAGES);
        double height = 200; // Fixed height for all rectangles
        double width = 150;  // Fixed width for all rectangles

        // Create a StackPane to hold the HBox
        StackPane pane = new StackPane();
        pane.setPadding(new javafx.geometry.Insets(20, 15, 5, 15));

        // Create rectangles and texts for each component
        for (int i = 0; i < COMPONENTS.length; i++) {
            Rectangle rectangle = new Rectangle(0, 0, width, height * PERCENTAGES[i] / max);
            rectangle.setFill(COLORS[i]);

            Text text = new Text(0, 0, COMPONENTS[i] + " -- " + PERCENTAGES[i] + "%");

            // Add each VBox (text and rectangle) to the HBox
            hBox.getChildren().add(getVBox(text, rectangle));
        }

        // Add the HBox to the StackPane
        pane.getChildren().add(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Grade Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to find the maximum value in an array
    private double getMax(double[] values) {
        double max = values[0];
        for (double value : values) {
            if (value > max)
                max = value;
        }
        return max;
    }

    // Method to create a VBox containing text and a rectangle
    private VBox getVBox(Text text, Rectangle rectangle) {
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getChildren().addAll(text, rectangle);
        return vBox;
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
