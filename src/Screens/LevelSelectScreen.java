package Screens;

import Engine.*;
import EnhancedMapTiles.CuriosityOrb;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import java.awt.*;

// This class is for the credits screen
public class LevelSelectScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Audio audio = null;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int currentMenuItemHovered = 0;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY, activePresetX, activePresetY;
    protected SpriteFont levelSelectLabel;
    protected SpriteFont world1Label;
    protected SpriteFont world2Label;
    protected SpriteFont world3Label;
    protected SpriteFont level1Label;
    protected SpriteFont level2Label;
    protected SpriteFont level3Label;
    protected SpriteFont level4Label;
    protected SpriteFont level5Label;
    protected SpriteFont level6Label;
    protected SpriteFont level7Label;
    protected SpriteFont level8Label;
    protected SpriteFont level9Label;
    protected SpriteFont level10Label;
    protected SpriteFont level11Label;
    protected SpriteFont level12Label;
    protected SpriteFont level13Label;
    protected SpriteFont level14Label;
    protected SpriteFont level15Label;
    protected SpriteFont returnOptionsLabel;
    protected String test;
    
    public LevelSelectScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        audio = GamePanel.getAudio();

                             // AUTHOR NOTE //
        // THIS CLASS CONTAINS LARGE AMOUNTS OF REPETITIVE CODE!  //
        // THE FIRST PRIORITY WAS TO GET THE GAME ELEMENT TO WORK!//
        // METHODS TO CONDENSE CODE WILL COME LATER!              //
        // FOR ANY COMPLAINTS, YELL AT MATT!                      //

///////////////////////////////////////////////Screen Labels and Text//////////////////////////////////////////////////////////////
        
        //Level Select Menu Text
        levelSelectLabel = new SpriteFont("LEVELS", 347, 80, "Comic Sans", 24, new Color(49, 207, 240));
        levelSelectLabel.setOutlineColor(Color.black);
        levelSelectLabel.setOutlineThickness(3);
        	//world 1
        world1Label = new SpriteFont("WORLD 1", 120, 130, "Comic Sans", 22, new Color(255, 215, 0));
        world1Label.setOutlineColor(Color.black);
        world1Label.setOutlineThickness(3);
        	//world 2
        world2Label = new SpriteFont("WORLD 2", 340, 130, "Comic Sans", 22, new Color(255, 215, 0));
        world2Label.setOutlineColor(Color.black);
        world2Label.setOutlineThickness(3);
        	//world 3
        world3Label = new SpriteFont("WORLD 3", 560, 130, "Comic Sans", 22, new Color(255, 215, 0));
        world3Label.setOutlineColor(Color.black);
        world3Label.setOutlineThickness(3);

        //game levels
        	//Level 1
        level1Label = new SpriteFont ("Level 1 : Intro", 100, 170, "Comic Sans", 20, new Color(49, 207, 240));
        level1Label.setOutlineColor(Color.black);
        level1Label.setOutlineThickness(3);

        	//Level 2
        level2Label = new SpriteFont ("Level 2 : Fields", 100, 210, "Comic Sans", 20, new Color(49, 207, 240));
        level2Label.setOutlineColor(Color.black);
        level2Label.setOutlineThickness(3);

        	//Level 3
        level3Label = new SpriteFont ("Level 3 : Forest", 100, 250, "Comic Sans", 20, new Color(49, 207, 240));
        level3Label.setOutlineColor(Color.black);
        level3Label.setOutlineThickness(3);

        	//Level 4
        level4Label = new SpriteFont ("Level 4 : Lake", 100, 290, "Comic Sans", 20, new Color(49, 207, 240));
        level4Label.setOutlineColor(Color.black);
        level4Label.setOutlineThickness(3);

        	//Level 5
        level5Label = new SpriteFont ("Level 5 : Hills", 100, 330, "Comic Sans", 20, new Color(49, 207, 240));
        level5Label.setOutlineColor(Color.black);
        level5Label.setOutlineThickness(3);

        	//Level 6
        level6Label = new SpriteFont ("Level 6   : Sands", 320, 170, "Comic Sans", 20, new Color(49, 207, 240));
        level6Label.setOutlineColor(Color.black);
        level6Label.setOutlineThickness(3);

        	//Level 7
        level7Label = new SpriteFont ("Level 7   : Dunes", 320, 210, "Comic Sans", 20, new Color(49, 207, 240));
        level7Label.setOutlineColor(Color.black);
        level7Label.setOutlineThickness(3);

        	//Level 8
        level8Label = new SpriteFont ("Level 8   : Pyramid", 320, 250, "Comic Sans", 20, new Color(49, 207, 240));
        level8Label.setOutlineColor(Color.black);
        level8Label.setOutlineThickness(3);

        	//Level 9
        level9Label = new SpriteFont ("Level 9   : Oasis", 320, 290, "Comic Sans", 20, new Color(49, 207, 240));
        level9Label.setOutlineColor(Color.black);
        level9Label.setOutlineThickness(3);

        	//Level 10
        level10Label = new SpriteFont ("Level 10 : Mirage", 320, 330, "Comic Sans", 20, new Color(49, 207, 240));
        level10Label.setOutlineColor(Color.black);
        level10Label.setOutlineThickness(3);

        	//Level 11
        level11Label = new SpriteFont ("Level 11 : Rocks", 540, 170, "Comic Sans", 20, new Color(49, 207, 240));
        level11Label.setOutlineColor(Color.black);
        level11Label.setOutlineThickness(3);

        	//Level 12
        level12Label = new SpriteFont ("Level 12 : Mountains", 540, 210, "Comic Sans", 20, new Color(49, 207, 240));
        level12Label.setOutlineColor(Color.black);
        level12Label.setOutlineThickness(3);

        	//Level 13
        level13Label = new SpriteFont ("Level 13 : Cliffs", 540, 250, "Comic Sans", 20, new Color(49, 207, 240));
        level13Label.setOutlineColor(Color.black);
        level13Label.setOutlineThickness(3);

        	//Level 14
        level14Label = new SpriteFont ("Level 14 : Volcano", 540, 290, "Comic Sans", 20, new Color(49, 207, 240));
        level14Label.setOutlineColor(Color.black);
        level14Label.setOutlineThickness(3);

        	//Level 15
        level15Label = new SpriteFont ("Level 15 : Crucible", 540, 330, "Comic Sans", 20, new Color(49, 207, 240));
        level15Label.setOutlineColor(Color.black);
        level15Label.setOutlineThickness(3);

        //Return to Main Menu Text
        returnOptionsLabel = new SpriteFont("Press the INTERACT key to select a level", 190, 380, "Comic Sans", 22, new Color(255, 215, 0));
        returnOptionsLabel.setOutlineColor(Color.black);
        returnOptionsLabel.setOutlineThickness(3);


        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyLocker.lockKey(Key.currentINTERACT);
        keyTimer.setWaitTime(200);
    }
    
