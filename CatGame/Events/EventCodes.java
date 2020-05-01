package CatGame.Events;

/**
 * This class defines the integer codes for all of the events.
 * Author(s): Greg, Hasler
 * Last Updated: 4/22/20
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
    public static final int ENEMY_COLLISION = 11;
    public static final int CLAW_FIRED = 12;
    public static final int CHEESE_DROPOFF = 13;

    //These are additional menu events.
    public static final int VOL_UP = 14;
    public static final int VOL_DOWN = 15;
    public static final int TOGGLE_SFX = 16;
    public static final int TOGGLE_MUSIC = 17;

    //These are end game events.
    public static final int YES_POST_TO_SOCIAL_MEDIA = 18;
    public static final int NO_POST_TO_SOCIAL_MEDIA = 19;
}
