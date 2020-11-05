package Screens;
import java.util.HashMap;
import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.AnimatedSprite;
import GameObject.Frame;
import GameObject.SpriteSheet;

public class TitleAnimation extends AnimatedSprite {

	public TitleAnimation( float x, float y) {
		super(new SpriteSheet(ImageLoader.load("GameTitle.png"), 111, 28), x, y, "AnimateCuriosity");
	}
	@Override
	public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("AnimateCuriosity",
						new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0), 500).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(1, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(2, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(3, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(4, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(6, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(7, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(8, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(9, 0), 100).withScale(5).build(),
				 new FrameBuilder(spriteSheet.getSprite(10, 0), 500).withScale(5).build() });

			}
		};
	}

	public void setAnimation(String animationName) {
		currentAnimationName = animationName;
	}
	
	public String getAnimation() {
		return currentAnimationName;
	}

	public void update() {
		super.update();
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
	}

}
