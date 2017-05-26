package com.grupox.pokemonv.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

// Singleton
public class SpriteSheet {
    /* Attributes */
    private static SpriteSheet instance;
    
    private BufferedImage spriteSheet;
    private final String route = "res/sprites/sheet.png";
    private final int spriteWidth = 16; // Width of each sprite in the sheet
    private final int spriteHeight = 16;    // Height of each sprite in the sheet
    
    /* Constructors */
    private SpriteSheet(){
        // ImageIO could case IOException
        try {
            spriteSheet = ImageIO.read( new File( route ) );
        } catch ( IOException ex ) {
            Logger.getLogger( SpriteSheet.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }
    
    /* Methods */
    public static SpriteSheet getInstance(){
        if( instance == null ){
            instance = new SpriteSheet();
        }
        return instance;
    }
    
    // Get a subImage from the sprite sheet. Give x,y in the spritesheet( 0, 1, 2...) and get the img
    public BufferedImage getSubImage( int x, int y ){
        return spriteSheet.getSubimage( 1 + ( spriteWidth + 1 ) * x, 1 + ( spriteHeight + 1 )* y, spriteWidth, spriteHeight );
    }

}