///////////////////////////////////////////////Screen Navigation///////////////////////////////////////////////////////////////////

    public void update() {
    	background.update(null);

    	//creates navigation cursor variable
        if (Keyboard.isKeyDown(Key.currentDOWN) && keyTimer.isTimeUp()) {
    		keyTimer.reset();
            audio.startPlayingOnce(6);
    		currentMenuItemHovered++;
    	} else if (Keyboard.isKeyDown(Key.currentUP) && keyTimer.isTimeUp()) {
    		keyTimer.reset();
            audio.startPlayingOnce(6);
    		currentMenuItemHovered--;
    	} else if (Keyboard.isKeyDown(Key.currentRIGHT) && keyTimer.isTimeUp()) {
    		keyTimer.reset();
            audio.startPlayingOnce(6);
    		currentMenuItemHovered += 5;
    	} else if (Keyboard.isKeyDown(Key.currentLEFT) && keyTimer.isTimeUp()) {
    		keyTimer.reset();
            audio.startPlayingOnce(6);
    		currentMenuItemHovered -= 5;
    	}


    		// if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
    	if (currentMenuItemHovered > 14) {
    		currentMenuItemHovered = 0;
    	} else if (currentMenuItemHovered < 0) {
    		currentMenuItemHovered = 14;
    	}


    	//instructions for navigation cursor
        if (currentMenuItemHovered == 0) {
        	//Highlights Level 1
        	level1Label.setColor(new Color(255, 215, 0));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 70;
            pointerLocationY = 153;

        } else if (currentMenuItemHovered == 1) {
        	//Highlights Level 2
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(255, 215, 0));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 70;
            pointerLocationY = 193;
        } else if (currentMenuItemHovered == 2) {
        	//Highlights Level 3
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(255, 215, 0));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 70;
            pointerLocationY = 233;
        } else if (currentMenuItemHovered == 3) {
        	//Highlights Level 4
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(255, 215, 0));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 70;
            pointerLocationY = 273;
        } else if (currentMenuItemHovered == 4) {
        	//Highlights Level 5
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(255, 215, 0));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 70;
            pointerLocationY = 313;
        } else if (currentMenuItemHovered == 5) {
        	//Highlights Level 6
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(255, 215, 0));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 290;
            pointerLocationY = 153;
        } else if (currentMenuItemHovered == 6) {
        	//Highlights Level 7
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(255, 215, 0));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 290;
            pointerLocationY = 193;
        } else if (currentMenuItemHovered == 7) {
        	//Highlights Level 8
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(255, 215, 0));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 290;
            pointerLocationY = 233;
        } else if (currentMenuItemHovered == 8) {
        	//Highlights Level 9
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(255, 215, 0));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 290;
            pointerLocationY = 273;
        } else if (currentMenuItemHovered == 9) {
        	//Highlights Level 10
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(255, 215, 0));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 290;
            pointerLocationY = 313;
        } else if (currentMenuItemHovered == 10) {
        	//Highlights Level 11
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(255, 215, 0));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 510;
            pointerLocationY = 153;
        } else if (currentMenuItemHovered == 11) {
        	//Highlights Level 12
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(255, 215, 0));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 510;
            pointerLocationY = 193;
        } else if (currentMenuItemHovered == 12) {
        	//Highlights Level 13
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(255, 215, 0));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 510;
            pointerLocationY = 233;
        } else if (currentMenuItemHovered == 13) {
        	//Highlights Level 14
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(255, 215, 0));
            level15Label.setColor(new Color(49, 207, 240));
            pointerLocationX = 510;
            pointerLocationY = 273;
        } else if (currentMenuItemHovered == 14) {
        	//Highlights Level 15
        	level1Label.setColor(new Color(49, 207, 240));
            level2Label.setColor(new Color(49, 207, 240));
            level3Label.setColor(new Color(49, 207, 240));
            level4Label.setColor(new Color(49, 207, 240));
            level5Label.setColor(new Color(49, 207, 240));
            level6Label.setColor(new Color(49, 207, 240));
            level7Label.setColor(new Color(49, 207, 240));
            level8Label.setColor(new Color(49, 207, 240));
            level9Label.setColor(new Color(49, 207, 240));
            level10Label.setColor(new Color(49, 207, 240));
            level11Label.setColor(new Color(49, 207, 240));
            level12Label.setColor(new Color(49, 207, 240));
            level13Label.setColor(new Color(49, 207, 240));
            level14Label.setColor(new Color(49, 207, 240));
            level15Label.setColor(new Color(255, 215, 0));
            pointerLocationX = 510;
            pointerLocationY = 313;
        }

        if (Keyboard.isKeyUp(Key.currentINTERACT)) {
            keyLocker.unlockKey(Key.currentINTERACT);
        }

