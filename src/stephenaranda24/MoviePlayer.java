package stephenaranda24;
/**
 * This class contains all of the characteristics of a movie player.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public class MoviePlayer extends Product implements MultimediaControl {
  private Screen screen;
  private MonitorType monitorType;

  /**
   * Constructor method for the MoviePlayer class that has the name of the product, its manufacturer, screen specifications, and monitor type
   * as the parameters.
   * @param name A string value that represents the name of the product.
   * @param manufacturer A string value that represents the manufacturer of the product.
   * @param screen An instance of the Screen class which holds the the screen specifications.
   * @param monitorType An instance of the enum class MonitorType that represents the item type of monitor.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void play() {
    System.out.println("Playing Movie");
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public void stop() {
    System.out.println("Stopping Movie");
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public void previous() {
    System.out.println("Previous Movie");
  }
  /**
   * {@inheritDoc}
   */
  @Override
  public void next() {
    System.out.println("Next Movie");
  }
  /**
   * {@inheritDoc}
   */
  public String toString() {
    return super.toString() + "\n" + screen + "\n" + "Monitor Type: " + monitorType;
  }
}
