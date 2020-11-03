package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Utils.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ItemBlock extends EnhancedMapTile {
    private Float x,y;
    private int z = 0;
    private Boolean cycle = false;
    private Boolean hit = false;
    private int test = 1000;
    private Items items;

    public ItemBlock(Point location, ArrayList<EnhancedMapTile> arrayList, ArrayList<Enemy> enemyList) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("ItemBlock.png"), 16, 16), "DEFAULT", TileType.NOT_PASSABLE);
        this.x = location.x;
        this.y = location.y;
        Point itemPoint = new Point(x, y-50);
        items = new Items(itemPoint, this, enemyList);
        arrayList.add(items);
    }

    @Override
    public void update(Player player) {
        super.update(player);

        Random random = new Random();
        int randomNumber = random.nextInt(3);
        z += randomNumber;

        if (cycle == true) {
            test -= 5;
        }

        if (test > 0 && test < 1000 && test % 50 == 0 && hit != true) {
            changeAnimation(z);
        }
        if (player.getBoundsX2() < x + 40 && player.getBoundsX2() > x - 30 && player.getBoundsY2() > y + 37 && player.getBoundsY2() < y + 38) {
            System.out.println("Hit Block");
            cycle = true;

        } else {
            if (test < 0) {
                cycle = false;
                test = 1000;
                if (hit == false) {
                    releaseItem(getAnimation());
                }
                hit = true;
            }
        }


    }

    private void releaseItem(String animation) {
        if (animation.equals("HEART")) {
            //spawn heart
            items.changeAnimation(z);
        } else if (animation.equals("COIN")) {
            //spawn coin
            items.changeAnimation(z);
        } else if (animation.equals("ENEMY")) {
            //spawn enemy
            items.changeAnimation(z);
        }

    }

    public void changeAnimation(int x) {



        if (test != 1) {
                z++;
                if (z % 3 == 0) {
                    setAnimation("HEART");
                } else if (z % 3 == 1) {
                    setAnimation("COIN");
                } else if (z % 3 == 2) {
                    setAnimation("ENEMY");
                }
            }
         else {
            if (x == 0) {
                setAnimation("HEART");
            } else if (x == 1) {
                setAnimation("COIN");
            } else if (x == 2) {
                setAnimation("ENEMY");
            }
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
                            new FrameBuilder(spriteSheet.getSprite(0, 1), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
                    });
            put("ENEMY", new Frame[]{new FrameBuilder(spriteSheet.getSprite(0, 2), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
                    });
            put("COIN", new Frame[] {new FrameBuilder(spriteSheet.getSprite(0, 3), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build()
            });

            put("HEART_ITEM", new Frame[] {new FrameBuilder(spriteSheet.getSprite(0, 4), 500)
                    .withScale(3)
                    .withBounds(1, 1, 14, 14)
                    .build()
            });

            put("COIN_ITEM", new Frame[] {new FrameBuilder(spriteSheet.getSprite(0, 5), 500)
                    .withScale(3)
                    .withBounds(1, 1, 14, 14)
                    .build()
            });




        }};
    }

    public int getRandom() {
        return z;
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
