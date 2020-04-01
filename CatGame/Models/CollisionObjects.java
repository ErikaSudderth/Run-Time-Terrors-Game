package CatGame.Models;

/**
 * This is the collisions class.
 *
 * @author Hasler Zuniga last updated: 3/28/20
 */

import CatGame.Sprite.Cat;
import CatGame.Sprite.Mouse;
import CatGame.Sprite.Cheese;
import CatGame.Sprite.Hairball;
import CatGame.Sprite.Sprite;
import static java.lang.Math.sqrt;

public class CollisionObjects  {
    private Cat cat;
    private Mouse mouse;
    private Cheese cheese;
    private Hairball hairball;
// Checks every object to see which one the mouse collided with)
    public void withWhatObject(){

        if (collisionCheck(mouse,cat) == true)
            System.out.println("Collided with Cat!");

    }

//This method detects collisions between objects.
   public boolean collisionCheck(Sprite object1, Sprite object2) {
        int radius = object1.
        int distanceX = object1.getXPos() - object2.getXPos();
        int distanceY = object1.getYPos() - object2.getYPos();
        int distance = (int) sqrt((distanceX * distanceX) + (distanceY * distanceY));
        System.out.println(distance);
        if(distance <= object1.get){
            return true;
        }

        return false;
    }
}
