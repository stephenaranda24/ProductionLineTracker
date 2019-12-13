package stephenaranda24;
/**
 * This class contains the details for a screen such as its resolution, refresh rate, and response
 * time.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public class Screen implements ScreenSpec {
  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   *  {@inheritDoc}
   */
  @Override
  public String getResolution() {
    return resolution;
  }
  /**
   *  {@inheritDoc}
   */
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }
  /**
   *  {@inheritDoc}
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * The constructor method to the screen class, which makes use of the parameters resolution, refreshRate, and responseTime.
   *
   * @param resolution A string value that represents the resolution of the screen.
   * @param refreshRate An integer value that represents the refresh rate of the screen.
   * @param responseTime An integer value that represents the response time of the screen.
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * String Formatter method.
   * @return The string value of the specifications after formatting.
   */
  public String toString() {
    return "Screen:"
        + "\n"
        + "Resolution: "
        + this.resolution
        + "\n"
        + "Refresh rate: "
        + refreshRate
        + "\n"
        + "Response time: "
        + this.responseTime;
  }
}
