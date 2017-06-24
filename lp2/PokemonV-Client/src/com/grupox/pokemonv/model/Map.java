package com.grupox.pokemonv.model;

import com.grupox.pokemonv.BD.MapDA;
import com.grupox.pokemonv.controller.Game;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Map {
    /* Attributes */
    private Tile[][] grid;
    private int height = 8;   // NUMBER OF CELLS
    private int width = 8;    // NUMBER OF CELLS
    private final int TILES_IN_WIDTH = (int)Math.ceil( (double)Game.WIDTH / Tile.spriteWidthOut);
    private final int TILES_IN_HEIGHT = (int)Math.ceil( (double)Game.HEIGHT / Tile.spriteHeightOut);
    private float probPokemon;
    private float probItem;
    
    /* Constructors */
    public Map(){
        //loadGrid();
    }
    
    private void loadGrid(){
        ArrayList tileStrings = new ArrayList();
        String route = "./res/maps/main.txt";
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(route));
            height = 0;
            while(true){
                String line = reader.readLine();
                if(line == null) break;
                
                String lines[] = line.split(" ");
                if(height == 0) width = lines.length;
                height++;
                
                for(String tileString : lines)
                    tileStrings.add(tileString);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        fillTiles(tileStrings);
    }
    
    private void fillTiles(ArrayList tileStrings){
        grid = new Tile[width][];
        for(int i = 0; i < width; i++){
            grid[i] = new Tile[height];
            for(int j = 0; j < height; j++){
                String tileChar = (String)tileStrings.get(j * width + i); // From one dimension to two dimensions
                
                Tile.Type type;
                switch (tileChar){
                    case "FLR01":
                        type = Tile.Type.FLR01;
                        break;
                    case "FLR02":
                        type = Tile.Type.FLR02;
                        break;
                    case "FLR03":
                        type = Tile.Type.FLR03;
                        break;    
                    case "SGN01":
                        type = Tile.Type.SGN01;
                        break;
                    case "GRA00":
                        type = Tile.Type.GRA00;
                        break;
                    case "GRA01":
                        type = Tile.Type.GRA01;
                        break;
                    case "GRA02":
                        type = Tile.Type.GRA02;
                        break;
                    case "GRA03":
                        type = Tile.Type.GRA03;
                        break;
                    case "GRA04":
                        type = Tile.Type.GRA04;
                        break;
                    case "GRA05":
                        type = Tile.Type.GRA05;
                        break;                        
                    case "GRA06":
                        type = Tile.Type.GRA06;
                        break;
                    case "GRA07":
                        type = Tile.Type.GRA07;
                        break;
                    case "GRA08":
                        type = Tile.Type.GRA08;
                        break;                        
                    case "GRA09":
                        type = Tile.Type.GRA09;
                        break;                
                    case "SND01":
                        type = Tile.Type.SND01;
                        break;
                    case "SND02":
                        type = Tile.Type.SND02;
                        break;
                    case "SND03":
                        type = Tile.Type.SND03;
                        break;
                    case "SND04":
                        type = Tile.Type.SND04;
                        break;
                    case "SND05":
                        type = Tile.Type.SND05;
                        break;
                    case "SND06":
                        type = Tile.Type.SND06;
                        break;
                    case "SND07":
                        type = Tile.Type.SND07;
                        break;
                    case "SND08":
                        type = Tile.Type.SND08;
                        break;
                    case "SND09":
                        type = Tile.Type.SND09;
                        break;                
                    case "TRG01":
                        type = Tile.Type.TRG01;
                        break;
                    case "TRG02":
                        type = Tile.Type.TRG02;
                        break;
                    case "TRG03":
                        type = Tile.Type.TRG03;
                        break;                
                    case "HO101":
                        type = Tile.Type.HO101;
                        break;
                    case "HO102":
                        type = Tile.Type.HO102;
                        break;
                    case "HO103":
                        type = Tile.Type.HO103;
                        break;
                    case "HO104":
                        type = Tile.Type.HO104;
                        break;
                    case "HO105":
                        type = Tile.Type.HO105;
                        break;
                    case "HO106":
                        type = Tile.Type.HO106;
                        break;
                    case "HO107":
                        type = Tile.Type.HO107;
                        break;
                    case "HO108":
                        type = Tile.Type.HO108;
                        break;
                    case "HO109":
                        type = Tile.Type.HO109;
                        break;
                    case "HO110":
                        type = Tile.Type.HO110;
                        break;
                    case "HO111":
                        type = Tile.Type.HO111;
                        break;
                    case "HO112":
                        type = Tile.Type.HO112;
                        break;
                    default:
                        type = Tile.Type.FLR02;
                        break;
                }
                grid[i][j] = new Tile(type, null, false, this);    // @TODO chance according to type
            }
        }
    }
    
    /* Methods */
    
    // Tries to set the user of the next tile according to the direction. Returns whether successful or not.
    public boolean tryMove( User user, Renderable.Direction direction ){
        int[] pos = getPosUser( user );
        int i = pos[0], j = pos[1];
        
        if( i == width || j == height ) return false;
        
        Tile nextTile;
        switch ( direction ){
            case UP:
                if ( j == 0 ) return false;
                nextTile = grid[i][j - 1];
                break;
            case DOWN:
                if( j == height - 1 ) return false;
                nextTile = grid[i][j + 1];
                break;
            case LEFT:
                if( i == 0 ) return false;
                nextTile = grid[i - 1][j];
                break;
            case RIGHT:
                if( i == width - 1 ) return false;
                nextTile = grid[i + 1][j];
                break;
            default:
                return false;
        }
        
        if( !nextTile.containsUser() && nextTile.isIsWalkable() ){
            user.getTile().setUser( null ); // Current tile
            user.setTile(nextTile);
            nextTile.setUser( user );
            return true;
        }else{
            return false;
        }
    }
    
    public Player tryBattle( Player player, Renderable.Direction direction){
        int[] pos = getPosUser( player );
        int i = pos[0], j = pos[1];
        
        if( i == width || j == height ) return null;
        
        Tile nextTile;
        switch ( direction ){
            case UP:
                if ( j == 0 ) return null;
                nextTile = grid[i][j - 1];
                break;
            case DOWN:
                if( j == height - 1 ) return null;
                nextTile = grid[i][j + 1];
                break;
            case LEFT:
                if( i == 0 ) return null;
                nextTile = grid[i - 1][j];
                break;
            case RIGHT:
                if( i == width - 1 ) return null;
                nextTile = grid[i + 1][j];
                break;
            default:
                return null;
        }
        
        if(nextTile.containsUser())
            return (Player)nextTile.getUser();
        else
            return null;
    }
    
    public void render( Graphics2D g, User user){
        // Render only if in screen.
        int[] pos = getPosUser( user );
        int x = pos[0], y = pos[1]; // Asume that the user exists
        
        // Tiles from and to where to draw
        int xStart = Integer.max( 0, x - TILES_IN_WIDTH / 2 );
        int yStart = Integer.max( 0, y - TILES_IN_HEIGHT / 2 );
        int xEnd = Integer.min(width, x + TILES_IN_WIDTH / 2 + 1);
        int yEnd = Integer.min(height, y + TILES_IN_HEIGHT / 2 + 1);
        
        for( int i = xStart; i < xEnd; i++ ){
            for( int j = yStart; j < yEnd; j++ ){
                grid[i][j].render( g, TILES_IN_WIDTH / 2 - (x - i) , TILES_IN_HEIGHT / 2 - (y - j) );
            }
        }
        
        
    }
    
    public int[] getPosUser( User user ){
        int[] pos = new int[2];
        int i=0, j=0;
        
        outerloop:  // Helpful when I want to break from a nested loop
        for( i = 0; i < width; i++ ){
            for( j = 0; j < height; j++ ){
                User currUser = grid[i][j].getUser();
                if( currUser != null ){
                    if( currUser.getUser_id() == user.getUser_id() ) break outerloop;
                }
            }
        }
        pos[0] = i;
        pos[1] = j;
        return pos;
    }

    /* Getters & Setters */
    public Tile[][] getGrid() {
        return grid;
    }
    
    public int getHeight() {
        return height;
    }

    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }

    public float getProbPokemon() {
        return probPokemon;
    }
    public void setProbPokemon(float probPokemon) {
        this.probPokemon = probPokemon;
    }

    public float getProbItem() {
        return probItem;
    }
    public void setProbItem(float probItem) {
        this.probItem = probItem;
    }
    
    
}
