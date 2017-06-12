package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Tile;

public class MapMenu extends SingleColumnMenu{
    private final int pokemonIndex, bagIndex, closeIndex;
    private MapManager mapManager;  // Needed to change state when "Close" option is selected
    
    public MapMenu(InputHandler input, int topOffset, int rightOffset, MapManager mapManager ) {
        super(input, topOffset, rightOffset);
        
        this.mapManager = mapManager;
        
        pokemonIndex = this.addItem("Pokemon");
        bagIndex = this.addItem("Bag");
        closeIndex = this.addItem("Close");
    }
    
    @Override
    public void tick(){
        super.tick();
        
        if ( input.action.isFirstPressed && items.size() != 0){
            if ( getSelectedIndex() == pokemonIndex ){
                // @TODO
            }else if( getSelectedIndex() == bagIndex ){
                // @TODO
            }else if( getSelectedIndex() == closeIndex ){
                mapManager.setState( MapManager.State.MOVING );
            }
        }
    }
    
    
    
}
