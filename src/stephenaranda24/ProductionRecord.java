package stephenaranda24;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class contains all of the details for a production record such as the production number, the
 * product Id, the serial number, date produced, products produced, and their item counts.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public class ProductionRecord {
  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;
  // private Product productProduced;
  // private ProductionRecord productionRecordProduced;
  // private int itemCount = 0;
  /**
   * String formatter method.
   *
   * @return A string value after formatting.
   */
  @Override

  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " "
        + "Product ID: "
        + productId
        + " "
        + "Serial Num: "
        + serialNumber
        + " "
        + "Date: "
        + dateProduced
        + "\n";
  }

  /**
   * This method is an overloaded constructor for the ProductionRecord class. It takes in a products
   * Id, its serial number, and the date it was produced.
   *
   * @param productionNumber An integer value that represents the production number of the product.
   * @param productId An integer value that represents the Id of the product.
   * @param serialNumber A string value that represents the serial number of the product.
   * @param dateProduced An object of the date class that represents the date the product was
   *     produced.
   */
  public ProductionRecord(
      int productionNumber, int productId, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = new Timestamp(dateProduced.getTime());
  }

  /**
   * This method is an overloaded constructor of the ProductionRecord class, which takes in a
   * products production number, the product produced, and its item count as its parameters.
   *
   * @param productionNumber An integer value that represents the production number of the product.
   * @param productProduced An object of the Product class that represents the product produced.
   * @param itemCount An integer value that represents the item count of the product.
   */
  public ProductionRecord(int productionNumber, Product productProduced, int itemCount) {
    // this.productProduced = productProduced;
    // this.itemCount = itemCount;
    this.productionNumber = productionNumber;
    productId = productProduced.getId();
    serialNumber =
        productProduced.getManufacturer().substring(0, 3)
            + productProduced.getType().getCode()
            + String.format("%05d", itemCount);
    Date now = new Date();
    dateProduced = new Timestamp(now.getTime());
  }

  /**
   * Changes the production number of this production record.
   *
   * @param productionNumber An integer value that represents the production number.
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * This method retrieves the production number of the product record.
   *
   * @return The production number of the production record.
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * This method changes the product Id of the production record.
   *
   * @param productId An integer value that represents the product Id.
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * This method retrieves the product Id of the production record.
   *
   * @return The product Id of the production record.
   */
  public int getProductId() {
    return productId;
  }

  /**
   * This method changes the serial number of the production record.
   *
   * @param serialNumber A string value that represents the serial number of the production record.
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This method retrieves the serial number of the production record.
   *
   * @return The
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * This method is the setter/mutator method for the production date of the product.
   *
   * @param dateProduced An object of the Date class.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Timestamp(dateProduced.getTime());
  }

  /**
   * This method retrieves the production date of the product.
   *
   * @return A Timestamp object is returned.
   */
  public Date getProdDate() {
    return new Timestamp(this.dateProduced.getTime());
  }
}
