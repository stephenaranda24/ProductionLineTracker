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
   * Produce tab. This method also initializes the item type values
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
   * This method prints "Product Added" to the console when the "Add Product" button is clicked on
   * the Produce Line tab. It also implements the method initializeDB when the same button is
   * pressed.
   */
  @FXML
  protected void handleAddButtonAction() {
    db.initializeDB();
    ObservableList<Product> productsList =
        FXCollections.observableArrayList(db.getAvailableDBProducts());
    // Product pr3 = new Prod
    int id = 0;
    for (Product obj : productsList) id = obj.getId();
    name = productName.getText();
    manufacturer = manufacturerName.getText();
    type = productType.getValue();
    ProductWidgetWithId product = new ProductWidgetWithId(++id, name, manufacturer, type);
    db.addToProductsDB(name, manufacturer, type);
    db.closeDB();
    productTableView.getItems().add(product);
  }
  /**
   * This method prints "Production Recorded" to the console when the "Record Production" button is
   * clicked on the Produce tab.
   */
  @FXML
  protected void handleRecordButtonAction() {

    //    for (int productionRunProduct = 0;
    //        productionRunProduct <= numbersList.getSelectionModel().getSelectedIndex();
    //        productionRunProduct++) {
    //      db.addToProductionRecordDB(selectedID, serialNumber);
    //    }
    getPrOfSelectedItem();
    System.out.println("Production Recorded");

    ;
  }

  public void showProductionRecordFromDB() {
    ObservableList<ProductionRecord> productionRecordList =
        FXCollections.observableArrayList((db.getAvailableDBProdRecords()));
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

  public void getPrOfSelectedItem() {
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
        String prod = pr.toString();
        productLogTextArea.appendText(prod);
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

  public void setupProductLineTable() {

    ObservableList<Product> data = FXCollections.observableArrayList(db.getAvailableDBProducts());
    productIdCol.setCellValueFactory(new PropertyValueFactory("id"));
    productNameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    itemTypeCol.setCellValueFactory(new PropertyValueFactory("type"));
    productTableView.setItems(data);
    productListView.setItems(data);
  }
}
