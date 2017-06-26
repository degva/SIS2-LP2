package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.Game;
import java.awt.Graphics2D;

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
    public Map(){}
    
    /* Methods */
    // Tries to set the player of the next tile according to the direction. Returns whether successful or not.
    public boolean tryMove( Player player, Renderable.Direction direction ){
        int[] pos = getPosPlayer(player );
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
            player.getTile().setPlayer( null ); // Current tile
            player.setTile(nextTile);
            nextTile.setPlayer(player );
            return true;
        }else{
            return false;
        }
    }
    
    public Player tryBattle( Player player, Renderable.Direction direction){
        int[] pos = getPosPlayer( player );
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
        return nextTile.getPlayer();
    }
    
    public void render( Graphics2D g, Player player){
        // Render only if in screen.
        int[] pos = getPosPlayer(player );
        int x = pos[0], y = pos[1]; // Asume that the player exists
        
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
    
    public int[] getPosPlayer( Player player ){
        int[] pos = new int[2];
        int i=0, j=0;
        
        outerloop:  // Helpful when I want to break from a nested loop
        for( i = 0; i < width; i++ ){
            for( j = 0; j < height; j++ ){
                Player currPlayer = grid[i][j].getPlayer();
                if( currPlayer != null ){
                    if( currPlayer.getId() == player.getId() ) break outerloop;
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
    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }

    public int getHeight() {
        return height;
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