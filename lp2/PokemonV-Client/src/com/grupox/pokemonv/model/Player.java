package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.InputHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends User{
    /* Attributes */
    private int experience;
    private int level;
    
    /* Constructors */
    public Player( InputHandler input ){
        super( input );
        
        this.sprite = SpriteSheet.getInstance().getSubImage( 0, 0 );
        
        experience = 0;
        level = 0;
    }
    
    /* Methods */
    
    /*
    catchPokemon()
    catchItem()
    requestBattle()
    acceptBattle()
    isInBattle()
    */
    
    /* Getters & Setters */

    public int getExperience() {
        return experience;
    }
    public void setExperience( int experience ) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel( int level ) {
        this.level = level;
    }
}
