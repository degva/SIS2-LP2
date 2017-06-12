package com.grupox.pokemonv.controller;

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
    public void render( Graphics2D g ){
        drawBorders( g );

        drawMenuItems( g );
    }
    
    // Gets the number of tiles needed to cover the longest description
    @Override
    protected int getWidthInTiles(){
        return (int)Math.ceil( 1.0 * getMaxLen() * Font.fontWidthOut / Tile.spriteWidthOut);    // Ceil or floor
    }
    
    @Override
    protected int calculateLeftOffset(){
        return Game.WIDTH - rightOffset - ( 2 + widthInTiles) * Tile.spriteWidthOut;
    }
    
    private void drawBorders( Graphics2D g  ){
        //int widthInTiles = getWidthInTiles();
        
        /* Draw top border */
        // Left
        g.drawImage( borders[0], leftOffset, topOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        
        // Middle
        for( int i = 0; i < widthInTiles ; i++ ){
            g.drawImage( borders[1], leftOffset + ( 1 + i ) * Tile.spriteWidthOut, topOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        }
        
        // Right
        g.drawImage( borders[2], leftOffset + ( 1 + widthInTiles ) * Tile.spriteWidthOut, topOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        
        /* Draw body */
        int localTopOffset;
        for(int i = 0; i < items.size(); i++ ){
            localTopOffset = topOffset +  (1 + i ) * Tile.spriteHeightOut;
            // Left
            g.drawImage( borders[3], leftOffset, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
            
            // Middle
            g.drawImage( borders[4], leftOffset + Tile.spriteWidthOut, localTopOffset, Tile.spriteWidthOut * widthInTiles, Tile.spriteHeightOut, null );
            
            // Right
            g.drawImage( borders[5], leftOffset + Tile.spriteWidthOut * ( widthInTiles + 1 ), localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        }
        
        /* Draw bottom */
        // Left
        localTopOffset = topOffset + ( 1 + items.size() ) * Tile.spriteHeightOut;
        g.drawImage( borders[6], leftOffset, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        
        // Middle
        for( int i = 0; i < widthInTiles ; i++ ){
            g.drawImage( borders[7], leftOffset + ( 1 + i ) * Tile.spriteWidthOut, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        }
        
        // Right
        g.drawImage( borders[8], leftOffset + ( 1 + widthInTiles ) * Tile.spriteWidthOut, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
    }
    
    private void drawMenuItems( Graphics2D g ){
        int x = leftOffset + Tile.spriteWidthOut, y = topOffset + Tile.spriteHeightOut;
        for( int i = 0; i < items.size(); i++, y += Tile.spriteHeightOut ){
            items.get( i ).render( g, x, y );
        }
    }
}
