package CatGame.Controller;

/**
 * The purpose of this file is to call the API.
 * Author Hasler, Greg
 * Last updated: 3/9/20
 *
 */

public class SocialMediaApiAdaptor implements SocialMediaInterface {

    protected static SocialMediaInterface api;
    private GameController controller;

    public SocialMediaApiAdaptor(GameController _controller){
        this.controller = _controller;
        this.api = new TwitterConnection(this.controller);
    }

    public void writeToSocialMedia(String _username, int _score) {
        this.api.writeToSocialMedia(_username, _score);
    }
}
