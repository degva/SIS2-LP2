package com.grupox.pokemonv.model;

import java.awt.Graphics2D;

public class Tile extends Renderable {
    // Enum declaration
    public enum Type { /*GRASS, SAND, ROCK*/
        FLR01, FLR02, FLR03, SGN01, // FLOWER XX, SIGN XX
        GRA00, GRA01, GRA02, GRA03, GRA04, GRA05, GRA06, GRA07, GRA08, GRA09,    // GRASS XX
        SND01, SND02, SND03, SND04, SND05, SND06, SND07, SND08, SND09,  // SAND XX
        TRG01, TRG02, TRG03,  // TREE GRASS/MOUNTAIN XX
        HO101, HO102, HO103, HO104, HO105, HO106, HO107, HO108, HO109, HO110, HO111, HO112  //HOUSE_Y XX
    };
    
    /* Attributes */
    private Type type;
    private User user;
    private boolean isItemEnabled;
    private Map map;
    
    public static final int spriteWidthOut = 64;    // Width with which is rendered each sprite
    public static final int spriteHeightOut = 64;   // Height with which is rendered each sprite
    
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
        return this.type != Type.SND01;
    }
    
    public void loadSprite(){
        int x,y;
        switch ( type ){
            case FLR01:
                x = 1;
                y = 0;
                break;
            case FLR02:
                x = 3;
                y = 0;
                break;
            case FLR03:
                x = 4;
                y = 0;
                break;
            case SGN01:
                x = 2;
                y = 0;
                break;
            case GRA00:
                x = 5;
                y = 0;
                break;
            case GRA01:
                x = 4;
                y = 4;
                break;
            case GRA02:
                x = 5;
                y = 4;
                break;
            case GRA03:
                x = 6;
                y = 4;
                break;
            case GRA04:
                x = 3;
                y = 4;
                break;
            case GRA05:
                x = 3;
                y = 5;
                break;
            case GRA06:
                x = 3;
                y = 6;
                break;
            case GRA07:
                x = 7;
                y = 4;
                break;
            case GRA08:
                x = 7;
                y = 5;
                break;
            case GRA09:
                x = 7;
                y = 6;
                break;
            case SND01:
                x = 7;
                y = 1;
                break;
            case SND02:
                x = 8;
                y = 1;
                break;
            case SND03:
                x = 9;
                y = 1;
                break;                
            case SND04:
                x = 7;
                y = 2;
                break;
            case SND05:
                x = 8;
                y = 2;
                break;
            case SND06:
                x = 9;
                y = 2;
                break;
            case SND07:
                x = 7;
                y = 3;
                break;
            case SND08:
                x = 8;
                y = 3;
                break;
            case SND09:
                x = 9;
                y = 3;
                break;                
            case TRG01:
                x = 9;
                y = 5;
                break; 
            case TRG02:
                x = 10;
                y = 4;
                break; 
            case TRG03:
                x = 9;
                y = 4;
                break;
            case HO101:
                x = 6;
                y = 8;
                break;
            case HO102:
                x = 7;
                y = 8;
                break;
            case HO103:
                x = 8;
                y = 8;
                break;
            case HO104:
                x = 9;
                y = 8;
                break;
            case HO105:
                x = 6;
                y = 9;
                break;
            case HO106:
                x = 7;
                y = 9;
                break;
            case HO107:
                x = 8;
                y = 9;
                break;
            case HO108:
                x = 9;
                y = 9;
                break;
            case HO109:
                x = 6;
                y = 10;
                break;
            case HO110:
                x = 7;
                y = 10;
                break;
            case HO111:
                x = 8;
                y = 10;
                break;
            case HO112:
                x = 9;
                y = 10;
                break;                
            default:
                x = 1;
                y = 0;
        }
        sprite = SpriteSheet.getInstance().getSubImage( x, y );
    }
    
    public void render( Graphics2D g, int x, int y ){
        g.drawImage(sprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
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
