package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;

// This class is for the credits screen
public class Characters extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Audio audio = null;
    protected Map background;
    protected SpriteFont title;
    protected SpriteFont BlackCat, CoolCat, IceCat, GhostCat, WizardCat, TopHatCat;
    protected SpriteFont returnMainMenu;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Stopwatch keyTimer = new Stopwatch();
    protected int currentMenuItemHovered = 0;
    protected int pointerLocationX, pointerLocationY, activePresetX, activePresetY;

    public Characters(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        audio = GamePanel.getAudio();
    	background = new TitleScreenMap();
        background.setAdjustCamera(false);

       	// setup graphics on screen
        	//Title text
        title = new SpriteFont("   CHARACTERS", 180, 60, "Comic Sans", 24, new Color(49, 207, 240));
        title.setOutlineColor(Color.black);
        title.setOutlineThickness(3);

        ///////////////////////////////////////////////////////////////
        	//BlackCat
        BlackCat = new SpriteFont("BlackCat", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        BlackCat.setOutlineColor(Color.black);
        BlackCat.setOutlineThickness(3);

        	//CoolCat
        CoolCat = new SpriteFont("CoolCat", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        CoolCat.setOutlineColor(Color.black);
        CoolCat.setOutlineThickness(3);
        
        	//IceCat
        IceCat = new SpriteFont("IceCat", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        IceCat.setOutlineColor(Color.black);
        IceCat.setOutlineThickness(3);
        
        	//GhostCat
        IceCat = new SpriteFont("GhostCat", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        IceCat.setOutlineColor(Color.black);
        IceCat.setOutlineThickness(3);
        
        	//WizardCat
        IceCat = new SpriteFont("WizardCat", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        IceCat.setOutlineColor(Color.black);
        IceCat.setOutlineThickness(3);
        
        	//TopHatCat
        IceCat = new SpriteFont("TopHatCat", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        IceCat.setOutlineColor(Color.black);
        IceCat.setOutlineThickness(3);

        	//Return to Main Menu Text
        returnMainMenu = new SpriteFont("Press the INTERACT key to select a preset", 40, 555, "Comic Sans", 22, new Color(49, 207, 240));
        returnMainMenu.setOutlineColor(Color.black);
        returnMainMenu.setOutlineThickness(3);

        keyLocker.lockKey(Key.currentINTERACT);
        keyTimer.setWaitTime(200);
    }

    public void update() {
//    	background.update(null);
//        audio.startPlayingLoop(5);
//    		//sets currentMenuItemHovered
//        if (Keyboard.isKeyDown(Key.currentDOWN) && keyTimer.isTimeUp()) {
//    		keyTimer.reset();
//            audio.startPlayingOnce(6);
//
//    		currentMenuItemHovered++;
//    	} else if (Keyboard.isKeyDown(Key.currentUP) && keyTimer.isTimeUp()) {
//    		keyTimer.reset();
//            audio.startPlayingOnce(6);
//    		currentMenuItemHovered--;
//    	}
//
//    		// if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
//    	if (currentMenuItemHovered > 5) {
//    		currentMenuItemHovered = 0;
//    	} else if (currentMenuItemHovered < 0) {
//    		currentMenuItemHovered = 5;
//    	}
//
//        if (currentMenuItemHovered == 0) {
//        		//Highlights BlackCat
//        	BlackCat.setColor(new Color(255, 215, 0));
//            CoolCat.setColor(new Color(49, 207, 240));
//            IceCat.setColor(new Color(49, 207, 240));
//            GhostCat.setColor(new Color(49, 207, 240));
//            WizardCat.setColor(new Color(49, 207, 240));
//            TopHatCat.setColor(new Color(49, 207, 240));
//            pointerLocationX = 10;
//            pointerLocationY = 133;
//
//        } else if (currentMenuItemHovered == 1) {
//        		//Highlights CoolCat
//        	BlackCat.setColor(new Color(49, 207, 240));
//            CoolCat.setColor(new Color(255, 215, 0));
//            IceCat.setColor(new Color(49, 207, 240));
//            GhostCat.setColor(new Color(49, 207, 240));
//            WizardCat.setColor(new Color(49, 207, 240));
//            TopHatCat.setColor(new Color(49, 207, 240));
//            pointerLocationX = 10;
//            pointerLocationY = 163;
//
//        } else if (currentMenuItemHovered == 2) {
//        		//Highlights IceCat
//        	BlackCat.setColor(new Color(49, 207, 240));
//        	CoolCat.setColor(new Color(49, 207, 240));
//            IceCat.setColor(new Color(255, 215, 0));
//            GhostCat.setColor(new Color(49, 207, 240));
//            WizardCat.setColor(new Color(49, 207, 240));
//            TopHatCat.setColor(new Color(49, 207, 240));
//            pointerLocationX = 10;
//            pointerLocationY = 193;
//
//        } else if (currentMenuItemHovered == 3) {
//        		//Highlights GhostCat
//        	BlackCat.setColor(new Color(49, 207, 240));
//        	CoolCat.setColor(new Color(49, 207, 240));
//            IceCat.setColor(new Color(49, 207, 240));
//            GhostCat.setColor(new Color(255, 215, 0));
//            WizardCat.setColor(new Color(49, 207, 240));
//            TopHatCat.setColor(new Color(49, 207, 240));
//            pointerLocationX = 10;
//            pointerLocationY = 223;
//
//        } else if (currentMenuItemHovered == 4) {
//        		//Highlights WizardCat
//        	BlackCat.setColor(new Color(49, 207, 240));
//            CoolCat.setColor(new Color(49, 207, 240));
//            IceCat.setColor(new Color(49, 207, 240));
//            GhostCat.setColor(new Color(49, 207, 240));
//            WizardCat.setColor(new Color(255, 215, 0));
//            TopHatCat.setColor(new Color(49, 207, 240));
//            pointerLocationX = 10;
//            pointerLocationY = 253;
//
//        }
//
//        else if (currentMenuItemHovered == 5) {
//        		//Highlights TopHatCat
//            BlackCat.setColor(new Color(49, 207, 240));
//            CoolCat.setColor(new Color(49, 207, 240));
//            IceCat.setColor(new Color(49, 207, 240));
//            GhostCat.setColor(new Color(49, 207, 240));
//            WizardCat.setColor(new Color(49, 207, 240));
//            TopHatCat.setColor(new Color(255, 215, 0));
//            pointerLocationX = 10;
//            pointerLocationY = 283;
//        }

//        if (Keyboard.isKeyUp(Key.currentINTERACT) && (currentMenuItemHovered == 5 || currentMenuItemHovered == 6)) {
//            keyLocker.lockKey(Key.currentINTERACT);
//        }
//        if (Keyboard.isKeyDown(Key.currentINTERACT) && (currentMenuItemHovered == 5 || currentMenuItemHovered == 6)) {
//            audio.startPlayingOnce(7);
//            screenCoordinator.setGameState(GameState.MENU);
//        }
    }

    	//displays screen elements
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        title.draw(graphicsHandler);
        BlackCat.draw(graphicsHandler);
        CoolCat.draw(graphicsHandler);
        IceCat.draw(graphicsHandler);
        GhostCat.draw(graphicsHandler);
        WizardCat.draw(graphicsHandler);
        TopHatCat.draw(graphicsHandler);
        returnMainMenu.draw(graphicsHandler);

		 	//blue cursor for scrolling through options
//        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
//    }

} }