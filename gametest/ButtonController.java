
package gametest;

/**
 *
 * Not being used currently.
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
