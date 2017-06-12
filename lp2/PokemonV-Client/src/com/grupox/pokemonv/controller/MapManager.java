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
    
    private MapMenu menu;
    private State state;
    
    /* Constructors */
    public MapManager( User user ){
        this.user = user;
        input = user.getInput();
        
        map = new Map();
        
        Tile tile = map.getGrid()[0][0];    // Initial position of user - test only
        tile.setUser( user );
        user.setTile( tile );
        
        menu = new MapMenu( input, 20, Game.WIDTH / 80, this );
        state = State.MOVING;
    }
    
    /* Methods */
    public void tick(){
        
        // Listen to input and set the inner state
        if( state == State.MOVING && input.menu.isFirstPressed ){
            // Set first element as selected
            menu.getItems().get( menu.getSelectedIndex() ).isSelected = false;
            menu.getItems().get( 0 ).isSelected = true;
            menu.setSelectedIndex( 0 );
            
            state = State.MENU;
        }else if( state == State.MENU && ( input.back.isFirstPressed || input.menu.isFirstPressed) ){
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
    
    /* Getters && Setters */

    public State getState() {
        return state;
    }
    public void setState( State state ) {
        this.state = state;
    }
    
}
