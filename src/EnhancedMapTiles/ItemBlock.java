package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Utils.Point;

import java.util.HashMap;
import java.util.Random;

public class ItemBlock extends EnhancedMapTile {
    private Float x,y;
    private Boolean cycle = false;
    private int test = 1000;


    public ItemBlock(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("GoldBox.png"), 16, 16), "DEFAULT", TileType.NOT_PASSABLE);
        this.x = location.x;
        this.y = location.y;
    }

    @Override
    public void update(Player player) {
        super.update(player);
        System.out.println("Current test: " + test);

        Random random = new Random();
        int randomNumber = random.nextInt(3);

        if (cycle == true) {
            test -= 5;
        }

        if (test > 0 && test < 1000 && test % 50 == 0) {
            changeAnimation(randomNumber);
            System.out.println(getCurrentAnimation().toString());
        }
        if (player.getBoundsX2() < x + 40 && player.getBoundsX2() > x - 30 && player.getBoundsY2() > y + 37 && player.getBoundsY2() < y + 38) {
            System.out.println("Hit Block");
            cycle = true;






        } else {
            if (test < 0) {
                cycle = false;
                test = 1000;
                releaseItem(getAnimation());
            }
        }


    }

    private void releaseItem(String animation) {
        if (animation.equals("HEART")) {
            //spawn heart
        } else if (animation.equals("COIN")) {
            //spawn coin
        } else if (animation.equals("ENEMY")) {
            //spawn enemy
        }


    }

    public void changeAnimation(int x) {
        if (x == 0) {
            setAnimation("HEART");
        } else if (x == 1) {
            setAnimation("COIN");
        } else if (x == 2) {
            setAnimation("ENEMY");
        }
    }

    @Override
    public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("DEFAULT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
            });

            put("HEART", new Frame[]{
                            new FrameBuilder(spriteSheet.getSprite(0, 0), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
                    });
            put("COIN", new Frame[]{new FrameBuilder(spriteSheet.getSprite(0, 1), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
                    });
            put("ENEMY", new Frame[] {new FrameBuilder(spriteSheet.getSprite(0, 2), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build()
            });

        }};
    }
    public void setAnimation(String animationName) {
        currentAnimationName = animationName;
    }
    public String getAnimation() {
        return currentAnimationName;
    }


    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

}
