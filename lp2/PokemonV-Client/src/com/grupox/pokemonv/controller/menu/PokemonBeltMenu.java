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
import com.grupox.pokemonv.controller.manager.PokemonBeltManager;
import com.grupox.pokemonv.controller.manager.PokemonBelt;
import com.grupox.pokemonv.controller.reporte;

/**
 *
 * @author alulab14
 */
public class PokemonBeltMenu extends SingleColumnMenu{
    private final int cancelIndex,ExchangeIndex, closeIndex, Report1Index,Report2Index;   // Variables to hold MenuItems indexs
    private Game game;  // Needed to change state when an option is selected
    private int vez = 0;


    public PokemonBeltMenu(InputHandler input, int topOffset, int rightOffset, Game game ) {
        super(input, topOffset, rightOffset);
        
        this.game = game;
        cancelIndex = this.addItem("Cancel");
        ExchangeIndex = this.addItem("Exchange");
        closeIndex = this.addItem("Back to Menu");
        Report1Index = this.addItem("Report1");
        Report2Index = this.addItem("Report2");
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
            }else if(selectedIndex == ExchangeIndex){
                if(vez == 0){
                    PokemonBeltManager.indiceA = PokemonBeltManager.ind;
                    PokemonBeltManager.presionadoF = false;
                    vez ++;
                }
                else{
                    PokemonBeltManager.indiceB = PokemonBeltManager.ind;
                    PokemonBeltManager.presionadoF = false;
                    vez ++;
                }
            }
            else if(selectedIndex == Report1Index){
                reporte rep = new reporte();
                rep.verReporte();
            }
            else if(selectedIndex == Report2Index){
                reporte rep = new reporte();
                rep.verReporte2();
            }
        }
    }
    
    public int getVez() {
        return vez;
    }

    public void setVez(int vez) {
        this.vez = vez;
    }
    
}
