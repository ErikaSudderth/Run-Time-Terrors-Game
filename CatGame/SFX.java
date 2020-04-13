package CatGame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

/**
 *  This class lays out the SFX methods and enumerates the needed files.
 * Author(s): Greg Dwyer
 * LastUpdated: 4/12/20
 */
public class SFX {

    private static final String SFX_FOLDER = "src/resources/sfx/";
    private static final String CLICK_MEDIA = new File(SFX.SFX_FOLDER + "click.wav").toURI().toString();
    private static final String RELEASE_MEDIA = new File(SFX.SFX_FOLDER + "release.wav").toURI().toString();
    private static final String ERROR_MEDIA = new File(SFX.SFX_FOLDER + "error.wav").toURI().toString();
    private static final Media MUSIC_MEDIA = new Media(new File(SFX.SFX_FOLDER + "game_music.wav").toURI().toString());
    private static final String THROW_MEDIA = new File(SFX.SFX_FOLDER + "throw.wav").toURI().toString();
    private static final String COLLECT_MEDIA = new File(SFX.SFX_FOLDER + "collect.wav").toURI().toString();
    private static final String POINT_MEDIA = new File(SFX.SFX_FOLDER + "point.wav").toURI().toString();
    private static final String COLLISION_MEDIA = new File(SFX.SFX_FOLDER + "collision.wav").toURI().toString();
    private static final double MIN_VOL = 0.01;
    private static final double MAX_VOL = 0.4;
    private static final double VOL_STEP = 0.05;
    private static double volume = SFX.MAX_VOL;
    private static boolean sfxMute = false;
    private static MediaPlayer music;

    /**
     * This method plays the thrown object sound.
     */
    public static void playThrow() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.THROW_MEDIA);
        }
    }

    /**
     * This method plays the object collected sound.
     */
    public static void playCollect() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.COLLECT_MEDIA);
        }
    }

    /**
     * This method plays the sound for a scored point.
     */
    public static void playPoint() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.POINT_MEDIA);
        }
    }

    /**
     * This method plays the sound for object collision.
     */
    public static void playCollision() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.COLLISION_MEDIA);
        }
    }

    /**
     * This method plays the button clicked sound.
     */
    public static void playClick() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.CLICK_MEDIA);
        }
    }

    /**
     * This method plays the button released sound.
     */
    public static void playRelease() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.RELEASE_MEDIA);
        }
    }

    /**
     * This method plays the error sound.
     */
    public static void playError() {
        if (!SFX.sfxMute) {
            SFX.playSound(SFX.ERROR_MEDIA);
        }
    }

    /**
     * Call this method upon starting the application to continuously loop the pre-defined music.
     */
    public static void startMusic() {
        SFX.music = new MediaPlayer(SFX.MUSIC_MEDIA);
        SFX.music.setVolume(SFX.volume);
        SFX.music.setCycleCount(MediaPlayer.INDEFINITE);
        SFX.music.play();
    }

    /**
     * This method will increase the volume for all sfx and music.
     */
    public static void volUp() {
        if (SFX.volume < SFX.MAX_VOL) {
            SFX.volume += SFX.VOL_STEP;
            SFX.setVolume();
            return;
        }
        if (!SFX.sfxMute) {
            SFX.playError();
        }
    }

    /**
     * This method decreases the volume for all sfx and music.
     */
    public static void volDown() {
        if (SFX.volume > SFX.MIN_VOL) {
            SFX.volume -= SFX.VOL_STEP;
            SFX.setVolume();
            return;
        }
        if (!SFX.sfxMute) {
            SFX.playError();
        }
    }

    /**
     * This method will invert the sfxMute attribute.
     */
    public static void toggleSFXMute() {
        SFX.sfxMute = !SFX.sfxMute;
    }

    /**
     * This method inverts the music mute.
     */
    public static void toggleMusicMute() {
        SFX.music.setMute(!SFX.music.isMute());
    }

    /**
     * This method plays the passed sound file.
     */
    private static void playSound(String _sound) {
        AudioClip sound = new AudioClip(_sound);
        sound.setVolume(SFX.volume);
        sound.play();
    }

    /**
     * This method sets the volume for all sfx and music to the class volume attribute.
     */
    private static void setVolume() {
        SFX.music.setVolume(SFX.volume);
    }
//===========GETTERS=======================

    public static boolean getSFXMute() {
        return SFX.sfxMute;
    }
}
