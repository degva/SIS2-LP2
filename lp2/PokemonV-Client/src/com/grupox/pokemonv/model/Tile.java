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
    private Player player;
    private boolean isItemEnabled;
    private boolean isPokemonSpawner;
    private Map map;
    private boolean isWalkable;
    
    public static final int spriteWidthOut = 64;    // Width with which is rendered each sprite
    public static final int spriteHeightOut = 64;   // Height with which is rendered each sprite
    
    /* Constructors */
    public Tile( Type type, Player player, boolean isItemEnabled, Map map ){
        this.type = type;
        this.player = player;
        this.isItemEnabled = isItemEnabled;
        this.map = map;
        
        isWalkable = determinateWalkable();
        isPokemonSpawner = determinatePokemonSpawner();
        loadSprite();
    }
    
    /* Methods */
    public static Type getType(int i){
        Type type = Tile.Type.FLR01;
        switch (i){
            case 1:
                type = Tile.Type.FLR01;
                break;
            case 2:
                type = Tile.Type.FLR02;
                break;
            case 3:
                type = Tile.Type.FLR03;
                break;
            case 4:
                type = Tile.Type.SGN01;
                break;
            case 5:
                type = Tile.Type.GRA00;
                break;
            case 6:
                type = Tile.Type.GRA01;
                break;
            case 7:
                type = Tile.Type.GRA02;
                break;
            case 8:
                type = Tile.Type.GRA03;
                break;
            case 9:
                type = Tile.Type.GRA04;
                break;
            case 10:
                type = Tile.Type.GRA05;
                break;
            case 11:
                type = Tile.Type.GRA06;
                break;
            case 12:
                type = Tile.Type.GRA07;
                break;
            case 13:
                type = Tile.Type.GRA08;
                break;
            case 14:
                type = Tile.Type.GRA09;
                break;
            case 15:
                type = Tile.Type.SND01;
                break;
            case 16:
                type = Tile.Type.SND02;
                break;
            case 17:
                type = Tile.Type.SND03;
                break;
            case 18:
                type = Tile.Type.SND04;
                break;
            case 19:
                type = Tile.Type.SND05;
                break;
            case 20:
                type = Tile.Type.SND06;
                break;
            case 21:
                type = Tile.Type.SND07;
                break;
            case 22:
                type = Tile.Type.SND08;
                break;
            case 23:
                type = Tile.Type.SND09;
                break;
            case 24:
                type = Tile.Type.TRG01;
                break;
            case 25:
                type = Tile.Type.TRG02;
                break;
            case 26:
                type = Tile.Type.TRG03;
                break;
            case 27:
                type = Tile.Type.HO101;
                break;
            case 28:
                type = Tile.Type.HO102;
                break;
            case 29:
                type = Tile.Type.HO103;
                break;
            case 30:
                type = Tile.Type.HO104;
                break;
            case 31:
                type = Tile.Type.HO105;
                break;
            case 32:
                type = Tile.Type.HO106;
                break;
            case 33:
                type = Tile.Type.HO107;
                break;
            case 34:
                type = Tile.Type.HO108;
                break;
            case 35:
                type = Tile.Type.HO109;
                break;
            case 36:
                type = Tile.Type.HO110;
                break;
            case 37:
                type = Tile.Type.HO111;
                break;
            case 38:
                type = Tile.Type.HO112;
                break;
            default:
                type = Tile.Type.FLR01;
                break;
        }
        return type;
    }
    
    public boolean containsUser(){
        return this.player != null;
    }
    
    public void render( Graphics2D g, int x, int y ){
        g.drawImage(sprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
        if( player != null ){
            player.render( g, x, y );
        }
    }
    
    private void loadSprite(){
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

    // Determinate walkable
    private boolean determinateWalkable(){
        if( type == Type.TRG01 || type == Type.TRG02 || type == Type.TRG03 || 
            type == Type.HO101 || type == Type.HO102 || type == Type.HO103 ||
            type == Type.HO104 || type == Type.HO105 || type == Type.HO106 ||
            type == Type.HO107 || type == Type.HO108 || type == Type.HO109 ||
            type == Type.HO110 || type == Type.HO111 || type == Type.HO112 ){
            return false;
        }
        return true;
    }
    
    private boolean determinatePokemonSpawner(){
        if( type == Type.GRA00 || type == Type.GRA01 || type == Type.GRA02 || type == Type.GRA03 || 
            type == Type.GRA04 || type == Type.GRA05 || type == Type.GRA06 || type == Type.GRA07 ||
            type == Type.GRA08 || type == Type.GRA09 ){
            return true;
        }
        return false;
    }
    
    /* Getters & Setters */
    public Type getType() {
        return type;
    }
    public void setType( Type type ) {
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer( Player player ) {
        this.player = player;
    }

    public boolean getIsItemEnabled() {
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

    public boolean getIsWalkable() {
        return isWalkable;
    }

    public boolean getIsPokemonSpawner() {
        return isPokemonSpawner;
    }

    public void setIsPokemonSpawner(boolean isPokemonSpawner) {
        this.isPokemonSpawner = isPokemonSpawner;
    }
    
}