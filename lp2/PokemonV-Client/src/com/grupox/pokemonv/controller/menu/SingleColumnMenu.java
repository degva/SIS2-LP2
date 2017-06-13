package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.menu.Menu;
import com.grupox.pokemonv.model.Tile;
import java.awt.Graphics2D;

public abstract class SingleColumnMenu extends Menu{
    /* Attributes */
    
    /* Constructors */
    public SingleColumnMenu( InputHandler input, int topOffset, int rightOffset ){
        super( input, topOffset, rightOffset );
    }
    
    /* Methods */
    @Override
    public void tick(){
        if ( input.up.isFirstPressed && selectedIndex > 0){
            items.get( selectedIndex-- ).isSelected = false;
            items.get( selectedIndex ).isSelected = true;
        }else if ( input.down.isFirstPressed && selectedIndex < items.size() - 1){
            items.get( selectedIndex++ ).isSelected = false;
            items.get( selectedIndex ).isSelected = true;
        }
    }

    @Override
    protected void drawMenuItems( Graphics2D g ){
        int x = leftOffset + Tile.spriteWidthOut, y = topOffset + Tile.spriteHeightOut;
        for( int i = 0; i < items.size(); i++, y += Tile.spriteHeightOut ){
            items.get( i ).render( g, x, y );
        }
    }
    
    @Override
    protected int getMaxLen(){
        int maxLen = 0;
        for( int i = 0; i < items.size(); i++ ){
            if( items.get( i ).description.length() > maxLen ){
                maxLen = items.get( i ).description.length();
            }
        }
        return maxLen;
    }
    
    @Override
    protected int getMaxRows(){
        return items.size();
    }
}
