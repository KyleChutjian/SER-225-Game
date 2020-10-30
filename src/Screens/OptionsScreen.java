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
public class OptionsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Audio audio = null;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected int currentMenuItemHovered = 0;
    protected int currentMusicItemHovered = 0;
    protected int currentEffectItemHovered = 0;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY, activePresetX, activePresetY;
    protected SpriteFont controlsLabel;
    protected SpriteFont controlsDescLabel;
    protected SpriteFont wasd1Label;
    	protected SpriteFont wasd1DescLabel1; 
    	protected SpriteFont wasd1DescLabel2;
    	protected SpriteFont wasd1DescLabel3;
    protected SpriteFont wasd2Label;
    	protected SpriteFont wasd2DescLabel1;
    	protected SpriteFont wasd2DescLabel2;
    	protected SpriteFont wasd2DescLabel3;
    protected SpriteFont arrows1Label;
    	protected SpriteFont arrows1DescLabel1;
    	protected SpriteFont arrows1DescLabel2;
    	protected SpriteFont arrows1DescLabel3;
    protected SpriteFont arrows2Label;
    	protected SpriteFont arrows2DescLabel1;
    	protected SpriteFont arrows2DescLabel2;
    	protected SpriteFont arrows2DescLabel3;
    protected SpriteFont numpadLabel;
    	protected SpriteFont numpadDescLabel1;
    	protected SpriteFont numpadDescLabel2;
    	protected SpriteFont numpadDescLabel3;
    protected SpriteFont returnOptionsLabel;
    protected SpriteFont returnOptionsLabel2;
    protected SpriteFont audioLabel;
    protected SpriteFont musicLabel;
    protected SpriteFont musicNumber;
    protected SpriteFont effectLabel;
    protected SpriteFont effectNumber;


    public OptionsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        audio = GamePanel.getAudio();
    	background = new TitleScreenMap();
        background.setAdjustCamera(false);

       	// setup graphics on screen
        	//Option Menu text
        controlsLabel = new SpriteFont("   CONTROLS", 180, 60, "Comic Sans", 24, new Color(49, 207, 240));
        controlsLabel.setOutlineColor(Color.black);
        controlsLabel.setOutlineThickness(3);

        controlsDescLabel = new SpriteFont("Movement Presets", 180, 100, "Comic Sans", 22, new Color(49, 207, 240));
        controlsDescLabel.setOutlineColor(Color.black);
        controlsDescLabel.setOutlineThickness(3);

        ///////////////////////////////////////////////////////////////
        	//WASD w/ F text
        wasd1Label = new SpriteFont("WASD Variant 1", 50, 150, "Comic Sans", 20, new Color(49, 207, 240));
        wasd1Label.setOutlineColor(Color.black);
        wasd1Label.setOutlineThickness(3);

        		//Preset Description
        wasd1DescLabel1 = new SpriteFont("Movement: WASD", 270, 150, "Comic Sans", 20, new Color( 255, 215, 0));
        wasd1DescLabel1.setOutlineColor(Color.black);
        wasd1DescLabel1.setOutlineThickness(3);

        wasd1DescLabel2 = new SpriteFont("Interact:     SPACE", 270, 180, "Comic Sans", 20, new Color( 255, 215, 0));
        wasd1DescLabel2.setOutlineColor(Color.black);
        wasd1DescLabel2.setOutlineThickness(3);

        wasd1DescLabel3 = new SpriteFont("Pause:       'P'", 270, 210, "Comic Sans", 20, new Color( 255, 215, 0));
        wasd1DescLabel3.setOutlineColor(Color.black);
        wasd1DescLabel3.setOutlineThickness(3);

        //////////////////////////////////////////////////////////////
        	//WASD w/ SPACE text
        wasd2Label = new SpriteFont("WASD Variant 2", 50, 180, "Comic Sans", 20, new Color(49, 207, 240));
        wasd2Label.setOutlineColor(Color.black);
        wasd2Label.setOutlineThickness(3);

        		//Preset Description
        wasd2DescLabel1 = new SpriteFont("Movement: WASD", 270, 150, "Comic Sans", 20, new Color( 255, 215, 0));
        wasd2DescLabel1.setOutlineColor(Color.black);
        wasd2DescLabel1.setOutlineThickness(3);

        wasd2DescLabel2 = new SpriteFont("Interact:     'F'", 270, 180, "Comic Sans", 20, new Color( 255, 215, 0));
        wasd2DescLabel2.setOutlineColor(Color.black);
        wasd2DescLabel2.setOutlineThickness(3);

        wasd2DescLabel3 = new SpriteFont("Pause:       'P'", 270, 210, "Comic Sans", 20, new Color( 255, 215, 0));
        wasd2DescLabel3.setOutlineColor(Color.black);
        wasd2DescLabel3.setOutlineThickness(3);

        ///////////////////////////////////////////////////////////////
        	//ARROWS w/ SPACE text
        arrows1Label = new SpriteFont("Arrow Keys Variant 1", 50, 210, "Comic Sans", 20, new Color(49, 207, 240));
        arrows1Label.setOutlineColor(Color.black);
        arrows1Label.setOutlineThickness(3);

        		//Preset Description
        arrows1DescLabel1 = new SpriteFont("Movement: Arrow Keys", 270, 150, "Comic Sans", 20, new Color( 255, 215, 0));
        arrows1DescLabel1.setOutlineColor(Color.black);
        arrows1DescLabel1.setOutlineThickness(3);

        arrows1DescLabel2 = new SpriteFont("Interact:     SPACE", 270, 180, "Comic Sans", 20, new Color( 255, 215, 0));
        arrows1DescLabel2.setOutlineColor(Color.black);
        arrows1DescLabel2.setOutlineThickness(3);

        arrows1DescLabel3 = new SpriteFont("Pause:       'P'", 270, 210, "Comic Sans", 20, new Color( 255, 215, 0));
        arrows1DescLabel3.setOutlineColor(Color.black);
        arrows1DescLabel3.setOutlineThickness(3);

        ///////////////////////////////////////////////////////////////
        	//ARROWS w/ NUMPAD "." text
        arrows2Label = new SpriteFont("Arrow Keys Variant 2", 50, 240, "Comic Sans", 20, new Color(49, 207, 240));
        arrows2Label.setOutlineColor(Color.black);
        arrows2Label.setOutlineThickness(3);

        		//Preset Description
        arrows2DescLabel1 = new SpriteFont("Movement: Arrow Keys", 270, 150, "Comic Sans", 20, new Color( 255, 215, 0));
        arrows2DescLabel1.setOutlineColor(Color.black);
        arrows2DescLabel1.setOutlineThickness(3);

        arrows2DescLabel2 = new SpriteFont("Interact:     NUMPAD '.'", 270, 180, "Comic Sans", 20, new Color( 255, 215, 0));
        arrows2DescLabel2.setOutlineColor(Color.black);
        arrows2DescLabel2.setOutlineThickness(3);

        arrows2DescLabel3 = new SpriteFont("Pause:       'P'", 270, 210, "Comic Sans", 20, new Color( 255, 215, 0));
        arrows2DescLabel3.setOutlineColor(Color.black);
        arrows2DescLabel3.setOutlineThickness(3);

        /////////////////////////////////////////////////////////////////
        	//NUMPAD Arrows text
        numpadLabel = new SpriteFont("Challenge Preset", 50, 270, "Comic Sans", 20, new Color(49, 207, 240));
        numpadLabel.setOutlineColor(Color.black);
        numpadLabel.setOutlineThickness(3);

        		//Preset Description
        numpadDescLabel1 = new SpriteFont("Movement: ?", 270, 150, "Comic Sans", 20, new Color( 255, 215, 0));
        numpadDescLabel1.setOutlineColor(Color.black);
        numpadDescLabel1.setOutlineThickness(3);

        numpadDescLabel2 = new SpriteFont("Interact:     ?", 270, 180, "Comic Sans", 20, new Color( 255, 215, 0));
        numpadDescLabel2.setOutlineColor(Color.black);
        numpadDescLabel2.setOutlineThickness(3);

        numpadDescLabel3 = new SpriteFont("Pause:       'P'", 270, 210, "Comic Sans", 20, new Color( 255, 215, 0));
        numpadDescLabel3.setOutlineColor(Color.black);
        numpadDescLabel3.setOutlineThickness(3);

        ///////////////////////////////////////////////////////////////////
        	//Audio Text Labels
        audioLabel = new SpriteFont("VOLUME MIXER", 180, 310, "Comic Sans", 24, new Color(49, 207, 240));
        audioLabel.setOutlineColor(Color.black);
        audioLabel.setOutlineThickness(3);

        musicLabel = new SpriteFont("Music", 50, 350, "Comic Sans", 20, new Color(49, 207, 240));
        musicLabel.setOutlineColor(Color.black);
        musicLabel.setOutlineThickness(3);

        effectLabel = new SpriteFont("Effects", 50, 400, "Comic Sans", 20, new Color(49, 207, 240));
        effectLabel.setOutlineColor(Color.black);
        effectLabel.setOutlineThickness(3);


        ///////////////////////////////////////////////////////////////////
        	//Return to Main Menu Text
        returnOptionsLabel = new SpriteFont("Press the INTERACT key to select a preset", 40, 555, "Comic Sans", 22, new Color(49, 207, 240));
        returnOptionsLabel.setOutlineColor(Color.black);
        returnOptionsLabel.setOutlineThickness(3);


        keyLocker.lockKey(Key.currentINTERACT);
        keyTimer.setWaitTime(200);
    }

    public void update() {
    	background.update(null);
        audio.startPlayingLoop(5);
    		//sets currentMenuItemHovered
        if (Keyboard.isKeyDown(Key.currentDOWN) && keyTimer.isTimeUp()) {
    		keyTimer.reset();
            audio.startPlayingOnce(6);

    		currentMenuItemHovered++;
    	} else if (Keyboard.isKeyDown(Key.currentUP) && keyTimer.isTimeUp()) {
    		keyTimer.reset();
            audio.startPlayingOnce(6);
    		currentMenuItemHovered--;
    	}

    		// if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
    	if (currentMenuItemHovered > 6) {
    		currentMenuItemHovered = 0;
    	} else if (currentMenuItemHovered < 0) {
    		currentMenuItemHovered = 6;
    	}


    	try {
            File audioFile = new File("SavedData/AudioPreferences.txt");
            Scanner audioInput = null;
            audioInput = new Scanner(audioFile);
            currentMusicItemHovered = audioInput.nextInt();
            currentEffectItemHovered = audioInput.nextInt();

        } catch (IOException e) {
            System.out.println("Error");
        }

        if (currentMenuItemHovered == 0) {
        		//Highlights WASD w/ F controls
        	wasd1Label.setColor(new Color( 255, 215, 0));
            wasd2Label.setColor(new Color( 49, 207, 240));
            arrows1Label.setColor(new Color( 49, 207, 240));
            arrows2Label.setColor(new Color( 49, 207, 240));
            numpadLabel.setColor(new Color( 49, 207, 240));
            pointerLocationX = 10;
            pointerLocationY = 133;
	
            	//displays associated preset
            wasd1DescLabel1.setFontSize(20);
            wasd1DescLabel2.setFontSize(20);
            wasd1DescLabel3.setFontSize(20);

            wasd2DescLabel1.setFontSize(0);
            wasd2DescLabel2.setFontSize(0);
            wasd2DescLabel3.setFontSize(0);

            arrows1DescLabel1.setFontSize(0);
            arrows1DescLabel2.setFontSize(0);
            arrows1DescLabel3.setFontSize(0);

            arrows2DescLabel1.setFontSize(0);
            arrows2DescLabel2.setFontSize(0);
            arrows2DescLabel3.setFontSize(0);

            numpadDescLabel1.setFontSize(0);
            numpadDescLabel2.setFontSize(0);
            numpadDescLabel3.setFontSize(0);

        } else if (currentMenuItemHovered == 1) {
        		//displays WASD w/ SPACE controls
        	wasd1Label.setColor(new Color( 49, 207, 240));
            wasd2Label.setColor(new Color( 255, 215, 0));
            arrows1Label.setColor(new Color( 49, 207, 240));
            arrows2Label.setColor(new Color( 49, 207, 240));
            numpadLabel.setColor(new Color( 49, 207, 240));
            pointerLocationX = 10;
            pointerLocationY = 163;

            	//displays associated preset
            wasd1DescLabel1.setFontSize(0);
            wasd1DescLabel2.setFontSize(0);
            wasd1DescLabel3.setFontSize(0);

            wasd2DescLabel1.setFontSize(20);
            wasd2DescLabel2.setFontSize(20);
            wasd2DescLabel3.setFontSize(20);

            arrows1DescLabel1.setFontSize(0);
            arrows1DescLabel2.setFontSize(0);
            arrows1DescLabel3.setFontSize(0);

            arrows2DescLabel1.setFontSize(0);
            arrows2DescLabel2.setFontSize(0);
            arrows2DescLabel3.setFontSize(0);

            numpadDescLabel1.setFontSize(0);
            numpadDescLabel2.setFontSize(0);
            numpadDescLabel3.setFontSize(0);

        } else if (currentMenuItemHovered == 2) {
        		//displays ARROWs w/ SPACE controls
        	wasd1Label.setColor(new Color( 49, 207, 240));
            wasd2Label.setColor(new Color( 49, 207, 240));
            arrows1Label.setColor(new Color( 255, 215, 0));
            arrows2Label.setColor(new Color( 49, 207, 240));
            numpadLabel.setColor(new Color( 49, 207, 240));
            pointerLocationX = 10;
            pointerLocationY = 193;

            	//displays associated preset
            wasd1DescLabel1.setFontSize(0);
            wasd1DescLabel2.setFontSize(0);
            wasd1DescLabel3.setFontSize(0);

            wasd2DescLabel1.setFontSize(0);
            wasd2DescLabel2.setFontSize(0);
            wasd2DescLabel3.setFontSize(0);

            arrows1DescLabel1.setFontSize(20);
            arrows1DescLabel2.setFontSize(20);
            arrows1DescLabel3.setFontSize(20);

            arrows2DescLabel1.setFontSize(0);
            arrows2DescLabel2.setFontSize(0);
            arrows2DescLabel3.setFontSize(0);

            numpadDescLabel1.setFontSize(0);
            numpadDescLabel2.setFontSize(0);
            numpadDescLabel3.setFontSize(0);

        } else if (currentMenuItemHovered == 3) {
        		//displays ARROWs w/ NUMPAD "." controls
        	wasd1Label.setColor(new Color( 49, 207, 240));
            wasd2Label.setColor(new Color( 49, 207, 240));
            arrows1Label.setColor(new Color( 49, 207, 240));
            arrows2Label.setColor(new Color( 255, 215, 0));
            numpadLabel.setColor(new Color( 49, 207, 240));
            pointerLocationX = 10;
            pointerLocationY = 223;

            	//displays associated preset
            wasd1DescLabel1.setFontSize(0);
            wasd1DescLabel2.setFontSize(0);
            wasd1DescLabel3.setFontSize(0);

            wasd2DescLabel1.setFontSize(0);
            wasd2DescLabel2.setFontSize(0);
            wasd2DescLabel3.setFontSize(0);

            arrows1DescLabel1.setFontSize(0);
            arrows1DescLabel2.setFontSize(0);
            arrows1DescLabel3.setFontSize(0);

            arrows2DescLabel1.setFontSize(20);
            arrows2DescLabel2.setFontSize(20);
            arrows2DescLabel3.setFontSize(20);

            numpadDescLabel1.setFontSize(0);
            numpadDescLabel2.setFontSize(0);
            numpadDescLabel3.setFontSize(0);

        } else if (currentMenuItemHovered == 4) {
        		//displays NUMPAD w/ NUMPAD ENTER controls
        	wasd1Label.setColor(new Color( 49, 207, 240));
            wasd2Label.setColor(new Color( 49, 207, 240));
            arrows1Label.setColor(new Color( 49, 207, 240));
            arrows2Label.setColor(new Color( 49, 207, 240));
            numpadLabel.setColor(new Color( 255, 215, 0));
            pointerLocationX = 10;
            pointerLocationY = 253;

            	//displays associated preset
            wasd1DescLabel1.setFontSize(0);
            wasd1DescLabel2.setFontSize(0);
            wasd1DescLabel3.setFontSize(0);

            wasd2DescLabel1.setFontSize(0);
            wasd2DescLabel2.setFontSize(0);
            wasd2DescLabel3.setFontSize(0);

            arrows1DescLabel1.setFontSize(0);
            arrows1DescLabel2.setFontSize(0);
            arrows1DescLabel3.setFontSize(0);

            arrows2DescLabel1.setFontSize(0);
            arrows2DescLabel2.setFontSize(0);
            arrows2DescLabel3.setFontSize(0);

            numpadDescLabel1.setFontSize(20);
            numpadDescLabel2.setFontSize(20);
            numpadDescLabel3.setFontSize(20);
        }

        else if (currentMenuItemHovered == 5) {
            wasd1Label.setColor(new Color( 49, 207, 240));
            wasd2Label.setColor(new Color( 49, 207, 240));
            arrows1Label.setColor(new Color( 49, 207, 240));
            arrows2Label.setColor(new Color( 49, 207, 240));
            numpadLabel.setColor(new Color( 49, 207, 240));
            pointerLocationX = -50;
            pointerLocationY = -50;

            if (Keyboard.isKeyDown(Key.currentLEFT) && keyTimer.isTimeUp()) {
                keyTimer.reset();
                audio.startPlayingOnce(6);
                currentMusicItemHovered--;
            } else if (Keyboard.isKeyDown(Key.currentRIGHT) && keyTimer.isTimeUp()) {
                keyTimer.reset();
                audio.startPlayingOnce(6);
                currentMusicItemHovered++;
            }

            if (currentMusicItemHovered > 4) {
                currentMusicItemHovered = 4;
            } else if (currentMusicItemHovered < 0) {
                currentMusicItemHovered = 0;
            }
                try {
                    FileWriter audioWriter = new FileWriter("SavedData/AudioPreferences.txt");
                    if (currentMusicItemHovered == 0) {
                        audio.setMusicVolume(-80);
                        audioWriter.write("0");
                        audioWriter.write("\n" + currentEffectItemHovered);
                        audioWriter.close();
                        Keyboard.keyMap = Keyboard.buildKeyMap();
                    } else if (currentMusicItemHovered == 1) {
                        audio.setMusicVolume(-30);
                        audioWriter.write("1");
                        audioWriter.write("\n" + currentEffectItemHovered);
                        audioWriter.close();
                        Keyboard.keyMap = Keyboard.buildKeyMap();
                    } else if (currentMusicItemHovered == 2) {
                        audio.setMusicVolume(-15);
                        audioWriter.write("2");
                        audioWriter.write("\n" + currentEffectItemHovered);
                        audioWriter.close();
                        Keyboard.keyMap = Keyboard.buildKeyMap();
                    } else if (currentMusicItemHovered == 3) {
                        audio.setMusicVolume(0);
                        audioWriter.write("3");
                        audioWriter.write("\n" + currentEffectItemHovered);
                        audioWriter.close();
                        Keyboard.keyMap = Keyboard.buildKeyMap();
                    } else if (currentMusicItemHovered == 4) {
                        audio.setMusicVolume(6);
                        audioWriter.write("4");
                        audioWriter.write("\n" + currentEffectItemHovered);
                        audioWriter.close();
                        Keyboard.keyMap = Keyboard.buildKeyMap();
                    }

                } catch (IOException e) {
                    System.out.println("Error");
                }

            wasd1DescLabel1.setFontSize(0);
            wasd1DescLabel2.setFontSize(0);
            wasd1DescLabel3.setFontSize(0);

            wasd2DescLabel1.setFontSize(0);
            wasd2DescLabel2.setFontSize(0);
            wasd2DescLabel3.setFontSize(0);

            arrows1DescLabel1.setFontSize(0);
            arrows1DescLabel2.setFontSize(0);
            arrows1DescLabel3.setFontSize(0);

            arrows2DescLabel1.setFontSize(0);
            arrows2DescLabel2.setFontSize(0);
            arrows2DescLabel3.setFontSize(0);

            numpadDescLabel1.setFontSize(0);
            numpadDescLabel2.setFontSize(0);
            numpadDescLabel3.setFontSize(0);
        } else if (currentMenuItemHovered == 6) {
            wasd1Label.setColor(new Color( 49, 207, 240));
            wasd2Label.setColor(new Color( 49, 207, 240));
            arrows1Label.setColor(new Color( 49, 207, 240));
            arrows2Label.setColor(new Color( 49, 207, 240));
            numpadLabel.setColor(new Color( 49, 207, 240));
            pointerLocationX = -50;
            pointerLocationY = -50;

            if (Keyboard.isKeyDown(Key.currentLEFT) && keyTimer.isTimeUp()) {
                keyTimer.reset();
                audio.startPlayingOnce(6);
                currentEffectItemHovered--;
            } else if (Keyboard.isKeyDown(Key.currentRIGHT) && keyTimer.isTimeUp()) {
                keyTimer.reset();
                audio.startPlayingOnce(6);
                currentEffectItemHovered++;
            }

            if (currentEffectItemHovered > 4) {
                currentEffectItemHovered = 4;
            } else if (currentEffectItemHovered < 0) {
                currentEffectItemHovered = 0;
            }

            if (Keyboard.isKeyUp(Key.currentINTERACT)) {
                keyLocker.lockKey(Key.currentINTERACT);
            }

            try {
                FileWriter audioWriter = new FileWriter("SavedData/AudioPreferences.txt");
                if (currentEffectItemHovered == 0) {
                    audio.setEffectVolume(-80);
                    audioWriter.write("" + currentMusicItemHovered);
                    audioWriter.write("\n0");
                    audioWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
                } else if (currentEffectItemHovered == 1) {
                    audio.setEffectVolume(-30);
                    audioWriter.write("" + currentMusicItemHovered);
                    audioWriter.write("\n1");
                    audioWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
                } else if (currentEffectItemHovered == 2) {
                    audio.setEffectVolume(-15);
                    audioWriter.write("" + currentMusicItemHovered);
                    audioWriter.write("\n2");
                    audioWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
                } else if (currentEffectItemHovered == 3) {
                    audio.setEffectVolume(0);
                    audioWriter.write("" + currentMusicItemHovered);
                    audioWriter.write("\n3");
                    audioWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
                } else if (currentEffectItemHovered == 4) {
                    audio.setEffectVolume(6);
                    audioWriter.write("" + currentMusicItemHovered);
                    audioWriter.write("\n4");
                    audioWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
                }

            } catch (IOException e) {
                System.out.println("Error");
            }

            //displays associated preset
            wasd1DescLabel1.setFontSize(0);
            wasd1DescLabel2.setFontSize(0);
            wasd1DescLabel3.setFontSize(0);

            wasd2DescLabel1.setFontSize(0);
            wasd2DescLabel2.setFontSize(0);
            wasd2DescLabel3.setFontSize(0);

            arrows1DescLabel1.setFontSize(0);
            arrows1DescLabel2.setFontSize(0);
            arrows1DescLabel3.setFontSize(0);

            arrows2DescLabel1.setFontSize(0);
            arrows2DescLabel2.setFontSize(0);
            arrows2DescLabel3.setFontSize(0);

            numpadDescLabel1.setFontSize(0);
            numpadDescLabel2.setFontSize(0);
            numpadDescLabel3.setFontSize(0);
        }

        if (Keyboard.isKeyUp(Key.currentINTERACT)) {
            keyLocker.unlockKey(Key.currentINTERACT);
        }

        	// applied selected preset and returns to main menu
        if (!keyLocker.isKeyLocked(Key.currentINTERACT) && Keyboard.isKeyDown(Key.currentINTERACT)) {
            audio.startPlayingOnce(7);
        	try {
        		FileWriter fileWriter = new FileWriter("SavedData/ControlPreferences.txt");
        		if(currentMenuItemHovered == 0) {
        			//set control preset to WASD preset 1
        			fileWriter.write("Active Preset: 1");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        		} else if (currentMenuItemHovered == 1) {
        			//set control preset to WASD preset 2
        			fileWriter.write("Active Preset: 2");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        		} else if (currentMenuItemHovered == 2) {
        			//set control preset to Arrows preset 1
        			fileWriter.write("Active Preset: 3");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        		} else if (currentMenuItemHovered == 3) {
        			//set control preset to Arrows preset 2
        			fileWriter.write("Active Preset: 4");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        		} else if (currentMenuItemHovered == 4) {
        			//set control preset to NUMPAD preset
        			fileWriter.write("Active Preset: 5");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        		}

        	} catch (IOException e) {
        		System.out.println("Error");
        	}
        }

        if (Keyboard.isKeyUp(Key.currentINTERACT) && (currentMenuItemHovered == 5 || currentMenuItemHovered == 6)) {
            keyLocker.lockKey(Key.currentINTERACT);
        }
        if (Keyboard.isKeyDown(Key.currentINTERACT) && (currentMenuItemHovered == 5 || currentMenuItemHovered == 6)) {
            audio.startPlayingOnce(7);
            screenCoordinator.setGameState(GameState.MENU);
        }

    }

    	//displays screen elements
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        controlsLabel.draw(graphicsHandler);
        controlsDescLabel.draw(graphicsHandler);
        wasd1Label.draw(graphicsHandler);
        	wasd1DescLabel1.draw(graphicsHandler);
        	wasd1DescLabel2.draw(graphicsHandler);
        	wasd1DescLabel3.draw(graphicsHandler);
        wasd2Label.draw(graphicsHandler);
        	wasd2DescLabel1.draw(graphicsHandler);
        	wasd2DescLabel2.draw(graphicsHandler);
        	wasd2DescLabel3.draw(graphicsHandler);
        arrows1Label.draw(graphicsHandler);
        	arrows1DescLabel1.draw(graphicsHandler);
        	arrows1DescLabel2.draw(graphicsHandler);
        	arrows1DescLabel3.draw(graphicsHandler);
        arrows2Label.draw(graphicsHandler);
        	arrows2DescLabel1.draw(graphicsHandler);
        	arrows2DescLabel2.draw(graphicsHandler);
        	arrows2DescLabel3.draw(graphicsHandler);
        numpadLabel.draw(graphicsHandler);
        	numpadDescLabel1.draw(graphicsHandler);
        	numpadDescLabel2.draw(graphicsHandler);
        	numpadDescLabel3.draw(graphicsHandler);
        returnOptionsLabel.draw(graphicsHandler);

        audioLabel.draw(graphicsHandler);
        musicLabel.draw(graphicsHandler);
            if (currentMusicItemHovered == 0) {
                graphicsHandler.drawFilledRectangle(130, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(170, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(210, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(250, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(290, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                musicNumber = new SpriteFont(" < >    0%", 330, 350, "Comic Sans", 20, new Color(49, 207, 240));
                musicNumber.setOutlineColor(Color.black);
                musicNumber.setOutlineThickness(3);
                musicNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 5) {
                    graphicsHandler.drawFilledRectangleWithBorder(130, 330, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentMusicItemHovered == 1) {
                graphicsHandler.drawFilledRectangle(130, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(210, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(250, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(290, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                musicNumber = new SpriteFont(" < >    25%", 330, 350, "Comic Sans", 20, new Color(49, 207, 240));
                musicNumber.setOutlineColor(Color.black);
                musicNumber.setOutlineThickness(3);
                musicNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 5) {
                    graphicsHandler.drawFilledRectangleWithBorder(170, 330, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentMusicItemHovered == 2) {
                graphicsHandler.drawFilledRectangle(130, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(210, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(250, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(290, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                musicNumber = new SpriteFont(" < >    50%", 330, 350, "Comic Sans", 20, new Color(49, 207, 240));
                musicNumber.setOutlineColor(Color.black);
                musicNumber.setOutlineThickness(3);
                musicNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 5) {
                    graphicsHandler.drawFilledRectangleWithBorder(210, 330, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentMusicItemHovered == 3) {
                graphicsHandler.drawFilledRectangle(130, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(210, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(250, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(290, 330, 30, 30, new Color(153, 217, 234), Color.black, 3);
                musicNumber = new SpriteFont(" < >    75%", 330, 350, "Comic Sans", 20, new Color(49, 207, 240));
                musicNumber.setOutlineColor(Color.black);
                musicNumber.setOutlineThickness(3);
                musicNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 5) {
                    graphicsHandler.drawFilledRectangleWithBorder(250, 330, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentMusicItemHovered == 4) {
                graphicsHandler.drawFilledRectangle(130, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(210, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(250, 330, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(290, 330, 30, 30, Color.black);
                musicNumber = new SpriteFont(" < >    100%", 330, 350, "Comic Sans", 20, new Color(49, 207, 240));
                musicNumber.setOutlineColor(Color.black);
                musicNumber.setOutlineThickness(3);
                musicNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 5) {
                    graphicsHandler.drawFilledRectangleWithBorder(290, 330, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            }

        effectLabel.draw(graphicsHandler);
            if (currentEffectItemHovered == 0) {
                graphicsHandler.drawFilledRectangle(130, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(170, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(210, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(250, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(290, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                effectNumber = new SpriteFont(" < >    0%", 330, 400, "Comic Sans", 20, new Color(49, 207, 240));
                effectNumber.setOutlineColor(Color.black);
                effectNumber.setOutlineThickness(3);
                effectNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 6) {
                    graphicsHandler.drawFilledRectangleWithBorder(130, 380, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentEffectItemHovered == 1) {
                graphicsHandler.drawFilledRectangle(130, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(210, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(250, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(290, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                effectNumber = new SpriteFont(" < >    25%", 330, 400, "Comic Sans", 20, new Color(49, 207, 240));
                effectNumber.setOutlineColor(Color.black);
                effectNumber.setOutlineThickness(3);
                effectNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 6) {
                    graphicsHandler.drawFilledRectangleWithBorder(170, 380, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentEffectItemHovered == 2) {
                graphicsHandler.drawFilledRectangle(130, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(210, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(250, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                graphicsHandler.drawFilledRectangleWithBorder(290, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                effectNumber = new SpriteFont(" < >    50%", 330, 400, "Comic Sans", 20, new Color(49, 207, 240));
                effectNumber.setOutlineColor(Color.black);
                effectNumber.setOutlineThickness(3);
                effectNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 6) {
                    graphicsHandler.drawFilledRectangleWithBorder(210, 380, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentEffectItemHovered == 3) {
                graphicsHandler.drawFilledRectangle(130, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(210, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(250, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangleWithBorder(290, 380, 30, 30, new Color(153, 217, 234), Color.black, 3);
                effectNumber = new SpriteFont(" < >    75%", 330, 400, "Comic Sans", 20, new Color(49, 207, 240));
                effectNumber.setOutlineColor(Color.black);
                effectNumber.setOutlineThickness(3);
                effectNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 6) {
                    graphicsHandler.drawFilledRectangleWithBorder(250, 380, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            } else if (currentEffectItemHovered == 4) {
                graphicsHandler.drawFilledRectangle(130, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(170, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(210, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(250, 380, 30, 30, Color.black);
                graphicsHandler.drawFilledRectangle(290, 380, 30, 30, Color.black);
                effectNumber = new SpriteFont(" < >    100%", 330, 400, "Comic Sans", 20, new Color(49, 207, 240));
                effectNumber.setOutlineColor(Color.black);
                effectNumber.setOutlineThickness(3);
                effectNumber.draw(graphicsHandler);
                if (currentMenuItemHovered == 6) {
                    graphicsHandler.drawFilledRectangleWithBorder(290, 380, 30, 30, new Color(49, 207, 240), Color.black, 3);
                }
            }

        	//yellow box creation and location set based on active control preset
        File controlsFile = new File("SavedData/ControlPreferences.txt");
		 Scanner fileInput = null;
		 try {
			 fileInput = new Scanner(controlsFile);
			 String activePreset = fileInput.nextLine();
			 if (activePreset.equals("Active Preset: 1")) {
				 graphicsHandler.drawFilledRectangleWithBorder(10, 133, 32, 20, new Color(255, 215, 0), Color.black, 2);
			 }
			 if (activePreset.equals("Active Preset: 2")) {
				 graphicsHandler.drawFilledRectangleWithBorder(10, 163, 32, 20, new Color(255, 215, 0), Color.black, 2);
			 }
			 if (activePreset.equals("Active Preset: 3")) {
				 graphicsHandler.drawFilledRectangleWithBorder(10, 193, 32, 20, new Color(255, 215, 0), Color.black, 2);
			 }
			 if (activePreset.equals("Active Preset: 4")) {
				 graphicsHandler.drawFilledRectangleWithBorder(10, 223, 32, 20, new Color(255, 215, 0), Color.black, 2);
			 }
			 if (activePreset.equals("Active Preset: 5")) {
				 graphicsHandler.drawFilledRectangleWithBorder(10, 253, 32, 20, new Color(255, 215, 0), Color.black, 2);
			 }
		 } catch (FileNotFoundException e) {
			 System.out.println("Error");
			 System.exit(1);
		 }

		 	//blue cursor for scrolling through options
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
        
    }

}