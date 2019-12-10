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

  public ProductionRecord(
      int productionNumber, int productId, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = new Timestamp(dateProduced.getTime());
  }

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

  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getProductId() {
    return productId;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Timestamp(dateProduced.getTime());
  }

  public Date getProdDate() {
    return new Timestamp(this.dateProduced.getTime());
  }
}
