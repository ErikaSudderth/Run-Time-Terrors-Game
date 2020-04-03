package CatGame.Models;

/**
 * This is the collisions class.
 *
 * @author Hasler Zuniga last updated: 3/28/20
 */

import CatGame.Sprite.Mouse;
import CatGame.Sprite.Cheese;
import CatGame.Sprite.Hairball;
import CatGame.Sprite.Sprite;
import static java.lang.Math.sqrt;
import CatGame.ViewManagers.GameView;

public class CollisionObjects  {
    private Mouse mouse;
    private Sprite cat;
    private int xVal;
    private int yVal;

    public CollisionObjects(int _mouseX, int _mouseY){
        this.xVal = _mouseX;
        this.yVal = _mouseY;
    }

// Checks every object to see which one the mouse collided with)
//    public void withWhatObject(){
//
//        if (collisionCheck(this.cat))
//            System.out.println("Collided with Cat!");
//        System.out.println("nothing");
//    }

//This method detects collisions between objects.
   public boolean collisionCheck(Sprite _cat) {
        int radius = 128;
        int distanceX =  this.xVal - _cat.getX();
        int distanceY = this.yVal - _cat.getY();
        int distance = (int) sqrt((distanceX * distanceX) + (distanceY * distanceY));
        System.out.println(distance);
        if(distance <= radius){
            return true;
        }

        return false;
    }
}
