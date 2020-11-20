package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.SnakeEnemy;
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
public class Level10Mirage extends Map {
    private ArrayList<Enemy> enemies;
    public Level10Mirage() {
        super("Level10-Mirage.txt", new CommonTileset(), new Point(3, 21));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(50, 23), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(66, 23), Direction.LEFT));

        enemies.add(new SnakeEnemy(getPositionByTileIndex(1, 21), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(13, 21), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(33, 21).addY(2), getPositionByTileIndex(40, 21).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(42, 20).addY(2), getPositionByTileIndex(47, 20).addY(2), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(46, 20).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(44, 3), getPositionByTileIndex(47, 3).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(47, 2), getPositionByTileIndex(54, 2).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(53, 2), getPositionByTileIndex(59, 2).addY(2), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(56, 20).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(63, 19).addY(2), getPositionByTileIndex(68, 19).addY(2), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(70, 19).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(35, 18).addY(2), getPositionByTileIndex(36, 18).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(79, 16).addY(2), getPositionByTileIndex(80, 16).addY(2), Direction.RIGHT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(43, 16),
                getPositionByTileIndex(50, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.LEFT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(38, 10),
                getPositionByTileIndex(46, 10),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(34, 8),
                getPositionByTileIndex(39, 8),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.LEFT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(36, 5),
                getPositionByTileIndex(41, 5),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(97, 18)
        ));

        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(35, 19), enhancedMapTiles, enemies, 13));
        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(79, 17), enhancedMapTiles, enemies, 14));

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(51,22));
        coinLocations.add(getPositionByTileIndex(54,23));
        coinLocations.add(getPositionByTileIndex(64,23));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(95, 20).subtract(new Point(0, 13)), this));

        return npcs;
    }
}