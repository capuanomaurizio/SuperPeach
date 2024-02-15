package it.unibo.superpeach.powerups;

import java.awt.*;

public class LifeMushroom extends PowerUp{

    public LifeMushroom (int x, int y, int w, int h, int s) {
        super(x, y, w, h, s);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getImage()[1],getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {

    }
    
}