package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Level.Player;
import Level.PlayerListener;
import Maps.Level3Forest;
import Players.Cat;
import Utils.Stopwatch;
import javax.sound.sampled.Clip;
import java.util.ArrayList;

// This class is for when the platformer game is actually being played
public class Level3ForestScreen extends Screen implements PlayerListener {
    protected ScreenCoordinator screenCoordinator;
    protected Audio audio = null;
    protected Map map;
    protected Player player;
    protected PlayLevelScreenState playLevelScreenState;
    protected Stopwatch screenTimer = new Stopwatch();
    protected LevelClearedScreen levelClearedScreen;
    protected Level3LoseScreen levelLoseScreen;
    protected boolean isGamePaused;
    protected Level3PauseScreen pauseLevelScreen;
    protected KeyLocker keyLocker;


    public Level3ForestScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    public void initialize() {
        // define/setup map
        audio = GamePanel.getAudio();
        audio.setPosition(0, 0);
        audio.stopPlaying(5);
        this.map = new Level3Forest();
        map.reset();

        // setup player
        this.isGamePaused = false;
        this.pauseLevelScreen = new Level3PauseScreen(screenCoordinator, this);
        this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.player.setMap(map);
        this.player.addListener(this);
        this.player.setLocation(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
        this.playLevelScreenState = PlayLevelScreenState.RUNNING;
        this.keyLocker = new KeyLocker();
    }

    public void update() {
        // based on screen state, perform specific actions
        switch (playLevelScreenState) {
            // if level is "running" update player and map to keep game logic for the platformer level going
            case RUNNING:
            	 if (Keyboard.isKeyDown(Key.P) && !keyLocker.isKeyLocked(Key.P)) {
                     audio.stopPlaying(0);
 					isGamePaused = !isGamePaused;
 					keyLocker.lockKey(Key.P);
 					
 					if (isGamePaused) {
                        audio.startPlayingOnce(4);
						pauseLevelScreen.initialize();
					} else {
                        audio.startPlayingOnce(4);
                    }
 				}

            	 if (Keyboard.isKeyUp(Key.P)) {
            		 keyLocker.unlockKey(Key.P);
				}

                 if (isGamePaused) {
 					pauseLevelScreen.update();
 				}
                 else {
 					player.update();
 					map.update(player);
 				}
                 break;
            // if level has been completed, bring up level cleared screen
            case LEVEL_COMPLETED:
                levelClearedScreen = new LevelClearedScreen();
                levelClearedScreen.initialize();
                screenTimer.setWaitTime(2500);
                playLevelScreenState = PlayLevelScreenState.LEVEL_WIN_MESSAGE;
                audio.stopPlaying(0);
                break;
            // if level cleared screen is up and the timer is up for how long it should stay out, go back to main menu
            case LEVEL_WIN_MESSAGE:
                if (screenTimer.isTimeUp()) {
                    levelClearedScreen = null;
                    audio.stopPlaying(0);
                    goBackToMenu();
                }
                break;
            // if player died in level, bring up level lost screen
            case PLAYER_DEAD:
                audio.stopPlaying(0);
                levelLoseScreen = new Level3LoseScreen(this);
                levelLoseScreen.initialize();
                playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE_MESSAGE;
                break;
            // wait on level lose screen to make a decision (either resets level or sends player back to main menu)
            case LEVEL_LOSE_MESSAGE:
                levelLoseScreen.update();
                break;
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // based on screen state, draw appropriate graphics
        switch (playLevelScreenState) {
            case RUNNING:
            case LEVEL_COMPLETED:
            case PLAYER_DEAD:
                map.draw(graphicsHandler);
                player.draw(graphicsHandler);
                if (isGamePaused) {
    				pauseLevelScreen.draw(graphicsHandler);
    			} 
                break;
            case LEVEL_WIN_MESSAGE:
                levelClearedScreen.draw(graphicsHandler);
                break;
            case LEVEL_LOSE_MESSAGE:
                levelLoseScreen.draw(graphicsHandler);
                break;
        }
    }

    public PlayLevelScreenState getPlayLevelScreenState() {
        return playLevelScreenState;
    }

    @Override
    public void onLevelCompleted() {
        playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
    }

    @Override
    public void onDeath() {
        playLevelScreenState = PlayLevelScreenState.PLAYER_DEAD;
    }

    public void resetLevel() {
        initialize();
    }

    public void goBackToMenu() {
        screenCoordinator.setGameState(GameState.MENU);
    }

    // This enum represents the different states this screen can be in
    private enum PlayLevelScreenState {
        RUNNING, LEVEL_COMPLETED, PLAYER_DEAD, LEVEL_WIN_MESSAGE, LEVEL_LOSE_MESSAGE
    }
}