package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.SpriteSheet;
import com.grupox.pokemonv.model.Tile;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Font {
    /* Attributes */
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ  " +
                                           "0123456789.,!?'\"-+=/\\%()<>:;";
    private static final int lastChar = alphabet.indexOf(' ') + 1;  // Second ' '
    private static Font instance;
    
    public static final int fontWidthOut = Tile.spriteWidthOut / 4;
    public static final int fontHeightOut = Tile.spriteHeightOut * 3 / 4;
    
    /* Constructors */
    private Font(){
    }
    
    /* Methods */
    public static Font getInstance(){
        if( instance == null ){
            instance = new Font();
        }
        return instance;
    }
    
    // X and Y in tiles
    public void drawStringInsideTile( String msg, Graphics2D g, int x, int y ){
        drawString( msg, g, x * Tile.spriteWidthOut, y * Tile.spriteHeightOut );
    }
    
    // X and Y in pixels
    public void drawString( String msg, Graphics2D g, int x, int y ){
        msg = msg.toUpperCase();
        int ix, row;
        
        for( int i = 0; i < msg.length(); i++ ){
            // Get the x position in the spritesheet of the message's i char
            ix = alphabet.indexOf( msg.charAt( i ) );
            
            // Determine whether the char is in the first or second row
            row = ix > lastChar ? 1 : 0;
            // If the char is in the second row, update the x pos
            ix = row == 0 ? ix : ix - lastChar - 1;
            
            // Get and draw the fontSprite
            BufferedImage fontSprite = SpriteSheet.getInstance().getSubFont(ix, row);
            g.drawImage(fontSprite, x + i * fontWidthOut, y, fontWidthOut, fontHeightOut, null );
        }
    }
}
