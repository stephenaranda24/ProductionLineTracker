package stephenaranda24;

import java.util.Date;
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
  private Product productProduced;
  private int itemCount;

  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " "
        + "Product ID: "
        + productId
        + " "
        + "Serial Num: "
        + productProduced.getManufacturer().substring(0, 3)
        + productProduced.getType().getCode()
        + "0000"
        + itemCount
        + " "
        + "Date: "
        + new Date();
  }

  public ProductionRecord(int productId) {
    this.productId = productId;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  public ProductionRecord(
      int productionNumber, int productId, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public ProductionRecord(Product productProduced, int itemCount) {
    this.productProduced = productProduced;
    this.itemCount = itemCount;
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
    this.dateProduced = dateProduced;
  }

  public Date getProdDate() {
    return dateProduced;
  }
}
