package com.grupox.pokemonv.model;

public class Attack {
    /* Attributes */
    private String name;
    private int points;
    
    /* Constructors */
    public Attack(){
        name = null;
        points = 0;
    }
    
    public Attack(String name, int points){
        this.name = name;
        this.points = points;
    }
    
    /* Getters && Setters */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    
}
