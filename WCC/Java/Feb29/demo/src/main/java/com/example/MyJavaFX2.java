package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyJavaFX2 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a button and place it in the scene
        Circle circle = new Circle();
        Text text = new Text("JavaFX");
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.PINK);
        text.setStyle("-fx-font-style: italic;-fx-font: 20 arial;");
        text.setFill(Color.BLACK);
        text.setStroke(Color.BLACK);
        StackPane pane = new StackPane();
        pane.setStyle("-fx-background-color: lightgray;");
        pane.getChildren().add(circle);
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("MyJavaFX"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
