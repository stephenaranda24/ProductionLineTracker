package stephenaranda24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javafx.fxml.FXML;
import stephenaranda24.ProductWidget.ProductWidgetWithId;

/**
 * This database managing class implements all database methods of the program.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */
class DataBaseManager {
  private Connection conn;
  private String productQuery;
  private PreparedStatement preparedStatement;
  private ResultSet result;
  //  Database credentials
  /**
   * This method initializes the database named "ProductionDataBase" and connects to it. It allows
   * for the addition of data into the database.
   */

  @FXML
  void initializeDB() {

    try {
      // STEP 1: Register JDBC driver
      final String JDBC_DRIVER = "org.h2.Driver";
      Class.forName(JDBC_DRIVER);
      // System.out.println("Driver Registered.");

      // STEP 2: Open a connection
      final String DB_URL = "jdbc:h2:./res/ProductionDataBase";
      // to create a database username and password,
      // type Create USER [username] PASSWORD "[password]"
      // Properties props = new Properties();
      // props.load(new FileInputStream("res/"));
      Properties props = new Properties();
      props.setProperty("username", "root");
      props.setProperty("password", "root");
      props.store(new FileOutputStream("res/db.properties"), "");
      props.load(new FileInputStream("res/db.properties"));
      String USER = props.getProperty("username");
      String PASS = props.getProperty("password");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      // System.out.println("Connection opened");

    } catch (ClassNotFoundException | SQLException | IOException exception) {
      exception.printStackTrace();
    }
  }
  /** This method closes the DataBase opened in initializeDB. */

  public void closeDB() {
    try {
      result.close();
      preparedStatement.close();
      conn.close();
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    // System.out.println("DataBase Closed");
  }

  /**
   * This method uses prepared statements to insert items into the Product database table.
   *
   * @param name This is the name of the product.
   * @param manufacturer This is the manufacturer of the product.
   * @param type This is the item type of the product.
   */
  void addToProductsDB(String name, String manufacturer, ItemType type) {
    initializeDB();
    String[] product = {name, manufacturer, String.valueOf(type)};
    int index = 1;
    try {
      // STEP 3: Execute a query
      productQuery = "INSERT INTO PRODUCT(NAME, MANUFACTURER, TYPE) VALUES(?, ?, ?);";
      preparedStatement = conn.prepareStatement(productQuery);
      for (String item : product) {
        preparedStatement.setString(index, item);
        index++;
      }
      preparedStatement
          .executeUpdate(); // Execute Update here since the Query is INSERT, UPDATE, OR DELETE
    } catch (SQLException exception) {
      exception.printStackTrace();
    } finally {
      closeDB();
    }
    System.out.println("Product Added");
  }

  /**
   * This method uses a prepared statement to return the products in the product table as a List of
   * type product.
   *
   * @return The list of products from the database is returned.
   */
  public List<Product> getAvailableDBProducts() {
    initializeDB();
    List<Product> productLine = new ArrayList<>();
    try {
      productQuery = "SELECT * FROM PRODUCT;";
      preparedStatement = conn.prepareStatement(productQuery);
      result = preparedStatement.executeQuery(); // Execute Query here since Query is SELECT
      while (result.next()) {
        int ID = result.getInt("ID");
        String name = result.getString("NAME");
        String manufacturer = result.getString("MANUFACTURER");
        String type = result.getString("TYPE");
        productLine.add(new ProductWidgetWithId(ID, name, manufacturer, ItemType.valueOf(type)));
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    } finally {
      closeDB();
    }
    return productLine;
  }

  /**
   * This method uses a prepared statement to return the production records in the database table as
   * a List of type ProductionRecord.
   *
   * @return The list of production records from the database is returned.
   */
  public List<ProductionRecord> getAvailableDBProdRecords() {
    initializeDB();
    List<ProductionRecord> productionRun = new ArrayList<>();
    try {
      productQuery = "SELECT * FROM PRODUCTIONRECORD;";
      preparedStatement = conn.prepareStatement(productQuery);
      result = preparedStatement.executeQuery(); // Execute Query here since Query is SELECT
      while (result.next()) {
        int prodNumber = result.getInt("PRODUCTION_NUM");
        int prodID = result.getInt("PRODUCT_ID");
        String serialNum = result.getString("SERIAL_NUM");
        Date dateProd = result.getTimestamp("DATE_PRODUCED");
        productionRun.add(new ProductionRecord(prodNumber, prodID, serialNum, dateProd));
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    } finally {
      closeDB();
    }
    return productionRun;
  }

  /**
   * This method makes it so that you are able to add a production record into its database table.
   *
   * @param ID An integer that represents the Id of the production record.
   * @param serialNumber A string value that represents the serial number of the production record.
   */
  void addToProductionRecordDB(Integer ID, String serialNumber) {
    initializeDB();
    try {
      Date now = new Date();
      Timestamp ts = new Timestamp((now.getTime()));
      // Execute Query
      productQuery =
          "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES(?, ?, ?);";
      preparedStatement = conn.prepareStatement(productQuery);
      preparedStatement.setInt(1, ID);
      preparedStatement.setString(2, serialNumber);
      preparedStatement.setTimestamp(3, ts);
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      closeDB();
    }
  }
}
