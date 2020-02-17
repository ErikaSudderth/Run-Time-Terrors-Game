/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

/**
 *
 * @author Latitude
 */
public class ButtonController {

	public static void buttonDecoder(String _button_name) {
		switch (_button_name) {
			case "Up":
				SFX.musicVolUp();
				System.out.println("Vol+");
				break;
			case "Down":
				SFX.musicVolDown();
				System.out.println("Vol-");
				break;
		}
	}
}
