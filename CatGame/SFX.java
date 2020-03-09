package CatGame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 *
 * @author Latitude
 */
public class SFX {
	private static final String SFX_FOLDER = "src/resources/sfx/";
	private static final Media CLICK = new Media(new File(SFX.SFX_FOLDER + "click.wav").toURI().toString());
	private static final Media RELEASE = new Media(new File(SFX.SFX_FOLDER + "release.wav").toURI().toString());
	private static final Media ERROR = new Media(new File(SFX.SFX_FOLDER + "error.wav").toURI().toString());
	private static final Media MUSIC = new Media(new File(SFX.SFX_FOLDER + "music.mp3").toURI().toString());
	private static final double MIN_VOL = 0.01;
	private static final double MAX_VOL = 0.4;
	private static final double VOL_STEP = 0.05;
	private static MediaPlayer music;

	public static void playClick() {
		MediaPlayer click = new MediaPlayer(SFX.CLICK);
		click.play();
	}

	public static void playRelease() {
		MediaPlayer release = new MediaPlayer(SFX.RELEASE);
		release.play();

	}

	public static void music() {
		music = new MediaPlayer(SFX.MUSIC);
		music.setVolume(SFX.MAX_VOL);
		music.setCycleCount(MediaPlayer.INDEFINITE);
		music.play();
	}

	public static void musicVolUp() {
		double volume = music.getVolume();
		if (volume < SFX.MAX_VOL) {
			music.setVolume(volume + SFX.VOL_STEP);
			return;
		}
		SFX.playError();
	}

	public static void musicVolDown() {
		double volume = music.getVolume();
		if (volume > SFX.MIN_VOL) {
			music.setVolume(volume - SFX.VOL_STEP);
			return;
		}
		SFX.playError();
	}

	public static void playError() {
		MediaPlayer error = new MediaPlayer(SFX.ERROR);
		error.setVolume(SFX.MAX_VOL);
		error.play();
	}
}
