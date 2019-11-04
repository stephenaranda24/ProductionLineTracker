package stephenaranda24;
/**
 * This enum stores the item types of the products that are to be made.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */
public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  private String code;

  ItemType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
