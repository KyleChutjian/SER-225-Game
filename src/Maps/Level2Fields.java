package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.Coin;
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
public class Level2Fields extends Map {

    public Level2Fields() {
        super("Level2-Fields.txt", new CommonTileset(), new Point(3, 16));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(16, 15), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(27, 16), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(43, 16), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(37, 16), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(55, 16), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(65, 17), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(75, 16), Direction.LEFT));
        
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(92, 8).addY(2), getPositionByTileIndex(95, 8).addY(2), Direction.RIGHT));
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

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(10,16));
        coinLocations.add(getPositionByTileIndex(19,5));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }
}
