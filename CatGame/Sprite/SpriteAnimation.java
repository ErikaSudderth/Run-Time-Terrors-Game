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

    private final ImageView imageView;
    private final int frameCount;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;

    private int lastIndex;

    public SpriteAnimation(ImageView _imageView, Duration _duration, int _frameCount, int _columns, int _offsetX, int _offsetY, int _width, int _height) {
        this.imageView = _imageView;
        this.frameCount = _frameCount;
        this.columns = _columns;
        this.offsetX = _offsetX;
        this.offsetY = _offsetY;
        this.width = _width;
        this.height = _height;
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
        final int index = Math.min((int) Math.floor(_k * this.frameCount), this.frameCount - 1);
        if (index != this.lastIndex) {
            final int x = (index % this.columns) * this.width + this.offsetX;
            final int y = (index / this.columns) * this.height + this.offsetY;
            this.imageView.setViewport(new Rectangle2D(x, y, this.width, this.height));
            this.lastIndex = index;
        }
    }
}
