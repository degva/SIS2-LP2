package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Player;
import java.awt.Color;
import java.awt.Graphics2D;

public class BagManager {
    /* Enum declaration */
    public enum State { POKEBALLS, POTIONS, REPELENTS};
    
    /* Attributes */
    private State state;
    private Player player;
    private BagMenu bagMenu;
    
    /* Constructors */
    public BagManager( Player player, Game game ){
        state = State.POKEBALLS;
        
        this.player = player;
        
        bagMenu = new BagMenu(player, 50, Game.WIDTH / 8, game);
    }
    
    /* Methods */
    public void tick(){
        bagMenu.tick();
    }
    
    public void render( Graphics2D g ){
        bagMenu.render( g );
    }
    
    /* Getters && Setters */

    public State getState() {
        return state;
    }
    public void setState( State state ) {
        this.state = state;
    }

    public BagMenu getBagMenu() {
        return bagMenu;
    }
    public void setBagMenu( BagMenu bagMenu ) {
        this.bagMenu = bagMenu;
    }
    
    
}
