/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.controller.menu.PokemonBeltMenu;
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
    private Game game;
    
    
    private PokemonBeltMenu menu;
    
    public static int ind;

    private boolean presionado= false;
    public static boolean presionadoF= false;
    public static int indiceA;
    public static int indiceB;
    
    /*constructor*/
    public PokemonBeltManager(User user, Game game){
        input = user.getInput();
        pokemonBelt = new PokemonBelt();
        ind =0;
        this.game = game;
        
        menu = new PokemonBeltMenu(input, 20, Game.WIDTH/80, game);
    }
    
    /*method*/
    public void tick(){
        //pokemonBelt.tick();
        // Listen to input and set the inner state
        //vamos a cambiar esto :)
        
        if( input.up.isFirstPressed && ind >0 && !presionadoF){
            ind--;
            System.out.println(ind);
            presionado = false;
        }else if(input.down.isFirstPressed && ind < pokemonBelt.tamanoLista()-1 && !presionadoF){
            ind++;
            System.out.println(ind);
            presionado = false;
        }
        
        if(input.action.isPressed && !presionadoF){
            System.out.println("action is presioned");
            presionado = true;
        }
        
        if(input.back.isPressed && presionado ){
            System.out.println("back is presioned");
            presionado = false;
        }
        else if(input.back.isFirstPressed && !presionadoF){
            System.out.println("salir");
            presionado = false;
            presionadoF = true;
            menu.setSelectedItem(0);
        }
        if(presionadoF) menu.tick();
    }
    
    public void render(Graphics2D g){
        if(menu.getVez() == 2){
            pokemonBelt.intercambiar(indiceA, indiceB); //funciona!
            menu.setVez(0);
        }
        
        pokemonBelt.render(g,ind, presionado);
        if(presionadoF) menu.render(g);
    }
}
