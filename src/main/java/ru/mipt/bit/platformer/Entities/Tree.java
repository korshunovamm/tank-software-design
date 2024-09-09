package ru.mipt.bit.platformer.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import lombok.Getter;

import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class Tree {

    @Getter
    private Texture greenTreeTexture;
    @Getter
    private TextureRegion treeObstacleGraphics;

    @Getter
    private GridPoint2 treeObstacleCoordinates;
    @Getter
    private Rectangle treeObstacleRectangle;

    public Tree(int x, int y) {
        greenTreeTexture = new Texture("images/greenTree.png");
        treeObstacleGraphics = new TextureRegion(greenTreeTexture);
        treeObstacleCoordinates = new GridPoint2(x, y);
        treeObstacleRectangle = createBoundingRectangle(treeObstacleGraphics);
    }

    public void draw(Batch batch) {
        drawTextureRegionUnscaled(batch, treeObstacleGraphics, treeObstacleRectangle, 0f);
    }
}
