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
    private ArrayList<Integer> enemyInts;
    private int index;
    private Audio audio;


    public Items(Point location, ItemBlock itemBlock, ArrayList<Enemy> enemyList, int enemyIndex) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Items.png"), 16, 16), "DEFAULT", TileType.PASSABLE);
        this.x = location.x;
        this.y = location.y;
        this.itemBlock = itemBlock;
        this.enemyList = enemyList;
        this.index = enemyIndex;
        this.enemyInts = enemyInts;
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
//                if (!enemyInts.isEmpty()) {
//                    System.out.println(enemyInts.toString());
//                    enemyList.get(enemyInts.get(0)).setActive(true);
//                    enemyInts.remove(0);
//                    System.out.println(enemyInts.toString());
//                    itemBlock.setHit(false);
//                }
                enemyList.get(index).setActive(true);
            }

        }

    }

    public void getItem(Player player) {
        if (itemBlock.getAnimation().equals("HEART")) {
            player.setCurrentHealth(player.getCurrentHealth() + 1);

        } else if (itemBlock.getAnimation().equals("COIN")) {
            player.setCoins(player.getCoins() + 1);

        } else if (itemBlock.getAnimation().equals("ENEMY")) {
            System.out.println("Get item enemy");
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
                System.out.println("changeAnimation enemy");


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
