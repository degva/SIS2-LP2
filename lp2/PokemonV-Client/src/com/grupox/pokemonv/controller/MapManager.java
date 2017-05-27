package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Tile;
import com.grupox.pokemonv.model.User;
import java.awt.Graphics2D;

public class MapManager {
    /* Attributes */
    private Map map;
    private User user;
    private InputHandler input;
    
    /* Constructors */
    public MapManager( User user ){
        this.user = user;
        input = user.getInput();
        
        map = new Map();
        
        Tile tile = map.getGrid()[0][0];    // Initial position of user - test only
        tile.setUser( user );
        user.setTile( tile );
    }
    
    /* Methods */
    public void tick(){
        user.tick();
    }
    
    public void render( Graphics2D g){
        map.render( g, user );
    }
}
