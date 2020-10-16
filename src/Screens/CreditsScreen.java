package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Audio audio = null;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont contributorsLabel;
    protected SpriteFont additionsMadeBy;
    protected SpriteFont bestTeamLabel;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        audio = GamePanel.getAudio();
        // setup graphics on screen (background map, spritefont text)
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 340, 110, "Comic Sans", 30, new Color(49, 207, 240));
        creditsLabel.setOutlineColor(Color.black);
    	creditsLabel.setOutlineThickness(3);
        createdByLabel = new SpriteFont("Created by Professor Alex Thimineur for Quinnipiac's SER225 Course.", 90, 140, "Comic Sans", 20, new Color(255, 215, 0));
        createdByLabel.setOutlineColor(Color.black);
    	createdByLabel.setOutlineThickness(3);
        contributorsLabel = new SpriteFont("Thank you to QU Alumni Brian Carducci, Joseph White, and Alex Hutman for their contributions.", 15, 170, "Comic Sans", 18, new Color(255, 215, 0));
        contributorsLabel.setOutlineColor(Color.black);
    	contributorsLabel.setOutlineThickness(3);
    	additionsMadeBy = new SpriteFont("Additions made by :", 310 , 210, "Comic Sans", 18, new Color(49, 207, 240));
    	additionsMadeBy.setOutlineColor(Color.black);
    	additionsMadeBy.setOutlineThickness(3);
    	bestTeamLabel = new SpriteFont("3MK Developers: Kyle Chutjian, Michael Tambascio, Max Petruzziello, Matthew Gumprecht", 110, 240, "Comic Sans", 14, new Color(255, 215, 0));
    	bestTeamLabel.setOutlineColor(Color.black);
    	bestTeamLabel.setOutlineThickness(3);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 560, "Comis Sans", 30, Color.white);
        keyLocker.lockKey(Key.currentINTERACT);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.currentINTERACT)) {
            keyLocker.unlockKey(Key.currentINTERACT);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.currentINTERACT) && Keyboard.isKeyDown(Key.currentINTERACT)) {
            audio.startPlayingOnce(7);
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.draw(graphicsHandler);
        contributorsLabel.drawWithParsedNewLines(graphicsHandler);
        additionsMadeBy.drawWithParsedNewLines(graphicsHandler);
        bestTeamLabel.drawWithParsedNewLines(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
