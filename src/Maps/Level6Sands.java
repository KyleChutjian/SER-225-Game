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
public class Level6Sands extends Map {
    private ArrayList<Enemy> enemies;
    public Level6Sands() {
        super("Level6-Sands.txt", new CommonTileset(), new Point(2, 15));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        enemies = new ArrayList<>();
        enemies.add(new SnakeEnemy(getPositionByTileIndex(23, 15).addY(2), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(38, 13).addY(2), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(46, 14).addY(2), Direction.RIGHT));
        enemies.add(new VultureEnemy(getPositionByTileIndex(57, 10), getPositionByTileIndex(68, 10).addY(2), Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(63, 17).addY(2),  Direction.RIGHT));
        enemies.add(new SnakeEnemy(getPositionByTileIndex(77, 14).addY(2),  Direction.RIGHT));

        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(41, 10).addY(2), getPositionByTileIndex(42, 10).addY(2), Direction.RIGHT));
        enemies.add(new StillDinosaurEnemy(getPositionByTileIndex(65, 14).addY(2), getPositionByTileIndex(66, 14).addY(2), Direction.RIGHT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(97, 14)
        ));

        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(41, 11), enhancedMapTiles, enemies, 6));
        enhancedMapTiles.add(new ItemBlock(getPositionByTileIndex(65, 15), enhancedMapTiles, enemies, 7));

        ArrayList<Point> coinLocations = new ArrayList<Point>();

        coinLocations.add(getPositionByTileIndex(55,15));
        coinLocations.add(getPositionByTileIndex(85,12));
        coinLocations.add(getPositionByTileIndex(19,9));


        for (int i = 0; i < coinLocations.size(); i++) {
            Coin coin = new Coin(coinLocations.get(i));
            enhancedMapTiles.add(coin);
        }

        return enhancedMapTiles;
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(96, 16).subtract(new Point(0, 13)), this));

        return npcs;
    }
}