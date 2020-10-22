package Level;

import java.awt.Color;
import Engine.GraphicsHandler;
import GameObject.Rectangle;
import SpriteFont.SpriteFont;

public class HUD {
	
	private Rectangle healthBar;
	private Rectangle backgroundBar;
	protected Player player;
	protected SpriteFont healthLabel;

	public HUD(Player player) {
		this.player = player;
		healthBar = new Rectangle(300, 15, 200, 25);
		backgroundBar = new Rectangle(300, 15, 200, 25);
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		healthBar.setBorderColor(Color.BLACK);
		backgroundBar.setBorderColor(Color.black);
		healthBar.setBorderThickness(5);
		backgroundBar.setBorderThickness(5);
		backgroundBar.setColor(Color.gray);
		if (player.getCurrentHealth() < 150 && player.getCurrentHealth() > 50) {
			healthBar.setColor(Color.yellow);
		} else if (player.getCurrentHealth() <= 50) {
			healthBar.setColor(Color.red);
		} else {
			healthBar.setColor(Color.green);
		}
		backgroundBar.draw(graphicsHandler);
		healthBar.draw(graphicsHandler);
	}

	public void update() {
		player.getCurrentHealth();
		if (player.getCurrentHealth() <= 200 && player.getCurrentHealth() > 150) {
			healthBar.setWidth(player.getCurrentHealth());
		}
		else if (player.getCurrentHealth() <= 150 && player.getCurrentHealth() > 50) {
			healthBar.setWidth(player.getCurrentHealth());
		} else if (player.getCurrentHealth() <= 50) {
			healthBar.setWidth(player.getCurrentHealth());
		} else if (player.getCurrentHealth() <= 0) {
			healthBar.setWidth(1);
		}
	}
	
}
