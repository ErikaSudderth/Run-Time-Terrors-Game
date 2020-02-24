package Prototype;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterBot {

    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("zkxzfcERcpPlZGpb9Xdiboo3J")
                .setOAuthConsumerSecret("Q6PEwZ88d6jnv5gRbR2Pw1f25f1DYxUqQHPTUcqsdS0YgliY9C")
                .setOAuthAccessToken("1222276825969131520-3iuVn78RpduNEViVwixUHDx6sFYBtT")
                .setOAuthAccessTokenSecret("AsYy7yoPW8lvkbY5fdQdcztktoBDq295Fr55AGsHQMKNz");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        twitter.updateStatus("Hellooo");
    }
}
