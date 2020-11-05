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
public class Level11Rocks extends Map {

    public Level11Rocks() {
        super("Level11-Rocks.txt", new CommonTileset(), new Point(3, 26));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(34, 23), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(25, 24), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(50, 21), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(67, 23), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(36, 23), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(81, 22), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(80, 23), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(93, 19), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(100, 10), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(108, 24), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(114, 24), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(116, 22), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(110, 24), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(120, 22), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(134, 22), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(138, 14), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(42, 24).addY(2), getPositionByTileIndex(48, 24).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(50, 21).addY(2), getPositionByTileIndex(52, 21).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(53, 23).addY(2), getPositionByTileIndex(61, 23).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(56, 23).addY(2), getPositionByTileIndex(63, 23).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(73, 18).addY(2), getPositionByTileIndex(76, 18).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(87, 21).addY(2), getPositionByTileIndex(93, 21).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(100, 10).addY(2), getPositionByTileIndex(105, 10).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(125, 15).addY(2), getPositionByTileIndex(132, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(127, 15).addY(2), getPositionByTileIndex(132, 15).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(96, 17),
                getPositionByTileIndex(99, 17),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(92, 15),
                getPositionByTileIndex(95, 15),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(116, 17),
                getPositionByTileIndex(121, 17),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(146, 20)
        ));

        return enhancedMapTiles;
    }
}