package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.StillDinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.Coin;
import EnhancedMapTiles.CuriosityOrb;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import EnhancedMapTiles.ItemBlock;
import GameObject.Rectangle;
import Level.*;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;
import java.util.ArrayList;

//Comment
// Represents a test map to be used in a level
public class Level2Fields extends Map {

    private ArrayList<Enemy> enemies;

    public Level2Fields() {
        super("Level2-Fields.txt", new CommonTileset(), new Point(3, 16));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(16, 15), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(27, 16), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(43, 16), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(37, 16), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(55, 16), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(65, 17), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(75, 16), Direction.LEFT));
        
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(92, 8).addY(2), getPositionByTileIndex(95, 8).addY(2), Direction.RIGHT));


        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(14, 12).addY(2), getPositionByTileIndex(15, 11).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(85, 12).addY(2), getPositionByTileIndex(86, 12).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        
        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(62, 14),
                getPositionByTileIndex(67, 14),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(96, 14)
        ));

        enhancedMapTiles.add(new CuriosityOrb(
                getPositionByTileIndex(99, 8)
        ));

        enhancedMapTiles.add(new CuriosityOrb(
                getPositionByTileIndex(0, 5)
        ));


        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(14, 13), enhancedMapTiles, enemies, 8));
        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(85, 13), enhancedMapTiles, enemies, 9));

        ArrayList<Point> coinLocations = new ArrayList<Point>();
        coinLocations.add(new Point(1500,650));
        coinLocations.add(new Point(1950, 600));
        coinLocations.add(new Point(2950, 500));

        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }

}