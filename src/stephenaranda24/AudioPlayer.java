package stephenaranda24;
/**
 * This class captures the details of an audio player.
 *
 * @author Stephen Aranda
 * @version 1.0
 * @since 2019-11-03
 */

public class AudioPlayer extends Product implements MultimediaControl {
  private final String supportedAudioFormats;
  private final String supportedPlaylistFormats;

  /**
   * Constructor method for the AudioPlayer class, it holds the name, manufacturer, supported audio
   * formats, and its supported playlist formats as the parameters.
   *
   * @param name A string value that represents the name of the audio player.
   * @param manufacturer A string value that represents the manufacturer of the audio player.
   * @param supportedAudioFormats A string value that represents the supported audio formats of the
   *     audio player.
   * @param supportedPlaylistFormats A string value that represents the supported playlists formats
   *     of the audio player.
   */
  AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }
  /**
   * {@inheritDoc}
   * */

  @Override
  public void play() {
    System.out.println("Playing");
  }
  /**
   * {@inheritDoc}
   * */

  @Override
  public void stop() {
    System.out.println("Stopping");
  }
  /**
   * {@inheritDoc}
   * */

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * {@inheritDoc}
   * */
  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * String formatter method.
   *
   * @return A string value after formatting.
   */
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
