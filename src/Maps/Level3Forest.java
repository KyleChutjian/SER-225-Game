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
public class Level3Forest extends Map {

    public Level3Forest() {
        super("Level3-Forest.txt", new CommonTileset(), new Point(2, 46));
    }
    
    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(32, 20), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(3, 14), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(27, 4), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(48, 5), Direction.RIGHT));
        enemies.add(new BugEnemy(getPositionByTileIndex(74, 26), Direction.LEFT));
        enemies.add(new BugEnemy(getPositionByTileIndex(77, 26), Direction.RIGHT));
        
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(6, 27).addY(2), getPositionByTileIndex(12, 27).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(10, 38).addY(2), getPositionByTileIndex(14, 38).addY(2), Direction.RIGHT));
        int set1 = (int)(Math.random()*1);
        if (set1 == 0) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(21, 39).addY(2), getPositionByTileIndex(25, 39).addY(2), Direction.RIGHT));
        } else if (set1 == 1) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(23, 29).addY(2), getPositionByTileIndex(28, 29).addY(2), Direction.RIGHT));
        }
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(32, 32).addY(2), getPositionByTileIndex(36, 32).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(13, 18).addY(2), getPositionByTileIndex(21, 18).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(8, 5).addY(2), getPositionByTileIndex(13, 5).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(14, 5).addY(2), getPositionByTileIndex(22, 5).addY(2), Direction.RIGHT));
        int set2 = (int)(Math.random()*2);
        if (set2 == 0) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(32, 3).addY(2), getPositionByTileIndex(38, 3).addY(2), Direction.RIGHT));
        } else if (set2 == 1) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(38, 3).addY(2), getPositionByTileIndex(44, 3).addY(2), Direction.RIGHT));
        } else if (set2 == 2) {
        	enemies.add(new DinosaurEnemy(getPositionByTileIndex(50, 10).addY(2), getPositionByTileIndex(55, 10).addY(2), Direction.RIGHT));
        }
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(39, 30).addY(2), getPositionByTileIndex(45, 30).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(59, 36).addY(2), getPositionByTileIndex(64, 36).addY(2), Direction.RIGHT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(68, 32).addY(2), getPositionByTileIndex(70, 32).addY(2), Direction.RIGHT));

        return enemies;
    }
    
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(97, 44)
        ));

        return enhancedMapTiles;
    }

}
