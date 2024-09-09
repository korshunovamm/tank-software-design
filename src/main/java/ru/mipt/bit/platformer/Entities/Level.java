package ru.mipt.bit.platformer.Entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Interpolation;
import ru.mipt.bit.platformer.util.TileMovement;
import lombok.Getter;
import lombok.Setter;

import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class Level {

    private MapRenderer levelRenderer;

    @Getter
    private TiledMap level;

    @Getter
    private Tree tree;

    @Getter
    private TileMovement tileMovement;

    public Level(Batch batch) {
        // load level tiles
        level = new TmxMapLoader().load("level.tmx");
        levelRenderer = createSingleLayerMapRenderer(level, batch);
        TiledMapTileLayer groundLayer = getSingleLayer(level);
        tileMovement = new TileMovement(groundLayer, Interpolation.smooth);
    }

    public void create(Tree tree) {
        this.tree = tree;
        TiledMapTileLayer groundLayer = getSingleLayer(level);
        moveRectangleAtTileCenter(groundLayer, tree.getTreeObstacleRectangle(), tree.getTreeObstacleCoordinates());
    }

    public void render() {
        levelRenderer.render();
    }
}
