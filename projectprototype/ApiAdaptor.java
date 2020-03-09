package projectprototype;

/**
 * The purpose of this file is to call the API.
 *
 *
 *
 * Author Hasler Last updated: 3/9/20
 *
 */
import twitter4j.TwitterException;

public class ApiAdaptor {

    private TwitterBot api = new TwitterBot();

    public void callAPI(String highscore) throws TwitterException {

        api.postToTwitter(highscore);

    }
}
