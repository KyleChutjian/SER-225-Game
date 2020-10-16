package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class InstructionsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected SpriteFont goalLabel;
    protected SpriteFont goalExplanationLabel;
    protected SpriteFont controlsLabel;
    protected SpriteFont controlsExplanationLabel1;
    protected SpriteFont controlsExplanationLabel2;
    protected SpriteFont controlsExplanationLabel3;
    protected SpriteFont controlsExplanationLabel4;
    protected SpriteFont controlsExplanationLabel5;
    protected SpriteFont returnInstructionsLabel;

    public InstructionsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        //background = new TitleScreenMap();

        controlsExplanationLabel4 = new SpriteFont("SPACE Bar                               : Interact", 60, 330, "Comic Sans", 18, Color.gray);
        controlsExplanationLabel5 = new SpriteFont("' P '                                            : Pause", 60, 350, "Comic Sans", 18, Color.gray);
        
        //Return to Main Menu Text
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 560, "Comic Sans", 30, Color.white);
        
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        // if space is pressed, go back to main menu
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.MENU);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        goalLabel.draw(graphicsHandler);
        goalExplanationLabel.draw(graphicsHandler);
        controlsLabel.draw(graphicsHandler);
        controlsExplanationLabel1.draw(graphicsHandler);
        controlsExplanationLabel2.draw(graphicsHandler);
        controlsExplanationLabel3.draw(graphicsHandler);
        controlsExplanationLabel4.draw(graphicsHandler);
        controlsExplanationLabel5.draw(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}