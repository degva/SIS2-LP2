package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.model.Player;

public class BagMenu extends QuantityMenu {
    
    /* Attributes */
    private Game game;
    private Player player;
    
    /* Constructors */
    public BagMenu( Player player, int topOffset, int rightOffset, Game game ) {
        super( player.getInput(), topOffset, rightOffset );
        
        this.player = player;
        this.game = game;
        
        this.addItem( player.getPokeballs().getName(), player.getPokeballs().getQuantity() );
        this.addItem( player.getPotions().getName(), player.getPotions().getQuantity());
        this.addItem( "Close" );
    }
    
    /* Methods */
    @Override
    public void tick(){
        super.tick();
        
        if( Game.getState() == Game.State.MAP ){
            if( input.action.isFirstPressed && !items.isEmpty() ){
                if( items.get( selectedIndex ).getDescription().equals( "Close" ) ){
                    game.setState( Game.State.MAP );
                }
            }else if ( input.back.isFirstPressed ){
                game.setState( Game.State.MAP );
            }
        }else if( Game.getState() == Game.State.BATTLE ){
            // Go get them Kevin
            // game.getBattleManager().usePotion()
            // player.getPotions().setQuantity(getQuantity()--)
        }
    }
}
