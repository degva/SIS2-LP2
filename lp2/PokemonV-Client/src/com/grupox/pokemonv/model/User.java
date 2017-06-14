package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.Animation;
import com.grupox.pokemonv.controller.InputHandler;
import java.awt.Graphics2D;
import static com.grupox.pokemonv.model.Tile.spriteWidthOut;
import static com.grupox.pokemonv.model.Tile.spriteHeightOut;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class User extends Renderable{
    /* Attributes */
    protected int user_id;
    protected String password;
    protected String name;
    protected String email;
    protected String address;
    
    protected Tile tile;
    
    private InputHandler input;
    
    private double now;
    private double lastMove = 0;
    private final double movePeriod = 0.2;
    
    /* Constructors */
    public User( InputHandler input ){
        super();
        
        this.input = input;
        user_id = 5;
        
        loadAnimations();
    }
    
    /* Methods */
    public void tick(){
        
        // Check movement
        now = System.nanoTime();
        if( input != null && now - lastMove > movePeriod * 1000000000 ){
            if( input.up.isPressed && !input.down.isPressed ){
                
                // Animate
                Animation walkTop = animations.get( findAnimation( "walkTop" ) );
                if( input.up.isFirstPressed ){
                    //stopAnimations();
                    walkTop.play();
                }
                currSprite = walkTop.getCurrSprite();
                direction = Direction.UP;
                
                tile.getMap().tryMove( this, Direction.UP );
                lastMove = now;
            }else if( input.down.isPressed && !input.up.isPressed ){
                
                // Animate
                Animation walkDown = animations.get( findAnimation( "walkDown" ) );
                if( input.up.isFirstPressed ){
                    //stopAnimations();
                    walkDown.play();
                }
                currSprite = walkDown.getCurrSprite();
                direction = Direction.DOWN;
                
                tile.getMap().tryMove( this, Direction.DOWN );
                lastMove = now;
            }else if( input.left.isPressed && !input.right.isPressed ){
                
                // Animate
                Animation walkLeft = animations.get( findAnimation( "walkLeft" ) );
                if( input.up.isFirstPressed ){
                    //stopAnimations();
                    walkLeft.play();
                }
                currSprite = walkLeft.getCurrSprite();
                direction = Direction.LEFT;
                
                tile.getMap().tryMove( this, Direction.LEFT );
                lastMove = now;
            }else if( input.right.isPressed && !input.left.isPressed ){
                
                // Animate
                Animation walkRight = animations.get( findAnimation( "walkRight" ) );
                if( input.up.isFirstPressed ){
                    System.out.println("FIRST PRESSED ANIMATIONS STOPPED");
                    //stopAnimations();
                    walkRight.play();
                }
                currSprite = walkRight.getCurrSprite();
                direction = Direction.RIGHT;
                
                tile.getMap().tryMove( this, Direction.RIGHT );
                lastMove = now;
            }else if( !input.up.isPressed && !input.down.isPressed && !input.left.isPressed && !input.right.isPressed){
                //stopAnimations();
                Animation anim;
                switch ( direction ){
                    case DOWN:
                        anim = animations.get( findAnimation( "iddleDown" ) );
                        break;
                    case UP:
                        anim = animations.get( findAnimation( "iddleTop" ) );
                        break;
                    case LEFT:
                        anim = animations.get( findAnimation( "iddleLeft" ) );
                        break;
                    default:
                        anim = animations.get( findAnimation( "iddleRight" ) );
                        break;
                }
                anim.play();
                currSprite = anim.getCurrSprite();
            }
        }
    }
    
    public void render( Graphics2D g, int x, int y ){
        g.drawImage(currSprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
    }
    
    private void loadAnimations(){
        SpriteSheet spriteSheet = SpriteSheet.getInstance();
        int row = 25;
        
        // Iddle down
        ArrayList<BufferedImage> iddleDownSprites = new ArrayList<>();
        iddleDownSprites.add( spriteSheet.getSubImage( 0, row ) );
        Animation iddleDownAnimation = new Animation("iddleDown", iddleDownSprites, 1);
        
        // Iddle top
        ArrayList<BufferedImage> iddleTopSprites = new ArrayList<>();
        iddleTopSprites.add( spriteSheet.getSubImage( 3, row ) );
        Animation iddleTopAnimation = new Animation("iddleTop", iddleTopSprites, 1);
        
        // Iddle Left
        ArrayList<BufferedImage> iddleLeftSprites = new ArrayList<>();
        iddleLeftSprites.add( spriteSheet.getSubImage( 1, row ) );
        Animation iddleLeftAnimation = new Animation("iddleLeft", iddleLeftSprites, 1);
        
        // Iddle Right
        ArrayList<BufferedImage> iddleRightSprites = new ArrayList<>();
        iddleRightSprites.add( spriteSheet.getSubImage( 2, row ) );
        Animation iddleRightAnimation = new Animation("iddleRight", iddleRightSprites, 1);
        
        // Walk down
        ArrayList<BufferedImage> walkDownSprites = new ArrayList<>();
        walkDownSprites.add( spriteSheet.getSubImage( 4, row ) );
        walkDownSprites.add( spriteSheet.getSubImage( 0, row ) );
        walkDownSprites.add( spriteSheet.getSubImage( 5, row ) );
        walkDownSprites.add( spriteSheet.getSubImage( 0, row ) );
        Animation walkDownAnimation = new Animation("walkDown", walkDownSprites, movePeriod);
        
        // Walk top
        ArrayList<BufferedImage> walkTopSprites = new ArrayList<>();
        walkTopSprites.add( spriteSheet.getSubImage( 10, row ) );
        walkTopSprites.add( spriteSheet.getSubImage( 3, row ) );
        walkTopSprites.add( spriteSheet.getSubImage( 11, row ) );
        walkTopSprites.add( spriteSheet.getSubImage( 3, row ) );
        Animation walkTopAnimation = new Animation("walkTop", walkTopSprites, movePeriod);
        
        // Walk left
        ArrayList<BufferedImage> walkLeftSprites = new ArrayList<>();
        walkLeftSprites.add( spriteSheet.getSubImage( 6, row ) );
        walkLeftSprites.add( spriteSheet.getSubImage( 1, row ) );
        walkLeftSprites.add( spriteSheet.getSubImage( 7, row ) );
        walkLeftSprites.add( spriteSheet.getSubImage( 1, row ) );
        Animation walkLeftAnimation = new Animation("walkLeft", walkLeftSprites, movePeriod);
        
        // Walk right
        ArrayList<BufferedImage> walkRightSprites = new ArrayList<>();
        walkRightSprites.add( spriteSheet.getSubImage( 8, row) );
        walkRightSprites.add( spriteSheet.getSubImage( 2, row ) );
        walkRightSprites.add( spriteSheet.getSubImage( 9, row ) );
        walkRightSprites.add( spriteSheet.getSubImage( 2, row ) );
        Animation walkRightAnimation = new Animation("walkRight", walkRightSprites, movePeriod);
        
        // Add animations
        animations.add( iddleDownAnimation );
        animations.add( iddleTopAnimation );
        animations.add( iddleLeftAnimation );
        animations.add( iddleRightAnimation );
        animations.add( walkDownAnimation );
        animations.add( walkTopAnimation );
        animations.add( walkLeftAnimation );
        animations.add( walkRightAnimation );
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

    public String getAddress() {
        return address;
    }
    public void setAddress( String address ) {
        this.address = address;
    }

    public InputHandler getInput() {
        return input;
    }
    public void setInput( InputHandler input ) {
        this.input = input;
    }
    
    
}