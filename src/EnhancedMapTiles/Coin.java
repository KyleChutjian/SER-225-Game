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
import java.util.ArrayList;
import java.util.HashMap;

public class Coin extends EnhancedMapTile {
    private Float x,y;
    private Point location;

    public Coin(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Items.png"), 16, 16), "VISIBLE_COIN", TileType.PASSABLE);
        this.x = location.x;
        this.y = location.y;
        this.location = location;
    }

    @Override
    public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("VISIBLE_COIN", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 2), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
            });

            put("INVISIBLE_COIN", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 500)
                            .withScale(3)
                            .withBounds(1, 1, 14, 14)
                            .build(),
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
        public void update(Player player) {
            super.update(player);
            if (player.intersects(this) && getAnimation().equals("VISIBLE_COIN")) {
                setAnimation("INVISIBLE_COIN");
                player.setCoins(player.getCoins() + 1);
            }
        }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

}