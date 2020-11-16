package Screens;

import java.awt.Color;

import Engine.Audio;
import Engine.GamePanel;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

public class StoryScreen3 extends Screen {
	protected ScreenCoordinator screenCoordinator;
	protected Audio audio = null;
	protected Map background;
	protected KeyLocker keyLocker = new KeyLocker();
	protected SpriteFont story;
	protected SpriteFont plotLabel;
	protected SpriteFont plotLabel2;
	protected SpriteFont plotLabel3;
	protected SpriteFont plotLabel4;
	protected SpriteFont plotLabel5;
	protected SpriteFont howToProgressLabel;

	public StoryScreen3(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}

	@Override
	public void initialize() {
		audio = GamePanel.getAudio();
		audio.startPlayingOnce(6);
		// setup graphics on screen (background map, spritefont text)
		background = new TitleScreenMap();
		background.setAdjustCamera(false);

		// The Text
		story = new SpriteFont(" 	The Story So Far: ", 220, 120, "Comic Sans", 23, new Color(49, 207, 240));
		story.setOutlineColor(Color.black);
		story.setOutlineThickness(3);

		plotLabel = new SpriteFont(" Tac is on his way home with his best friend Surlaw.", 50, 150,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel.setOutlineColor(Color.black);
		plotLabel.setOutlineThickness(3);

		plotLabel2 = new SpriteFont(
				" Tac just got through the desert Surlaw convinced him to go through.", 50, 200,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel2.setOutlineColor(Color.black);
		plotLabel2.setOutlineThickness(3);

		plotLabel3 = new SpriteFont(
				" After fully leaving the desert, they see a rocky area with a huge volcano in the distance.", 50, 250,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel3.setOutlineColor(Color.black);
		plotLabel3.setOutlineThickness(3);

		plotLabel4 = new SpriteFont(" Surlaw tells Tac this this is the final area they need to cross to get home.", 50,
				300, "Comic Sans", 18, new Color(255, 215, 0));
		plotLabel4.setOutlineColor(Color.black);
		plotLabel4.setOutlineThickness(3);

		plotLabel5 = new SpriteFont(" So Tac travels on...", 50, 350, "Comic Sans", 18,
				new Color(255, 215, 0));
		plotLabel5.setOutlineColor(Color.black);
		plotLabel5.setOutlineThickness(3);

		// Progress onto the level text
		howToProgressLabel = new SpriteFont("Press the INTERACT key to progress to the level", 20, 560, "Comic Sans",
				30, Color.white);

		keyLocker.lockKey(Key.currentINTERACT);
	}

	public void update() {
		background.update(null);
		audio.startPlayingLoop(5);
		if (Keyboard.isKeyUp(Key.currentINTERACT)) {
			keyLocker.unlockKey(Key.currentINTERACT);
		}

		// if space is pressed, go back to main menu
		if (!keyLocker.isKeyLocked(Key.currentINTERACT) && Keyboard.isKeyDown(Key.currentINTERACT)) {
			audio.startPlayingOnce(7);
			screenCoordinator.setGameState(GameState.LEVEL11);
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		background.draw(graphicsHandler);
		story.draw(graphicsHandler);
		plotLabel.draw(graphicsHandler);
		plotLabel2.draw(graphicsHandler);
		plotLabel3.draw(graphicsHandler);
		plotLabel4.draw(graphicsHandler);
		plotLabel5.draw(graphicsHandler);
		howToProgressLabel.draw(graphicsHandler);
	}
}
