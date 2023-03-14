import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioMain {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioPlayer musicPlayer = new AudioPlayer();
		musicPlayer.startPlayer();
	}

}
