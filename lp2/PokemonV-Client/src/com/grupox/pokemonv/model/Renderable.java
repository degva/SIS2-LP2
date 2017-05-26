package com.grupox.pokemonv.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Renderable {
    /* Enum declaration */
    public enum Direction { UP, DOWN, LEFT, RIGHT };
    
    /* Attributes */    
    protected Direction direction;
    protected BufferedImage sprite;
    
    /* Methods */
    public abstract void render( Graphics2D g, int x, int y );
    
    /* Getters and setters */
    public Direction getDirection() {
        return direction;
    }
    // No need to give others objects the possibility to set my direction
}
