package stephenaranda24;
/**
 * This interface includes the methods that will be implemented in the screen class.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public interface ScreenSpec {

  /**
   * Gets the resolution of the specific screen.
   *
   * @return A string value that represents the resolution of the screen.
   */
  String getResolution();

  /**
   * Gets the refresh rate of the specific screen.
   *
   * @return An integer value that represents the refresh rate of the screen.
   */
  int getRefreshRate();

  /**
   * Gets the response time of the specific screen.
   *
   * @return An integer value that represent the response time of the screen.
   */
  int getResponseTime();
}
