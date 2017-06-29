package com.grupox.pokemonv.controller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    /* Enum declaration */
    public enum AUDIO { INTRO, MAP, BEFORE_BATTLE, BATTLE };
    
    /* Attributes */
    private final String mapRoute = "res/sounds/route101.wav";
    private final String battleRoute = "res/sounds/battle.wav";
    private final String introRoute = "res/sounds/intro.wav";
    private final String beforeBattleRoute = "res/sounds/beforeBattle.wav";
    private Clip mapClip;
    private Clip battleClip;
    private Clip introClip;
    private Clip beforeBattleClip;
    private static Sound instance;
    
    /* Constructors */
    private Sound(){
        try {
            AudioInputStream aIn = AudioSystem.getAudioInputStream(new File(mapRoute));
            mapClip = AudioSystem.getClip();
            mapClip.open(aIn);
            
            aIn = AudioSystem.getAudioInputStream(new File(battleRoute));
            battleClip = AudioSystem.getClip();
            battleClip.open(aIn);
            
            aIn = AudioSystem.getAudioInputStream(new File(introRoute));
            introClip = AudioSystem.getClip();
            introClip.open(aIn);
            
            aIn = AudioSystem.getAudioInputStream(new File(beforeBattleRoute));
            beforeBattleClip = AudioSystem.getClip();
            beforeBattleClip.open(aIn);
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
                battleClip.loop(Clip.LOOP_CONTINUOUSLY);
                break;
            case MAP:
                mapClip.loop(Clip.LOOP_CONTINUOUSLY);
                break;
            case INTRO:
                introClip.loop(Clip.LOOP_CONTINUOUSLY);
                break;
            case BEFORE_BATTLE:
                beforeBattleClip.loop(Clip.LOOP_CONTINUOUSLY);
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
            case INTRO:
                introClip.stop();
                break;
            case BEFORE_BATTLE:
                beforeBattleClip.stop();
                beforeBattleClip.setMicrosecondPosition(0);
        }
    }
}
