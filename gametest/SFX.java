/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 *
 * @author Latitude
 */
public class SFX {
	private static final Media CLICK = new Media(new File("src/resources/click.wav").toURI().toString());
	private static final Media RELEASE = new Media(new File("src/resources/release.wav").toURI().toString());
	private static final Media MUSIC = new Media(new File("src/resources/music.mp3").toURI().toString());
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
		music.setVolume(.5);
		music.setRate(.92);
		music.setCycleCount(MediaPlayer.INDEFINITE);
		music.play();
	}

	public static void musicVolUp(){
		double volume = music.getVolume();
		if (volume < 1){
			music.setVolume(volume + .05);
			System.out.println(music.getVolume());
		}
	}

	public static void musicVolDown(){
		double volume = music.getVolume();
		if (volume > 0){
			music.setVolume(volume - .05);
			System.out.println(music.getVolume());
		}
	}
}
