package Screens;

import Engine.Audio;
import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import Maps.Level2Fields;
import Maps.Level3Forest;
import Maps.Level4Lake;
import Maps.Level5Hills;
import Maps.Level6Sands;
import Maps.Level7Dunes;
import Maps.Level8Pyramid;
import Maps.Level9Oasis;
import Maps.Level10Mirage;
import Maps.Level11Rocks;
import Maps.Level12Mountains;
import Maps.Level13Cliffs;
import Maps.Level14Volcano;
import Maps.Level15Descent;
import Players.Cat;
import Utils.Stopwatch;
import javax.sound.sampled.Clip;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Timer;

// This class is for when the platformer game is actually being played
public class PlayLevelScreen extends Screen implements PlayerListener {
	protected ScreenCoordinator screenCoordinator;
	protected Audio audio = null;
	protected Map map;
	protected Player player;
	protected HUD hud;
	protected PlayLevelScreenState playLevelScreenState;
	protected Stopwatch screenTimer = new Stopwatch();
	protected LevelClearedScreen levelClearedScreen;
	protected LevelLoseScreen levelLoseScreen;
	protected boolean isGamePaused;
	protected PauseLevelScreen pauseLevelScreen;
	protected KeyLocker keyLocker;
	protected long startTime;
	protected long pauseTime;
	protected long startPauseTime;
	protected static int k;

	public PlayLevelScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}
	
	public static int mapSelection(int i) {
		k = i;
		return k;
	}

	public void initialize() {
		// define/setup map
		audio = GamePanel.getAudio();
		audio.setPosition(0, 0);
		audio.setPosition(5, 0);
		audio.stopPlaying(5);
		if (k == 0) {
			this.map = new TestMap();
		} else if (k == 1) {
			this.map = new Level2Fields();
		} else if (k == 2) {
			this.map = new Level3Forest();
		} else if (k == 3) {
			this.map = new Level4Lake();
		} else if (k == 4) {
			this.map = new Level5Hills();
		} else if (k == 5) {
			this.map = new Level6Sands();
		} else if (k == 6) {
			this.map = new Level7Dunes();
		} else if (k == 7) {
			this.map = new Level8Pyramid();
		} else if (k == 8) {
			this.map = new Level9Oasis();
		} else if (k == 9) {
			this.map = new Level10Mirage();
		} else if (k == 10) {
			this.map = new Level11Rocks();
		} else if (k == 11) {
			this.map = new Level12Mountains();
		} else if (k == 12) {
			this.map = new Level13Cliffs();
		} else if (k == 13) {
			this.map = new Level14Volcano();
		} else if (k == 14) {
			this.map = new Level15Descent();
		}

		map.reset();

		// setup time
		startTime = System.currentTimeMillis();

		// setup player
		this.isGamePaused = false;
		this.pauseLevelScreen = new PauseLevelScreen(screenCoordinator, this);
		this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
		this.player.setMap(map);
		this.player.addListener(this);
		this.player.setLocation(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
		this.playLevelScreenState = PlayLevelScreenState.RUNNING;
		this.keyLocker = new KeyLocker();
		this.hud = new HUD(player);
	}

	public void update() {
		// based on screen state, perform specific actions
		switch (playLevelScreenState) {
		// if level is "running" update player and map to keep game logic for the
		// platformer level going
		case RUNNING:
			if (player.getLevelState() == LevelState.LEVEL_COMPLETED || player.getLevelState() == LevelState.PLAYER_DEAD) {
				audio.stopPlayingMusic();
			}
			if (!isGamePaused && player.getLevelState() == LevelState.RUNNING) {
				switch (k) {
					case 0,1,2:
						audio.startPlayingLoop(0); // jumper
						break;
					case 3,4:
						audio.startPlayingLoop(13); // mario forest
						break;

					case 5,6,7:
						audio.startPlayingLoop(12); // day sonic desert
						break;

					case 8,9:
						audio.startPlayingLoop(11); // mario desert
						break;

					case 10,11,12:
						audio.startPlayingLoop(9); // aquatic mountain
						break;

					case 13:
						audio.startPlayingLoop(8); // second mountain clip
						break;

					case 14:
						audio.startPlayingLoop(14); // credits
				}
			}

			if (Keyboard.isKeyDown(Key.P) && !keyLocker.isKeyLocked(Key.P)) {
				audio.stopPlaying(0);
				isGamePaused = !isGamePaused;
				keyLocker.lockKey(Key.P);


				if (isGamePaused) {
					audio.startPlayingOnce(4);
					pauseLevelScreen.initialize();
					startPauseTime = System.currentTimeMillis();

				} else {
					audio.startPlayingOnce(4);
					long timePassedPaused = System.currentTimeMillis() - startPauseTime;
					pauseTime += timePassedPaused;
				}
			}

			if (Keyboard.isKeyUp(Key.P)) {
				keyLocker.unlockKey(Key.P);
			}

			if (isGamePaused) {
				pauseLevelScreen.update();
			} else {
				player.update();
				map.update(player);
				hud.update();
			}
			break;
		// if level has been completed, bring up level cleared screen
		case LEVEL_COMPLETED:
			levelClearedScreen = new LevelClearedScreen(startTime, pauseTime);
			levelClearedScreen.initialize();
			screenTimer.setWaitTime(2500);
			playLevelScreenState = PlayLevelScreenState.LEVEL_WIN_MESSAGE;
			audio.stopPlayingMusic();
			audio.startPlayingOnce(1);
			break;
		// if level cleared screen is up and the timer is up for how long it should stay
		// out, go back to main menu
		case LEVEL_WIN_MESSAGE:
			if (screenTimer.isTimeUp()) {
				levelClearedScreen = null;
				goBackToMenu();
			}
			break;
		// if player died in level, bring up level lost screen
		case PLAYER_DEAD:
			audio.stopPlaying(0);
			levelLoseScreen = new LevelLoseScreen(this);
			levelLoseScreen.initialize();
			playLevelScreenState = PlayLevelScreenState.LEVEL_LOSE_MESSAGE;
			break;
		// wait on level lose screen to make a decision (either resets level or sends
		// player back to main menu)
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
			hud.draw(graphicsHandler);
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