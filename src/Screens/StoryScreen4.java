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

public class StoryScreen4 extends Screen {
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
	protected SpriteFont plotLabel6;
	protected SpriteFont plotLabel7;
	protected SpriteFont plotLabel8;
	protected SpriteFont howToProgressLabel;

	public StoryScreen4(ScreenCoordinator screenCoordinator) {
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

		plotLabel = new SpriteFont(" Tac is on the final part of his trip home with his best friend Surlaw.", 50, 150,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel.setOutlineColor(Color.black);
		plotLabel.setOutlineThickness(3);

		plotLabel2 = new SpriteFont(
				" Tac and Surlaw just got to the volcano.", 50, 200,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel2.setOutlineColor(Color.black);
		plotLabel2.setOutlineThickness(3);

		plotLabel3 = new SpriteFont(
				" They both look around and Surlaw says that he can see a tundra in the distance.", 50, 250,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel3.setOutlineColor(Color.black);
		plotLabel3.setOutlineThickness(3);
		
		plotLabel4 = new SpriteFont(
				" Tac shakes his head, knowing that home is not in the tundra.", 50, 300,
				"Comic Sans", 18, new Color(255, 215, 0));
		plotLabel4.setOutlineColor(Color.black);
		plotLabel4.setOutlineThickness(3);

		plotLabel5 = new SpriteFont(" After seeing this, Surlaw pushes Tac into boulders, as he runs, he says.", 50,
				350, "Comic Sans", 18, new Color(255, 215, 0));
		plotLabel5.setOutlineColor(Color.black);
		plotLabel5.setOutlineThickness(3);

		plotLabel6 = new SpriteFont(" 'This was a trick to lead you away from home, you were never my friend, and you must die.'", 50,
				400, "Comic Sans", 18, new Color(255, 215, 0));
		plotLabel6.setOutlineColor(Color.black);
		plotLabel6.setOutlineThickness(3);
		
		plotLabel7 = new SpriteFont(" Tac has no time to think about this, as he needs to find a new route home.", 50, 450, "Comic Sans", 18,
				new Color(255, 215, 0));
		plotLabel7.setOutlineColor(Color.black);
		plotLabel7.setOutlineThickness(3);
		
		plotLabel8 = new SpriteFont(" The only way to do that is to climb to the top of the volcano...", 50, 500, "Comic Sans", 18,
				new Color(255, 215, 0));
		plotLabel8.setOutlineColor(Color.black);
		plotLabel8.setOutlineThickness(3);

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
			screenCoordinator.setGameState(GameState.LEVEL14);
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
		plotLabel6.draw(graphicsHandler);
		plotLabel7.draw(graphicsHandler);
		plotLabel8.draw(graphicsHandler);
		howToProgressLabel.draw(graphicsHandler);
	}
}
