package CatGame.Controller;

/**
 * This interface defines the methods that need to be implemented for any valid API translator class.
 * @author Hasler Zuniga
 * Last Updated 4/15/20
 */
public interface SocialMediaInterface {

    /**
     * This is the generic method for writing to Social Media.
     * @param username - This is the name no be posted.
     * @param score  - This is the player's score to be posted
     */
    public abstract void writeToSocialMedia(String username, int score);

}
