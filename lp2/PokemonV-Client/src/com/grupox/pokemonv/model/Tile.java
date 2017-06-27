package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.Animation;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile extends Renderable {
    // Enum declaration
    public enum Type { /*GRASS, SAND, ROCK*/
        FLR01, FLR02, FLR03, SGN01, // FLOWER XX, SIGN XX
        GRA00, GRA01, GRA02, GRA03, GRA04, GRA05, GRA06, GRA07, GRA08, GRA09, GRA10,    // GRASS XX
        SND01, SND02, SND03, SND04, SND05, SND06, SND07, SND08, SND09,  // SAND XX
        TRG01, TRG02, TRG03,  // TREE GRASS/MOUNTAIN XX
        TRW01, TRW02, TRW03, TRW04, TRW05, TRW06, TRW07, TRW08, TRW09, TRW10, // TREE WALL
        HO101, HO102, HO103, HO104, HO105, HO106, HO107, HO108, HO109, HO110, HO111, HO112,  //HOUSE_Y XX
        
        HO201, HO202, HO203, HO204, HO205, HO206, HO207, HO208, HO209, HO210, HO211, HO212,  // OAK's lab
        HO213, HO214, HO215, HO216, HO217, HO218, HO219, HO220, HO221, HO222, HO223, HO224,
        HO225, HO226, HO227, HO228, HO229, HO230,
        
        HO301, HO302, HO303, HO304, HO305, HO306, HO307, HO308, HO309, HO310, HO311, HO312,  // Right house
        HO313, HO314, HO315, HO316, HO317, HO318, HO319, HO320, HO321, HO322, HO323, HO324,
        HO325,
        
        HO401, HO402, HO403, HO404, HO405, HO406,    // Left house, different tiles
        PAT00,  // PATCH OF SAND OUTSIDE HOUSE
        
        EBA01, EBA02, EBA03, EBA04, EBA05   // Earth barriers
    };
    
    /* Attributes */
    private Type type;
    private Player player;
    private boolean isItemEnabled;
    private boolean isPokemonSpawner;
    private Map map;
    private boolean isWalkable;
    
    private BufferedImage topSprite;
    
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
        loadAnimations();
    }
    
    /* Methods */
    public void tick(){
        if(type == Type.FLR01 || type == Type.FLR02){
            sprite = animations.get(findAnimation("idle")).getCurrSprite();
        }
    }
    
    public void render( Graphics2D g, int x, int y ){
        g.drawImage(sprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
        if( player != null ){
            player.render( g, x, y );
        }
        if(type == Tile.Type.GRA10 || type == Tile.Type.TRW03 || type == Tile.Type.TRW04 || type == Tile.Type.TRW01 ||
           type == Tile.Type.TRW02 ){
            g.drawImage(topSprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
        }
    }
    
    public boolean containsUser(){
        return this.player != null;
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
            case PAT00:
                x = 27;
                y = 6;
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
            case GRA10:
                x = 9;
                y = 0;
                topSprite = SpriteSheet.getInstance().getSubImage(8, 0);
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
            case TRW01:
                x = 22;
                y = 0;
                topSprite = SpriteSheet.getInstance().getSubImage(22, 3);
                break;
            case TRW02:
                x = 23;
                y = 0;
                topSprite = SpriteSheet.getInstance().getSubImage(23, 3);
                break;
            case TRW03:
                x = 20;
                y = 0;
                topSprite = SpriteSheet.getInstance().getSubImage(22, 1);
                break;
            case TRW04:
                x = 21;
                y = 0;
                topSprite = SpriteSheet.getInstance().getSubImage(23, 1);
                break;
            case TRW05:
                x = 18;
                y = 1;
                break;
            case TRW06:
                x = 19;
                y = 1;
                break;
            case TRW07:
                x = 18;
                y = 2;
                break;
            case TRW08:
                x = 19;
                y = 2;
                break;
            case TRW09:
                x = 20;
                y = 2;
                break;
            case TRW10:
                x = 21;
                y = 2;
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
            case HO201:
                x = 24;
                y = 1;
                break;
            case HO202:
                x = 25;
                y = 1;
                break;
            case HO203:
                x = 26;
                y = 1;
                break;
            case HO204:
                x = 27;
                y = 1;
                break;
            case HO205:
                x = 28;
                y = 1;
                break;
            case HO206:
                x = 29;
                y = 1;
                break;
            case HO207:
                x = 24;
                y = 2;
                break;
            case HO208:
                x = 25;
                y = 2;
                break;
            case HO209:
                x = 26;
                y = 2;
                break;
            case HO210:
                x = 27;
                y = 2;
                break;
            case HO211:
                x = 28;
                y = 2;
                break;
            case HO212:
                x = 29;
                y = 2;
                break;
            case HO213:
                x = 24;
                y = 3;
                break;
            case HO214:
                x = 25;
                y = 3;
                break;
            case HO215:
                x = 26;
                y = 3;
                break;
            case HO216:
                x = 27;
                y = 3;
                break;
            case HO217:
                x = 28;
                y = 3;
                break;
            case HO218:
                x = 29;
                y = 3;
                break;
            case HO219:
                x = 24;
                y = 4;
                break;
            case HO220:
                x = 25;
                y = 4;
                break;
            case HO221:
                x = 26;
                y = 4;
                break;
            case HO222:
                x = 27;
                y = 4;
                break;
            case HO223:
                x = 28;
                y = 4;
                break;
            case HO224:
                x = 29;
                y = 4;
                break;
            case HO225:
                x = 24;
                y = 5;
                break;
            case HO226:
                x = 25;
                y = 5;
                break;
            case HO227:
                x = 26;
                y = 5;
                break;
            case HO228:
                x = 27;
                y = 5;
                break;
            case HO229:
                x = 28;
                y = 5;
                break;
            case HO230:
                x = 29;
                y = 5;
                break;
            case HO301:
                x = 30;
                y = 1;
                break;
            case HO302:
                x = 31;
                y = 1;
                break;
            case HO303:
                x = 32;
                y = 1;
                break;
            case HO304:
                x = 33;
                y = 1;
                break;
            case HO305:
                x = 34;
                y = 1;
                break;
            case HO306:
                x = 30;
                y = 2;
                break;
            case HO307:
                x = 31;
                y = 2;
                break;
            case HO308:
                x = 32;
                y = 2;
                break;
            case HO309:
                x = 33;
                y = 2;
                break;
            case HO310:
                x = 34;
                y = 2;
                break;
            case HO311:
                x = 30;
                y = 3;
                break;
            case HO312:
                x = 31;
                y = 3;
                break;
            case HO313:
                x = 32;
                y = 3;
                break;
            case HO314:
                x = 33;
                y = 3;
                break;
            case HO315:
                x = 34;
                y = 3;
                break;
            case HO316:
                x = 30;
                y = 4;
                break;
            case HO317:
                x = 31;
                y = 4;
                break;
            case HO318:
                x = 32;
                y = 4;
                break;
            case HO319:
                x = 33;
                y = 4;
                break;
            case HO320:
                x = 34;
                y = 4;
                break;
            case HO321:
                x = 30;
                y = 5;
                break;
            case HO322:
                x = 31;
                y = 5;
                break;
            case HO323:
                x = 32;
                y = 5;
                break;
            case HO324:
                x = 33;
                y = 5;
                break;
            case HO325:
                x = 34;
                y = 5;
                break;
            case HO401:
                x = 30;
                y = 9;
                break;
            case HO402:
                x = 32;
                y = 9;
                break;
            case HO403:
                x = 34;
                y = 9;
                break;
            case HO404:
                x = 30;
                y = 10;
                break;
            case HO405:
                x = 32;
                y = 10;
                break;
            case HO406:
                x = 34;
                y = 10;
                break;
            case EBA01:
                x = 21;
                y = 4;
                break;
            case EBA02:
                x = 22;
                y = 4;
                break;
            case EBA03:
                x = 23;
                y = 4;
                break;
            case EBA04:
                x = 22;
                y = 5;
                break;
            case EBA05:
                x = 23;
                y = 5;
                break;
            default:
                x = 0;
                y = 0;
        }
        sprite = SpriteSheet.getInstance().getSubImage( x, y );
    }

    private void loadAnimations(){
        if(type == Type.FLR01){
            ArrayList<BufferedImage> animation = new ArrayList<BufferedImage>();
            BufferedImage idle1 = SpriteSheet.getInstance().getSubImage(10, 0);
            animation.add(idle1);
            BufferedImage idle2 = SpriteSheet.getInstance().getSubImage(11, 0);
            animation.add(idle2);
            Animation idle = new Animation("idle", animation, 1);
            idle.play();
            
            animations.add(idle);
        }else if(type == Type.FLR02){
            ArrayList<BufferedImage> animation = new ArrayList<BufferedImage>();
            BufferedImage idle1 = SpriteSheet.getInstance().getSubImage(13, 0);
            animation.add(idle1);
            BufferedImage idle2 = SpriteSheet.getInstance().getSubImage(14, 0);
            animation.add(idle2);
            Animation idle = new Animation("idle", animation, 1);
            idle.play();
            
            animations.add(idle);
        }
    }
    
    // Determinate walkable
    private boolean determinateWalkable(){
//        if( type == Type.TRG01 || type == Type.TRG02 || type == Type.TRG03 || 
//            type == Type.HO101 || type == Type.HO102 || type == Type.HO103 ||
//            type == Type.HO104 || type == Type.HO105 || type == Type.HO106 ||
//            type == Type.HO107 || type == Type.HO108 || type == Type.HO109 ||
//            type == Type.HO110 || type == Type.HO111 || type == Type.HO112 ){
//            return false;
//        }
//        return true;
        if( type == Type.GRA00 || type == Type.FLR01 || type == Type.FLR02 || type == Type.PAT00 ||
            type == Type.GRA10 || type == Type.TRW01 || type == Type.TRW02 || type == Type.TRW03 ||
            type == Type.TRW04 ){
            return true;
        }
        return false;
    }
    
    private boolean determinatePokemonSpawner(){
        return type == Type.GRA10;
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