package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Font;
import java.awt.Graphics2D;

public class MenuItem {
    /* Attributes */
    public boolean isSelected;
    protected String description;
    protected int longestDescrip;   // Longest description in the menu

    /* Constructors */
    public MenuItem( String description ){
        this.description = description;
        this.longestDescrip = 0;
    }
    
    /* Methods */
    /**
     * X and Y in pixels
     */
    public void render( Graphics2D g, int x, int y ){
        if( isSelected ){
            Font.getInstance().drawString(">" + description, g, x, y);
        }else{
            Font.getInstance().drawString(" " + description, g, x, y);
        }
    }
    
    /**
     * Returns the length of the item.
     */
    public int length(){
        //It adds +1 to consider the '>' symbol.
        return 1 + description.length();
    }
    
    /* Getters && Setters */
    public String getDescription() {
        return description;
    }

    public int getLongestDescrip() {
        return longestDescrip;
    }
    public void setLongestDescrip( int longestDescrip ) {
        this.longestDescrip = longestDescrip;
    }
    
}
