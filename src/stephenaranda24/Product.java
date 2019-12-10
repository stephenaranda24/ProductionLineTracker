package stephenaranda24;
/**
 * This abstract class contains the characteristics for the products that can be produced such as
 * the name, manufacturer, and the item type.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public abstract class Product implements Item {

  private int Id;
  private ItemType Type;
  private String Manufacturer;
  private String Name;

  Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  Product(int id, String name, String manufacturer, ItemType type) {
    this.Id = id;
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  public String toString() {
    return "ID: "
        + Id
        + "\n"
        + "Name: "
        + Name
        + "\n"
        + "Manufacturer: "
        + Manufacturer
        + "\n"
        + "Type: "
        + Type;
  }

  public int getId() {
    return Id;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public void setType(ItemType type) {
    this.Type = type;
  }

  public ItemType getType() {
    return Type;
  }
}
/**
 * This class tests the methods included in the abstract class "Product".
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
class ProductWidget extends Product {
  ProductWidget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  static class ProductWidgetWithId extends Product {
    ProductWidgetWithId(int id, String name, String manufacturer, ItemType type) {
      super(id, name, manufacturer, type);
    }
  }
}
