package com.grupox.pokemonv.controller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    /* Enum declaration */
    public enum AUDIO { MAP, BATTLE };
    
    /* Attributes */
    private final String mapRoute = "res/sounds/route101.wav";
    private final String battleRoute = "res/sounds/battle.wav";
    private Clip mapClip;
    private Clip battleClip;
    private static Sound instance;
    
    /* Constructors */
    private Sound(){
        try {
            AudioInputStream aIn = AudioSystem.getAudioInputStream(new File(mapRoute));
            mapClip = AudioSystem.getClip();
            mapClip.open(aIn);
            mapClip.setLoopPoints(0, -1);
            
            aIn = AudioSystem.getAudioInputStream(new File(battleRoute));
            battleClip = AudioSystem.getClip();
            battleClip.open(aIn);
            battleClip.setLoopPoints(0, -1);
        } catch (Exception ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /* Methods */
    public static Sound getInstance(){
        if(instance == null){
            instance = new Sound();
        }
        return instance;
    }
    
    public void start(AUDIO audio){
        switch(audio){
            case BATTLE:
                battleClip.start();
                break;
            case MAP:
                mapClip.start();
                break;
        }
    }
    
    public void stop(AUDIO audio){
        switch(audio){
            case BATTLE:
                battleClip.stop();
                battleClip.setMicrosecondPosition(0);
                break;
            case MAP:
                mapClip.stop();
                mapClip.setMicrosecondPosition(0);
                break;
        }
    }
}
