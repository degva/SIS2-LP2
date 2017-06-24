package com.grupox.pokemonv.model;

public class Pokeball extends Item{
    /* Attributes */
    private float catchProb;
    
    /* Constructors */
    public Pokeball(float catchProb, int quantity){
        super(quantity);
        this.catchProb = catchProb;
        this.name = "Pokeball";
    }
}