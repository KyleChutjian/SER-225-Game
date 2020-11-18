package Screens;

import Engine.Audio;
import Engine.GraphicsHandler;
import Engine.Screen;
import Engine.ScreenManager;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

// This class is for the level cleared screen
public class LevelClearedScreen extends Screen {
	protected long startTime;
	protected long pauseTime;
    protected SpriteFont winMessage;
    protected SpriteFont timeMessage;
    
    public LevelClearedScreen(long startTime, long pauseTime) {
    	this.startTime = startTime;
    	this.pauseTime = pauseTime;
    }

	@Override
    public void initialize() {
		
        winMessage = new SpriteFont("Level Cleared", 320, 270, "Comic Sans", 30, Color.white);
        
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - startTime - pauseTime;
        double timePassedSeconds = timePassed/1000.0;
        
        timeMessage = new SpriteFont("Time Cleared: " + timePassedSeconds + " seconds", 260, 440, "Comic Sans", 30, Color.white);
    }

    @Override
    public void update() {

    }

    public void draw(GraphicsHandler graphicsHandler) {
        // paint entire screen black and display level cleared text
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.black);
        winMessage.draw(graphicsHandler);
        timeMessage.draw(graphicsHandler);
    }
}
