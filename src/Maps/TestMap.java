package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Enemies.HedgehogEnemy;
import Enemies.MushroomEnemy;
import Enemies.StillDinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.*;
import EnhancedMapTiles.CuriosityOrb;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.CommonTileset;
import Utils.Direction;
import Utils.Point;
import java.util.ArrayList;

//Comment
// Represents a test map to be used in a level
public class TestMap extends Map {

    private ArrayList<Enemy> enemies;

    public TestMap() {
        super("test_map.txt", new CommonTileset(), new Point(1, 11));
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new MushroomEnemy(getPositionByTileIndex(15, 9), Direction.LEFT));
        enemies.add(new HedgehogEnemy(getPositionByTileIndex(19,10), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(14, 4).addY(2), getPositionByTileIndex(15, 4).addY(2), Direction.RIGHT));

        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(24, 6),
                getPositionByTileIndex(27, 6),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,4),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(32, 7)
        ));
        
        enhancedMapTiles.add(new CuriosityOrb(
                getPositionByTileIndex(21, 5)
        ));

        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(14, 5), enhancedMapTiles, enemies, 2));

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(6,6));
        coinLocations.add(getPositionByTileIndex(19,5));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(30, 10).subtract(new Point(0, 13)), this));

        return npcs;
    }
}