//////////////////////////////////////////////Level Selection and Launch///////////////////////////////////////////////////////////

        //reads map text file and launches appropriate level
        if (!keyLocker.isKeyLocked(Key.currentINTERACT) && Keyboard.isKeyDown(Key.currentINTERACT)) {
            audio.startPlayingOnce(7);
        	
        		if(currentMenuItemHovered == 0) {
        			screenCoordinator.setGameState(GameState.STORY);
        			PlayLevelScreen.mapSelection(0);
        			CuriosityOrb.mapSelection(0);
        		} else if (currentMenuItemHovered == 1) {
        			screenCoordinator.setGameState(GameState.LEVEL2);
        			PlayLevelScreen.mapSelection(1);
        			CuriosityOrb.mapSelection(1);
        		} else if (currentMenuItemHovered == 2) {
        			screenCoordinator.setGameState(GameState.LEVEL3);
        			PlayLevelScreen.mapSelection(2);
        			CuriosityOrb.mapSelection(2);
        		} else if (currentMenuItemHovered == 3) {
        			screenCoordinator.setGameState(GameState.LEVEL4);
        			PlayLevelScreen.mapSelection(3);
        			CuriosityOrb.mapSelection(3);
        		} else if (currentMenuItemHovered == 4) {
        			screenCoordinator.setGameState(GameState.LEVEL5);
        			PlayLevelScreen.mapSelection(4);
        			CuriosityOrb.mapSelection(4);
        		} else if (currentMenuItemHovered == 5) {
        			screenCoordinator.setGameState(GameState.STORY2);
        			PlayLevelScreen.mapSelection(5);
        			CuriosityOrb.mapSelection(5);
        		} else if (currentMenuItemHovered == 6) {
        			screenCoordinator.setGameState(GameState.LEVEL7);
        			PlayLevelScreen.mapSelection(6);
        			CuriosityOrb.mapSelection(6);
        		} else if (currentMenuItemHovered == 7) {
        			screenCoordinator.setGameState(GameState.LEVEL8);
        			PlayLevelScreen.mapSelection(7);
        			CuriosityOrb.mapSelection(7);
        		} else if (currentMenuItemHovered == 8) {
        			screenCoordinator.setGameState(GameState.LEVEL9);
        			PlayLevelScreen.mapSelection(8);
        			CuriosityOrb.mapSelection(8);
        		} else if (currentMenuItemHovered == 9) {
        			screenCoordinator.setGameState(GameState.LEVEL10);
        			PlayLevelScreen.mapSelection(9);
        			CuriosityOrb.mapSelection(9);
        		} else if (currentMenuItemHovered == 10) {
        			screenCoordinator.setGameState(GameState.STORY3);
        			PlayLevelScreen.mapSelection(10);
        			CuriosityOrb.mapSelection(10);
        		} else if (currentMenuItemHovered == 11) {
        			screenCoordinator.setGameState(GameState.LEVEL12);
        			PlayLevelScreen.mapSelection(11);
        			CuriosityOrb.mapSelection(11);
        		} else if (currentMenuItemHovered == 12) {
        			screenCoordinator.setGameState(GameState.LEVEL13);
        			PlayLevelScreen.mapSelection(12);
        			CuriosityOrb.mapSelection(12);
        		} else if (currentMenuItemHovered == 13) {
        			screenCoordinator.setGameState(GameState.STORY4);
        			PlayLevelScreen.mapSelection(13);
        			CuriosityOrb.mapSelection(13);
        		} else if (currentMenuItemHovered == 14) {
        			screenCoordinator.setGameState(GameState.STORY5);
        			PlayLevelScreen.mapSelection(14);
        			CuriosityOrb.mapSelection(14);
        		}
        	}

        }
