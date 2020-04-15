/**
 * The purpose of this file is to call the API twitter bot so the high score can be posted on to twitter.
 *
 *
 *
 * Author Hasler Last updated: 3/9/20
 *
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnection implements SocialMediaInterface{
    private String authConsumerKey = "zkxzfcERcpPlZGpb9Xdiboo3J";
    private String authConsumerSecret = "Q6PEwZ88d6jnv5gRbR2Pw1f25f1DYxUqQHPTUcqsdS0YgliY9C";
    private String authAccessToken = "1222276825969131520-3iuVn78RpduNEViVwixUHDx6sFYBtT";
    private String authAccessTokenSecret = "AsYy7yoPW8lvkbY5fdQdcztktoBDq295Fr55AGsHQMKNz";
    private ConfigurationBuilder cb = new ConfigurationBuilder();

//    This method hold the api call and writes to twitter feed
    public void writeToSocialMedia(String _username, int score) {
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(this.authConsumerKey)
                .setOAuthConsumerSecret(this.authConsumerSecret)
                .setOAuthAccessToken(this.authAccessToken)
                .setOAuthAccessTokenSecret(this.authAccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            twitter.updateStatus(_username +": " + score);
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
