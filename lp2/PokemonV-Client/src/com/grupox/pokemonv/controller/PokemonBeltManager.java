/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Tile;
import com.grupox.pokemonv.model.User;
import java.awt.Graphics2D;

/**
 *
 * @author USUARIO
 */
public class PokemonBeltManager {
    /* Attributes */
    private User user; //
    private InputHandler input; //
    private PokemonBelt pokemonBelt;
    
    private Menu menu;
    private int ind;
    private boolean presionado= false;
    /*constructor*/
    public PokemonBeltManager(User user){
        input = user.getInput();
        menu = new Menu( input );
        //pokemonBelt = new PokemonBelt(map);
        pokemonBelt = new PokemonBelt();
        ind =0;
    }
    
    /*method*/
    public void tick(){
        //pokemonBelt.tick();
        // Listen to input and set the inner state
        //vamos a cambiar esto :)
        
        if( input.up.isFirstPressed && ind >0 ){
            ind--;
            System.out.println(ind);
            presionado = false;
        }else if(input.down.isFirstPressed && ind < pokemonBelt.tamanoLista()-1){
            ind++;
            System.out.println(ind);
            presionado = false;
        }
        
        if(input.action.isPressed){
            System.out.println("action is presioned");
            presionado = true;
        }
        
        if(input.back.isPressed){
            System.out.println("action is presioned");
            presionado = false;
        }
        //System.out.println(pokemonBelt.tamanoLista());//4
    }
    
    public void render(Graphics2D g){
        pokemonBelt.render(g,ind, presionado);
        //presionado = false;
    }
}
