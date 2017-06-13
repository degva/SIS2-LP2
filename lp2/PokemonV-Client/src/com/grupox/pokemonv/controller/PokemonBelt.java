/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller;
import static com.grupox.pokemonv.controller.Game.HEIGHT;
import static com.grupox.pokemonv.controller.Game.WIDTH;
//añadi esto!
//import static com.grupox.pokemonv.controller.Font.fontWidthOut;
//import static com.grupox.pokemonv.controller.Font.fontHeightOut;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Pokemon;
import com.grupox.pokemonv.model.SpriteSheet;
import static com.grupox.pokemonv.model.Tile.spriteHeightOut;
import static com.grupox.pokemonv.model.Tile.spriteWidthOut;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author USUARIO
 */
public class PokemonBelt {
    /* Attributes */
    
    private final int topOffset = 30;   // px
    private final int rightOffset = Game.WIDTH / 80; // Margin that will be left at the right in px
    private int leftOffset;
    
    private BufferedImage[] borders;
//    private Map map;
    private ArrayList<Pokemon> listaPokemones;
    
    private int altura=2;//alejandro me matara por el español ... tengo sueño!
    
    private int spriteWidthOut = 23;//con esto aparecen los 6
    private int spriteHeightOut = 23;
    //private int indice;
    
    public PokemonBelt(){
//        this.map = map;
        
        listaPokemones = new ArrayList<>();
        
        Pokemon.TypeP tipoE = Pokemon.TypeP.Earth;
        Pokemon.TypeP tipoF = Pokemon.TypeP.Fire;
        Pokemon.TypeP tipoWa = Pokemon.TypeP.Water;
        Pokemon.TypeP tipoWi = Pokemon.TypeP.Wind;
        Pokemon pok1 = new Pokemon(1,10,20,30,"Bulbasaur",tipoE);
        Pokemon pok2 = new Pokemon(4,30,20,46,"Charmander",tipoF);
        Pokemon pok3 = new Pokemon(7,50,10,30,"Squirtle",tipoWa);
        Pokemon pok4 = new Pokemon(12,60,22,44,"Butterfree",tipoWi);
        Pokemon pok5 = new Pokemon(12,60,22,44,"Butterfree2",tipoWi);
        Pokemon pok6 = new Pokemon(12,60,22,44,"Butterfree3",tipoWi);
        listaPokemones.add(pok1);
        listaPokemones.add(pok2);
        listaPokemones.add(pok3);
        listaPokemones.add(pok4);
        listaPokemones.add(pok5);
        listaPokemones.add(pok6);
        
        
        // Boards
        borders = new BufferedImage[9];
        iniBorders();
        calculateLeftOffset();
    }
    
    private void iniBorders(){
        borders[0] = SpriteSheet.getInstance().getSubImage(15, 22);
        borders[1] = SpriteSheet.getInstance().getSubImage(16, 22);
        borders[2] = SpriteSheet.getInstance().getSubImage(17, 22);
        
        borders[3] = SpriteSheet.getInstance().getSubImage(15, 23);
        borders[4] = SpriteSheet.getInstance().getSubImage(16, 23);
        borders[5] = SpriteSheet.getInstance().getSubImage(17, 23);
        
        borders[6] = SpriteSheet.getInstance().getSubImage(15, 24);
        borders[7] = SpriteSheet.getInstance().getSubImage(16, 24);
        borders[8] = SpriteSheet.getInstance().getSubImage(17, 24);
    }
    
    
    public void tick(){
        
        
    }
    
    public void render(Graphics2D g, int ind, boolean presionado){
        g.setColor( Color.orange );
        g.fillRect( 0, 0, WIDTH, HEIGHT );
        
        drawBorders( g ,ind, presionado);
        drawInfo(g,ind);
    }
    
