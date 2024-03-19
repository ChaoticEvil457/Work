package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowHBoxVBoxToDo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a border pane
    BorderPane pane = new BorderPane();

    // Place nodes in the pane
    pane.setBottom(getVBox());
    pane.setLeft(getHBox());

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShowHBoxVBox"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  private HBox getHBox() {
    // complete
    HBox hBox = new HBox(15);
    hBox.setPadding(new Insets(5, 15, 5, 5));
    Button bt1 = new Button("Computer Science");
    Button bt2 = new Button("Chemestry");
    hBox.setStyle("-fx-background-color:yellow");
    Image image = new Image("Flag.gif");
    ImageView iv1 = new ImageView();
    iv1.setImage(image);
    iv1.setFitWidth(100);
    iv1.setPreserveRatio(true);
    iv1.setSmooth(true);
    iv1.setCache(true);
    hBox.getChildren().addAll(bt1, bt2, iv1);
    return hBox;
  }

  private VBox getVBox() {
    VBox vBox = new VBox(15);
    vBox.setPadding(new Insets(15, 5, 5, 5));
    vBox.getChildren().add(new Label("Courses"));

    Label[] courses = { new Label("CSCI 1301"), new Label("CSCI 1302"),
        new Label("CSCI 2410"), new Label("CSCI 3720") };

    for (Label course : courses) {
      VBox.setMargin(course, new Insets(0, 0, 0, 15));
      vBox.getChildren().add(course);
    }

    return vBox;
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
