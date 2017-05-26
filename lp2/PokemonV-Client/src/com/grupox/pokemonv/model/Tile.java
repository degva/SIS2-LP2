package com.grupox.pokemonv.model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tile extends Renderable {
    // Enum declaration
    public enum Type { GRASS, SAND, ROCK };
    
    /* Attributes */
    private Type type;
    private User user;
    private boolean isItemEnabled;
    private Map map;
    
    public static final int spriteWidth = 64;
    public static final int spriteHeight = 64;
    
    /* Constructors */
    public Tile( Type type, User user, boolean isItemEnabled, Map map ){
        this.type = type;
        this.user = user;
        this.isItemEnabled = isItemEnabled;
        this.map = map;
        
        loadSprite();
    }
    
    /* Methods */
    public boolean containsUser(){
        return this.user != null;
    }
    
    public boolean isSolid(){
        return this.type != Type.ROCK;
    }
    
    /*public boolean updateState(){
        return true;
    }*/
    
    public void loadSprite(){
        int x,y;
        switch ( type ){
            case GRASS:
                x = 5;
                y = 0;
                break;
            case SAND:
                x = 8;
                y = 2;
                break;
            case ROCK:
                x = 1;
                y = 2;
                break;
            default:
                x = 1;
                y = 0;
        }
        sprite = SpriteSheet.getInstance().getSubImage( x, y );
    }
    
    public void render( Graphics2D g, int x, int y ){
        g.drawImage( sprite, x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight, null );
        if( user != null ){
            user.render( g, x, y );
        }
    }
    
    /* Getters & Setters */
    public Type getType() {
        return type;
    }
    public void setType( Type type ) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }
    public void setUser( User user ) {
        this.user = user;
    }

    public boolean isIsItemEnabled() {
        return isItemEnabled;
    }
    public void setIsItemEnabled( boolean isItemEnabled ) {
        this.isItemEnabled = isItemEnabled;
    }

    public Map getMap() {
        return map;
    }
    public void setMap( Map map ) {
        this.map = map;
    }
}
