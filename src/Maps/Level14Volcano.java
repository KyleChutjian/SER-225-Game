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
public class Level14Volcano extends Map {

    public Level14Volcano() {
        super("Level14-Volcano.txt", new CommonTileset(), new Point(25, 137));
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(41, 135), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(30, 95), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(19, 94), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(28, 58), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(38, 57), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(21, 26), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(30, 26), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(26, 26), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(24, 23), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(27, 23), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(20, 23), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(22, 29), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(28, 29), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(16, 122).addY(2), getPositionByTileIndex(20, 122).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(19, 122).addY(2), getPositionByTileIndex(23, 122).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(28, 109).addY(2), getPositionByTileIndex(32, 109).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(33, 109).addY(2), getPositionByTileIndex(36, 109).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(27, 71).addY(2), getPositionByTileIndex(31, 71).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(28, 66).addY(2), getPositionByTileIndex(32, 66).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(19, 66).addY(2), getPositionByTileIndex(23, 66).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(30, 58).addY(2), getPositionByTileIndex(34, 58).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(32, 58).addY(2), getPositionByTileIndex(38, 58).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(35, 52).addY(2), getPositionByTileIndex(41, 52).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(28, 46).addY(2), getPositionByTileIndex(33, 46).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(18, 46).addY(2), getPositionByTileIndex(23, 46).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(28, 19).addY(2), getPositionByTileIndex(32, 19).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(19, 19).addY(2), getPositionByTileIndex(23, 19).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(16, 118),
                getPositionByTileIndex(24, 118),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(25, 105),
                getPositionByTileIndex(33, 105),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(22, 95),
                getPositionByTileIndex(27, 95),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(20, 92),
                getPositionByTileIndex(23, 92),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(27, 92),
                getPositionByTileIndex(30, 92),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(20, 89),
                getPositionByTileIndex(28, 89),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(19, 86),
                getPositionByTileIndex(26, 86),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(27, 86),
                getPositionByTileIndex(31, 86),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(23, 83),
                getPositionByTileIndex(27, 83),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(23, 64),
                getPositionByTileIndex(27, 64),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(17, 42),
                getPositionByTileIndex(22, 42),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(21, 40),
                getPositionByTileIndex(26, 40),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(47, 1)
        ));

        return enhancedMapTiles;
    }

}