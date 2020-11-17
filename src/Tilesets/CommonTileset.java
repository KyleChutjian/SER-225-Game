package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Rectangle;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class CommonTileset extends Tileset {

    public CommonTileset() {
        super(ImageLoader.load("CommonTileset.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // grass
        Frame grassFrame = new FrameBuilder(getSubImage(0, 0), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder grassTile = new MapTileBuilder(grassFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassTile);

        // sky
        Frame skyFrame = new FrameBuilder(getSubImage(0, 1), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder skyTile = new MapTileBuilder(skyFrame);

        mapTiles.add(skyTile);

        // dirt
        Frame dirtFrame = new FrameBuilder(getSubImage(0, 2), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder dirtTile = new MapTileBuilder(dirtFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dirtTile);

        // sun
        Frame[] sunFrames = new Frame[] {
                new FrameBuilder(getSubImage(2, 0), 400)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(2, 1), 400)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder sunTile = new MapTileBuilder(sunFrames);

        mapTiles.add(sunTile);

        // tree trunk with full hole
        Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(treeTrunkWithFullHoleFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkWithFullHoleTile);

        // left end branch
        Frame leftEndBranchFrame = new FrameBuilder(getSubImage(1, 5), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndBranchTile = new MapTileBuilder(leftEndBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(leftEndBranchTile);

        // right end branch
        Frame rightEndBranchFrame = new FrameBuilder(getSubImage(1, 5), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndBranchTile = new MapTileBuilder(rightEndBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(rightEndBranchTile);
        
        // tree trunk
        Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkTile = new MapTileBuilder(treeTrunkFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkTile);

        // tree top leaves
        Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopLeavesTile = new MapTileBuilder(treeTopLeavesFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTopLeavesTile);
        
        // yellow flower
        Frame[] yellowFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(1, 2), 500)
                    .withScale(tileScale)
                    .build(),
                new FrameBuilder(getSubImage(1, 3), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 2), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(1, 4), 500)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder yellowFlowerTile = new MapTileBuilder(yellowFlowerFrames);

        mapTiles.add(yellowFlowerTile);

        // purple flower
        Frame[] purpleFlowerFrames = new Frame[] {
                new FrameBuilder(getSubImage(0, 3), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 4), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 3), 500)
                        .withScale(tileScale)
                        .build(),
                new FrameBuilder(getSubImage(0, 5), 500)
                        .withScale(tileScale)
                        .build()
        };

        MapTileBuilder purpleFlowerTile = new MapTileBuilder(purpleFlowerFrames);

        mapTiles.add(purpleFlowerTile);

        // middle branch
        Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder middleBranchTile = new MapTileBuilder(middleBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(middleBranchTile);

        // tree trunk hole top
        Frame treeTrunkHoleTopFrame = new FrameBuilder(getSubImage(2, 4), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkHoleTopTile = new MapTileBuilder(treeTrunkHoleTopFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkHoleTopTile);

        // tree trunk hole bottom
        Frame treeTrunkHoleBottomFrame = new FrameBuilder(getSubImage(2, 5), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTrunkHoleBottomTile = new MapTileBuilder(treeTrunkHoleBottomFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTrunkHoleBottomTile);

        // top water
        Frame topWaterFrame = new FrameBuilder(getSubImage(3, 0), 0)
                .withScale(tileScale)
                .withBounds(new Rectangle(0, 8, 16, 8))
                .build();

        MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrame).withTileType(TileType.LIQUID);

        mapTiles.add(topWaterTile);

        // water
        Frame waterFrame = new FrameBuilder(getSubImage(3, 1), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder waterTile = new MapTileBuilder(waterFrame).withTileType(TileType.LIQUID);

        mapTiles.add(waterTile);

        // grey rock
        Frame greyRockFrame = new FrameBuilder(getSubImage(3, 2), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder greyRockTile = new MapTileBuilder(greyRockFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(greyRockTile);
        
     // Snowy Rock
        Frame greyRockSnowFrame = new FrameBuilder(getSubImage(3, 3), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder greyRockSnowTile = new MapTileBuilder(greyRockSnowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(greyRockSnowTile);
        
     // Snowy Grass
        Frame grassSnowFrame = new FrameBuilder(getSubImage(3, 4), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder grassSnowTile = new MapTileBuilder(grassSnowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(grassSnowTile);
        
     // Sand
        Frame sandFrame = new FrameBuilder(getSubImage(3, 5), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder sandTile = new MapTileBuilder(sandFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(sandTile);

        // SandStone
        Frame sandStoneFrame = new FrameBuilder(getSubImage(4, 0), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder sandStoneTile = new MapTileBuilder(sandStoneFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(sandStoneTile);
        
     // Left End Branch with Snow at Night
        Frame leftEndSnowyNightBranchFrame = new FrameBuilder(getSubImage(4, 1), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndSnowyNightBranchTile = new MapTileBuilder(leftEndSnowyNightBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(leftEndSnowyNightBranchTile);
        
        // Right End Branch with Snow at Night
        Frame rightEndSnowyNightBranchFrame = new FrameBuilder(getSubImage(4, 2), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndSnowyNightBranchTile = new MapTileBuilder(rightEndSnowyNightBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);
        
        mapTiles.add(rightEndSnowyNightBranchTile);
        
        
     // Ice
        Frame iceFrame = new FrameBuilder(getSubImage(4, 3), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder iceTile = new MapTileBuilder(iceFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(iceTile);
        
     // Left End Branch at Night
        Frame leftEndNightBranchFrame = new FrameBuilder(getSubImage(4, 4), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndNightBranchTile = new MapTileBuilder(leftEndNightBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(leftEndNightBranchTile);

        // Right End Branch at Night
        Frame rightEndNightBranchFrame = new FrameBuilder(getSubImage(4, 5), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndNightBranchTile = new MapTileBuilder(rightEndNightBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(rightEndNightBranchTile);
        
     // Night Sky Single Star
        Frame NightSkyFrame = new FrameBuilder(getSubImage(5, 0), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder NightSkyTile = new MapTileBuilder(NightSkyFrame);

        mapTiles.add(NightSkyTile);
        
     // Water Night
        Frame NightWaterFrame = new FrameBuilder(getSubImage(5, 1), 0)
                .withScale(tileScale)
                .withBounds(new Rectangle(0, 8, 16, 8))
                .build();

        MapTileBuilder NightWaterTile = new MapTileBuilder(NightWaterFrame)
                .withTileType(TileType.LIQUID);

        mapTiles.add(NightWaterTile);
        
     // LAVA Night
        Frame NightLavaFrame = new FrameBuilder(getSubImage(5, 2), 0)
                .withScale(tileScale)
                .withBounds(new Rectangle(0, 8, 16, 8))
                .build();

        MapTileBuilder NightLavaTile = new MapTileBuilder(NightLavaFrame)
                .withTileType(TileType.LIQUID);

        mapTiles.add(NightLavaTile);
        
     // LAVA
        Frame LavaFrame = new FrameBuilder(getSubImage(5, 3), 0)
                .withScale(tileScale)
                .withBounds(new Rectangle(0, 8, 16, 8))
                .build();

        MapTileBuilder LavaTile = new MapTileBuilder(LavaFrame)
                .withTileType(TileType.LIQUID);

        mapTiles.add(LavaTile);
        
        // LAVA Body
        Frame LavaBodyFrame = new FrameBuilder(getSubImage(5, 4), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder LavaBodyTile = new MapTileBuilder(LavaBodyFrame);

        mapTiles.add(LavaBodyTile);
        
     // Snowy Treetop
        Frame treeTopSnowFrame = new FrameBuilder(getSubImage(5, 5), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder treeTopSnowTile = new MapTileBuilder(treeTopSnowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treeTopSnowTile);
        
     // Right End Branch with Snow
        Frame rightEndSnowyBranchFrame = new FrameBuilder(getSubImage(6, 0), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder rightEndSnowyBranchTile = new MapTileBuilder(rightEndSnowyBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(rightEndSnowyBranchTile);
        
        // Left End Branch with Snow
        Frame leftEndSnowyBranchFrame = new FrameBuilder(getSubImage(6, 1), 0)
                .withScale(tileScale)
                .withBounds(0, 6, 16, 4)
                .build();

        MapTileBuilder leftEndSnowyBranchTile = new MapTileBuilder(leftEndSnowyBranchFrame)
                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

        mapTiles.add(leftEndSnowyBranchTile);

    
        // Moon
        Frame MoonFrame = new FrameBuilder(getSubImage(6, 2), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder MoonTile = new MapTileBuilder(MoonFrame);

        mapTiles.add(MoonTile);
        
     // Open Night Sky
        Frame NightFrame = new FrameBuilder(getSubImage(6, 3), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder NightTile = new MapTileBuilder(NightFrame);

        mapTiles.add(NightTile);
        
     // Cactus Top
        Frame CactusTopFrame = new FrameBuilder(getSubImage(6, 4), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder CactusTopTile = new MapTileBuilder(CactusTopFrame)
        		.withTileType(TileType.CACTUS);

        mapTiles.add(CactusTopTile);
        
     // Cactus Body
        Frame CactusBodyFrame = new FrameBuilder(getSubImage(6, 5), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder CactusBodyTile = new MapTileBuilder(CactusBodyFrame)
        		.withTileType(TileType.CACTUS);

        mapTiles.add(CactusBodyTile);
        
     // Cactus Top at Night
        Frame CactusTopNightFrame = new FrameBuilder(getSubImage(7, 0), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder CactusTopNightTile = new MapTileBuilder(CactusTopNightFrame)
        		.withTileType(TileType.CACTUS);

        mapTiles.add(CactusTopNightTile);
        
     // Night Sky with Stars Variant 1
        Frame Night2Frame = new FrameBuilder(getSubImage(7, 1), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder Night2Tile = new MapTileBuilder(Night2Frame);

        mapTiles.add(Night2Tile);
        
     // Night Sky with Stars Variant 2
        Frame Night3Frame = new FrameBuilder(getSubImage(7, 2), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder Night3Tile = new MapTileBuilder(Night3Frame);

        mapTiles.add(Night3Tile);
        
     // Dark Stone Background
        Frame DarkStoneFrame = new FrameBuilder(getSubImage(7, 3), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder DarkStoneTile = new MapTileBuilder(DarkStoneFrame);

        mapTiles.add(DarkStoneTile);
        
     // Low Lava Glow Stone
        
        Frame LowGlowFrame = new FrameBuilder(getSubImage(7, 4), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder LowGlowTile = new MapTileBuilder(LowGlowFrame);

        mapTiles.add(LowGlowTile);
        
     // Left Lava Glow Stone
        
        Frame LeftGlowFrame = new FrameBuilder(getSubImage(7, 5), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder LeftGlowTile = new MapTileBuilder(LeftGlowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(LeftGlowTile);
        
     // Right Lava Glow Stone
        
        Frame RightGlowFrame = new FrameBuilder(getSubImage(8, 0), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder RightGlowTile = new MapTileBuilder(RightGlowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(RightGlowTile);
        
     // Lava with Glow
        
        Frame LavaWGlowFrame = new FrameBuilder(getSubImage(8, 1), 0)
                .withScale(tileScale)
                .withBounds(new Rectangle(0, 8, 16, 8))
                .build();

        MapTileBuilder LavaWGlowTile = new MapTileBuilder(LavaWGlowFrame)
                .withTileType(TileType.LIQUID);

        mapTiles.add(LavaWGlowTile);
        
     // Low Lava Glow on Dark Stone
        
        Frame LowGlow2Frame = new FrameBuilder(getSubImage(8, 2), 0)
                .withScale(tileScale)
                .build();

        MapTileBuilder LowGlow2Tile = new MapTileBuilder(LowGlow2Frame);

        mapTiles.add(LowGlow2Tile);

        return mapTiles;
    }

}