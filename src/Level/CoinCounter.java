package Level;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.AnimatedSprite;
import GameObject.Frame;
import GameObject.SpriteSheet;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class CoinCounter extends AnimatedSprite {

    private Player player;
    private SpriteFont coinCounter;
    private int coins = 0;

    public CoinCounter(float x, float y, Player player) {
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
        int currentCoins = 0;
        try {
            File fileReader = new File("SavedData/MapData.txt");
            Scanner mapReader = null;
            mapReader = new Scanner(fileReader);
            currentCoins = mapReader.nextInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        coinCounter.setText("" + currentCoins);

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        coinCounter.draw(graphicsHandler);
    }


}
