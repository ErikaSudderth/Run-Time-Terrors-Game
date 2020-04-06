package CatGame.Events;

/**
 * This class defines the integer codes for all of the events. Author(s): Greg Last Updated: 3/20/20
 */
public class EventCodes {

    //These are the menu events.
    public static final int START_GAME = 1;
    public static final int HOW_TO_PLAY = 2;
    public static final int HIGHSCORES = 3;
    public static final int SETTINGS_MENU = 4;
    public static final int EXIT = 5;

    //These are the game's mouse character events.
    public static final int MOVE_LEFT = 6;
    public static final int MOVE_RIGHT = 7;
    public static final int MOVE_UP = 8;
    public static final int MOVE_DOWN = 9;
    public static final int CHEESE_PICKUP = 10;

    //These are general game events.
    public static final int ENEMY_COLLISION = 12;
    public static final int CLAW_FIRED = 13;
    public static final int CHEESE_DROPOFF = 14;

    //These are additional menu events.
    public static final int VOL_UP = 15;
    public static final int VOL_DOWN = 16;
    public static final int TOGGLE_SFX = 17;
    public static final int TOGGLE_MUSIC = 18;
    

}
