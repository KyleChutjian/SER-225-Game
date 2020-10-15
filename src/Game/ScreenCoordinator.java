package Game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Level.Map;
import Screens.CreditsScreen;
import Screens.InstructionsScreen;
import Screens.OptionsScreen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;

	// Audio instance variables
	protected AudioInputStream mainMenuAudio, forwardAudio, backwardAudio;
	protected Clip mainMenuClip, forwardClip, backwardClip;
	protected ArrayList<Clip> menuAudio = new ArrayList<>();

	public GameState getGameState() {
		return gameState;
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void initialize() {
		// start game off with Menu Screen
		loadAudio();
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case INSTRUCTIONS:
						currentScreen = new InstructionsScreen(this);
						break;
					case OPTIONS:
						currentScreen = new OptionsScreen(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
				}
				currentScreen.initialize();
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}

	public void loadAudio() {
		try {

			mainMenuAudio = AudioSystem.getAudioInputStream(new File("Audio/MainMenu.wav"));
			mainMenuClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, mainMenuAudio.getFormat()));
			mainMenuClip.open(mainMenuAudio);

			forwardAudio = AudioSystem.getAudioInputStream(new File("Audio/Forward.wav"));
			forwardClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, forwardAudio.getFormat()));
			forwardClip.open(forwardAudio);

			backwardAudio = AudioSystem.getAudioInputStream(new File("Audio/Backward.wav"));
			backwardClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, backwardAudio.getFormat()));
			backwardClip.open(backwardAudio);

			Map.setVolume(mainMenuClip, -20);
			Map.setVolume(forwardClip, 0);
			Map.setVolume(backwardClip, 0);


			menuAudio.add(mainMenuClip);
			menuAudio.add(forwardClip);
			menuAudio.add(backwardClip);


		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}


	}
	public ArrayList<Clip> getMenuAudio() {
		return menuAudio;
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}
