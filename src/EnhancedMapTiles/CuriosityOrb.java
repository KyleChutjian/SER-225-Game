package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.TileType;
import Maps.Level2Fields;
import Maps.Level3Forest;
import Maps.TestMap;
import Utils.Point;
import java.util.Random;

import java.util.HashMap;

// This class is for the end level gold box tile
// when the player touches it, it will tell the player that the level has been completed
public class CuriosityOrb extends EnhancedMapTile {

	Random random = new Random();
	protected static int k;

	public CuriosityOrb(Point location) {
		super(location.x, location.y, new SpriteSheet(ImageLoader.load("CuriosityOrbSprite.png"), 16, 16), "DEFAULT",
				TileType.PASSABLE);
	}

	public static int mapSelection(int i) {
		k = i;
		return k;
	}

	@Override
	public void update(Player player) {
		super.update(player);
		if (intersects(player)) {
			int randomNumber = random.nextInt(5);
			if (k == 0) {
				if (randomNumber == 0) {
					player.setX(100);
					player.setY(450);
				} else if (randomNumber == 1) {
					player.setX(300);
					player.setY(300);
				} else if (randomNumber == 2) {
					player.setX(700);
					player.setY(350);
				} else if (randomNumber == 3) {
					player.setX(1000);
					player.setY(60);
				} else if (randomNumber == 4) {
					player.setX(1200);
					player.setY(100);
				}
			}
			if (k == 1) {
				if (randomNumber == 0) {
					player.setX(160);
					player.setY(700);
				} else if (randomNumber == 1) {
					player.setX(400);
					player.setY(100);
				} else if (randomNumber == 2) {
					System.out.println(k);
					player.setX(500);
					player.setY(500);
				} else if (randomNumber == 3) {
					player.setX(100);
					player.setY(300);
				} else if (randomNumber == 4) {
					player.setX(160);
					player.setY(700);
				}
			}
//			if (k == 2) {
//				if (randomNumber == 0) {
//					System.out.println(k);
//					player.setX(160);
//					player.setY(700);
//				} else if (randomNumber == 1) {
//					System.out.println(k);
//					player.setX(400);
//					player.setY(100);
//				} else if (randomNumber == 2) {
//					System.out.println(k);
//					player.setX(500);
//					player.setY(500);
//				} else if (randomNumber == 3) {
//					System.out.println(k);
//					player.setX(100);
//					player.setY(300);
//				} else if (randomNumber == 4) {
//					System.out.println(k);
//					player.setX(160);
//					player.setY(700);
//				}
//			}
		}
	}

	@Override
	public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("DEFAULT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(2, 0), 200).withScale(3).withBounds(1, 1, 14, 14)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(2, 1), 200).withScale(3).withBounds(1, 1, 14, 14)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(2, 2), 200).withScale(3).withBounds(1, 1, 14, 14)
										.build(),
								new FrameBuilder(spriteSheet.getSprite(2, 3), 200).withScale(3).withBounds(1, 1, 14, 14)
										.build() });

			}
		};
	}
}
