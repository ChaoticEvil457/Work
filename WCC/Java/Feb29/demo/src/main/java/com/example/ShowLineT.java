package com.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class ShowLineT extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new LinePane(), 200, 200);
    primaryStage.setTitle("ShowLine"); // Set the stage title
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

class LinePane extends Pane {//define custom pane
  public LinePane() {
    Line line1 = new Line(10, 10, 10, 10);//create line
    Line line2 = new Line(10, 10, 10, 10);//create line
    line1.endXProperty().bind(widthProperty().subtract(10));//binds the end of line1 to the right
    line1.endYProperty().bind(heightProperty().subtract(10));//binds the end of line1 to the bottom

    line2.startXProperty().bind(widthProperty().subtract(10));//binds the start of line2 to the right
    line2.endYProperty().bind(heightProperty().subtract(10));//binds the end of line2 to the bottom
    line1.setStrokeWidth(5);
    line1.setStroke(Color.GREEN);
    line2.setStrokeWidth(5);
    line2.setStroke(Color.GREEN);
    getChildren().add(line1);//add line to pane
    getChildren().add(line2);//add line to pane
    
      }
  
  
  
}
