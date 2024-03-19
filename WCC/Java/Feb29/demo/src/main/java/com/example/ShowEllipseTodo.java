package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;

public class ShowEllipseTodo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane
    Pane pane = new Pane();

    for (int i = 0; i < 18; ++i) {
      Ellipse e1 = new Ellipse(150, 100, 100, 50);
      e1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
      e1.setFill(Color.WHITE);
      pane.getChildren().add(e1);
      e1.setRotate(10 + 10 * i);
    }
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("ShowEllipse"); // Set the stage title
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
