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

  /**
   * This is an overloaded constructor that contains the products name, its manufacturer, and its
   * item type as the parameters.
   *
   * @param name A string value that represents the name of the product.
   * @param manufacturer A string value that represents the manufacturer of the product.
   * @param type An object of the enum class ItemType that represents the item type of the product.
   */
  Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  /**
   * An overloaded constructor that takes the product Id, its name, manufacturer, and item
   * type as the arguments.
   *
   * @param id An integer value that represents the product Id.
   * @param name A string value that represents the name of the product.
   * @param manufacturer A string value that represents the manufacturer of the product.
   * @param type An object of the enum class ItemType that represents the item type of the product.
   */
  Product(int id, String name, String manufacturer, ItemType type) {
    this.Id = id;
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }
  /**
   * String formatter method.
   *
   * @return A string value after formatting.
   */

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

  /**
   * {@inheritDoc}
   */
  public int getId() {
    return Id;
  }
  /**
   *  {@inheritDoc}
   */

  public String getManufacturer() {
    return Manufacturer;
  }
  /**
   * {@inheritDoc}
   */

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }
  /**
   * {@inheritDoc}
   */

  public String getName() {
    return Name;
  }
  /**
   * {@inheritDoc}
   */

  public void setName(String name) {
    this.Name = name;
  }
  /**
   * Mutator/setter method for the name of the product.
   *
   * @param type An instance of the ItemType interface that represents the item type of the product.
   */

  public void setType(ItemType type) {
    this.Type = type;
  }
  /** {@inheritDoc} */

  public ItemType getType() {
    return Type;
  }
}
/**
 * This class tests the methods included in the abstract class "Product" by using its constructor.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */

class ProductWidget extends Product {

  /**
   * A constructor for the ProductWidget class that contains the product name, manufacturer, and
   * item type as its parameters.
   *
   * @param name A string value that represents the name of the product.
   * @param manufacturer A string value that represents the manufacturer of the product.
   * @param type An instance of the ItemType interface that represents what the item type of the
   *     product is.
   */
  ProductWidget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  /**
   * This class tests the methods included in the abstract class "Product" by using a constructor
   * that contains the product Id.
   *
   * @author Stephen Aranda
   * @version 1.0
   * @since 2019-11-03
   */
  static class ProductWidgetWithId extends Product {

    /**
     * A constructor that contains the product Id, its name, manufacturer, and item type os the
     * parameters.
     *
     * @param id An integer value that represents the Id of the product.
     * @param name A string value that represents the name of the product.
     * @param manufacturer A string value that represents the manufacturer of the product.
     * @param type An instance of the ItemType interface that represents the type of product.
     */
    ProductWidgetWithId(int id, String name, String manufacturer, ItemType type) {
      super(id, name, manufacturer, type);
    }
  }
}
