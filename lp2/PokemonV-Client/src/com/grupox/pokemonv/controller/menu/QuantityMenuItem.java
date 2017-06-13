package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Font;
import java.awt.Graphics2D;

public class QuantityMenuItem extends MenuItem{
    /* Attributes */
    private int quantity;
    
    /* Constructors */
    public QuantityMenuItem(String description, int quantity) {
        super(description);
        
        this.quantity = quantity;
    }
    
    /* Methods */

    /**
     * X and Y in pixels. NOTE: Its menu should override "getMaxRows" and "drawItems" in order to work accordingly.
     */
    public void render(Graphics2D g, int x, int y) {
        if( isSelected ){
            Font.getInstance().drawString(">" + description, g, x, y);
        }else{
            Font.getInstance().drawString(" " + description, g, x, y);
        }
        if(quantity != -1){ // quantity == -1 means that that item should not display its quantity
            Font.getInstance().drawString(" x" + String.format("%02d", quantity), g, x + (longestDescrip - 4) * Font.fontWidthOut, y + Font.fontHeightOut);
        }
    }
    
    /* Getters && Setters */

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }
    
    
}
