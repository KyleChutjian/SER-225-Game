package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
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
public class Level12Mountains extends Map {
    private ArrayList<Enemy> enemies;

    public Level12Mountains() {
        super("Level12-Mountains.txt", new CommonTileset(), new Point(2, 45));
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(19, 34), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(22, 26), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(31, 29), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(33, 48), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(39, 48), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(43, 48), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(47, 47), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(49, 46), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(47, 33), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(50, 28), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(84, 9), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(91, 9), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(64, 35), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(64, 48), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(72, 48), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(76, 48), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(83, 48), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(96, 40), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(119, 24), Direction.RIGHT));

        enemies.add(new DinosaurEnemy(getPositionByTileIndex(13, 39).addY(2), getPositionByTileIndex(18, 39).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(22, 26).addY(2), getPositionByTileIndex(27, 26).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(32, 40).addY(2), getPositionByTileIndex(40, 40).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(37, 40).addY(2), getPositionByTileIndex(43, 40).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(45, 41).addY(2), getPositionByTileIndex(48, 41).addY(2), Direction.RIGHT));
        enemies.add(new VultureEnemy(getPositionByTileIndex(61, 4).addY(2), getPositionByTileIndex(68, 4).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(71, 14).addY(2), getPositionByTileIndex(77, 14).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(85, 9).addY(2), getPositionByTileIndex(90, 9).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(93, 21).addY(2), getPositionByTileIndex(96, 21).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(86, 26).addY(2), getPositionByTileIndex(91, 26).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(68, 26).addY(2), getPositionByTileIndex(71, 26).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(66, 48).addY(2), getPositionByTileIndex(71, 48).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(72, 48).addY(2), getPositionByTileIndex(82, 48).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(86, 47).addY(2), getPositionByTileIndex(92, 47).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(112, 39).addY(2), getPositionByTileIndex(115, 39).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(121, 38).addY(2), getPositionByTileIndex(127, 38).addY(2), Direction.RIGHT));
        enemies.add(new VultureEnemy(getPositionByTileIndex(104, 19).addY(2), getPositionByTileIndex(115, 19).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(24, 23).addY(2), getPositionByTileIndex(25, 23).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(102, 37).addY(2), getPositionByTileIndex(103, 37).addY(2), Direction.RIGHT));

        return enemies;
    }
    
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(45, 44),
                getPositionByTileIndex(50, 44),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(46, 39),
                getPositionByTileIndex(52, 39),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(78, 27),
                getPositionByTileIndex(83, 27),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(72, 26),
                getPositionByTileIndex(76, 26),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(100, 37),
                getPositionByTileIndex(110, 37),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(121, 36),
                getPositionByTileIndex(126, 36),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(122, 33),
                getPositionByTileIndex(127, 33),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(146, 33)
        ));

        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(24, 24), enhancedMapTiles, enemies, 37));
        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(102, 38), enhancedMapTiles, enemies, 38));

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(38,47));
        coinLocations.add(getPositionByTileIndex(65,47));
        coinLocations.add(getPositionByTileIndex(88,25));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }

}