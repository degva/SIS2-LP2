package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.SpriteSheet;
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
    
    // No need to pass where to draw (final variables defined at the start will calculate the final position)
    public abstract void render( Graphics2D g );
    
    protected abstract int getWidthInTiles();
    
    protected abstract int calculateLeftOffset();
    
    // Returns the index
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
    
    // Gets the length of the menuItem's longest description
    protected int getMaxLen(){
        int maxLen = 0;
        for( int i = 0; i < items.size(); i++ ){
            if( items.get( i ).description.length() > maxLen ){
                maxLen = items.get( i ).description.length();
            }
        }
        return maxLen;
    }
    
    /* Getters & Setters */
    public int getSelectedIndex() {
        return selectedIndex;
    }
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
