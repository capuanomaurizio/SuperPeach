package it.unibo.superpeach.gameObjects.powerups;

import java.awt.*;

import it.unibo.superpeach.gameObjects.blocks.BlocksHandler;

public class Coin extends PowerUp{

    public Coin (int x, int y, int w, int h, int s, BlocksHandler blocksHandler) {
        super(x, y, w, h, s, blocksHandler, PowerUpType.COIN);
        setMovement(0);
        setIsFalling(false);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getSprites()[3],getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {}

}