package com.grupox.pokemonv.controller;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
    /* Attributes */
    private String name;
    private double period;
    private ArrayList<BufferedImage> sprites;
    private boolean isPlaying;
    
    private double last, now, elapsed;
    private int index;
    
    /* Constructors */
    public Animation( String name, ArrayList<BufferedImage> sprites, double period ){
        this.name = name;
        this.sprites = sprites;
        this.period = period;
        index = 0;
        isPlaying = false;
    }
    
    /* Methods */
    public void play(){
//        System.out.println("PLAY");
        index = 0;
        last = System.nanoTime();
//        isPlaying = true;
        elapsed = 0;
    }
    
    public void stop(){
//        System.out.println("STOP");
//        isPlaying = false;
        index = 0;  // First sprite
    }
    
    public BufferedImage getCurrSprite(){
        
        now = System.nanoTime();
        if( now - last >= period * 1000000000/* && isPlaying*/){
            index = ++index % sprites.size();
            last = now;
        }
        return sprites.get( index );
    }
    
    public void addSprite( BufferedImage sprite ){
        sprites.add( sprite );
    }
    
    /* Getters && Setters */
    public double getPeriod() {
        return period;
    }
    public void setPeriod( double period ) {
        this.period = period;
    }

    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }   
}
