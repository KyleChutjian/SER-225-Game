package Game;

import Engine.DefaultScreen;

import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.Characters;
import Screens.CreditsScreen;
import Screens.InstructionsScreen;
import Screens.LevelClearedScreen;
import Screens.OptionsScreen;
import Screens.MenuScreen;
import Screens.LevelSelectScreen;
import Screens.PlayLevelScreen;
import Screens.StoryScreen;
import Screens.StoryScreen2;
import Screens.StoryScreen3;
import Screens.StoryScreen4;
import Screens.StoryScreen5;

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
					case STORY:
						currentScreen = new StoryScreen(this);
						break;
					case STORY2:
						currentScreen = new StoryScreen2(this);
						break;
					case STORY3:
						currentScreen = new StoryScreen3(this);
						break;
					case STORY4:
						currentScreen = new StoryScreen4(this);
						break;
					case STORY5:
						currentScreen = new StoryScreen5(this);
						break;
					case LEVELSELECT:
						currentScreen = new LevelSelectScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL2:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL3:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL4:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL5:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL6:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL7:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL8:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL9:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL10:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL11:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL12:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL13:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL14:
						currentScreen = new PlayLevelScreen(this);
						break;
					case LEVEL15:
						currentScreen = new PlayLevelScreen(this);
						break;
					case CHARACTERS:
						currentScreen = new Characters(this);
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

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}
}
