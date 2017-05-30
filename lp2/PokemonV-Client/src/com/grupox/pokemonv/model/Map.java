package com.grupox.pokemonv.model;

// @TODO This class should have a render() method

import com.grupox.pokemonv.controller.Game;
import static com.grupox.pokemonv.controller.Game.HEIGHT;
import static com.grupox.pokemonv.controller.Game.WIDTH;
import java.awt.Graphics2D;

public class Map {
    /* Attributes */
    private Tile[][] grid;
    private final int HEIGHT = 8;   // NUMBER OF CELLS
    private final int WIDTH = 8;    // NUMBER OF CELLS
    private final int TILES_IN_WIDTH = (int)Math.ceil( (double)Game.WIDTH / Tile.spriteWidthOut);
    private final int TILES_IN_HEIGHT = (int)Math.ceil( (double)Game.HEIGHT / Tile.spriteHeightOut);
    
    /* Constructors */
    public Map(){
        grid = new Tile[ WIDTH ][ HEIGHT ];
        for( int i = 0; i < WIDTH; i++ ){
            for( int j = 0; j < HEIGHT; j++ ){
                // TEST
                Tile.Type type;
                if( i == j || i + j == HEIGHT-1) type = Tile.Type.SAND;
                else type = Tile.Type.GRASS;

                grid[i][j] = new Tile( type, null, false, this );
            }
        }
    }
    
    /* Methods */
    
    // Tries to set the user of the next tile according to the direction. Returns whether successful or not.
    public boolean tryMove( User user, Renderable.Direction direction ){
        int[] pos = getPosUser( user );
        int i = pos[0], j = pos[1];
        
        if( i == WIDTH || j == HEIGHT ) return false;
        
        Tile nextTile;
        switch ( direction ){
            case UP:
                if ( j == 0 ) return false;
                nextTile = grid[i][j - 1];
                break;
            case DOWN:
                if( j == HEIGHT - 1 ) return false;
                nextTile = grid[i][j + 1];
                break;
            case LEFT:
                if( i == 0 ) return false;
                nextTile = grid[i - 1][j];
                break;
            case RIGHT:
                if( i == WIDTH - 1 ) return false;
                nextTile = grid[i + 1][j];
                break;
            default:
                return false;
        }
        
        if( !nextTile.containsUser() ){
            user.getTile().setUser( null ); // Current tile
            nextTile.setUser( user );
            user.setTile(nextTile);
            return true;
        }else{
            return false;
        }
    }
    
    /*
    public void downloadMap(){
      ???????  
    }
    */
    
    public void render( Graphics2D g, User user){
        // Render only if in screen.
        int[] pos = getPosUser( user );
        int x = pos[0], y = pos[1]; // Asume that the user exists
        //grid[x][y].render(g, x, y);
        //x - i + TILES_IN_WIDTH/2
        // Tiles from and to where to draw
        int xStart = Integer.max( 0, x - TILES_IN_WIDTH / 2 );
        int yStart = Integer.max( 0, y - TILES_IN_HEIGHT / 2 );
        int xEnd = Integer.min( WIDTH, x + TILES_IN_WIDTH / 2 + 1);
        int yEnd = Integer.min( HEIGHT, y + TILES_IN_HEIGHT / 2 + 1);
        
        for( int i = xStart; i < xEnd; i++ ){
            for( int j = yStart; j < yEnd; j++ ){
//                if( i * Tile.spriteWidth < Game.WIDTH && j * Tile.spriteHeight < Game.HEIGHT ){
//                    grid[i][j].render( g, i, j );
//                }
                //if( x - i < 0 || x + i >= TILES_IN_WIDTH || y - j < 0 || y + j >= TILES_IN_HEIGHT)
                    //g.fillRect(Game.WIDTH - (x-i)*Tile.spriteWidth, Game.WIDTH - (x-i) * Tile.spriteHeight, Tile.spriteWidth, Tile.spriteHeight);
                //else
                    grid[i][j].render( g, TILES_IN_WIDTH / 2 - (x - i) , TILES_IN_HEIGHT / 2 - (y - j) );
//                else
//                    g.fillRect(i-x, y, WIDTH, HEIGHT);
            }
        }
        
        
    }
    
    public int[] getPosUser( User user ){
        int[] pos = new int[2];
        int i=0, j=0;
        
        outerloop:  // Helpful when I want to break from a nested loop
        for( i = 0; i < WIDTH; i++ ){
            for( j = 0; j < HEIGHT; j++ ){
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

    public int getHEIGHT() {
        return HEIGHT;
    }
    public int getWIDTH() {
        return WIDTH;
    }
    
}
