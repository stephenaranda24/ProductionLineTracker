package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * This controller class implements the actions of the program.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */
public class Controller {
  /**
   * This method initializes the database named "ProductionDataBase" and connects to it. It allows
   * for the addition of data into the database.
   */
  @FXML
  private void initializeDB() {
    final String Jdbc_Driver = "org.h2.Driver";
    final String Db_Url = "jdbc:h2:./res/ProductionDataBase";

    //  Database credentials
    final String User = "";
    final String Pass = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(Jdbc_Driver);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(Db_Url, User, Pass);

      // STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql =
          "INSERT INTO Product"
              + "(type, manufacturer, name)"
              + "VALUES ( 'AUDIO', 'Apple', 'MacBook' )";
      stmt.executeUpdate(sql);
      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML ComboBox comboBox = new ComboBox();
  /**
   * This method initializes the numbers associated to the dropdown box named ComboBox on the
   * Produce tab.
   */

  public void initializeNumbers() {
    comboBox.getItems().add("1");
    comboBox.getItems().add("2");
    comboBox.getItems().add("3");
    comboBox.getItems().add("4");
    comboBox.getItems().add("5");
    comboBox.getItems().add("6");
    comboBox.getItems().add("7");
    comboBox.getItems().add("8");
    comboBox.getItems().add("9");
    comboBox.getItems().add("10");

    // comboBox.getSelectionModel().selectFirst();
    comboBox.setEditable(true);
  }

  /**
   * This method prints "Product Added" to the console when the "Add Product" button is clicked on
   * the Produce Line tab. It also implements the method initializeDB when the same button is
   * pressed.
   */
  @FXML
  protected void handleAddButtonAction() {
    System.out.println("Product Added");
    initializeDB();
  }
  /**
   * This method prints "Production Recorded" to the console when the "Record Production" button is
   * clicked on the Produce tab.
   */

  @FXML
  protected void handleRecordButtonAction() {
    System.out.println("Production Recorded");
  }
}
