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

  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {
    System.out.println("Playing Movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping Movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous Movie");
  }

  @Override
  public void next() {
    System.out.println("Next Movie");
  }

  public String toString() {
    return super.toString() + "\n" + screen + "\n" + "Monitor Type: " + monitorType;
  }
}
