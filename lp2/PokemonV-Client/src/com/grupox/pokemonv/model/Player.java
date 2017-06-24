package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.InputHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends User{
    /* Enum declaration */
    public enum NPC_TYPE { MARIA, KEVIN, ASH };
    
    /* Attributes */
    private ArrayList<Pokemon> pokemons;
    private NPC_TYPE npcType;
    private Pokeball pokeballs;
    private Potion potions;
    
    /* Constructors */
    public Player( InputHandler input ){
        super( input );
        
        pokemons = new ArrayList<>();
        
    }
    
    /* Methods */
    public static NPC_TYPE getNpcType(int i){
        NPC_TYPE type = null;
        
        switch (i){
            case 1:
                type = NPC_TYPE.KEVIN;
                break;
            case 2:
                type = NPC_TYPE.MARIA;
                break;
            case 3:
            default:
                type = NPC_TYPE.ASH;
                break;
        }
        return type;
    }
    
    public static int getIndexNpcType(NPC_TYPE type){
        int index = 0;
        switch (type){
            case KEVIN:
                index = 1;
                break;
            case MARIA:
                index = 2;
                break;
            case ASH:
            default:
                index = 3;
                break;
        }
        return index;
    }
    
    /* Getters & Setters */

    public Pokeball getPokeballs() {
        return pokeballs;
    }
    public void setPokeballs(Pokeball pokeballs) {
        this.pokeballs = pokeballs;
    }

    public Potion getPotions() {
        return potions;
    }
    public void setPotions(Potion potions) {
        this.potions = potions;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public NPC_TYPE getNpcType() {
        return npcType;
    }
    public void setNpcType(NPC_TYPE npcType) {
        this.npcType = npcType;
    }
    
}
