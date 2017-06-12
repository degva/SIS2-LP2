package com.grupox.pokemonv.controller;

public class MapMenu extends SingleColumnMenu{
    private final int pokemonIndex, bagIndex, closeIndex;   // Variables to hold MenuItems indexs
    private Game game;  // Needed to change state when an option is selected
    
    public MapMenu(InputHandler input, int topOffset, int rightOffset, Game game ) {
        super(input, topOffset, rightOffset);
        
        this.game = game;
        
        pokemonIndex = this.addItem("Pokemon");
        bagIndex = this.addItem("Bag");
        closeIndex = this.addItem("Close");
    }
    
    @Override
    public void tick(){
        super.tick();
        
        if ( input.action.isFirstPressed && items.size() != 0){
            if ( selectedIndex == pokemonIndex ){
                // @TODO
            }else if( selectedIndex == bagIndex ){
                game.getBagManager().setState( BagManager.State.POKEBALLS );
                game.getBagManager().getBagMenu().setSelectedItem( 0 );
                game.setState( Game.State.BAG );
            }else if( selectedIndex == closeIndex ){
                game.getMapManager().setState( MapManager.State.MOVING );
            }
        }
    }
    
    
    
}
