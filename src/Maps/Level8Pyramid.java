package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;
import java.util.ArrayList;

//Comment
// Represents a test map to be used in a level
public class Level8Pyramid extends Map {
	private int x, y;

    public Level8Pyramid() {
        super("Level8-Pyramid.txt", new CommonTileset(), new Point(2, 47));
        int randomEndValue = (int)(Math.random()*2);
        if (randomEndValue == 0) {
        	x = 147;
        	y = 7;
        } else if (randomEndValue == 1) {
        	x = 147;
        	y = 26;
        } else if (randomEndValue == 2) {
        	x = 148;
        	y = 46;
        }

    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(75, 3), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(137, 31), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(98, 10), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(138, 31), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(106, 10), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(99, 3), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(141, 31), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(140, 31), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(116, 10), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(117, 10), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(141, 45), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(120, 47), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(133, 10), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(105, 41), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(137, 10), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(107, 41), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(137, 19), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(66, 32), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(110, 41), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(54, 41), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(62, 34), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(57, 41), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(42, 48), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(37, 48), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(50, 48), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(100, 27), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(111, 27), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(105, 27), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(93, 27), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(87, 27), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(59, 25), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(65, 20), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(120, 2).addY(2), getPositionByTileIndex(123, 2).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(130, 19).addY(2), getPositionByTileIndex(139, 19).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(130, 27).addY(2), getPositionByTileIndex(134, 27).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(128, 47).addY(2), getPositionByTileIndex(136, 47).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(132, 47).addY(2), getPositionByTileIndex(140, 47).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(143, 47).addY(2), getPositionByTileIndex(147, 47).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(122, 27).addY(2), getPositionByTileIndex(127, 27).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(115, 38).addY(2), getPositionByTileIndex(120, 38).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(91, 38).addY(2), getPositionByTileIndex(96, 38).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(80, 38).addY(2), getPositionByTileIndex(87, 38).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(84, 38).addY(2), getPositionByTileIndex(89, 38).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(70, 38).addY(2), getPositionByTileIndex(79, 38).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(50, 33).addY(2), getPositionByTileIndex(53, 33).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(91, 48).addY(2), getPositionByTileIndex(100, 48).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(101, 20).addY(2), getPositionByTileIndex(104, 20).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(73, 20).addY(2), getPositionByTileIndex(79, 20).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(78, 20).addY(2), getPositionByTileIndex(84, 20).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(53, 48),
                getPositionByTileIndex(62, 48),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(63, 48),
                getPositionByTileIndex(67, 48),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(68, 48),
                getPositionByTileIndex(75, 48),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(76, 48),
                getPositionByTileIndex(84, 48),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(85, 48),
                getPositionByTileIndex(90, 48),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(57, 48),
                getPositionByTileIndex(65, 48),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(x, y)
        ));

        return enhancedMapTiles;
    }

}