///////////////////////////////////////////////Draws Screen Elements///////////////////////////////////////////////////////////////

    	//displays screen elements
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        levelSelectLabel.draw(graphicsHandler);
        world1Label.draw(graphicsHandler);
        world2Label.draw(graphicsHandler);
        world3Label.draw(graphicsHandler);
        level1Label.draw(graphicsHandler);
        level2Label.draw(graphicsHandler);
        level3Label.draw(graphicsHandler);
        level4Label.draw(graphicsHandler);
        level5Label.draw(graphicsHandler);
        level6Label.draw(graphicsHandler);
        level7Label.draw(graphicsHandler);
        level8Label.draw(graphicsHandler);
        level9Label.draw(graphicsHandler);
        level10Label.draw(graphicsHandler);
        level11Label.draw(graphicsHandler);
        level12Label.draw(graphicsHandler);
        level13Label.draw(graphicsHandler);
        level14Label.draw(graphicsHandler);
        level15Label.draw(graphicsHandler);
        returnOptionsLabel.draw(graphicsHandler);


/////////////////////////////Reference Code from Options Screen for Implementing Level Progression and Saving//////////////////////
        	
        		//yellow box creation and location set based on active control preset
//        File controlsFile = new File("SavedData/ControlPreferences.txt");
//		 Scanner fileInput = null;
//		 try {
//			 fileInput = new Scanner(controlsFile);
//			 String activePreset = fileInput.nextLine();
//			 if (activePreset.equals("Active Preset: 1")) {
//				 graphicsHandler.drawFilledRectangleWithBorder(10, 133, 32, 20, new Color(255, 215, 0), Color.black, 2);
//			 }
//			 if (activePreset.equals("Active Preset: 2")) {
//				 graphicsHandler.drawFilledRectangleWithBorder(10, 163, 32, 20, new Color(255, 215, 0), Color.black, 2);
//			 }
//			 if (activePreset.equals("Active Preset: 3")) {
//				 graphicsHandler.drawFilledRectangleWithBorder(10, 193, 32, 20, new Color(255, 215, 0), Color.black, 2);
//			 }
//			 if (activePreset.equals("Active Preset: 4")) {
//				 graphicsHandler.drawFilledRectangleWithBorder(10, 223, 32, 20, new Color(255, 215, 0), Color.black, 2);
//			 }
//			 if (activePreset.equals("Active Preset: 5")) {
//				 graphicsHandler.drawFilledRectangleWithBorder(10, 253, 32, 20, new Color(255, 215, 0), Color.black, 2);
//			 }
//		 } catch (FileNotFoundException e) {
//			 System.out.println("Error");
//			 System.exit(1);
//		 }


		 	//blue cursor for scrolling through options
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }

}