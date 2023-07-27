import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class GameAudio {

	AudioInputStream streamAudio;
	Clip audioClip;
	FloatControl controlVolume;

	URL congratulationsSoundURL = getClass().getResource("congratulationsSound.wav");
	URL maxScoreSoundURL = getClass().getResource("maxScoreSound.wav");
	URL wrongInputSoundURL = getClass().getResource("wrongInput.wav");
	URL skipSoundURL = getClass().getResource("skipSound.wav");
	URL resetSoundURL = getClass().getResource("resetSound.wav");
	URL exitSoundURL = getClass().getResource("exitSound.wav");
	URL backgroundMusicURL = getClass().getResource("backgroundMusic.wav");

	public void playBackgroundMusic() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(backgroundMusicURL);
			audioClip = AudioSystem.getClip();
			audioClip.open(streamAudio);
			controlVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			controlVolume.setValue(-36.0f);
			audioClip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playCongratsSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(congratulationsSoundURL);
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

	public void playMaxScoreSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(maxScoreSoundURL);
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

	public void playWrongInputSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(wrongInputSoundURL);
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

	public void playSkipSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(skipSoundURL);
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

	public void playResetSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(resetSoundURL);
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

	public void playExitSound() {
		try {
			streamAudio = AudioSystem.getAudioInputStream(exitSoundURL);
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
