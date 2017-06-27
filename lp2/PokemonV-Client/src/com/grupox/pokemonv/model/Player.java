package com.grupox.pokemonv.model;

import com.grupox.pokemonv.controller.Animation;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import java.awt.Graphics2D;
import static com.grupox.pokemonv.model.Tile.spriteWidthOut;
import static com.grupox.pokemonv.model.Tile.spriteHeightOut;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Renderable{
    /* Enum declaration */
    public enum NPC_TYPE { PLAYER, WOMAN01, MAN01, MAN02, MAN03, WOMAN02};
    
    /* Attributes */
    private int id;
    private Tile tile;
    
    private InputHandler input;
    private ArrayList<Pokemon> pokemons;
    private NPC_TYPE npcType;
    private Pokeball pokeballs;
    private Potion potions;
    private Dialog battleDialog;
    private Dialog defeatDialog;
    
    private boolean canBattle;
    
    private double now;
    private double lastMove = 0;
    private final double movePeriod = 0.2;
    
    private BufferedImage leftIdle;
    private BufferedImage rightIdle;
    private BufferedImage upIdle;
    private BufferedImage downIdle;
    
    
    /* Constructors */
    public Player( InputHandler input ){
        super();
        
        this.input = input;
        direction = Direction.DOWN;
        
        if( input != null ){
            loadAnimations();
        }
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
                
                if(tile.getMap().tryMove( this, Direction.UP )){
                    lastMove = now;
                }
            }else if( input.down.isPressed && !input.up.isPressed ){
                
                // Animate
                Animation walkDown = animations.get( findAnimation( "walkDown" ) );
                if( input.up.isFirstPressed ){
                    //stopAnimations();
                    walkDown.play();
                }
                currSprite = walkDown.getCurrSprite();
                direction = Direction.DOWN;
                
                if(tile.getMap().tryMove( this, Direction.DOWN )){
                    lastMove = now;
                }
            }else if( input.left.isPressed && !input.right.isPressed ){
                
                // Animate
                Animation walkLeft = animations.get( findAnimation( "walkLeft" ) );
                if( input.up.isFirstPressed ){
                    //stopAnimations();
                    walkLeft.play();
                }
                currSprite = walkLeft.getCurrSprite();
                direction = Direction.LEFT;
                
                if(tile.getMap().tryMove( this, Direction.LEFT )){
                    lastMove = now;
                }
            }else if( input.right.isPressed && !input.left.isPressed ){
                
                // Animate
                Animation walkRight = animations.get( findAnimation( "walkRight" ) );
                if( input.up.isFirstPressed ){
                    //stopAnimations();
                    walkRight.play();
                }
                currSprite = walkRight.getCurrSprite();
                direction = Direction.RIGHT;
                
                if(tile.getMap().tryMove( this, Direction.RIGHT )){
                    lastMove = now;
                }
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
        if(input == null){
            // Render for NPC
            switch(direction){
                case DOWN:
                    sprite = downIdle;
                    break;
                case LEFT:
                    sprite = leftIdle;
                    break;
                case RIGHT:
                    sprite = rightIdle;
                    break;
                case UP:
                    sprite = upIdle;
                    break;
            }
            g.drawImage(sprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
        }else{
            g.drawImage(currSprite, x * spriteWidthOut, y * spriteHeightOut, spriteWidthOut, spriteHeightOut, null );
        }
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
    
    private void getNPCSprite(){
        switch (npcType){
            case PLAYER:
                this.downIdle = SpriteSheet.getInstance().getSubImage(0, 25);
                this.leftIdle = SpriteSheet.getInstance().getSubImage(1, 25);
                this.rightIdle = SpriteSheet.getInstance().getSubImage(2, 25);
                this.upIdle = SpriteSheet.getInstance().getSubImage(3, 25);
                break;
            case MAN01:
                this.downIdle = SpriteSheet.getInstance().getSubImage(18, 6);
                this.leftIdle = SpriteSheet.getInstance().getSubImage(19, 6);
                this.rightIdle = SpriteSheet.getInstance().getSubImage(20, 6);
                this.upIdle = SpriteSheet.getInstance().getSubImage(21, 6);
                break;
            case MAN02:
                this.downIdle = SpriteSheet.getInstance().getSubImage(18, 7);
                this.leftIdle = SpriteSheet.getInstance().getSubImage(19, 7);
                this.rightIdle = SpriteSheet.getInstance().getSubImage(20, 7);
                this.upIdle = SpriteSheet.getInstance().getSubImage(21, 7);
                break;
            case MAN03:
                this.downIdle = SpriteSheet.getInstance().getSubImage(18, 8);
                this.leftIdle = SpriteSheet.getInstance().getSubImage(19, 8);
                this.rightIdle = SpriteSheet.getInstance().getSubImage(20, 8);
                this.upIdle = SpriteSheet.getInstance().getSubImage(21, 8);
                break;
            case WOMAN01:
                this.downIdle = SpriteSheet.getInstance().getSubImage(18, 9);
                this.leftIdle = SpriteSheet.getInstance().getSubImage(19, 9);
                this.rightIdle = SpriteSheet.getInstance().getSubImage(20, 9);
                this.upIdle = SpriteSheet.getInstance().getSubImage(21, 9);
                break;
            case WOMAN02:
                this.downIdle = SpriteSheet.getInstance().getSubImage(18, 10);
                this.leftIdle = SpriteSheet.getInstance().getSubImage(19, 10);
                this.rightIdle = SpriteSheet.getInstance().getSubImage(20, 10);
                this.upIdle = SpriteSheet.getInstance().getSubImage(21, 10);
                break;
        }
        
        
    }
    
    /* Getters & Setters */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Tile getTile() {
        return tile;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public NPC_TYPE getNpcType() {
        return npcType;
    }
    public void setNpcType(NPC_TYPE npcType) {
        this.npcType = npcType;
        System.out.println(this.npcType);
        getNPCSprite();
    }

    public Pokeball getPokeballs() {
        return pokeballs;
    }
    public void setPokeballs(Pokeball pokeballs) {
        this.pokeballs = pokeballs;
    }

    public Potion getPotions() {
        return potions;
    }
    public void setPotions(Potion potions) {
        this.potions = potions;
    }
    
    public InputHandler getInput() {
        return input;
    }
    public void setInput( InputHandler input ) {
        this.input = input;
    }

    public boolean getCanBattle() {
        return canBattle;
    }
    public void setCanBattle(boolean canBattle) {
        this.canBattle = canBattle;
    }

    public Dialog getBattleDialog() {
        return battleDialog;
    }
    public void setBattleDialog(Dialog battleDialog) {
        this.battleDialog = battleDialog;
    }

    public Dialog getDefeatDialog() {
        return defeatDialog;
    }
    public void setDefeatDialog(Dialog defeatDialog) {
        this.defeatDialog = defeatDialog;
    }
}