package CatGame.Events;

/**
 * This class defines the integer codes for all of the events. Author(s): Greg Last Updated: 3/20/20
 */
public class EventCodes {

	//These are the menu events.
	public static final int START_GAME = 1;
	public static final int HOW_TO_PLAY = 2;
	public static final int SETTINGS_MENU = 3;
	public static final int EXIT = 4;

	//These are the game's mouse character events.
	public static final int MOVE_LEFT = 5;
	public static final int MOVE_RIGHT = 6;
	public static final int MOVE_UP = 7;
	public static final int MOVE_DOWN = 8;
	public static final int CHEESE_PICKUP = 9;

	//These are general game events.
	public static final int ENEMY_COLLISION = 11;
	public static final int CLAW_FIRED = 12;
	public static final int CHEESE_DROPOFF = 13;

}
