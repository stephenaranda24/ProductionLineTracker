package stephenaranda24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This controller class implements the actions of the program.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */
public class DashBoardController {
  @FXML private ListView<ProductWidget> productListView;
  @FXML private ComboBox<String> numbersList;
  @FXML private TextField manufacturerName;

  @FXML private TextField productName;

  @FXML private ChoiceBox<ItemType> productType;
  @FXML private TableView<ProductWidget> productTableView;

  @FXML private TableColumn<?, ?> productNameCol;

  @FXML private TableColumn<?, ?> manufacturerCol;

  @FXML private TableColumn<?, ?> itemTypeCol;
  @FXML private TextArea productLogTextArea;

  /** */
  public static void testMultimedia() {
    AudioPlayer newAudioProduct =
        new AudioPlayer(
            "DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct =
        new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen, MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }
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
   * This method prints "Product Added" to the console when the "Add Product" button is clicked on
   * the Produce Line tab. It also implements the method initializeDB when the same button is
   * pressed.
   */
  @FXML
  protected void handleAddButtonAction() {
    initializeDB();
    ProductWidget product =
        new ProductWidget(
            productName.getText(), manufacturerName.getText(), productType.getValue());
    productTableView.getItems().add(product);
  }
  /**
   * This method prints "Production Recorded" to the console when the "Record Production" button is
   * clicked on the Produce tab.
   */
  @FXML
  protected void handleRecordButtonAction() {
    System.out.println("Production Recorded");
  }

  /**
   * This method initializes the numbers associated to the dropdown box named numbersList on the
   * Produce tab. This method also initializes the item type values
   */
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
      System.out.println(itemChoices + " " + itemChoices.getCode());
      productType.getItems().add(itemChoices);
    }

    // comboBox.getSelectionModel().selectFirst();
    numbersList.setEditable(true); // creates editable combo box
    testMultimedia();
    ObservableList<ProductWidget> data = productLine();
    productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    itemTypeCol.setCellValueFactory(new PropertyValueFactory("type"));
    productTableView.setItems(data);
    productListView.setItems(data);
    // productLogTextArea.appendText();

  }

  public static ObservableList<ProductWidget> productLine() {
    return FXCollections.observableArrayList(
        new ProductWidget("iPhone", "Apple", ItemType.AUDIO),
        new ProductWidget("MacBook", "Apple", ItemType.VISUAL));
  }
}
