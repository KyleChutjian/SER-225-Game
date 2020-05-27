package Map;

import Engine.Config;
import Engine.Graphics;
import Game.Kirby;
import GameObject.Rectangle;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Map {
    protected MapTile[] mapTiles;
    protected int width;
    protected int height;
    protected Tileset tileset;
    protected Camera camera;
    protected Point playerStartTile;
    protected int xMidPoint, yMidPoint;
    protected int startBoundX, startBoundY, endBoundX, endBoundY;
    private String mapFileName;

    public Map(String mapFileName, Tileset tileset, Rectangle screenBounds, Point playerStartTile) {
        this.mapFileName = mapFileName;
        this.tileset = tileset;
        loadMapFile();
        camera = new Camera(0, 0, screenBounds, tileset.getScaledSpriteWidth(), tileset.getScaledSpriteHeight(), this);
        this.startBoundX = 0;
        this.startBoundY = 0;
        this.endBoundX = width * tileset.getScaledSpriteWidth();
        this.endBoundY = height * tileset.getScaledSpriteHeight();
        this.xMidPoint = screenBounds.getWidth() / 2;
        this.yMidPoint = (screenBounds.getHeight() / 2);
        this.playerStartTile = playerStartTile;
    }

    private void loadMapFile() {
        Scanner fileInput;
        try {
            fileInput = new Scanner(new File(Config.MAP_FILES_PATH + this.mapFileName));
        } catch(FileNotFoundException ex) {
            System.out.println("Map file " + Config.MAP_FILES_PATH + this.mapFileName + " not found! Creating empty map file...");

            try {
                createEmptyMapFile();
                fileInput = new Scanner(new File(Config.MAP_FILES_PATH + this.mapFileName));
            } catch(IOException ex2) {
                ex2.printStackTrace();
                System.out.println("Failed to create an empty map file!");
                throw new RuntimeException();
            }
        }

        this.width = fileInput.nextInt();
        this.height = fileInput.nextInt();
        this.mapTiles = new MapTile[this.height * this.width];
        fileInput.nextLine();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int tileIndex = fileInput.nextInt();
                MapTile tile = tileset.getTile(tileIndex)
                        .build(j * tileset.getScaledSpriteWidth(), i * tileset.getScaledSpriteHeight());
                setTile(j, i, tile);
            }
        }

        fileInput.close();
    }

    private void createEmptyMapFile() throws IOException {
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(Config.MAP_FILES_PATH + this.mapFileName);
        fileWriter.write("0 0\n");
        fileWriter.close();
    }

    public MapTile[] getMapTiles() {
        return mapTiles;
    }
    public void setMapTiles(MapTile[] mapTiles) {
        this.mapTiles = mapTiles;
    }

    public MapTile getTile(int x, int y) {
        if (isInBounds(x, y)) {
            return mapTiles[getConvertedIndex(x, y)];
        } else {
            return null;
        }
    }

    public void setTile(int x, int y, MapTile tile) {
        mapTiles[getConvertedIndex(x, y)] = tile;
    }

    public MapTile getTileByPosition(int xPosition, int yPosition) {
        Point tileIndex = getTileIndexByPosition(xPosition, yPosition);
        if (isInBounds(tileIndex.x, tileIndex.y)) {
            return getTile(tileIndex.x, tileIndex.y);
        } else {
            return null;
        }
    }

    public Point getTileIndexByPosition(int xPosition, int yPosition) {
        int xIndex = (xPosition + camera.getX()) / Math.round(tileset.getScaledSpriteWidth());
        int yIndex = (yPosition + camera.getY()) / Math.round(tileset.getScaledSpriteHeight());
        return new Point(xIndex, yIndex);
    }

    private boolean isInBounds(int x, int y) {
        int index = getConvertedIndex(x, y);
        return x >= 0 && y >= 0 && x < width && y < height && index >= 0 && index < mapTiles.length;
    }

    private int getConvertedIndex(int x, int y) {
        return x + width * y;
    }

    public void update(Kirby player) {
        adjustMovementY(player);
        adjustMovementX(player);
        camera.update();
    }

    private void adjustMovementX(Kirby player) {
        int xMidPointDifference = 0;
        if (player.getX() > xMidPoint && camera.getEndBoundX() < endBoundX) {
            xMidPointDifference = xMidPoint - player.getX();
            player.moveX(xMidPointDifference);
            camera.moveX(-xMidPointDifference);
            if (camera.getEndBoundX() > endBoundX) {
                int cameraDifference = camera.getEndBoundX() - endBoundX;
                player.moveX(cameraDifference);
                camera.moveX(-cameraDifference);
            }
        } else if (player.getX() < xMidPoint && camera.getX() > startBoundX) {
            xMidPointDifference = xMidPoint - player.getX();
            player.moveX(xMidPointDifference);
            camera.moveX(-xMidPointDifference);
            if (camera.getX() < startBoundX) {
                int cameraDifference = startBoundX - camera.getX();
                player.moveX(-cameraDifference);
                camera.moveX(cameraDifference);
            }
        }
    }

    private void adjustMovementY(Player player) {
        int yMidPointDifference = 0;
        if (player.getY() > yMidPoint && camera.getEndBoundY() < endBoundY) {
            yMidPointDifference = yMidPoint - player.getY();
            player.moveY(yMidPointDifference);
            camera.moveY(-yMidPointDifference);
            if (camera.getEndBoundY() > endBoundY) {
                int cameraDifference = camera.getEndBoundY() - endBoundY;
                player.moveY(cameraDifference);
                camera.moveY(-cameraDifference);
            }
        } else if (player.getY() < yMidPoint && camera.getY() > startBoundY) {
            yMidPointDifference = yMidPoint - player.getY();
            player.moveY(yMidPointDifference);
            camera.moveY(-yMidPointDifference);
            if (camera.getY() < startBoundY) {
                int cameraDifference = startBoundY - camera.getY();
                player.moveY(-cameraDifference);
                camera.moveY(cameraDifference);
            }
        }
    }

    public void draw(Graphics graphics) {
        camera.draw(graphics);
    }

    public Point getPlayerStartPosition() {
        MapTile tile = getTile(playerStartTile.x, playerStartTile.y);
        return new Point(tile.getX(), tile.getY());
    }

    public Tileset getTileset() {
        return tileset;
    }

    public int getWidthPixels() {
        return width * tileset.getScaledSpriteWidth();
    }

    public int getHeightPixels() {
        return height * tileset.getScaledSpriteHeight();
    }

    public String getMapFileName() {
        return mapFileName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
