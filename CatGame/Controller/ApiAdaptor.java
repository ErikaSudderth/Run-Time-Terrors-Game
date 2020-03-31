package CatGame.Controller;

/**
 * The purpose of this file is to call the API.
 *
 *
 *
 * Author Hasler, Greg Last updated: 3/9/20
 *
 */
import CatGame.Models.PostToConnection;
import twitter4j.TwitterException;

public class ApiAdaptor {

	private PostToConnection api = new PostToConnection();

	public void callAPI(String _highscore) throws TwitterException {

		api.postToTwitter(_highscore);

	}
}
