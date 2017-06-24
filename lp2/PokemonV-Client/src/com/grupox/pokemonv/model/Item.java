package com.grupox.pokemonv.model;

public abstract class Item {
    /* Attributes */
    protected String name;
    protected int quantity;
    
    /* Constructor */
    public Item(int quantity){
        this.quantity = quantity;
    }
    
    /* Getters && Setters */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
