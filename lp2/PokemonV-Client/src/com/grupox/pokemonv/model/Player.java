package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.InputHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends User{
    /* Attributes */
    private int experience;
    private int level;
    private ArrayList<Pokemon> pokemons;
    
    /* Constructors */
    public Player( InputHandler input ){
        super( input );
        
        pokemons = new ArrayList<>();
        
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

    //letura de pokemones
    public void setPokemnons(){
        //pokemons = ;
    }
    
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
    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
}
