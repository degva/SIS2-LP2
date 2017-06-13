package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Font;
import com.sun.org.glassfish.gmbal.Description;
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
    @Override
    /**
     * Returns the length of the item.
     */
    public int length() {
        return 1 + description.length() + 4;    // Adds +4 for " x01" string
    }

    @Override
    /**
     * X and Y in pixels
     */
    public void render(Graphics2D g, int x, int y) {
        if( isSelected ){
            Font.getInstance().drawString(">" + description + " x" + String.format("%02d", quantity), g, x, y);
        }else{
            Font.getInstance().drawString(" " + description + " x" + String.format("%02d", quantity), g, x, y);
        }
    }
    
}
