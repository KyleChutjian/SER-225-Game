package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.ShopScreenMap;
import Maps.Level2Fields;
import Maps.Level3Forest;
import Maps.Level4Lake;
import Maps.Level5Hills;
import Maps.Level6Sands;
import Maps.Level7Dunes;
import Maps.Level8Pyramid;
import Maps.Level9Oasis;
import Maps.Level10Mirage;
import Maps.Level11Rocks;
import Maps.Level12Mountains;
import Maps.Level13Cliffs;
import Maps.Level14Volcano;
import Maps.Level15Crucible;
import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("ShopScreen");
            add("Level2Fields");
            add("Level3Forest");
            add("Level4Lake");
            add("Level5Hills");
            add("Level6Sands");
            add("Level7Dunes");
            add("Level8Pyramid");
            add("Level9Oasis");
            add("Level10Mirage");
            add("Level11Rocks");
            add("Level12Mountains");
            add("Level13Cliffs");
            add("Level14Volcano");
            add("Level15Crucible");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "ShopScreen":
            	return new ShopScreenMap();
            case "Level2Fields":
            	return new Level2Fields();
            case "Level3Forest":
            	return new Level3Forest();
            case "Level4Lake":
            	return new Level4Lake();
            case "Level5Hills":
            	return new Level5Hills();
            case "Level6Sands":
            	return new Level6Sands();
            case "Level7Dunes":
            	return new Level7Dunes();
            case "Level8Pyramid":
            	return new Level8Pyramid();
            case "Level9Oasis":
            	return new Level9Oasis();
            case "Level10Mirage":
            	return new Level10Mirage();
            case "Level11Rocks":
            	return new Level11Rocks();
            case "Level12Mountains":
            	return new Level12Mountains();
            case "Level13Cliffs":
            	return new Level13Cliffs();
            case "Level14Volcano":
            	return new Level14Volcano();
            case "Level15Crucible":
            	return new Level15Crucible();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }

}