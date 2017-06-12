package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.SpriteSheet;
import com.grupox.pokemonv.model.Tile;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Menu {
    /* Attributes */
    protected InputHandler input;
    protected ArrayList<MenuItem> items;
    protected int selectedIndex;
    protected BufferedImage[] borders;
    
    protected int topOffset;
    protected int rightOffset;
    protected int leftOffset;
    protected int widthInTiles;
    
    /* Constructors */
    public Menu( InputHandler input, int topOffset, int rightOffset ){
        this.input = input;
        this.topOffset = topOffset;
        this.rightOffset = rightOffset;
        
        loadBorders();
        
        // Menu items
        items = new ArrayList<>();        
        selectedIndex = -1; // Initially, no option is select (could be the case that there is an empty menu)
    }
    
    /* Methods */
    public abstract void tick();
    
    /**
     * Draws the menu items inside the border. Its width should be approximately as the one stated in getWithInTiles
     */
    protected abstract void drawMenuItems( Graphics2D g );
    
    /**
     * Gets the length, in characters, of the longest row
     */
    protected abstract int getMaxLen();
    
    /**
     * Gets the number of rows.
     */
    protected abstract int getMaxRows();
    
    /**
     * No need to pass where to draw (final variables defined at the start will calculate the final position)
     * DrawBorders will only work if getWidthInTiles is implemented properly. drawMenuItems should span exactly 'getWidthInTiles' tiles
     */
    public void render( Graphics2D g ){
        drawBorders( g );
        
        drawMenuItems( g );
    }
    
    /**
     * Adds an item and returns its index
     */
    public int addItem( String description ){
        items.add( new MenuItem( description ) );
        if(selectedIndex == -1){
            selectedIndex = 0;
            items.get( selectedIndex ).isSelected = true;
        }
        // Update menu widths
        widthInTiles = getWidthInTiles();
        leftOffset = calculateLeftOffset();
        
        return items.size() - 1;
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
    
    private void drawBorders( Graphics2D g ){
        
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
        for(int i = 0; i < getMaxRows(); i++ ){
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
        localTopOffset = topOffset + ( 1 + getMaxRows() ) * Tile.spriteHeightOut;
        g.drawImage( borders[6], leftOffset, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        
        // Middle
        for( int i = 0; i < widthInTiles ; i++ ){
            g.drawImage( borders[7], leftOffset + ( 1 + i ) * Tile.spriteWidthOut, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
        }
        
        // Right
        g.drawImage( borders[8], leftOffset + ( 1 + widthInTiles ) * Tile.spriteWidthOut, localTopOffset, Tile.spriteWidthOut, Tile.spriteHeightOut, null );
    }
    
    /**
     * Gets the number of tiles needed to cover the width, not considering the left and right border.
     */
    private int getWidthInTiles(){
        return (int)Math.ceil( 1.0 * getMaxLen() * Font.fontWidthOut / Tile.spriteWidthOut);    // Ceil or floor

    }
    
    private int calculateLeftOffset(){
        return Game.WIDTH - rightOffset - ( 2 + widthInTiles ) * Tile.spriteWidthOut;
    }

    /**
     * Sets the selectedIndex item to selected. It also deselects the old selectedIndex item.
     */
    public void setSelectedItem( int selectedIndex ) {
        items.get( this.selectedIndex ).isSelected = false;
        items.get( selectedIndex ).isSelected = true;
        this.selectedIndex = selectedIndex;
    }    
    
    /* Getters & Setters */
    public ArrayList<MenuItem> getItems() {
        return items;
    }
    public void setItems( ArrayList<MenuItem> items ) {
        this.items = items;
    }
}
