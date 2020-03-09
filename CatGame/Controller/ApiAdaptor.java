package CateGame.Controller;

/**
 * The purpose of this file is to call the API.
 *
 *
 *
 * Author Hasler Last updated: 3/9/20
 *
 */
import projectprototype.TwitterBot;
import twitter4j.TwitterException;

public class ApiAdaptor {

    private TwitterBot api = new TwitterBot();

    public void callAPI(String _highscore) throws TwitterException {

        api.postToTwitter(_highscore);

    }
}
