package stephenaranda24;
/**
 * This class captures the details of an audio player
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */

public class AudioPlayer extends Product implements MultimediaControl {
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  public String toString() {
    return super.toString()
        + "\n"
        + "Supported Audio Formats: "
        + this.supportedAudioFormats
        + "\n"
        + "Supported Playlist Formats: "
        + this.supportedPlaylistFormats;
  }
}
