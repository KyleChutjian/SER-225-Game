package Enemies;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Player;
import Utils.AirGroundState;
import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;
import java.util.HashMap;

// This class is for the Vulture enemy that has deadly poop. It is essentially a copy of the Dinosaur Enemy class
// It flies back and forth between two set points (startLocation and endLocation)
// Every so often (based on shootTimer) it will poop a VulturePoop enemy
public class VultureEnemy extends Enemy {

    // start and end location defines the two points that it flies between
    // is only made to flies along the x axis and has no air ground state logic, so make sure both points have the same Y value
    protected Point startLocation;
    protected Point endLocation;
    
    protected float movementSpeed = 1f;
    private Direction startFacingDirection;
    protected Direction facingDirection;
    protected AirGroundState airGroundState;

    // timer is used to determine when poop is to be shot out
    protected Stopwatch shootTimer = new Stopwatch();

    // can be either FLY or POOP based on what the enemy is currently set to do
    
    protected VultureState vultureState;
    protected VultureState previousVultureState;

    public VultureEnemy(Point startLocation, Point endLocation, Direction facingDirection) {
        super(startLocation.x, startLocation.y, new SpriteSheet(ImageLoader.load("Vulture.png"), 27, 18), "FLY_RIGHT");
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startFacingDirection = facingDirection;
        this.initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        vultureState = VultureState.FLY;
        previousVultureState = vultureState;
        facingDirection = startFacingDirection;
        if (facingDirection == Direction.RIGHT) {
            currentAnimationName = "FLY_RIGHT";
        } else if (facingDirection == Direction.LEFT) {
            currentAnimationName = "FLY_LEFT";
        }
       // airGroundState = AirGroundState.GROUND;

        // every 2 seconds, the poop will be shot out
        shootTimer.setWaitTime(2000);
    }

    @Override
    public void update(Player player) {
        float startBound = startLocation.x;
        float endBound = endLocation.x;

        // if shoot timer is up and Vulture is not currently pooping, set its state to SHOOT
        if (shootTimer.isTimeUp() && vultureState != VultureState.POOP) {
        	vultureState = VultureState.POOP;
        }

        super.update(player);

        // if Vulture is flying, determine which direction to fly based on facing direction
        if (vultureState == VultureState.FLY) {
            if (facingDirection == Direction.RIGHT) {
                currentAnimationName = "FLY_RIGHT";
                moveXHandleCollision(movementSpeed);
            } else {
                currentAnimationName = "FLY_LEFT";
                moveXHandleCollision(-movementSpeed);
            }

            // if Vulture reaches the start or end location, it turns around
            // Vulture may end up going a bit past the start or end location depending on movement speed
            // this calculates the difference and pushes the enemy back a bit so it ends up right on the start or end location
            if (getX1() + getScaledWidth() >= endBound) {
                float difference = endBound - (getScaledX2());
                moveXHandleCollision(-difference);
                facingDirection = Direction.LEFT;
            } else if (getX1() <= startBound) {
                float difference = startBound - getX1();
                moveXHandleCollision(difference);
                facingDirection = Direction.RIGHT;
            }

            // if Vulture is pooping, it flies in one spot for a second
            // then the Poop is actually shot out
        } else if (vultureState == VultureState.POOP) {
            if (previousVultureState == VultureState.FLY) {
                shootTimer.setWaitTime(1000);
               // currentAnimationName = facingDirection == Direction.RIGHT ? "SHOOT_RIGHT" : "SHOOT_LEFT";
            } else if (shootTimer.isTimeUp()) {

                // define where Poop will spawn on map (x location) relative to Vulture enemy's location
                // and define its movement speed
                int poopX;
                float movementSpeed;
                if (facingDirection == Direction.RIGHT) {
                    poopX = Math.round(getX()) + getScaledWidth() - 80;
                    movementSpeed = 1.5f;
                } else {
                    poopX = Math.round(getX()) + 50;
                    movementSpeed = 1.5f;
                }

                // define where poop will spawn on the map (y location) relative to Vulture enemy's location
                int poopY = Math.round(getY()) + 15;

                // create Poop enemy
                VulturePoop vulturePoo = new VulturePoop(new Point(poopX, poopY), movementSpeed, 5000);

                // add poop enemy to the map for it to officially spawn in the level
                map.addEnemy(vulturePoo);

                // change Vulture back to its FLY state after shooting, reset shootTimer to wait another 2 seconds before shooting again
                vultureState = VultureState.FLY;
                shootTimer.setWaitTime(2000);
            }
        }
        previousVultureState = vultureState;
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction) {
        // if Vulture enemy collides with something on the x axis, it turns around and flys the other way
        if (hasCollided) {
            if (direction == Direction.RIGHT) {
                facingDirection = Direction.LEFT;
                currentAnimationName = "FLY_LEFT";
            } else {
                facingDirection = Direction.RIGHT;
                currentAnimationName = "FLY_RIGHT";
            }
        }
    }

    @Override
    public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("FLY_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 200)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 200)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });

            put("FLY_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 200)
                            .withScale(3)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 200)
                            .withScale(3)
                            .build()
            });

            put("SHOOT_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(3)
                            .build(),
            });

            put("SHOOT_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(3)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build(),
            });
        }};
    }

    public enum VultureState {
        FLY, POOP
    }
}