import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class GameAudio {

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl controlVolume;

	URL firstNumberSoundURL = getClass().getResource("firstNumberSound.wav");
	URL congratulationsSoundURL = getClass().getResource("congratulationsSound.wav");
	URL maxScoreSoundURL = getClass().getResource("maxScoreSound.wav");
	URL wrongInputSoundURL = getClass().getResource("wrongInput.wav");
	URL skipSoundURL = getClass().getResource("skipSound.wav");
	URL resetSoundURL = getClass().getResource("resetSound.wav");
	URL exitSoundURL = getClass().getResource("exitSound.wav");
	URL backgroundMusicURL = getClass().getResource("backgroundMusic.wav");

	public void playBackgroundMusic() {
		startBackgroundMusic(backgroundMusicURL);
	}

	// DONE: play a sound when the user enters the first number of Pi
	public void playFirstNumberSound() {
		startMiscMusic(firstNumberSoundURL);
	}

	public void playCongratsSound() {
		startMiscMusic(congratulationsSoundURL);
	}

	public void playMaxScoreSound() {
		startMiscMusic(maxScoreSoundURL);
	}

	public void playWrongInputSound() {
		startMiscMusic(wrongInputSoundURL);
	}

	public void playSkipSound() {
		startMiscMusic(skipSoundURL);
	}

	public void playResetSound() {
		startMiscMusic(resetSoundURL);
	}

	public void playExitSound() {
		startMiscMusic(exitSoundURL);
	}

	public void startBackgroundMusic(URL soundURL) {
		try {
			streamAudio = AudioSystem.getAudioInputStream(soundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-48.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void startMiscMusic(URL soundURL) {
		try {
			streamAudio = AudioSystem.getAudioInputStream(soundURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-12.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
