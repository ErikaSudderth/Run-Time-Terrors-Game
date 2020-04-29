package CatGame.Sprite;

/**
 * This animation class is adapted from an example by Michael Heinrichs found at netopyr.com/2012/03/09/creating-a-sprite-animation-with-javafx/. A SpriteAnimation object sets and plays the frames for
 * a sprite. Author(s): Michael Heinrichs, Greg Dwyer Last Updated: 3/20/20
 */
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

    private final ImageView IMAGE_VIEW;
    private final int FRAME_COUNT;
    private final int COLUMNS;
    private final int OFFSET_X;
    private final int OFFSET_Y;
    private final int WIDTH;
    private final int HEIGHT;

    private int lastIndex;

    public SpriteAnimation(ImageView _imageView, Duration _duration, int _frameCount, int _columns, int _offsetX, int _offsetY, int _width, int _height) {
        this.IMAGE_VIEW = _imageView;
        this.FRAME_COUNT = _frameCount;
        this.COLUMNS = _columns;
        this.OFFSET_X = _offsetX;
        this.OFFSET_Y = _offsetY;
        this.WIDTH = _width;
        this.HEIGHT = _height;
        this.setCycleDuration(_duration);
        this.setInterpolator(Interpolator.LINEAR);
    }

    /**
     * Interpolate is called in every frame and calculates which frame needs to be displayed at the given moment.
     *
     * @param _k This parameter is set by the Transition class and is a relative time position in the frame.
     */
    @Override
    protected void interpolate(double _k) {
        final int index = Math.min((int) Math.floor(_k * this.FRAME_COUNT), this.FRAME_COUNT - 1);
        if (index != this.lastIndex) {
            final int x = (index % this.COLUMNS) * this.WIDTH + this.OFFSET_X;
            final int y = (index / this.COLUMNS) * this.HEIGHT + this.OFFSET_Y;
            this.IMAGE_VIEW.setViewport(new Rectangle2D(x, y, this.WIDTH, this.HEIGHT));
            this.lastIndex = index;
        }
    }
}
