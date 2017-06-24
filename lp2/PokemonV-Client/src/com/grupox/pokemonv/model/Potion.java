package com.grupox.pokemonv.model;

public class Potion extends Item{
    /* Attributes */
    private int hp;

    /* Constructors */
    public Potion(int hp, int quantity){
        super(quantity);
        this.hp = hp;
        this.name = "Potion";
    }
    
    /* Getters && Setters */
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}