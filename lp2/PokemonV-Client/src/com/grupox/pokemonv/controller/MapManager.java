package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Tile;
import com.grupox.pokemonv.model.User;
import java.awt.Graphics2D;

public class MapManager {
    /* Enum declaration */
    public enum State { MENU, MOVING };
    
    /* Attributes */
    private Map map;
    private User user;
    private InputHandler input;
    
    private Menu menu;
    private State state;
    
    /* Constructors */
    public MapManager( User user ){
        this.user = user;
        input = user.getInput();
        
        map = new Map();
        
        Tile tile = map.getGrid()[0][0];    // Initial position of user - test only
        tile.setUser( user );
        user.setTile( tile );
        
        menu = new Menu( input );
        state = State.MOVING;
    }
    
    /* Methods */
    public void tick(){
        
        // Listen to input and set the inner state
        if( input.menu.isFirstPressed && state == State.MOVING ){
            // Set first element as selected
            menu.getItems()[menu.getSelectedIndex()].isSelected = false;
            menu.getItems()[0].isSelected = true;
            menu.setSelectedIndex( 0 );
            
            state = State.MENU;
        }else if( ( input.back.isFirstPressed || input.menu.isFirstPressed) && state == State.MENU ){
            state = State.MOVING;
        }
        
        // Tick according to state
        switch ( state ){
            case MENU:
                menu.tick();
                break;
            case MOVING:
                user.tick();
                break;
        }
    }
    
    public void render( Graphics2D g){
        map.render( g, user );
        
        if( state == State.MENU ){
            menu.render(g);
        }
    }
}
