package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.Font;
import com.grupox.pokemonv.controller.Game;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Dialog {
    /* Attributes */
    private String content;
    private String line1;
    private String line2;
    private static BufferedImage frame;
    
    private static final int spaceBetweenLines = 30;
    private static final int leftOffset = 20;
    
    private static final int padding = spaceBetweenLines;
    private static final int height = Font.fontHeightOut * 2 + spaceBetweenLines + 2 * padding;
    private static final int topOffset = Game.HEIGHT - height - 10;
    private static final int width = Game.WIDTH - 2 * leftOffset;
    
    /* Constructors */
    public Dialog(String content){
        setContent(content);
        
        if( this.frame == null){
            this.frame = SpriteSheet.getInstance().getDialogFrame();
        }
    }
    
    /* Methods */
    public void render( Graphics2D g ){
        g.drawImage(frame, leftOffset, topOffset, width, height, null);
        Font.getInstance().drawString(line1, g, leftOffset + padding, topOffset + padding);
        Font.getInstance().drawString(line2, g, leftOffset + padding, topOffset + padding  + spaceBetweenLines + Font.fontHeightOut);
    }
    
    /* Getters && Setters */
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
        this.line1 = "";
        this.line2 = "";
        boolean line1Full = false;
        for(String word : content.split(" ")){
            if((line1.length() + 1 + word.length()) * Font.fontWidthOut < width - 2 * padding && !line1Full) {
                line1 = line1.concat(" " + word);
            }else if((line2.length() + 1 + word.length()) * Font.fontWidthOut < width - 2 * padding){
                if(!line1Full){
                    line1Full = true;
                }
                line2 = line2.concat(" " + word);
            }
        }
    }
    
}
