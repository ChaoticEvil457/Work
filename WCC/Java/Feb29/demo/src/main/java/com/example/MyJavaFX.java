package com.example;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MyJavaFX extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a button and place it in the scene
    Circle circle = new Circle();
    circle.setCenterX(100);
    circle.setCenterY(100);
    circle.setRadius(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    Pane pane = new Pane();
    Circle circle2 = new Circle();
    circle2.centerXProperty().bind(pane.widthProperty().divide(2));
    circle2.centerYProperty().bind(pane.heightProperty().divide(2));
    circle2.setRadius(50);
    circle2.setStroke(Color.RED);
    circle2.setFill(Color.WHITE);
    Button button = new Button("OK");
    button.setStyle("-fx-border-color: blue;");
    button.setLayoutX(250);
    button.setLayoutY(250);
    pane.setRotate(45);
    pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
    pane.getChildren().add(circle);
    pane.getChildren().add(circle2);
    pane.getChildren().add(button);
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
