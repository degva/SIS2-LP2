package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.model.Tile;
import java.awt.Graphics2D;

public class QuantityMenu extends SingleColumnMenu{
    
    public QuantityMenu(InputHandler input, int topOffset, int rightOffset) {
        super(input, topOffset, rightOffset);
    }

    @Override
    protected int getMaxRows() {
        return items.size() * 2 - 1;    // 2 rows for each item except for "Close" item
    }

    @Override
    protected void drawMenuItems(Graphics2D g) {
        int x = leftOffset + Tile.spriteWidthOut, y = topOffset + Tile.spriteHeightOut;
        for( int i = 0; i < items.size(); i++, y += Tile.spriteHeightOut * 2){
            items.get( i ).render( g, x, y );
        }
    }
}
