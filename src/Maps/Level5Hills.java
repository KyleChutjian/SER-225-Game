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
public class Level5Hills extends Map {

    public Level5Hills() {
        super("Level5-Hills.txt", new CommonTileset(), new Point(6, 25));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(10, 24), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(21, 21), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(23, 21), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(46, 22), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(50, 18), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(53, 26), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(58, 26), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(56, 19), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(67, 27), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(78, 15), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(89, 19), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(100, 19), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(119, 25), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(124, 25), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(132, 19), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(78, 15).addY(2), getPositionByTileIndex(84, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(113, 13).addY(2), getPositionByTileIndex(118, 13).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(128, 14).addY(2), getPositionByTileIndex(133, 14).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(41, 25).addY(2), getPositionByTileIndex(42, 25).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(36, 26),
                getPositionByTileIndex(40, 26),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(64, 19),
                getPositionByTileIndex(69, 19),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(146, 19)
        ));

        return enhancedMapTiles;
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(145, 21).subtract(new Point(0, 13)), this));

        return npcs;
    }
}