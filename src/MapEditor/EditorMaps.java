package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.Level2Fields;
import Maps.Level3Forest;
import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("Level2Fields");
            add("Level3Forest");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "Level2Fields":
            	return new Level2Fields();
            case "Level3Forest":
            	return new Level3Forest();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
