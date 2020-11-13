package Level;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.AnimatedSprite;
import GameObject.Frame;
import GameObject.SpriteSheet;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.util.HashMap;


public class CoinCounter extends AnimatedSprite {

    private Player player;
    private SpriteFont coinCounter;
    private int coins = 0;

    public CoinCounter(float x, float y, Player player) {
        //super(new SpriteSheet(ImageLoader.load("Items.png"), 16, 16), x, y, "COIN_DEFAULT");
        super(new SpriteSheet(ImageLoader.load("CoinCount.png"), 33, 16), x, y, "Default");
        this.player = player;
        coinCounter = new SpriteFont("" + coins, 425, 63, "Retro", 20, new Color(240, 237, 49));
        coinCounter.setOutlineColor(Color.black);
        coinCounter.setOutlineThickness(4);
    }

    public void setCoin(int coins) {
        this.coins = coins;
    }



    @Override
    public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {
            {
                put("Default",
                        new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0), 0).withScale(2).build() });
            }
        };
    }

    public void setAnimation(String animationName) {
        currentAnimationName = animationName;
    }

    public void update() {
        super.update();
        coins = player.getCoins();
        coinCounter.setText("" + coins);

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        coinCounter.draw(graphicsHandler);
    }


}
