package stephenaranda24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

/**
 * This controller class implements the actions of the program.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */
public class DashBoardController {
  @FXML private ComboBox<String> numbersList;
  @FXML private ChoiceBox<ItemType> productType;

  /**
   * This method initializes the database named "ProductionDataBase" and connects to it. It allows
   * for the addition of data into the database.
   */
  @FXML
  private void initializeDB() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDataBase";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // STEP 3: Execute a query
      stmt = conn.createStatement();

      // this needs to be taken out of this method
      String sql =
          "INSERT INTO Product"
              + "(type, manufacturer, name)"
              + "VALUES ( 'AUDIO', 'Apple', 'MacBook' )";
      //
      stmt.executeUpdate(sql);
      System.out.println("Product Added");
      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method initializes the numbers associated to the dropdown box named ComboBox on the
   * Produce tab.
   */

  /**
   * This method prints "Product Added" to the console when the "Add Product" button is clicked on
   * the Produce Line tab. It also implements the method initializeDB when the same button is
   * pressed.
   */
  @FXML
  protected void handleAddButtonAction() {
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

  public void initialize() {

    numbersList.getItems().add("1");
    numbersList.getItems().add("2");
    numbersList.getItems().add("3");
    numbersList.getItems().add("4");
    numbersList.getItems().add("5");
    numbersList.getItems().add("6");
    numbersList.getItems().add("7");
    numbersList.getItems().add("8");
    numbersList.getItems().add("9");
    numbersList.getItems().add("10");

    for (ItemType itemChoices : ItemType.values()) {
      System.out.println(itemChoices + " " + itemChoices.code);
      productType.getItems().add(itemChoices);
    }

    // comboBox.getSelectionModel().selectFirst();
    numbersList.setEditable(true); // creates editable combo box
  }
}
