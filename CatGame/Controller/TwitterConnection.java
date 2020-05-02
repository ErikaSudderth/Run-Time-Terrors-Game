package CatGame.Controller;

/**
 * The purpose of this file is to call the API twitter bot so the high score can be posted on to twitter.
 * Author Hasler Zuniga
 * Last updated: 3/9/20
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnection implements SocialMediaInterface {

    private String authConsumerKey = "zkxzfcERcpPlZGpb9Xdiboo3J";
    private String authConsumerSecret = "Q6PEwZ88d6jnv5gRbR2Pw1f25f1DYxUqQHPTUcqsdS0YgliY9C";
    private String authAccessToken = "1222276825969131520-3iuVn78RpduNEViVwixUHDx6sFYBtT";
    private String authAccessTokenSecret = "AsYy7yoPW8lvkbY5fdQdcztktoBDq295Fr55AGsHQMKNz";
    private GameController controller;
    private ConfigurationBuilder configBuilder = new ConfigurationBuilder();
    private String success = "Your score has been successfully posted.";
    private String fail = "There was an error.\nYour score failed to post to Twitter.";


    public TwitterConnection(GameController _controller){
        this.controller = _controller;
    }
    /**
     * This method calls the Twitter API and sends the text to be posted.
     * @param _username - This is the player name/handle.
     * @param _score    - This is the player's score.
     */
    public void writeToSocialMedia(String _username, int _score) {
        this.configBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(this.authConsumerKey)
                .setOAuthConsumerSecret(this.authConsumerSecret)
                .setOAuthAccessToken(this.authAccessToken)
                .setOAuthAccessTokenSecret(this.authAccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(this.configBuilder.build());
        Twitter twitter = tf.getInstance();
        try {
            twitter.updateStatus(_username + ": " + _score);
            controller.showSuccessfulPost(success);
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterConnection.class.getName()).log(Level.SEVERE, null, ex);
            controller.showSuccessfulPost(fail);
        }
    }

}
