package CatGame.Controller;

/**
 * The purpose of this file is to call the API.
 *
 *
 *
 * Author Hasler, Greg Last updated: 3/9/20
 *
 */
import CatGame.Models.TwitterConnection;
import twitter4j.TwitterException;

public class ApiAdaptor {

    private TwitterConnection api = new TwitterConnection();

    public void callAPI(String _highscore) throws TwitterException {

        api.postToTwitter(_highscore);

    }
}
