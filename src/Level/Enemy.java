package Level;

import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;
import GameObject.SpriteSheet;

import java.awt.image.BufferedImage;
import java.util.HashMap;

// This class is a base class for all enemies in the game -- all enemies should extend from it
public class Enemy extends MapEntity {

    protected String type = "DEFAULT";

    public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
        super(x, y, spriteSheet, startingAnimation);
    }

    public Enemy(float x, float y, HashMap<String, Frame[]> animations, String startingAnimation) {
        super(x, y, animations, startingAnimation);
    }

    public Enemy(BufferedImage image, float x, float y, String startingAnimation) {
        super(image, x, y, startingAnimation);
    }

    public Enemy(BufferedImage image, float x, float y) {
        super(image, x, y);
    }

    public Enemy(BufferedImage image, float x, float y, float scale) {
        super(image, x, y, scale);
    }

    public Enemy(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect) {
        super(image, x, y, scale, imageEffect);
    }

    public Enemy(BufferedImage image, float x, float y, float scale, ImageEffect imageEffect, Rectangle bounds) {
        super(image, x, y, scale, imageEffect, bounds);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    public void update(Player player) {
        super.update();
        if (intersects(player)) {
            touchedPlayer(player);
        }
    }

    // A subclass can override this method to specify what it does when it touches the player
    public void touchedPlayer(Player player) {
        if (super.isActive) {
            player.hurtPlayer(this);
        }

    }

    public void setActive(boolean active) {
        super.isActive = active;
    }
    public boolean getActive() {
        return isActive;
    }

    public String getEnemyType() {
        if (type.equals("DINOSAUR_STILL")) {
            return type;
        } else {
            return "Not still, skip in the loop";
        }

    }
    public void setEnemyType(String type) {
        this.type = type;
    }
}
