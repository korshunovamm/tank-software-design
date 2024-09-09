//package ru.mipt.bit.platformer.Entities;
//
//import com.badlogic.gdx.Gdx;
//
//import static com.badlogic.gdx.Input.Keys.*;
//import static com.badlogic.gdx.Input.Keys.D;
//import static com.badlogic.gdx.math.MathUtils.isEqual;
//import static ru.mipt.bit.platformer.util.GdxGameUtils.*;
//import static ru.mipt.bit.platformer.util.GdxGameUtils.incrementedX;
//
//public class Movement {
//    enum KeyPress {
//        UP,
//        LEFT,
//        RIGHT,
//        DOWN,
//        W,
//        A,
//        S,
//        D
//    }
//
//    private KeyPress tmp_key_press;
//
//    Movement() {}
//
//    public void render(Player player, Tree tree) {
//        if (!isEqual(player.getPlayerMovementProgress(), 1f) ) {
//            return;
//        }
//
//        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
//                // check potential player destination for collision with obstacles
//                if (!treeObstacleCoordinates.equals(incrementedY(playerCoordinates))) {
//                    playerDestinationCoordinates.y++;
//                    playerMovementProgress = 0f;
//                }
//                playerRotation = 90f;
//
//        }
//        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
//                if (!treeObstacleCoordinates.equals(decrementedX(playerCoordinates))) {
//                    playerDestinationCoordinates.x--;
//                    playerMovementProgress = 0f;
//                }
//                playerRotation = -180f;
//        }
//        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
//                if (!treeObstacleCoordinates.equals(decrementedY(playerCoordinates))) {
//                    playerDestinationCoordinates.y--;
//                    playerMovementProgress = 0f;
//                }
//                playerRotation = -90f;
//        }
//        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
//                if (!treeObstacleCoordinates.equals(incrementedX(playerCoordinates))) {
//                    playerDestinationCoordinates.x++;
//                    playerMovementProgress = 0f;
//                }
//                playerRotation = 0f;
//        }
//
//    }
//
//}
