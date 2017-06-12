package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Player;

public class BagMenu extends SingleColumnMenu {
    
    /* Attributes */
    private Game game;
    private Player player;
    
    private final int closeIndex;
    
    /* Constructors */
    public BagMenu( Player player, int topOffset, int rightOffset, Game game ) {
        super( player.getInput(), topOffset, rightOffset );
        
        this.player = player;
        this.game = game;
        
        this.addItem( "Pokeball" );
        closeIndex = this.addItem( "Close" );
    }
    
    /* Methods */
    public void tick(){
        super.tick();
        
        if( input.action.isFirstPressed && this.selectedIndex > -1){
            if( selectedIndex == closeIndex){
                game.setState( Game.State.MAP );
            }
        }
    }
}
