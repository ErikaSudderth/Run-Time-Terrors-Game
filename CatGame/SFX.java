package CatGame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.util.Duration;

/**
 *
 * @author Latitude
 */
public class SFX {

    private static final String SFX_FOLDER = "src/resources/sfx/";
    private static final Media CLICK_MEDIA = new Media(new File(SFX.SFX_FOLDER + "click.wav").toURI().toString());
    private static final Media RELEASE_MEDIA = new Media(new File(SFX.SFX_FOLDER + "release.wav").toURI().toString());
    private static final Media ERROR_MEDIA = new Media(new File(SFX.SFX_FOLDER + "error.wav").toURI().toString());
    private static final Media MUSIC_MEDIA = new Media(new File(SFX.SFX_FOLDER + "music.mp3").toURI().toString());
    private static final double MIN_VOL = 0.01;
    private static final double MAX_VOL = 0.4;
    private static final double VOL_STEP = 0.05;
    private static double volume = SFX.MAX_VOL;
    private static boolean sfxMute = false;
    private static MediaPlayer click = new MediaPlayer(SFX.CLICK_MEDIA);
    private static MediaPlayer release = new MediaPlayer(SFX.RELEASE_MEDIA);
    private static MediaPlayer error = new MediaPlayer(SFX.ERROR_MEDIA);
    private static MediaPlayer music;

    public static void playClick() {
        SFX.click.seek(Duration.ZERO);
        SFX.click.play();
    }

    public static void playRelease() {
        SFX.release.seek(Duration.ZERO);
        SFX.release.play();
    }

    public static void playError() {
        SFX.error.seek(Duration.ZERO);
        SFX.error.play();
    }

    public static void startMusic() {
        SFX.music = new MediaPlayer(SFX.MUSIC_MEDIA);
        SFX.music.setVolume(SFX.volume);
        SFX.music.setCycleCount(MediaPlayer.INDEFINITE);
        SFX.music.play();
    }

    public static void volUp() {
        if (SFX.volume < SFX.MAX_VOL) {
            SFX.volume += SFX.VOL_STEP;
            SFX.setVolume();
            return;
        }
        SFX.playError();
    }

    public static void volDown() {
        if (SFX.volume > SFX.MIN_VOL) {
            SFX.volume -= SFX.VOL_STEP;
            SFX.setVolume();
            return;
        }
        SFX.playError();
    }

    public static void toggleSFXMute() {
        SFX.sfxMute = !SFX.sfxMute;
        SFX.click.setMute(SFX.sfxMute);
        SFX.release.setMute(SFX.sfxMute);
        SFX.error.setMute(SFX.sfxMute);
    }

    public static void toggleMusicMute() {
        SFX.music.setMute(!SFX.music.isMute());
    }

    private static void setVolume() {
        SFX.click.setVolume(SFX.volume);
        SFX.release.setVolume(SFX.volume);
        SFX.error.setVolume(SFX.volume);
        SFX.music.setVolume(SFX.volume);
    }
}
