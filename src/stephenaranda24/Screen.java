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

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

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
