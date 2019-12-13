package stephenaranda24;

import java.awt.Dimension;
import java.awt.Font;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

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
    Parent root = FXMLLoader.load(getClass().getResource("ProductionTabs.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 800, 550));
    primaryStage.show();
  }

  /**
   * This is the main method of the javaFx program.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {
    launch(args);
  }
  /**
   * This method creates an error message that will appear in the occurrence that the user inputs
   * something incorrect data.
   *
   * @param message A string that represents the error that needs to be shown.
   */

  public static void errorMessage(String message) {
    UIManager.put("OptionPane.minimumSize", new Dimension(250, 100));
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
  }
  /**
   * This method creates an info message to appear when the user needs to be alerted of something.
   *
   * @param message A string that represents the message that needs to shown.
   */

  public static void infoMessage(String message) {
    UIManager.put("OptionPane.minimumSize", new Dimension(250, 100));
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 20)));
    JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
  }
}
