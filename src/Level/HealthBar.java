package Level;

import java.util.HashMap;
import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.AnimatedSprite;
import GameObject.Frame;
import GameObject.SpriteSheet;

public class HealthBar extends AnimatedSprite {

	public HealthBar(float x, float y) {
		super(new SpriteSheet(ImageLoader.load("HealthLevel.png"), 111, 13), x, y, "FULL_HEALTH");

	}

	@Override
	public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("FULL_HEALTH",
						new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0), 0).withScale(2).build() });
				put("8Hearts", new Frame[] { new FrameBuilder(spriteSheet.getSprite(1, 0), 0).withScale(2).build() });
				put("7Hearts", new Frame[] { new FrameBuilder(spriteSheet.getSprite(2, 0), 0).withScale(2).build() });
				put("6Hearts", new Frame[] { new FrameBuilder(spriteSheet.getSprite(3, 0), 0).withScale(2).build() });
				put("5Hearts", new Frame[] { new FrameBuilder(spriteSheet.getSprite(4, 0), 0).withScale(2).build() });
				put("4Hearts", new Frame[] { new FrameBuilder(spriteSheet.getSprite(5, 0), 0).withScale(2).build() });
				put("3Hearts", new Frame[] { new FrameBuilder(spriteSheet.getSprite(6, 0), 0).withScale(2).build() });
				put("2Heart", new Frame[] { new FrameBuilder(spriteSheet.getSprite(7, 0), 0).withScale(2).build() });
				put("1Heart", new Frame[] { new FrameBuilder(spriteSheet.getSprite(8, 0), 0).withScale(2).build() });
				put("Dead", new Frame[] { new FrameBuilder(spriteSheet.getSprite(9, 0), 0).withScale(2).build() });

			}
		};
	}

	public void setAnimation(String animationName) {
		currentAnimationName = animationName;
	}

	public void update() {
		super.update();
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
	}

}