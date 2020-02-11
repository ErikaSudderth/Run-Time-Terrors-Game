
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterAPI {

    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("9zplEzOvItLs0hxC9yqtcQHmk")
                .setOAuthConsumerSecret("5bKaaLb5CJPKRYVRYd0ExbmGM3presHRQ69ibsocPRgveQzfLu")
                .setOAuthAccessToken("1222276825969131520-XhkgscVSqnnZIDfJxqsvMYu5nHYpt3")
                .setOAuthAccessTokenSecret("LKA2JeErj1KwE7hXluUcDoUtf1e81RPRnDmLnudxFOwrc");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        twitter.updateStatus("Today is Tuesday");
    }
}
