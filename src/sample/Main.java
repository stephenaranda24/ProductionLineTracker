package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents the main class of this production tracker program.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */
public class Main extends Application {
  /**
   * The starting point of a javaFX program.
   *
   * @param primaryStage This is an object of the Stage class
   * @throws Exception Exception on input error
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  /**
   *This is the main method of the javaFx program.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
