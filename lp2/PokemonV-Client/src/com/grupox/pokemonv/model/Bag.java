
package com.grupox.pokemonv.model;

import java.util.ArrayList;


public class Bag {
    private ArrayList<Potion> potionsFromBag;
    private ArrayList<Pokeball> pokeballsFromBag;

    public Bag() {
        potionsFromBag = new ArrayList<Potion>();
        pokeballsFromBag = new ArrayList<Pokeball>();
    }
    public void insertPotion(Potion p){
        potionsFromBag.add(p);
    }
    public void insertPokeball(Pokeball p){
        pokeballsFromBag.add(p);
    }

    public ArrayList<Potion> getPotionsFromBag() {
        return potionsFromBag;
    }

    public void setPotionsFromBag(ArrayList<Potion> potionsFromBag) {
        this.potionsFromBag = potionsFromBag;
    }

    public ArrayList<Pokeball> getPokeballsFromBag() {
        return pokeballsFromBag;
    }

    public void setPokeballsFromBag(ArrayList<Pokeball> pokeballsFromBag) {
        this.pokeballsFromBag = pokeballsFromBag;
    }
    
    
}