    private void drawInfo(Graphics2D g, int ind){
        int x = leftOffset + spriteWidthOut+80, y = topOffset +spriteHeightOut*3/4;//80+
        Pokemon pok = listaPokemones.get(ind);
        pok.isSelected = true;
        listaPokemones.set(ind, pok);
        int fin,ini;
        if(listaPokemones.size() <6){
            ini = 0;
            fin = listaPokemones.size();
        }
        else{
            if(ind< 6) {
                ini = 0;
                fin = 6;
            }
            else{
                fin = ind+1;
                ini = fin-6;
            }
        }
        for( int i = ini; i < fin; i++, y += spriteHeightOut+ 3*spriteWidthOut+1 ){ //3+
            pok = listaPokemones.get(i);
            int fontAnt = Font.getFontHeightOut();
            Font.setFontHeightOut(fontAnt - 20);
            if(pok.isSelected) Font.getInstance().drawString(">>", g, x-6*spriteWidthOut, y+10);
            Font.getInstance().drawString(pok.getName(), g, x, y);
            Font.getInstance().drawString("HP:"+Double.toString(pok.getLife()),g, x, y+ spriteHeightOut + spriteHeightOut/2 );
            
            BufferedImage spriteSheet= new BufferedImage(96, 96, BufferedImage.TYPE_INT_RGB);
            String route = "res/pokemons/"+pok.getId()+".png";
            try {
                spriteSheet = ImageIO.read( new File( route ) );
            } catch ( IOException ex ) {
                Logger.getLogger( SpriteSheet.class.getName() ).log( Level.SEVERE, null, ex );
            }
            g.drawImage(spriteSheet,430,y-38, 6*spriteWidthOut, 6*spriteHeightOut, null );
            
            Font.setFontHeightOut(fontAnt);
            pok.isSelected = false;
            listaPokemones.set(i, pok);
        }
    }
    
    private void cambiarFormato(){
        borders[0] = SpriteSheet.getInstance().getSubImage(11, 5);
        borders[1] = SpriteSheet.getInstance().getSubImage(12, 5);
        borders[2] = SpriteSheet.getInstance().getSubImage(13, 5);
        
        borders[3] = SpriteSheet.getInstance().getSubImage(11, 6);
        borders[4] = SpriteSheet.getInstance().getSubImage(12, 6);
        borders[5] = SpriteSheet.getInstance().getSubImage(13, 6);
        
        borders[6] = SpriteSheet.getInstance().getSubImage(11, 7);
        borders[7] = SpriteSheet.getInstance().getSubImage(12, 7);
        borders[8] = SpriteSheet.getInstance().getSubImage(13, 7);
    }
    
    
    private void drawBorders( Graphics2D g,int ind, boolean presionado){
        int widthInTiles = getWidthInTiles()-2;//ver esto para el ancho!-2
        int suma = 4*spriteWidthOut+1;
        int fin,ini;
        if(listaPokemones.size() <6){//para que salgan los 6 pokemones en la pantalla
            ini = 0;
            fin = listaPokemones.size();
        }
        else{
            if(ind< 6) {
                ini = 0;
                fin = 6;
            }
            else{
                fin = ind+1;
                ini = fin-6;
            }
        }
        int a=0;
        for(int b=ini;b<fin;b++) {
            if (b == ind && presionado) {
                cambiarFormato();
                drawInformacionCompleta(g,ind);
            }
            draw(g, suma,a,widthInTiles);
            a++;
            iniBorders();
        }
        
        
    }
    
