
package it.unibo.superpeach.gameObjects.enemies;

import org.junit.jupiter.api.Test;

import it.unibo.superpeach.game.Game;
import it.unibo.superpeach.gameObjects.blocks.BlocksHandler;
import it.unibo.superpeach.gameObjects.blocks.MapFixedBlock;
import it.unibo.superpeach.gameObjects.blocks.Block.BlockType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnemyTest {

    private static final int X1 = 12;
    private static final int Y1 = 13;
    private static final int X2 = 22;
    private static final int Y2 = 23;
    private static final int X3 = 32;
    private static final int Y3 = 33;
    private static final int WIDTH = 16;
    private static final int KOOPA_HEIGHT = 24;
    private static final int GOOMBA_HEIGHT = 16;
    private static final int SCALE1 = 1;
    private static final int SCALE2 = 2;

    private static final BlocksHandler BLOCKS_HANDLER = new BlocksHandler();

    @Test
    void testEnemy() {

        new Game().init();

        // Creating an enemy for each type
        Enemy koopa = new KoopaTroopa(X1, Y1, WIDTH, KOOPA_HEIGHT, SCALE1, BLOCKS_HANDLER);
        Enemy goomba = new Goomba(X2, Y2, WIDTH, GOOMBA_HEIGHT, SCALE2, BLOCKS_HANDLER);
        Enemy fkoopa = new FlyingKoopa(X3, Y3, WIDTH, KOOPA_HEIGHT, SCALE2, BLOCKS_HANDLER);

        // Checking if the enemies got correctly created
        assertNotNull(koopa);
        assertNotNull(goomba);
        assertNotNull(fkoopa);

        // Checking the field values of the enemies that have been created
        assertEquals(X1, koopa.getX());
        assertEquals(Y1, koopa.getY());
        assertEquals(WIDTH, koopa.getWidth());
        assertEquals(KOOPA_HEIGHT, koopa.getHeight());
        assertEquals(SCALE1, koopa.getScale());
        assertEquals(BLOCKS_HANDLER, koopa.getBlocksHandler());

        // Checking if the scales operations on the coordinates are done correcly
        assertNotEquals(X2, goomba.getX());
        assertEquals(X2 * SCALE2, goomba.getX());
        assertNotEquals(X3, fkoopa.getX());
        assertEquals(X3 * SCALE2, fkoopa.getX());

        // Checking direction changes
        assertFalse(fkoopa.getDirection());
        fkoopa.changeDirection();
        assertTrue(fkoopa.getDirection());

        // Checking enemy "alive" status
        assertTrue(goomba.getIsAlive());
        goomba.die();
        assertFalse(goomba.getIsAlive());

    }

    @Test
    void testEnemyDeathCollision() {

        new Game().init();

        // Creating an enemy and a BlocksHandler containing a DEATH_BLOCK with the same
        // coords of the enemy
        // to check if enemies correctly die after collision with it
        BlocksHandler bh = new BlocksHandler();
        bh.addFixedBlock(new MapFixedBlock(X1, Y1, WIDTH, GOOMBA_HEIGHT, SCALE1, BlockType.DEATH_BLOCK));

        Enemy koopa = new KoopaTroopa(X1, Y1 - 1, WIDTH, KOOPA_HEIGHT, SCALE1, bh);

        assertTrue(koopa.getIsAlive());

        // Checking if the enemy is alive after the collision
        koopa.collision();
        assertFalse(koopa.getIsAlive());

    }

    @Test
    public void testCollisions() {

        new Game().init();

        BlocksHandler bh1 = new BlocksHandler();
        bh1.addFixedBlock(new MapFixedBlock(X2, Y2, WIDTH, GOOMBA_HEIGHT, SCALE1, BlockType.BRICK));

        Enemy goomba = new Goomba(X2, Y2, WIDTH, GOOMBA_HEIGHT, SCALE1, BLOCKS_HANDLER);

        assertEquals(X2, goomba.getX());
        assertEquals(Y2, goomba.getY());
        assertFalse(goomba.getDirection());

        goomba.collision();

        assertTrue(goomba.getDirection());
        assertEquals(X2, goomba.getX());
        assertEquals(Y2, goomba.getY());

    }
}