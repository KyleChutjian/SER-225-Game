package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.SnakeEnemy;
import Enemies.StillDinosaurEnemy;
import Enemies.VultureEnemy;
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
public class Level7Dunes extends Map {
    private ArrayList<Enemy> enemies;
    public Level7Dunes() {
        super("Level7-Dunes.txt", new CommonTileset(), new Point(4, 26));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new SnakeEnemy(getPositionByTileIndex(33, 26), Direction.LEFT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(37, 26), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(44, 26), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(47, 26), Direction.LEFT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(49, 26), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(71, 26), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(120, 26), Direction.RIGHT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(13, 23).addY(2), getPositionByTileIndex(19, 23).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(21, 27).addY(2), getPositionByTileIndex(25, 27).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(61, 26).addY(2), getPositionByTileIndex(67, 26).addY(2), Direction.RIGHT));
        enemies.add(new VultureEnemy(getPositionByTileIndex(37, 13).addY(2), getPositionByTileIndex(42, 13).addY(2), Direction.RIGHT));
        enemies.add(new VultureEnemy(getPositionByTileIndex(44, 13).addY(2), getPositionByTileIndex(49, 13).addY(2), Direction.RIGHT));
        int set1 = (int)(Math.random()*1);
        if (set1 == 0) {
        	enemies.add(new VultureEnemy(getPositionByTileIndex(64, 7).addY(2), getPositionByTileIndex(71, 7).addY(2), Direction.RIGHT));
        } else if (set1 == 1) {
        	enemies.add(new VultureEnemy(getPositionByTileIndex(60, 7).addY(2), getPositionByTileIndex(67, 7).addY(2), Direction.RIGHT));
        }
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(94, 15).addY(2), getPositionByTileIndex(99, 15).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(98, 15).addY(2), getPositionByTileIndex(103, 15).addY(2), Direction.RIGHT));
        int set2 = (int)(Math.random()*1);
        if (set2 == 0) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(110, 22).addY(2), getPositionByTileIndex(116, 22).addY(2), Direction.RIGHT));
        } else if (set2 == 1) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(121, 17).addY(2), getPositionByTileIndex(124, 17).addY(2), Direction.RIGHT));
        }
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(46, 18).addY(2), getPositionByTileIndex(47, 18).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(132, 23).addY(2), getPositionByTileIndex(133, 23).addY(2), Direction.RIGHT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(62, 22),
                getPositionByTileIndex(72, 22),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(125, 24),
                getPositionByTileIndex(128, 24),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(147, 17)
        ));

        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(46, 19), enhancedMapTiles, enemies, 17));
        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(132, 24), enhancedMapTiles, enemies, 18));

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(57,17));
        coinLocations.add(getPositionByTileIndex(62,11));
        coinLocations.add(getPositionByTileIndex(139,13));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }
        return enhancedMapTiles;
    }
}