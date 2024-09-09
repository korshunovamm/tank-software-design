package ru.mipt.bit.platformer.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import static com.badlogic.gdx.Input.Keys.*;
import com.badlogic.gdx.Gdx;

import lombok.Getter;
import lombok.Setter;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;


public class Player {
    @Getter
    private Texture blueTankTexture = new Texture("images/tank_blue.png");

    @Getter
    private TextureRegion playerGraphics;
    @Getter
    private Rectangle playerRectangle;

    @Getter
    private GridPoint2 playerCoordinates;
    @Getter
    private GridPoint2 playerDestinationCoordinates;
    @Getter
    private float playerRotation;
    @Getter
    @Setter
    private float playerMovementProgress;


    private Level level;


    public Player(int x, int y) {
        this(x, y, 0f);
    }

    public Player(int x, int y, float rotation) {
        // TextureRegion represents Texture portion, there may be many TextureRegion instances of the same Texture
        playerGraphics = new TextureRegion(blueTankTexture);
        playerRectangle = createBoundingRectangle(playerGraphics);
        // set player initial position
        playerDestinationCoordinates = new GridPoint2(x, y);
        playerCoordinates = new GridPoint2(playerDestinationCoordinates);
        playerMovementProgress = rotation;
    }

    public void create(Level level) {
        this.level = level;
    }

    public void render() {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            render(0, 1, 90f);
        }

        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            render(0, -1, -90f);
        }

        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            render(-1, 0, -180f);
        }

        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            render(1, 0, 0f);
        }
    }

    public void render(int directionX, int directionY, float rotation) {
        if (isEqual(playerMovementProgress, 1f)) {
            GridPoint2 move_point = new GridPoint2(playerCoordinates.x + directionX, playerCoordinates.y + directionY);

            Tree tree = level.getTree();
            // check potential player destination for collision with obstacles
            if (!tree.getTreeObstacleCoordinates().equals(move_point)) {
                playerDestinationCoordinates = move_point;
                playerMovementProgress = 0f;
            }
            playerRotation = rotation;
        }


    }

    public void render(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(playerRectangle, playerCoordinates, playerDestinationCoordinates, playerMovementProgress);

        float deltaTime  = Gdx.graphics.getDeltaTime();
        playerMovementProgress = continueProgress(playerMovementProgress, deltaTime, Movement.MOVEMENT_SPEED);
        if (isEqual(playerMovementProgress, 1f)) {
            // record that the player has reached his/her destination
            playerCoordinates.set(playerDestinationCoordinates);
        }
    }

    public void draw(Batch batch) {
        drawTextureRegionUnscaled(batch, playerGraphics, playerRectangle, playerRotation);
    }

}
