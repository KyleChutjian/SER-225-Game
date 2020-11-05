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
public class Level9Oasis extends Map {

    public Level9Oasis() {
        super("Level9-Oasis.txt", new CommonTileset(), new Point(1, 11));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(3, 21), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(6, 21), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(12, 21), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(16, 19), Direction.LEFT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(39, 15).addY(2), getPositionByTileIndex(42, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(51, 15).addY(2), getPositionByTileIndex(56, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(65, 16).addY(2), getPositionByTileIndex(70, 16).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(75, 13).addY(2), getPositionByTileIndex(80, 13).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(83, 21).addY(2), getPositionByTileIndex(89, 21).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(79, 21).addY(2), getPositionByTileIndex(86, 21).addY(2), Direction.RIGHT));
        int set1 = (int)(Math.random()*2);
        if (set1 == 0) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(76, 13).addY(2), getPositionByTileIndex(79, 13).addY(2), Direction.RIGHT));
        } else if (set1 == 1) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(67, 16).addY(2), getPositionByTileIndex(70, 16).addY(2), Direction.RIGHT));
        } else if (set1 == 2) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(52, 15).addY(2), getPositionByTileIndex(55, 15).addY(2), Direction.RIGHT));
        }
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(44, 18),
                getPositionByTileIndex(48, 18),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(57, 20),
                getPositionByTileIndex(63, 20),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(97, 18)
        ));

        return enhancedMapTiles;
    }

}