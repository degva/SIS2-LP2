package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.manager.BagManager;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.MapManager;

public class MapMenu extends SingleColumnMenu{
    private Game game;  // Needed to change state when an option is selected
    
    public MapMenu(InputHandler input, int topOffset, int rightOffset, Game game ) {
        super(input, topOffset, rightOffset);
        
        this.game = game;
        
        this.addItem("Pokemon");
        this.addItem("Bag");
        this.addItem("Close");
    }
    
    @Override
    public void tick(){
        super.tick();
        
        if ( input.action.isFirstPressed && !items.isEmpty() ){
            if ( items.get( selectedIndex ).getDescription().equals( "Pokemon" ) ){
                // @TODO
            }else if( items.get( selectedIndex ).getDescription().equals( "Bag" ) ){
                game.getBagManager().setState( BagManager.State.POKEBALLS );
                game.getBagManager().getBagMenu().setSelectedItem( 0 );
                game.setState( Game.State.BAG );
            }else if( items.get( selectedIndex ).getDescription().equals( "Close" ) ){
                game.getMapManager().setState( MapManager.State.MOVING );
            }
        }
    }
    
    
    
}
