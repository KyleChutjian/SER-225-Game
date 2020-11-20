package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Map;
import Maps.ShopScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import Builders.FrameBuilder;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;

// This class is for the credits screen
public class Characters extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Audio audio = null;
    protected Map background;
    protected SpriteFont title;
    	//cat options
    protected SpriteFont DefaultCat, BlackCat, CoolCat, IceCat, GhostCat, WizardCat, TopHatCat;
    	//descriptions
    protected SpriteFont DefaultCatDesc1, DefaultCatDesc2, DefaultCatDesc3, DefaultCatDesc4, DefaultCatDesc5;
    protected SpriteFont BlackCatDesc1, BlackCatDesc2, BlackCatDesc3, BlackCatDesc4, BlackCatDesc5, BlackCatDesc6;
    protected SpriteFont CoolCatDesc1, CoolCatDesc2, CoolCatDesc3, CoolCatDesc4, CoolCatDesc5, CoolCatDesc6, CoolCatDesc7, CoolCatDesc8;
    protected SpriteFont IceCatDesc1, IceCatDesc2, IceCatDesc3, IceCatDesc4, IceCatDesc5, IceCatDesc6;
    protected SpriteFont GhostCatDesc1, GhostCatDesc2, GhostCatDesc3, GhostCatDesc4, GhostCatDesc5, GhostCatDesc6, GhostCatDesc7, GhostCatDesc8, GhostCatDesc9;
    protected SpriteFont WizardCatDesc1, WizardCatDesc2, WizardCatDesc3, WizardCatDesc4, WizardCatDesc5, WizardCatDesc6, WizardCatDesc7;
    protected SpriteFont TopHatCatDesc1, TopHatCatDesc2, TopHatCatDesc3, TopHatCatDesc4, TopHatCatDesc5, TopHatCatDesc6, TopHatCatDesc7, TopHatCatDesc8, TopHatCatDesc9, TopHatCatDesc10, TopHatCatDesc11, TopHatCatDesc12;
    	//costs
    protected SpriteFont Cost;
    protected SpriteFont DefaultCatCostValue, BlackCatCostValue, CoolCatCostValue, IceCatCostValue, GhostCatCostValue, WizardCatCostValue, TopHatCatCostValue;
    	//balance
    protected SpriteFont Balance, BalanceValue;
    protected SpriteFont returnMainMenu;
    protected KeyLocker keyLocker = new KeyLocker();
    protected Stopwatch keyTimer = new Stopwatch();
    private int currentMenuItemHovered = 0;
    private int pointerLocationX, pointerLocationY, activePresetX, activePresetY;
    private int characterMenuPreview = 0;
    private int activeBalance;
    private String balanceToString;

    public Characters(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
//        test = new SpriteSheet(ImageLoader.load("Title.png"), 50, 50);
    }

    @Override
    public void initialize() {
        audio = GamePanel.getAudio();
    	background = new ShopScreenMap();
        background.setAdjustCamera(false);

       	// setup graphics on screen
        	//Title text
        title = new SpriteFont("SHOP", 371, 80, "Comic Sans", 30, new Color(49, 207, 240));
        title.setOutlineColor(Color.black);
        title.setOutlineThickness(3);

        ///////////////////////////////////////////////////////////////
        	//BlackCat
        DefaultCat = new SpriteFont("Default Cat", 52, 150, "Comic Sans", 22, new Color(49, 207, 240));
        DefaultCat.setOutlineColor(Color.black);
        DefaultCat.setOutlineThickness(3);

        DefaultCatDesc1 = new SpriteFont("The standard cat for", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        DefaultCatDesc1.setOutlineColor(Color.black);
        DefaultCatDesc1.setOutlineThickness(3);
        DefaultCatDesc2 = new SpriteFont("Curiosity. He's just", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        DefaultCatDesc2.setOutlineColor(Color.black);
        DefaultCatDesc2.setOutlineThickness(3);
        DefaultCatDesc3 = new SpriteFont("an orange tabby cat. ", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        DefaultCatDesc3.setOutlineColor(Color.black);
        DefaultCatDesc3.setOutlineThickness(3);
        DefaultCatDesc4 = new SpriteFont("Based on Professor", 230, 250, "Comic Sans", 20, new Color(255, 215, 0));
        DefaultCatDesc4.setOutlineColor(Color.black);
        DefaultCatDesc4.setOutlineThickness(3);
        DefaultCatDesc5 = new SpriteFont("Thimineur's cat.", 230, 275, "Comic Sans", 20, new Color(255, 215, 0));
        DefaultCatDesc5.setOutlineColor(Color.black);
        DefaultCatDesc5.setOutlineThickness(3);

        	//BlackCat
        BlackCat = new SpriteFont("Black Cat", 52, 180, "Comic Sans", 22, new Color(49, 207, 240));
        BlackCat.setOutlineColor(Color.black);
        BlackCat.setOutlineThickness(3);

        BlackCatDesc1 = new SpriteFont("Just a regular ol'", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatDesc1.setOutlineColor(Color.black);
        BlackCatDesc1.setOutlineThickness(3);
        BlackCatDesc2 = new SpriteFont("black cat. Nothing", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatDesc2.setOutlineColor(Color.black);
        BlackCatDesc2.setOutlineThickness(3);
        BlackCatDesc3 = new SpriteFont("special here. Totally", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatDesc3.setOutlineColor(Color.black);
        BlackCatDesc3.setOutlineThickness(3);
        BlackCatDesc4 = new SpriteFont("not evil or anything.", 230, 225, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatDesc4.setOutlineColor(Color.black);
        BlackCatDesc4.setOutlineThickness(3);
        BlackCatDesc5 = new SpriteFont("The eyes? Oh, that's", 230, 275, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatDesc5.setOutlineColor(Color.black);
        BlackCatDesc5.setOutlineThickness(3);
        BlackCatDesc6 = new SpriteFont("just allergies.", 230, 300, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatDesc6.setOutlineColor(Color.black);
        BlackCatDesc6.setOutlineThickness(3);

        	//CoolCat
        CoolCat = new SpriteFont("Cool Cat", 52, 210, "Comic Sans", 22, new Color(49, 207, 240));
        CoolCat.setOutlineColor(Color.black);
        CoolCat.setOutlineThickness(3);

        CoolCatDesc1 = new SpriteFont("He's a cool cat.", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc1.setOutlineColor(Color.black);
        CoolCatDesc1.setOutlineThickness(3);
        CoolCatDesc2 = new SpriteFont("Wears the shades so", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc2.setOutlineColor(Color.black);
        CoolCatDesc2.setOutlineThickness(3);
        CoolCatDesc3 = new SpriteFont("everyone knows it.", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc3.setOutlineColor(Color.black);
        CoolCatDesc3.setOutlineThickness(3);
        CoolCatDesc4 = new SpriteFont("Won't wear them at", 230, 250, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc4.setOutlineColor(Color.black);
        CoolCatDesc4.setOutlineThickness(3);
        CoolCatDesc5 = new SpriteFont("night. He thinks", 230, 275, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc5.setOutlineColor(Color.black);
        CoolCatDesc5.setOutlineThickness(3);
        CoolCatDesc6 = new SpriteFont("that's uncool. Don't", 230, 300, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc6.setOutlineColor(Color.black);
        CoolCatDesc6.setOutlineThickness(3);
        CoolCatDesc7 = new SpriteFont("wear your sunglasses", 230, 325, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc7.setOutlineColor(Color.black);
        CoolCatDesc7.setOutlineThickness(3);
        CoolCatDesc8 = new SpriteFont("at night.", 230, 350, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatDesc8.setOutlineColor(Color.black);
        CoolCatDesc8.setOutlineThickness(3);

        	//IceCat
        IceCat = new SpriteFont("Ice Cat", 52, 240, "Comic Sans", 22, new Color(49, 207, 240));
        IceCat.setOutlineColor(Color.black);
        IceCat.setOutlineThickness(3);

        IceCatDesc1 = new SpriteFont("If a snowman turned", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatDesc1.setOutlineColor(Color.black);
        IceCatDesc1.setOutlineThickness(3);
        IceCatDesc2 = new SpriteFont("into a cat, you'd", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatDesc2.setOutlineColor(Color.black);
        IceCatDesc2.setOutlineThickness(3);
        IceCatDesc3 = new SpriteFont("basically have this.", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatDesc3.setOutlineColor(Color.black);
        IceCatDesc3.setOutlineThickness(3);
        IceCatDesc4 = new SpriteFont("Doesn't seem to", 230, 250, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatDesc4.setOutlineColor(Color.black);
        IceCatDesc4.setOutlineThickness(3);
        IceCatDesc5 = new SpriteFont("melt oddly enough.", 230, 275, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatDesc5.setOutlineColor(Color.black);
        IceCatDesc5.setOutlineThickness(3);
        IceCatDesc6 = new SpriteFont("Cooler than Cool Cat?", 230, 325, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatDesc6.setOutlineColor(Color.black);
        IceCatDesc6.setOutlineThickness(3);

        	//GhostCat
        GhostCat = new SpriteFont("Ghost Cat", 52, 270, "Comic Sans", 22, new Color(49, 207, 240));
        GhostCat.setOutlineColor(Color.black);
        GhostCat.setOutlineThickness(3);

        GhostCatDesc1 = new SpriteFont("Nine lives runs out", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc1.setOutlineColor(Color.black);
        GhostCatDesc1.setOutlineThickness(3);
        GhostCatDesc2 = new SpriteFont("eventually, right?", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc2.setOutlineColor(Color.black);
        GhostCatDesc2.setOutlineThickness(3);
        GhostCatDesc3 = new SpriteFont("Regardless, this guy", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc3.setOutlineColor(Color.black);
        GhostCatDesc3.setOutlineThickness(3);
        GhostCatDesc4 = new SpriteFont("is still mortal.", 230, 225, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc4.setOutlineColor(Color.black);
        GhostCatDesc4.setOutlineThickness(3);
        GhostCatDesc5 = new SpriteFont("Somehow...", 230, 250, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc5.setOutlineColor(Color.black);
        GhostCatDesc5.setOutlineThickness(3);
        GhostCatDesc6 = new SpriteFont("Will still get hurt", 230, 300, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc6.setOutlineColor(Color.black);
        GhostCatDesc6.setOutlineThickness(3);
        GhostCatDesc7 = new SpriteFont("if you're not careful.", 230, 325, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc7.setOutlineColor(Color.black);
        GhostCatDesc7.setOutlineThickness(3);
        GhostCatDesc8 = new SpriteFont("Semi-transparent", 230, 375, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc8.setOutlineColor(Color.black);
        GhostCatDesc8.setOutlineThickness(3);
        GhostCatDesc9 = new SpriteFont("while exploring.", 230, 400, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatDesc9.setOutlineColor(Color.black);
        GhostCatDesc9.setOutlineThickness(3);

        	//WizardCat
        WizardCat = new SpriteFont("Wizard Cat", 52, 300, "Comic Sans", 22, new Color(49, 207, 240));
        WizardCat.setOutlineColor(Color.black);
        WizardCat.setOutlineThickness(3);

        WizardCatDesc1 = new SpriteFont("Not actually a wizard.", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc1.setOutlineColor(Color.black);
        WizardCatDesc1.setOutlineThickness(3);
        WizardCatDesc2 = new SpriteFont("Just likes to wear", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc2.setOutlineColor(Color.black);
        WizardCatDesc2.setOutlineThickness(3);
        WizardCatDesc3 = new SpriteFont("the hat.", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc3.setOutlineColor(Color.black);
        WizardCatDesc3.setOutlineThickness(3);
        WizardCatDesc4 = new SpriteFont("He doesn't know any", 230, 250, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc4.setOutlineColor(Color.black);
        WizardCatDesc4.setOutlineThickness(3);
        WizardCatDesc5 = new SpriteFont("magic tricks. Unless", 230, 275, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc5.setOutlineColor(Color.black);
        WizardCatDesc5.setOutlineThickness(3);
        WizardCatDesc6 = new SpriteFont("you find conjuring up", 230, 300, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc6.setOutlineColor(Color.black);
        WizardCatDesc6.setOutlineThickness(3);
        WizardCatDesc7 = new SpriteFont("hairballs 'magical'...", 230, 325, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatDesc7.setOutlineColor(Color.black);
        WizardCatDesc7.setOutlineThickness(3);

        	//TopHatCat
        TopHatCat = new SpriteFont("Top Hat Cat", 52, 330, "Comic Sans", 22, new Color(49, 207, 240));
        TopHatCat.setOutlineColor(Color.black);
        TopHatCat.setOutlineThickness(3);

        TopHatCatDesc1 = new SpriteFont("His hat alone is", 230, 150, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc1.setOutlineColor(Color.black);
        TopHatCatDesc1.setOutlineThickness(3);
        TopHatCatDesc2 = new SpriteFont("worth more than the", 230, 175, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc2.setOutlineColor(Color.black);
        TopHatCatDesc2.setOutlineThickness(3);
        TopHatCatDesc3 = new SpriteFont("computer you are", 230, 200, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc3.setOutlineColor(Color.black);
        TopHatCatDesc3.setOutlineThickness(3);
        TopHatCatDesc4 = new SpriteFont("currently using and", 230, 225, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc4.setOutlineColor(Color.black);
        TopHatCatDesc4.setOutlineThickness(3);
        TopHatCatDesc5 = new SpriteFont("he is very proud of", 230, 250, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc5.setOutlineColor(Color.black);
        TopHatCatDesc5.setOutlineThickness(3);
        TopHatCatDesc6 = new SpriteFont("it.", 230, 275, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc6.setOutlineColor(Color.black);
        TopHatCatDesc6.setOutlineThickness(3);
        TopHatCatDesc7 = new SpriteFont("Feels a sense of", 230, 325, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc7.setOutlineColor(Color.black);
        TopHatCatDesc7.setOutlineThickness(3);
        TopHatCatDesc8 = new SpriteFont("emptiness without a", 230, 350, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc8.setOutlineColor(Color.black);
        TopHatCatDesc8.setOutlineThickness(3);
        TopHatCatDesc9 = new SpriteFont("matching monocle.", 230, 375, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc9.setOutlineColor(Color.black);
        TopHatCatDesc9.setOutlineThickness(3);
        TopHatCatDesc10 = new SpriteFont("Too bad someone", 230, 400, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc10.setOutlineColor(Color.black);
        TopHatCatDesc10.setOutlineThickness(3);
        TopHatCatDesc11 = new SpriteFont("didn't give him one", 230, 425, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc11.setOutlineColor(Color.black);
        TopHatCatDesc11.setOutlineThickness(3);
        TopHatCatDesc12 = new SpriteFont("in the beginning...", 230, 455, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatDesc12.setOutlineColor(Color.black);
        TopHatCatDesc12.setOutlineThickness(3);

        File controlsFile = new File("SavedData/MapData.txt");
		Scanner fileInput = null;
		try {
			 fileInput = new Scanner(controlsFile);
			 int fileBalance = fileInput.nextInt();
			 this.activeBalance = fileBalance;
		 } catch (FileNotFoundException e) {
			 System.out.println("Error");
			 System.exit(1);
		 }

        	//Current Balance
		this.balanceToString = String.valueOf(this.activeBalance);
		System.out.println(this.activeBalance);
        Balance = new SpriteFont("Current Balance:", 440, 175, "Comic Sans", 20, new Color(49, 207, 240));
        Balance.setOutlineColor(Color.black);
        Balance.setOutlineThickness(3);
        BalanceValue = new SpriteFont(this.balanceToString, 600, 175, "Comic Sans", 20, new Color(255, 215, 0));
        BalanceValue.setOutlineColor(Color.black);
        BalanceValue.setOutlineThickness(3);

        	//Costs Label
        Cost = new SpriteFont("Cost : ", 440, 457, "Comic Sans", 20, new Color(49, 207, 240));
        Cost.setOutlineColor(Color.black);
        Cost.setOutlineThickness(3);

        	//Character Values
        DefaultCatCostValue = new SpriteFont("0", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        DefaultCatCostValue.setOutlineColor(Color.black);
        DefaultCatCostValue.setOutlineThickness(3);

        BlackCatCostValue = new SpriteFont("5", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        BlackCatCostValue.setOutlineColor(Color.black);
        BlackCatCostValue.setOutlineThickness(3);

        CoolCatCostValue = new SpriteFont("10", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        CoolCatCostValue.setOutlineColor(Color.black);
        CoolCatCostValue.setOutlineThickness(3);
        
        IceCatCostValue = new SpriteFont("15", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        IceCatCostValue.setOutlineColor(Color.black);
        IceCatCostValue.setOutlineThickness(3);
        
        GhostCatCostValue = new SpriteFont("20", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        GhostCatCostValue.setOutlineColor(Color.black);
        GhostCatCostValue.setOutlineThickness(3);
        
        WizardCatCostValue = new SpriteFont("30", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        WizardCatCostValue.setOutlineColor(Color.black);
        WizardCatCostValue.setOutlineThickness(3);
        
        TopHatCatCostValue = new SpriteFont("50", 510, 457, "Comic Sans", 20, new Color(255, 215, 0));
        TopHatCatCostValue.setOutlineColor(Color.black);
        TopHatCatCostValue.setOutlineThickness(3);

        	//Return to Main Menu Text
        returnMainMenu = new SpriteFont("Press the INTERACT key to select a character", 180, 559, "Comic Sans", 22, new Color(49, 207, 240));
        returnMainMenu.setOutlineColor(Color.black);
        returnMainMenu.setOutlineThickness(3);

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

        if (currentMenuItemHovered == 0) {
        		//Highlights DefaultCat
        	DefaultCat.setColor(new Color(255, 215, 0));
        	BlackCat.setColor(new Color(49, 207, 240));
            CoolCat.setColor(new Color(49, 207, 240));
            IceCat.setColor(new Color(49, 207, 240));
            GhostCat.setColor(new Color(49, 207, 240));
            WizardCat.setColor(new Color(49, 207, 240));
            TopHatCat.setColor(new Color(49, 207, 240));
            characterMenuPreview = 0;
            pointerLocationX = 10;
            pointerLocationY = 133;

        } else if (currentMenuItemHovered == 1) {
        		//Highlights BlackCat
        	DefaultCat.setColor(new Color(49, 207, 240));
        	BlackCat.setColor(new Color(255, 215, 0));
            CoolCat.setColor(new Color(49, 207, 240));
            IceCat.setColor(new Color(49, 207, 240));
            GhostCat.setColor(new Color(49, 207, 240));
            WizardCat.setColor(new Color(49, 207, 240));
            TopHatCat.setColor(new Color(49, 207, 240));
            characterMenuPreview = 1;
            pointerLocationX = 10;
            pointerLocationY = 163;

        } else if (currentMenuItemHovered == 2) {
        		//Highlights CoolCat
        	DefaultCat.setColor(new Color(49, 207, 240));
        	BlackCat.setColor(new Color(49, 207, 240));
        	CoolCat.setColor(new Color(255, 215, 0));
            IceCat.setColor(new Color(49, 207, 240));
            GhostCat.setColor(new Color(49, 207, 240));
            WizardCat.setColor(new Color(49, 207, 240));
            TopHatCat.setColor(new Color(49, 207, 240));
            characterMenuPreview = 2;
            pointerLocationX = 10;
            pointerLocationY = 193;

        } else if (currentMenuItemHovered == 3) {
        		//Highlights IceCat
        	DefaultCat.setColor(new Color(49, 207, 240));
        	BlackCat.setColor(new Color(49, 207, 240));
        	CoolCat.setColor(new Color(49, 207, 240));
            IceCat.setColor(new Color(255, 215, 0));
            GhostCat.setColor(new Color(49, 207, 240));
            WizardCat.setColor(new Color(49, 207, 240));
            TopHatCat.setColor(new Color(49, 207, 240));
            characterMenuPreview = 3;
            pointerLocationX = 10;
            pointerLocationY = 223;

        } else if (currentMenuItemHovered == 4) {
        		//Highlights GhostCat
        	DefaultCat.setColor(new Color(49, 207, 240));
        	BlackCat.setColor(new Color(49, 207, 240));
            CoolCat.setColor(new Color(49, 207, 240));
            IceCat.setColor(new Color(49, 207, 240));
            GhostCat.setColor(new Color(255, 215, 0));
            WizardCat.setColor(new Color(49, 207, 240));
            TopHatCat.setColor(new Color(49, 207, 240));
            characterMenuPreview = 4;
            pointerLocationX = 10;
            pointerLocationY = 253;

        } else if (currentMenuItemHovered == 5) {
        		//Highlights WizardCat
        	DefaultCat.setColor(new Color(49, 207, 240));
            BlackCat.setColor(new Color(49, 207, 240));
            CoolCat.setColor(new Color(49, 207, 240));
            IceCat.setColor(new Color(49, 207, 240));
            GhostCat.setColor(new Color(49, 207, 240));
            WizardCat.setColor(new Color(255, 215, 0));
            TopHatCat.setColor(new Color(49, 207, 240));
            characterMenuPreview = 5;
            pointerLocationX = 10;
            pointerLocationY = 283;

        } else if (currentMenuItemHovered == 6) {
    		//Highlights TopHatCat
        DefaultCat.setColor(new Color(49, 207, 240));
        BlackCat.setColor(new Color(49, 207, 240));
        CoolCat.setColor(new Color(49, 207, 240));
        IceCat.setColor(new Color(49, 207, 240));
        GhostCat.setColor(new Color(49, 207, 240));
        WizardCat.setColor(new Color(49, 207, 240));
        TopHatCat.setColor(new Color(255, 215, 0));
        characterMenuPreview = 6;
        pointerLocationX = 10;
        pointerLocationY = 313;
        }

        if (Keyboard.isKeyUp(Key.currentINTERACT)) {
            keyLocker.unlockKey(Key.currentINTERACT);
        }

     // applied selected preset and returns to main menu
        if (!keyLocker.isKeyLocked(Key.currentINTERACT) && Keyboard.isKeyDown(Key.currentINTERACT)) {
            audio.startPlayingOnce(7);
        	try {
        		FileWriter fileWriter = new FileWriter("SavedData/CharacterPreferences.txt");
        		if(currentMenuItemHovered == 0) {
        			//set character to DefaultCat
        			fileWriter.write("0");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        		} else if (currentMenuItemHovered == 1) {
        			if (this.activeBalance >= 5) {
        				//set character to BlackCat
        			this.activeBalance -= 5;
        			System.out.println(activeBalance);
        			fileWriter.write("1");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        			} else {
        				System.out.println("Not enough funds");
        			}
        		} else if (currentMenuItemHovered == 2) {
        			if (this.activeBalance >= 10) {
        				//set character to CoolCat
        			this.activeBalance -= 5;
        			fileWriter.write("2");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        			} else {
        				System.out.println("Not enough funds");
        			}

        		} else if (currentMenuItemHovered == 3) {
        			if (this.activeBalance >= 15) {
        				//set character to IceCat
        			this.activeBalance -= 15;
        			fileWriter.write("3");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        			} else {
        				System.out.println("Not enough funds");
        			}

        		} else if (currentMenuItemHovered == 4) {
        			if (this.activeBalance >= 20) {
        				//set character to GhostCat
        			this.activeBalance -= 20;
        			fileWriter.write("4");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        			} else {
        				System.out.println("Not enough funds");
        			}

        		} else if (currentMenuItemHovered == 5) {
        			if (this.activeBalance >= 30) {
        				//set character to WizardCat
        			this.activeBalance -= 30;
        			fileWriter.write("5");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        			} else {
        				System.out.println("Not enough funds");
        			}

        		} else if (currentMenuItemHovered == 6) {
        			if (this.activeBalance >= 50) {
        				//set character to CoolCat
        			this.activeBalance -= 50;
        			fileWriter.write("6");
        			fileWriter.close();
                    Keyboard.keyMap = Keyboard.buildKeyMap();
        			screenCoordinator.setGameState(GameState.MENU);
        			} else {
        				System.out.println("Not enough funds");
        			}
        		}
        	} catch (IOException e) {
        		System.out.println("Error");
        	}
        }
    }

    	//displays screen elements
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        title.draw(graphicsHandler);
        DefaultCat.draw(graphicsHandler);
        BlackCat.draw(graphicsHandler);
        CoolCat.draw(graphicsHandler);
        IceCat.draw(graphicsHandler);
        GhostCat.draw(graphicsHandler);
        WizardCat.draw(graphicsHandler);
        TopHatCat.draw(graphicsHandler);
        Balance.draw(graphicsHandler);
        BalanceValue.draw(graphicsHandler);
        Cost.draw(graphicsHandler);
        returnMainMenu.draw(graphicsHandler);

        if (characterMenuPreview == 0) {
        	graphicsHandler.drawImage(ImageLoader.load("DefaultCatProfile.PNG"), 424, 196, 300, 300);
        	DefaultCatDesc1.draw(graphicsHandler);
        	DefaultCatDesc2.draw(graphicsHandler);
        	DefaultCatDesc3.draw(graphicsHandler);
        	DefaultCatDesc4.draw(graphicsHandler);
        	DefaultCatDesc5.draw(graphicsHandler);
        	DefaultCatCostValue.draw(graphicsHandler);
        } else if (characterMenuPreview == 1) {
        	graphicsHandler.drawImage(ImageLoader.load("BlackCatProfile.PNG"), 424, 196, 314, 300);
        	BlackCatDesc1.draw(graphicsHandler);
        	BlackCatDesc2.draw(graphicsHandler);
        	BlackCatDesc3.draw(graphicsHandler);
        	BlackCatDesc4.draw(graphicsHandler);
        	BlackCatDesc5.draw(graphicsHandler);
        	BlackCatDesc6.draw(graphicsHandler);
        	BlackCatCostValue.draw(graphicsHandler);
    	} else if (characterMenuPreview == 2) {
        	graphicsHandler.drawImage(ImageLoader.load("CoolCatProfile.PNG"), 424, 196, 300, 300);
        	CoolCatDesc1.draw(graphicsHandler);
        	CoolCatDesc2.draw(graphicsHandler);
        	CoolCatDesc3.draw(graphicsHandler);
        	CoolCatDesc4.draw(graphicsHandler);
        	CoolCatDesc5.draw(graphicsHandler);
        	CoolCatDesc6.draw(graphicsHandler);
        	CoolCatDesc7.draw(graphicsHandler);
        	CoolCatDesc8.draw(graphicsHandler);
        	CoolCatCostValue.draw(graphicsHandler);
    	} else if (characterMenuPreview == 3) {
        	graphicsHandler.drawImage(ImageLoader.load("IceCatProfile.PNG"), 424, 196, 300, 287);
        	IceCatDesc1.draw(graphicsHandler);
        	IceCatDesc2.draw(graphicsHandler);
        	IceCatDesc3.draw(graphicsHandler);
        	IceCatDesc4.draw(graphicsHandler);
        	IceCatDesc5.draw(graphicsHandler);
        	IceCatDesc6.draw(graphicsHandler);
        	IceCatCostValue.draw(graphicsHandler);
    	} else if (characterMenuPreview == 4) {
        	graphicsHandler.drawImage(ImageLoader.load("GhostCatProfile.PNG"), 424, 196, 300, 287);
        	GhostCatDesc1.draw(graphicsHandler);
        	GhostCatDesc2.draw(graphicsHandler);
        	GhostCatDesc3.draw(graphicsHandler);
        	GhostCatDesc4.draw(graphicsHandler);
        	GhostCatDesc5.draw(graphicsHandler);
        	GhostCatDesc6.draw(graphicsHandler);
        	GhostCatDesc7.draw(graphicsHandler);
        	GhostCatDesc8.draw(graphicsHandler);
        	GhostCatDesc9.draw(graphicsHandler);
        	GhostCatCostValue.draw(graphicsHandler);
    	} else if (characterMenuPreview == 5) {
        	graphicsHandler.drawImage(ImageLoader.load("WizardCatProfile.PNG"), 424, 182, 300, 289);
        	WizardCatDesc1.draw(graphicsHandler);
        	WizardCatDesc2.draw(graphicsHandler);
        	WizardCatDesc3.draw(graphicsHandler);
        	WizardCatDesc4.draw(graphicsHandler);
        	WizardCatDesc5.draw(graphicsHandler);
        	WizardCatDesc6.draw(graphicsHandler);
        	WizardCatDesc7.draw(graphicsHandler);
        	WizardCatCostValue.draw(graphicsHandler);
    	} else if (characterMenuPreview == 6) {
        	graphicsHandler.drawImage(ImageLoader.load("TopHatCatProfile.PNG"), 424, 195, 300, 289);
        	TopHatCatDesc1.draw(graphicsHandler);
        	TopHatCatDesc2.draw(graphicsHandler);
        	TopHatCatDesc3.draw(graphicsHandler);
        	TopHatCatDesc4.draw(graphicsHandler);
        	TopHatCatDesc5.draw(graphicsHandler);
        	TopHatCatDesc6.draw(graphicsHandler);
        	TopHatCatDesc7.draw(graphicsHandler);
        	TopHatCatDesc8.draw(graphicsHandler);
        	TopHatCatDesc9.draw(graphicsHandler);
        	TopHatCatDesc10.draw(graphicsHandler);
        	TopHatCatDesc11.draw(graphicsHandler);
        	TopHatCatDesc12.draw(graphicsHandler);
        	TopHatCatCostValue.draw(graphicsHandler);
    	}
        //NOTE: X and Y coordinates for a 300 x 300 .PNG character image is (425, 196)
        //The 4 numerical values differ from one another due to slight differences in the size and dimensions of the .PNG files
        //The slight deviation is used to compensate for this.
    
		 	//blue cursor for scrolling through options
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }

}