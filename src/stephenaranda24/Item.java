package stephenaranda24;
/**
 * This interface declares the methods that will be implemented throughout this project.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public interface Item {

  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();

  ItemType getType();
}
