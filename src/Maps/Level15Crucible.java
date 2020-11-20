package Maps;

import Enemies.LavaFireball;
import Engine.ImageLoader;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;
import java.util.ArrayList;

//Comment
// Represents a test map to be used in a level
public class Level15Crucible extends Map {
	 private ArrayList<Enemy> enemies;
    public Level15Crucible() {
        super("Level15-Crucible.txt", new CommonTileset(), new Point(3, 15));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new LavaFireball(getPositionByTileIndex(10, 17), -.5f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(18, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(25, 17), -.5f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(31, 17), -.5f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(36, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(40, 17), -.5f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(44, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(49, 17), -.5f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(55, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(62, 17), -.5f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(70, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(77, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(83, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(88, 17), -.75f, 300));
        enemies.add(new LavaFireball(getPositionByTileIndex(92, 17), -.75f, 300));
      
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(7, 16),
                getPositionByTileIndex(15, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(16, 16),
                getPositionByTileIndex(21, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(22, 16),
                getPositionByTileIndex(26, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(28, 16),
                getPositionByTileIndex(33, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(34, 16),
                getPositionByTileIndex(42, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(42, 16),
                getPositionByTileIndex(50, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(52, 16),
                getPositionByTileIndex(58, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(61, 16),
                getPositionByTileIndex(70, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(76, 16),
                getPositionByTileIndex(81, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(83, 16),
                getPositionByTileIndex(89, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(90, 16),
                getPositionByTileIndex(93, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(42, 16),
                getPositionByTileIndex(45, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(59, 16),
                getPositionByTileIndex(62, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(80, 16),
                getPositionByTileIndex(82, 16),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(97, 14)
        ));
        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(74,15));
        coinLocations.add(getPositionByTileIndex(26,14));
        coinLocations.add(getPositionByTileIndex(94,14));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }
        return enhancedMapTiles;
    }

}