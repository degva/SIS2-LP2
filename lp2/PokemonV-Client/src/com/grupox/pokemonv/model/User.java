package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.InputHandler;
import static com.grupox.pokemonv.model.Tile.spriteHeight;
import static com.grupox.pokemonv.model.Tile.spriteWidth;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class User extends Renderable{
    /* Attributes */
    protected int user_id;
    protected String password;
    protected String name;
    protected String email;
    
    protected Tile tile;
    
    private InputHandler input;
    
    private double now;
    private double lastMove = 0;
    private final double movePeriod = 0.5 * 1000000000;
    
    /* Constructors */
    public User( InputHandler input ){
        this.input = input;
        user_id = 5;
    }
    
    /* Methods */
    public void tick(){
        
        // Check movement
        now = System.nanoTime();
        if( input != null && now - lastMove > movePeriod ){
            if( input.up.down && !input.down.down ){
                tile.getMap().tryMove( this, Direction.UP );
                lastMove = now;
            }else if( input.down.down && !input.up.down ){
                tile.getMap().tryMove( this, Direction.DOWN );
                lastMove = now;
            }else if( input.left.down && !input.right.down ){
                tile.getMap().tryMove( this, Direction.LEFT );
                lastMove = now;
            }else if( input.right.down && !input.left.down ){
                tile.getMap().tryMove( this, Direction.RIGHT );
                lastMove = now;
            }
        }
    }
    
    public void render( Graphics2D g, int x, int y ){
        g.drawImage( sprite, x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight, null );
    }
    
    /*
    login(){}
    logout(){}
    */
    
    /* Getters & Setters */

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id( int user_id ) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword( String password ) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail( String email ) {
        this.email = email;
    }

    public Tile getTile() {
        return tile;
    }
    public void setTile( Tile tile ) {
        this.tile = tile;
    }  
}