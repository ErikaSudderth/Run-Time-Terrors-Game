package CatGame.Controller;

/**
 * The purpose of this file is to call the API.
 * Author Hasler, Greg
 * Last updated: 3/9/20
 *
 */

public class SocialMediaApiAdaptor implements SocialMediaInterface {

    protected static final SocialMediaInterface api = new TwitterConnection();

    public void writeToSocialMedia(String _username, int _score) {
        api.writeToSocialMedia(_username, _score);
    }
}
