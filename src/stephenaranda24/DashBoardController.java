package stephenaranda24;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
import stephenaranda24.ProductWidget.ProductWidgetWithId;

/**
 * This controller class implements the actions of the program.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-09-21
 */
public class DashBoardController {
  ObservableList<Product> productsList;
  ObservableList<ProductionRecord> productionRecordList;
  @FXML private ListView<Product> productListView;
  @FXML private ComboBox<String> numbersList;
  @FXML private TextField manufacturerName;

  @FXML private TextField productName;

  @FXML private ChoiceBox<ItemType> productType;
  @FXML private TableView<Product> productTableView;

  @FXML private TableColumn<?, ?> productNameCol;
  @FXML private TableColumn<?, ?> productIdCol;
  @FXML private TableColumn<?, ?> manufacturerCol;

  @FXML private TableColumn<?, ?> itemTypeCol;
  @FXML private TextArea productLogTextArea;
  private String name = null;
  private String manufacturer = null;
  private ItemType type = null;
  private DataBaseManager db = new DataBaseManager();
  /**
   * This method initializes the numbers associated to the dropdown box named numbersList on the
   * Produce tab. This method contains all of the actions that are required to be implemented
   * when the program is first started, such as initializing the database, loading the database of products into the product table view and list view,
   * loading the database of production records into the text area in the production log.
   */
  public void initialize() {
    db.initializeDB();
    for (ItemType itemChoices : ItemType.values()) {
      System.out.println(itemChoices + " " + itemChoices.getCode());
      productType.getItems().add(itemChoices);
    }
    numbersList.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    numbersList.setEditable(true); // creates editable combo box
    numbersList.getSelectionModel().selectFirst();
    testMultimedia();
    setupProductLineTable();
    showProductionRecordFromDB();
  }

  /**
   * This method is used to test the MultimediaControl class along with its constructor(s).
   */
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
   * This method adds the name, manufacturer, and the item type of the product that is type in
   * by the user, into its database table by making use of the DataBaseManager class and instances of it. The database
   * values are loaded into an observable array list which is then displayed onto the product table view and the list view where
   * the user can create production logs.
   */
  @FXML
  protected void handleAddButtonAction() {
    db.initializeDB();
    productsList = FXCollections.observableArrayList(db.getAvailableDBProducts());
    // Product pr3 = new Prod
    int id = 0;
    for (Product obj : productsList) {
      id = obj.getId();
    name = productName.getText();
    manufacturer = manufacturerName.getText();
    type = productType.getValue();
    ProductWidgetWithId product = new ProductWidgetWithId(++id, name, manufacturer, type);
    db.addToProductsDB(name, manufacturer, type);
    db.closeDB();
    productTableView.getItems().add(product);
    }
  }
  /**
   * This method records the selected amount of the selected product in the list view onto a production log tab that is formatted using
   * the toString methods that were written for this program. It calls the method getPrOfSelectedItem which adds the production record into
   * its own database, which is also updated onto the text area when a production record is created.
   */
  @FXML
  protected void handleRecordButtonAction() {

    getPrOfSelectedProduct();
    System.out.println("Production Recorded");
  }

  /**
   * This method loads the production record database values onto the text area in the production log. It does so, by loading all the production
   * records into an observable array list named productionRecordList and then pulling each necessary field
   * from each object in the list and printing those values onto the text area after formatting with the toString.
   */
  public void showProductionRecordFromDB() {
    productionRecordList = FXCollections.observableArrayList((db.getAvailableDBProdRecords()));
    for (ProductionRecord obj : productionRecordList) {
      String productionNum = String.valueOf(obj.getProductionNum());
      String productId = String.valueOf(obj.getProductId());
      String serialNumber = String.valueOf(obj.getSerialNum());
      Date dateProd = obj.getProdDate();
      ProductionRecord pr1 =
          new ProductionRecord(
              Integer.parseInt(productionNum), Integer.parseInt(productId), serialNumber, dateProd);
      String prod1 = pr1.toString();
      productLogTextArea.appendText(prod1);
    }
  }

  /**
   * This method pulls the needed values from the selected product in the list view for the production record
   * of that product. It uses a for loop to print the production record however many times the user selects
   * from the numbersList combo box.
   */
  public void getPrOfSelectedProduct() {
    int ItemCount = 0;
    Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
    Integer selectedID = productListView.getSelectionModel().getSelectedItem().getId();
    ItemType selectedType = productListView.getSelectionModel().getSelectedItem().getType();
    String selectedManufacturer =
        productListView.getSelectionModel().getSelectedItem().getManufacturer();

    String serialNumber;
    for (int productionRunProduct = 0;
        productionRunProduct <= numbersList.getSelectionModel().getSelectedIndex();
        productionRunProduct++) {
      ArrayList<ProductionRecord> productionRecordList =
          new ArrayList<>(db.getAvailableDBProdRecords());
      // int selectedItemCount =
      // Integer.parseInt(numbersList.getSelectionModel().getSelectedItem());
      if (productionRecordList.size() == 0) {
        int productionNumber = 1;
        ProductionRecord pr =
            new ProductionRecord(productionNumber++, selectedProduct, ItemCount++);
        productLogTextArea.appendText(pr.toString());
        productionRecordList.add(pr);
        serialNumber =
            selectedManufacturer.substring(0, 3)
                + selectedType.getCode()
                + String.format("%05d", ItemCount);
        db.addToProductionRecordDB(selectedID, serialNumber);
        ItemCount++;

      } else {
        int productionNumber =
            productionRecordList.get(productionRecordList.size() - 1).getProductionNum();
        ProductionRecord pr = new ProductionRecord(++productionNumber, selectedProduct, ItemCount);
        String prod = pr.toString();
        productLogTextArea.appendText(prod);
        productionRecordList.add(pr);
        //    int selectedRecordQuantity++;
        serialNumber =
            selectedManufacturer.substring(0, 3)
                + selectedType.getCode()
                + String.format("%05d", ItemCount);
        db.addToProductionRecordDB(selectedID, serialNumber);
        ItemCount++;
      }
    }
  }

  /**
   * This method loads all products in the database into the table view and list view by loading the database values of the products into
   * an observable array list, and then loading that into each view. Then each column for the table view is set to the designated column in the database table
   * so that they can show correctly onto the table view.
   */
  public void setupProductLineTable() {

     productsList = FXCollections.observableArrayList(db.getAvailableDBProducts());
    productIdCol.setCellValueFactory(new PropertyValueFactory("id"));
    productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    itemTypeCol.setCellValueFactory(new PropertyValueFactory("type"));
    productTableView.setItems(productsList);
    productListView.setItems(productsList);
  }
}
