package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.StillDinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import EnhancedMapTiles.ItemBlock;
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
    private ArrayList<Enemy> enemies;
    public Level5Hills() {
        super("Level5-Hills.txt", new CommonTileset(), new Point(6, 25));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
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

        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(21, 18).addY(2), getPositionByTileIndex(22, 18).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(81, 12).addY(2), getPositionByTileIndex(82, 12).addY(2), Direction.RIGHT));

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

        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(21, 19), enhancedMapTiles, enemies, 19));
        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(81, 13), enhancedMapTiles, enemies, 20));

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(38,25));
        coinLocations.add(getPositionByTileIndex(52,25));
        coinLocations.add(getPositionByTileIndex(118,24));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(145, 21).subtract(new Point(0, 13)), this));

        return npcs;
    }
}