package com.grupox.pokemonv.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputHandler implements KeyListener{

    /* Inner class */
    public class Key{
        /* Attributes */
        public boolean isPressed;
        public boolean isFirstPressed;   // First time it is pressed. Useful for menus
        private boolean lastTimePressed;
        
        /* Constructors */
        public Key(){
            keys.add(this);
            isPressed = false;
            lastTimePressed = false;
            isFirstPressed = false;
        }
        
        /* Methods */
        public void tick(){
            if( isPressed && !lastTimePressed){
                isFirstPressed = true;
            }else{
                isFirstPressed = false;
            }
            lastTimePressed = isPressed;
        }
        public void toggle( boolean pressed ){
            isPressed = pressed;
        }
    };
    
    /* Attributes */
    public Key up, down, left, right;
    public Key menu;
    public Key action, back;
    
    //private Key[] keys;
    private ArrayList<Key> keys = new ArrayList();
    
    /* Constructors */
    public InputHandler(){
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();
        menu = new Key();
        action = new Key();
        back = new Key();
    }

    /* Methods */
    public void tick(){
        for( int i = 0; i < keys.size(); i++ ){
            keys.get(i).tick();
        }
    }
    
    private void toggle( KeyEvent ke, boolean pressed ){
        if( ke.getKeyCode() == KeyEvent.VK_UP ){
            up.toggle( pressed );
            
        }
        
        if( ke.getKeyCode() == KeyEvent.VK_DOWN ){
            down.toggle( pressed );
        }
        
        if( ke.getKeyCode() == KeyEvent.VK_LEFT ){
            left.toggle( pressed );
        }
        
        if( ke.getKeyCode() == KeyEvent.VK_RIGHT ){
            right.toggle( pressed );
        }
        
        if( ke.getKeyCode() == KeyEvent.VK_M ){
            menu.toggle( pressed );
        }
        
        if( ke.getKeyCode() == KeyEvent.VK_Z ){
            action.toggle( pressed );
        }
        
        if( ke.getKeyCode() == KeyEvent.VK_X ){
            back.toggle( pressed );
        }
    }
    
    @Override
    public void keyPressed( KeyEvent e ) {
        toggle(e, true);
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        toggle( e, false );
    }
    
    @Override
    public void keyTyped( KeyEvent e ) {}
}
