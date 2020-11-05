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
public class Level13Cliffs extends Map {

    public Level13Cliffs() {
        super("Level13-Cliffs.txt", new CommonTileset(), new Point(5, 9));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(19, 41), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(23, 41), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(26, 41), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(37, 42), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(52, 61), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(62, 58), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(70, 57), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(85, 63), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(102, 63), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(107, 57), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(111, 50), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(12, 17).addY(2), getPositionByTileIndex(17, 17).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(15, 17).addY(2), getPositionByTileIndex(19, 17).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(34, 41).addY(2), getPositionByTileIndex(37, 41).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(38, 42).addY(2), getPositionByTileIndex(44, 42).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(40, 42).addY(2), getPositionByTileIndex(47, 42).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(42, 67).addY(2), getPositionByTileIndex(47, 67).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(52, 61).addY(2), getPositionByTileIndex(55, 61).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(63, 58).addY(2), getPositionByTileIndex(68, 58).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(73, 52).addY(2), getPositionByTileIndex(78, 52).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(80, 49).addY(2), getPositionByTileIndex(86, 49).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(85, 49).addY(2), getPositionByTileIndex(90, 49).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(84, 49).addY(2), getPositionByTileIndex(93, 49).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(93, 64).addY(2), getPositionByTileIndex(101, 64).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(89, 64).addY(2), getPositionByTileIndex(94, 64).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(92, 64).addY(2), getPositionByTileIndex(97, 64).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(14, 27),
                getPositionByTileIndex(24, 27),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(29, 41),
                getPositionByTileIndex(33, 41),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(117, 48)
        ));

        return enhancedMapTiles;
    }

}