    public void draw(Graphics2D g, int suma,int a,int widthInTiles){
        /* Draw top border */
            // Left
            g.drawImage( borders[0], leftOffset, topOffset+ suma*a, spriteWidthOut, spriteHeightOut, null );

            // Middle
            for( int i = 0; i < widthInTiles ; i++ ){
                g.drawImage( borders[1], leftOffset + ( 1 + i ) * spriteWidthOut, topOffset+suma*a, spriteWidthOut, spriteHeightOut, null );
            }

            // Right
            g.drawImage( borders[2], leftOffset + ( 1 + widthInTiles ) * spriteWidthOut, topOffset+suma*a, spriteWidthOut, spriteHeightOut, null );

            /* Draw body */
            int localTopOffset;
            for(int i = 0; i < altura ; i++ ){
                localTopOffset = topOffset +  (1 + i ) * spriteHeightOut + suma*a;
                // Left
                g.drawImage( borders[3], leftOffset, localTopOffset, spriteWidthOut, spriteHeightOut, null );

                // Middle
                g.drawImage( borders[4], leftOffset + spriteWidthOut, localTopOffset, spriteWidthOut * widthInTiles,spriteHeightOut, null );

                // Right
                g.drawImage( borders[5], leftOffset + spriteWidthOut * ( widthInTiles + 1 ), localTopOffset, spriteWidthOut, spriteHeightOut, null );
            }

            /* Draw bottom */
            // Left
            localTopOffset = topOffset + ( 1 + altura ) * spriteHeightOut + suma*a;
            g.drawImage( borders[6], leftOffset, localTopOffset, spriteWidthOut, spriteHeightOut, null );

            // Middle
            for( int i = 0; i < widthInTiles ; i++ ){
                g.drawImage( borders[7], leftOffset + ( 1 + i ) * spriteWidthOut, localTopOffset, spriteWidthOut, spriteHeightOut, null );
            }

            // Right
            g.drawImage( borders[8], leftOffset + ( 1 + widthInTiles ) * spriteWidthOut, localTopOffset, spriteWidthOut, spriteHeightOut, null );
    }
    
    
    
    private void drawInformacionCompleta(Graphics2D g, int ind){
        int widthInTiles = 13;
        leftOffset = 50;
        altura = 20;
        //topOffset = 10;
        draw(g, 0,0,widthInTiles);
        calculateLeftOffset();
        altura =2;
        
        Pokemon pok = listaPokemones.get(ind);
        //impresion de la informacion del pokemon seleccionado
        int x=80, y=50;
        //Font.getInstance().drawString(pok.getName(), g, x-2*spriteWidthOut, y);
        Font.getInstance().drawString(pok.getName(), g, x,y);
        Font.getInstance().drawString("ATTACK: "+ Double.toString(pok.getAttack_pts()),g, x, y+70);
        Font.getInstance().drawString("DEFENSE: "+ Double.toString(pok.getDefense_pts()), g, x, y +2*70);
        Font.getInstance().drawString("LIFE: "+ Double.toString(pok.getLife()), g, x, y +3*70);
        Font.getInstance().drawString("TYPE: "+pok.getType().toString(), g, x, y +4*70);
        
        BufferedImage spriteSheet= new BufferedImage(96, 96, BufferedImage.TYPE_INT_RGB);
        String route = "res/pokemons/"+pok.getId()+".png";
        try {
            spriteSheet = ImageIO.read( new File( route ) );
        } catch ( IOException ex ) {
            Logger.getLogger( SpriteSheet.class.getName() ).log( Level.SEVERE, null, ex );
        }
        g.drawImage(spriteSheet,73,14*spriteWidthOut, 12*spriteWidthOut, 12*spriteHeightOut, null );
            
    }
    
    
    private int getWidthInTiles(){
        int maxLen = 20;//cambiando por defecto
        return (int)Math.floor( 1.0 * maxLen * Font.getFontWidthOut() / spriteWidthOut);
    }
    private void calculateLeftOffset(){
        int widthInTiles = getWidthInTiles();
        
        leftOffset = Game.WIDTH - rightOffset - ( 2 + widthInTiles ) * spriteWidthOut;
    }
    public int tamanoLista(){
        return listaPokemones.size();
    }
    
    public void intercambiar(int A, int B){
        Pokemon pokA= listaPokemones.get(A);
        Pokemon pokB= listaPokemones.get(B);
        listaPokemones.set(A, pokB);
        listaPokemones.set(B, pokA);
    }
}