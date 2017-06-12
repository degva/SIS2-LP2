package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.SpriteSheet;
import com.grupox.pokemonv.model.Tile;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Menu {
    /* Attributes */
    private InputHandler input;
    private ArrayList<MenuItem> items;
    private int selectedIndex;
    private BufferedImage[] borders;
    
    private final int topOffset = 20;   // px
    private final int rightOffset = Game.WIDTH / 80; // Margin that will be left at the right in px
    private int leftOffset;
    
    /* Constructors */
    public Menu( InputHandler input ){
        this.input = input;
        
        // Boards
        loadBorders();
        
        // Menu items
        items = new ArrayList<>();
        items.add( new MenuItem( "Pokemons" ) );
        items.add( new MenuItem( "Bag" ) );
        items.add( new MenuItem( "Exit" ) );
        items.get( 0 ).isSelected = true;
        
        selectedIndex = 0;
        
        calculateLeftOffset();
    }
    
    /* Methods */
    public void tick(){
        if ( input.action.isFirstPressed ){
            // @TODO
        }else if ( input.up.isFirstPressed && selectedIndex > 0){
            items.get( selectedIndex-- ).isSelected = false;
            items.get( selectedIndex ).isSelected = true;
        }else if ( input.down.isFirstPressed && selectedIndex < items.size() - 1){
            items.get( selectedIndex++ ).isSelected = false;
            items.get( selectedIndex ).isSelected = true;
        }
    }
    
    // No need to pass where to draw (final variables defined at the start will calculate the final position)
    public void render( Graphics2D g ){
        drawBorders( g );

        drawMenuItems( g );
    }
    
    private void loadBorders(){
        borders = new BufferedImage[9];
        borders[0] = SpriteSheet.getInstance().getSubImage(15, 22);
        borders[1] = SpriteSheet.getInstance().getSubImage(16, 22);
        borders[2] = SpriteSheet.getInstance().getSubImage(17, 22);
        
        borders[3] = SpriteSheet.getInstance().getSubImage(15, 23);
        borders[4] = SpriteSheet.getInstance().getSubImage(16, 23);
        borders[5] = SpriteSheet.getInstance().getSubImage(17, 23);
        
        borders[6] = SpriteSheet.getInstance().getSubImage(15, 24);
        borders[7] = SpriteSheet.getInstance().getSubImage(16, 24);
        borders[8] = SpriteSheet.getInstance().getSubImage(17, 24);
    }
    
    private void drawBorders( Graphics2D g  ){
        int widthInTiles = getWidthInTiles();
        
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
    
    private void calculateLeftOffset(){
        int widthInTiles = getWidthInTiles();
        
        leftOffset = Game.WIDTH - rightOffset - ( 2 + widthInTiles ) * Tile.spriteWidthOut;
    }
    
    // Gets the length of the menuItem's longest description
    private int getMaxLen(){
        int maxLen = -1;
        for( int i = 0; i < items.size(); i++ ){
            if( items.get( i ).description.length() > maxLen ) maxLen = items.get( i ).description.length();
        }
        return maxLen;
    }
    
    // Gets the number of tiles needed to contain the maxLen
    private int getWidthInTiles(){
        int maxLen = getMaxLen();
        return (int)Math.floor( 1.0 * maxLen * Font.fontWidthOut / Tile.spriteWidthOut);
    }
    

    public int getSelectedIndex() {
        return selectedIndex;
    }

    /* Getters & Setters */
    public void setSelectedIndex( int selectedIndex ) {
        this.selectedIndex = selectedIndex;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
    public void setItems( ArrayList<MenuItem> items ) {
        this.items = items;
    }
    
    
}
