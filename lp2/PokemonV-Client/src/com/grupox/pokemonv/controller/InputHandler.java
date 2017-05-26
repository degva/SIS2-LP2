package com.grupox.pokemonv.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

    /* Inner class */
    public class Key{
        /* Attributes */
        public boolean down;
        public boolean first;   // First time it is pressed. Useful for menus
        
        /* Constructors */
        public Key(){
            down = false;
            first = false;
        }
        
        /* Methods */
        public void toggle( boolean pressed ){
            if( pressed && !this.down ){
                first = true;
            }else if( !pressed ){
                first = false;
            }
            this.down = pressed;
        }
    };
    
    /* Attributes */
    public Key up;
    public Key down;
    public Key left;
    public Key right;
    
    /* Constructors */
    public InputHandler(){
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();
    }

    /* Methods */
    @Override
    public void keyPressed( KeyEvent e ) {
        if( e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP ){
            up.toggle( true );
        }
        
        if( e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN ){
            down.toggle( true );
        }
        
        if( e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT ){
            left.toggle( true );
        }
        
        if( e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT ){
            right.toggle( true );
        }
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        if( e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP ){
            up.toggle( false );
        }
        
        if( e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN ){
            down.toggle( false );
        }
        
        if( e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT ){
            left.toggle( false );
        }
        
        if( e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT ){
            right.toggle( false );
        }
    }
    
    @Override
    public void keyTyped( KeyEvent e ) {}
}
