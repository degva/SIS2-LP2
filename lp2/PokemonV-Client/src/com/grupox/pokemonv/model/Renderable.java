package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.Animation;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Renderable {
    /* Enum declaration */
    public enum Direction { UP, DOWN, LEFT, RIGHT };
    
    /* Attributes */    
    protected Direction direction;
    protected BufferedImage sprite;
    
    protected ArrayList<Animation> animations;
    protected BufferedImage currSprite;
    
    /* Constructors */
    public Renderable(){
        animations = new ArrayList<>();
        direction = Direction.DOWN;
    }
    
    /* Methods */
    public abstract void render( Graphics2D g, int x, int y );
    
    protected int findAnimation(String name){
        int index = 0;
        for(Animation animation : animations){
            if( animation.getName().equals( name ) ){
                return index; 
            }
            index++;
        }
        return -1;
    }
    
    /*protected void stopAnimations(){
        for(Animation animation : animations){
            animation.stop();
        }
    }*/
    
    /* Getters and setters */
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
