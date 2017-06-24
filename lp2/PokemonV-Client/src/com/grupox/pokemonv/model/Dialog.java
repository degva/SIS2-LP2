package com.grupox.pokemonv.model;

import java.awt.image.BufferedImage;

public class Dialog {
    /* Attributes */
    private String content;
    private BufferedImage sprite;
    private final int topOffset = 600;
    
    /* Constructors */
    public Dialog(String content){
        this.content = content;
    }
    
    /* Getters && Setters */
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
}
