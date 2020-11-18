package EnhancedMapTiles;

import Builders.FrameBuilder;
import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Utils.Direction;
import Utils.Point;
import Engine.GamePanel;
import Engine.Audio;
import java.util.ArrayList;
import java.util.HashMap;

public class Items extends EnhancedMapTile {
    private Float x,y;
    private ItemBlock itemBlock;
    private boolean hitItem = false;
    private ArrayList<Enemy> enemyList;
    private Audio audio;


    public Items(Point location, ItemBlock itemBlock, ArrayList<Enemy> enemyList) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Items.png"), 16, 16), "DEFAULT", TileType.PASSABLE);
        this.x = location.x;
        this.y = location.y;
        this.itemBlock = itemBlock;
        this.enemyList = enemyList;
        audio = GamePanel.getAudio();
    }

    @Override
    public void update(Player player) {
        super.update(player);

        if (itemBlock.getHit() == true) {
            if (player.intersects(this) && hitItem == false) {
                getItem(player);
                setAnimation("DEFAULT");
                hitItem = true;
                audio.startPlayingOnce(7);
            } else if (itemBlock.getAnimation().equals("ENEMY")) {
                for (int i = 0; i < enemyList.size(); i++) {
                    if (enemyList.get(i).getEnemyType().equals("DINOSAUR_STILL")) {
                        enemyList.get(i).setActive(true);
                        return;
                    }
                }

            }

        }

    }

    public void getItem(Player player) {
        if (itemBlock.getAnimation().equals("HEART")) {
            player.setCurrentHealth(player.getCurrentHealth() + 1);

        } else if (itemBlock.getAnimation().equals("COIN")) {
            player.setCoins(player.getCoins() + 1);

        } else if (itemBlock.equals("ENEMY")) {
            hitItem = true;
            itemBlock.setHit(true);

        }
    }


    public void changeAnimation(int x) {

            if (itemBlock.getAnimation().equals("HEART")) {
                setAnimation("HEART_ITEM");
            } else if (itemBlock.getAnimation().equals("COIN")) {
                setAnimation("COIN_ITEM");
            } else if (itemBlock.getAnimation().equals("ENEMY")) {
                hitItem = true;
                itemBlock.setHit(true);
                enemyList.get(2).setActive(true);


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

            put("HEART_ITEM", new Frame[] {new FrameBuilder(spriteSheet.getSprite(0, 1), 500)
                    .withScale(3)
                    .withBounds(1, 1, 14, 14)
                    .build()
            });

            put("COIN_ITEM", new Frame[] {new FrameBuilder(spriteSheet.getSprite(0, 2), 500)
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
