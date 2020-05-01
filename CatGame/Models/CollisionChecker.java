package CatGame.Models;

/**
 * This class holds the logic for checking collisions.
 * Author(s) Gregory Dwyer, Hasler Zuniga
 * Last updated: 4/30/20
 */

import CatGame.Controller.GameController;
import CatGame.Sprite.Mouse;
import java.util.List;
import javafx.geometry.Bounds;
import javafx.scene.Node;

public class CollisionChecker {

    private final GameController CONTROLLER;
    private final Mouse MOUSE;
    private final int FUDGE = 15;
    private final static String CAT = "cat";
    private final static String CLAW = "claw";
    private final static String CHEESE = "cheese";
    private final static String HAIRBALL = "hairball";
    private final static String DOOR = "door";
    private boolean testScenario = false;

    public CollisionChecker(GameController _cont, Mouse _mouse) {
        this.CONTROLLER = _cont;
        this.MOUSE = _mouse;
        this.testScenario = false;
    }

    /**
     * This is an overloaded constructor to run the test methods.
     * @param _cont
     * @param _mouse
     * @param _test
     */
    public CollisionChecker(GameController _cont, Mouse _mouse, boolean _test) {
        this.CONTROLLER = _cont;
        this.MOUSE = _mouse;
        this.testScenario = _test;
    }

    /**
    * This method iterates through the passed list and checks for collisions.
    * @param _nodes This is the list of nodes to check.
    */
    public void checkCollisionsList(List<Node> _nodes) {
        try{
            for (Node n : _nodes) {
                switch (n.getId()) {
                    case CollisionChecker.CAT:
                        //Fall through.
                    case CollisionChecker.HAIRBALL:
                        //Fall through.
                    case CollisionChecker.CLAW:
                        this.checkEnemyCollision(n);
                        break;
                    case CollisionChecker.CHEESE:
                        if (!this.MOUSE.hasCheese()) {
                            this.checkCheeseCollision(n);
                        }
                        break;
                    case CollisionChecker.DOOR:
                        if (this.MOUSE.hasCheese()) {
                            if (this.checkDoorCollision(n)) {
                                this.CONTROLLER.replaceCheese(this.MOUSE.getCollectedCheese());
                            }
                        }
                        break;
                    default:
                        //Ignore the node and continue.
                }
            }
        } catch(Exception e){
            if(this.testScenario) {
                System.out.println(e);
            }
        }
    }

    /**
    * This method will test for a collision between the mouse and the passed node.
    * @param _node
    * @return The return value is whether or not there was a collision.
    */
    private boolean checkCollision(Node _node) {
        Bounds nodeBounds = _node.getBoundsInParent();
        Bounds mouseBounds = this.MOUSE.getAnimationGroup().getBoundsInParent();

        //This block is only used for the CollisionTest class.
        if(this.testScenario && mouseBounds.intersects(nodeBounds.getMinX() + this.FUDGE, nodeBounds.getMinY() + this.FUDGE, nodeBounds.getWidth() - this.FUDGE * 2, nodeBounds.getHeight() - this.FUDGE * 2) ) {
            System.out.println("Mouse has collided with " + _node.getId());
        }

        //The "FUDGE" value helps account for transparent pixels in enemies.
        return mouseBounds.intersects(nodeBounds.getMinX() + this.FUDGE, nodeBounds.getMinY() + this.FUDGE, nodeBounds.getWidth() - this.FUDGE * 2, nodeBounds.getHeight() - this.FUDGE * 2);
    }

    /**
    * This method handles collisions with enemy sprites.
    * On a collision it is added to the list of the mouse's collisions.
    * If the node is no longer colliding, it will remove the node from the list.
    * @param _node This is the node to be checked.
    */
    private void checkEnemyCollision(Node _node) {
        if (this.checkCollision(_node)) {
            if (!this.MOUSE.isCollided()) {
                SFX.playCollision();
                this.CONTROLLER.enemyCollsion();
                this.MOUSE.addCollision(_node);
                this.MOUSE.setCollided(true);
                //Decrement Health.
            }
        } else {
            if (this.MOUSE.getCollisionList().contains(_node)) {
                this.MOUSE.removeCollision(_node);
            }
            if (this.MOUSE.getCollisionList().isEmpty()) {
                this.MOUSE.setCollided(false);
            }
        }
    }

    /**
    * This method checks for collisions with a cheese object.
    * If there is a collision it is added to the mouse's Collected cheese parameter and the mouse's "has cheese" variable is set to true.
    * @param _cheese This is the Cheese object to be checked.
    */
    private void checkCheeseCollision(Node _cheese) {
        if (this.checkCollision(_cheese) && !this.MOUSE.hasCheese()) {
            SFX.playCollect();
            this.MOUSE.setCollectedCheese(_cheese);
            this.MOUSE.setHasCheese(true);
        }
    }

    /**
    * This method checks for a collision between the mouse and the door.
    * If there is a collision and the mouse had cheese, it returns true and sets the correct parameters on the mouse.
    * @param _door This is the door node to be checked.
    * @return Returns if a cheese was deposited.
    */
    private boolean checkDoorCollision(Node _door) {
        if (this.checkCollision(_door)) {
            //Increase score.
            this.MOUSE.setHasCheese(false);
            SFX.playPoint();
            return true;
        }
        return false;
    }
}
