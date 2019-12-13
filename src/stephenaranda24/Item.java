package stephenaranda24;
/**
 * This interface declares the methods that will be implemented throughout this project.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */

public interface Item {

  /**
   * The accessor/setter method for the Id of the Item.
   *
   * @return An integer that represents the Id.
   */
  int getId();
  /**
   * The mutator/setter method for the name of the item. It makes it so you can change its value.
   *
   * @param name A string value that represents the name of the Item.
   */

  void setName(String name);

  /**
   * The accessor/getter method for the name of the item.
   *
   * @return A string value that represents the name of the item.
   */
  String getName();

  /**
   * The mutator/setter method for the manufacturer of the item. It makes it so you can change its
   * value.
   *
   * @param manufacturer A string value that represents the manufacturer of the item.
   */
  void setManufacturer(String manufacturer);

  /**
   * The accessor/getter method for the manufacturer of the item.
   *
   * @return A string value that represents the manufacturer of the item.
   */
  String getManufacturer();

  /**
   * The accessor/getter method for the type of item.
   *
   * @return An instance of the ItemType interface.
   */
  ItemType getType();
}
