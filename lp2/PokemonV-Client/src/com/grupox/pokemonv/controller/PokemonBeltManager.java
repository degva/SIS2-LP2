/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.controller.menu.PokemonBeltMenu;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Player;
import java.awt.Graphics2D;

/**
 *
 * @author USUARIO
 */
public class PokemonBeltManager {
    /* Attributes */
    private Player user; //
    private InputHandler input; //
    private PokemonBelt pokemonBelt;
    private Game game;
    
    
    public static PokemonBeltMenu menu; //veamos eso!
    
    public static int ind;

    private boolean presionado= false;
    public static boolean presionadoF= false;
    public static int indiceA = -1;
    public static int indiceB = -1;
    
    /*constructor*/
    public PokemonBeltManager(Player user, Game game){
        input = user.getInput();
        pokemonBelt = new PokemonBelt((Player)user);
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
            //System.out.println(ind);
            presionado = false;
        }else if(input.down.isFirstPressed && ind < pokemonBelt.tamanoLista()-1 && !presionadoF){
            ind++;
            //System.out.println(ind);
            presionado = false;
        }
        
        if(input.action.isPressed && !presionadoF){
            //System.out.println("action is presioned");
            presionado = true;
        }
        
        if(input.back.isPressed && presionado ){
            //System.out.println("back is presioned");
            presionado = false;
        }
        else if(input.back.isFirstPressed && !presionadoF){
            //System.out.println("salir");
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
            indiceA = -1;
            indiceB = -1;
        }
        
        pokemonBelt.render(g,ind, presionado);
        if(presionadoF) menu.render(g);
    }
}
