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
public class Level15Descent extends Map {

    public Level15Descent() {
        super("Level15-Descent.txt", new CommonTileset(), new Point(3, 3));
    }

//    @Override
//    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
//        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
//
//        enhancedMapTiles.add(new EndLevelBox(
//                getPositionByTileIndex(47, 1)
//        ));
//
//        return enhancedMapTiles;
//    }

}