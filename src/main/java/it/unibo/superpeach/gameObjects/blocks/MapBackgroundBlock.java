package it.unibo.superpeach.gameObjects.blocks;

import java.awt.Graphics;

public class MapBackgroundBlock extends Block{

    public MapBackgroundBlock(int x, int y, int width, int height, int scale, BlockType type){
        super(x, y, width, height, scale);
        setType(type);
        switch (type) {
            case CLOUD_TOP_LEFT:
            case CLOUD_TOP_MIDDLE:
            case CLOUD_TOP_RIGHT:
            case CLOUD_BOT_LEFT:
            case CLOUD_BOT_MIDDLE:
            case CLOUD_BOT_RIGHT:
                setSprites(getTexturer().getCloud());
                break;
            case BUSH_LEFT:
            case BUSH_MIDDLE:
            case BUSH_RIGHT:
                setSprites(getTexturer().getBush());
                break;
            case HILL_UP:
            case HILL_BLANK:
            case HILL_SPOTS1:
            case HILL_SPOTS2:
            case HILL_TOP:
            case HILL_DOWN:
                setSprites(getTexturer().getHill());
                break;
            case FLAG_LEFT:
            case FLAG_RIGHT:
                setSprites(getTexturer().getFlag());
                break;
            default:
                //its for sure a castle block, using default to avoid too many code
                setSprites(getTexturer().getTerrain());
                break;
        }
    }

    @Override
    public void render(Graphics g) {
        switch (getType()) {
            case CLOUD_TOP_LEFT:
                g.drawImage(getSprites()[0], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CLOUD_TOP_MIDDLE:
                g.drawImage(getSprites()[1], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CLOUD_TOP_RIGHT:
                g.drawImage(getSprites()[2], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CLOUD_BOT_LEFT:
                g.drawImage(getSprites()[3], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CLOUD_BOT_MIDDLE:
                g.drawImage(getSprites()[4], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CLOUD_BOT_RIGHT:
                g.drawImage(getSprites()[5], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case BUSH_LEFT:
                g.drawImage(getSprites()[0], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case BUSH_MIDDLE:
                g.drawImage(getSprites()[1], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case BUSH_RIGHT:
                g.drawImage(getSprites()[2], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case HILL_UP:
                g.drawImage(getSprites()[1], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case HILL_BLANK:
                g.drawImage(getSprites()[3], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case HILL_SPOTS1:
                g.drawImage(getSprites()[2], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case HILL_SPOTS2:
                g.drawImage(getSprites()[4], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case HILL_TOP:
                g.drawImage(getSprites()[0], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case HILL_DOWN:
                g.drawImage(getSprites()[5], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case FLAG_LEFT:
                g.drawImage(getSprites()[2], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case FLAG_RIGHT:
                g.drawImage(getSprites()[3], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CASTLE_BRICK:
                g.drawImage(getSprites()[2], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CASTLE_BALCONY1:
                g.drawImage(getSprites()[4], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CASTLE_BALCONY2:
                g.drawImage(getSprites()[5], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CASTLE_WINDOW_LEFT:
                g.drawImage(getSprites()[11], getX(), getY(), getWidth(), getHeight(), null);
                break;
            case CASTLE_WINDOW_RIGHT:
                g.drawImage(getSprites()[13], getX(), getY(), getWidth(), getHeight(), null);
                break;
            default:
                break;
        }
    }

    @Override
    public void tick() {
    }

}