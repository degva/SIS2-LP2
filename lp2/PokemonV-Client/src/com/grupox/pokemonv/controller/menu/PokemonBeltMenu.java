/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.manager.BagManager;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.MapManager;
import com.grupox.pokemonv.controller.menu.SingleColumnMenu;
import com.grupox.pokemonv.controller.PokemonBeltManager;

/**
 *
 * @author alulab14
 */
public class PokemonBeltMenu extends SingleColumnMenu{
    private final int cancelIndex, closeIndex;   // Variables to hold MenuItems indexs
    private Game game;  // Needed to change state when an option is selected
    
    public PokemonBeltMenu(InputHandler input, int topOffset, int rightOffset, Game game ) {
        super(input, topOffset, rightOffset);
        
        this.game = game;
        
        cancelIndex = this.addItem("Cancel");
        closeIndex = this.addItem("Accept");
    }
    
    @Override
    public void tick(){
        super.tick();
        
        if ( input.action.isFirstPressed && items.size() != 0){
            if ( selectedIndex == cancelIndex ){
                // @TODO aqui entra lo mio!
                PokemonBeltManager.presionadoF = false;
            }else if( selectedIndex == closeIndex ){
                PokemonBeltManager.presionadoF = false;
                game.setState( Game.State.MAP );
            }
        }
    }
}
