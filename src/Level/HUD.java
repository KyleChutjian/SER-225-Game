package Level;

import Engine.GraphicsHandler;
import SpriteFont.SpriteFont;

public class HUD {

	protected Player player;
	protected SpriteFont healthLabel;
	private HealthBar healthBar;

	public HUD(Player player) {
		this.player = player;
		healthBar = new HealthBar(300, 20);
	}

	public void draw(GraphicsHandler graphicsHandler) {
		healthBar.draw(graphicsHandler);
	}

	public void update() {
		if (player.getCurrentHealth() == 9) {
			healthBar.setAnimation("FULL_HEALTH");
			healthBar.update();
		} else if (player.getCurrentHealth() == 8) {
			healthBar.setAnimation("8Hearts");
			healthBar.update();
		} else if (player.getCurrentHealth() == 7) {
			healthBar.setAnimation("7Hearts");
			healthBar.update();
		} else if (player.getCurrentHealth() == 6) {
			healthBar.setAnimation("6Hearts");
			healthBar.update();
		} else if (player.getCurrentHealth() == 5) {
			healthBar.setAnimation("5Hearts");
			healthBar.update();
		} else if (player.getCurrentHealth() == 4) {
			healthBar.setAnimation("4Hearts");
			healthBar.update();
		} else if (player.getCurrentHealth() == 3) {
			healthBar.setAnimation("3Hearts");
			healthBar.update();
		} else if (player.getCurrentHealth() == 2) {
			healthBar.setAnimation("2Heart");
			healthBar.update();
		} else if (player.getCurrentHealth() == 1) {
			healthBar.setAnimation("1Heart");
			healthBar.update();
		} else {
			healthBar.setAnimation("Dead");
			healthBar.update();
		}
	}
}
