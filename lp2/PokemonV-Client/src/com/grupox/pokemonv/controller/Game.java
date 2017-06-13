package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.controller.manager.BagManager;
import com.grupox.pokemonv.controller.manager.MapManager;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.User;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
    /* Enum declaration */
    public enum State { MAP, BATTLE, POKEMON_BELT, BAG };
    
    /* Attributes */
    private boolean running = false;
    
    private JFrame frame;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private BufferStrategy strategy;
    public InputHandler input;
    
    private double now, last, elapsed, lastInfoPrint;
    private int ticks, fps;
    private boolean shouldRender;
    public final int FPS = 60;
    public final double TIME_PER_FRAME = 1000000000/FPS;    // 1 second as nanosecond / 60 frames
    
    private MapManager mapManager;
    private BagManager bagManager;
    private User user;
    private State state;
    
    /* Constructors */
    public Game(){
        // Main loop
        running = false;
        
        // UI
        initUI();
        
        // Keyboard
        input = new InputHandler();
        this.addKeyListener( input );
        
        // Initialization
        user = new Player( input );
        mapManager = new MapManager( user, this );
        bagManager = new BagManager( (Player)user, this );
        state = State.MAP;
    }
    
    /* Methods */
    public void start(){
        running = true;
        Thread thread = new Thread( this );   // Start this class as a new thread
        thread.run();   // Calls Game.run();
    }
    
    public void initUI(){
        frame = new JFrame( "Pokemon V" );
        frame.setIgnoreRepaint( true );
        frame.setResizable( false );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        this.setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
        this.setIgnoreRepaint( true );
        this.setFocusable( true );
        
        frame.add( this );
        frame.pack();
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        
        // Needed to render
        this.createBufferStrategy( 2 );
        strategy = this.getBufferStrategy();
    }
    
    @Override
    public void run() {
        last = System.nanoTime();
        ticks = 0;
        fps = 0;
        lastInfoPrint = System.nanoTime();
        shouldRender = false;
        while( running ){
            now = System.nanoTime();
            elapsed += now - last;   // Time elapsed since last loop
            last = now;
            
            // Tick as many times as it should in "TIME_PER_FRAME" interval
            while( elapsed > TIME_PER_FRAME ){
                elapsed -= TIME_PER_FRAME;
                ticks++;
                tick();
                shouldRender = true;
            }
            
            if( shouldRender ){
                fps++;
                render();
                shouldRender = false;
            }
            
            // If one second has passed since the last info print, print again and update counters
            if( System.nanoTime() - lastInfoPrint > 1000000000 ){
                lastInfoPrint += 1000000000;
                System.out.println( "ticks:" + ticks + ",fps:" + fps );
                fps = 0;
                ticks = 0;
            }
            try {
                Thread.sleep( 1 );
            } catch (Exception e) {}
        }
    }
    
    private void tick(){
        // Update input
        input.tick();
        
        // Update objects
        switch( state ){
            case MAP:
                mapManager.tick();
                break;
            case BATTLE:
                // @TODO
                break;
            case POKEMON_BELT:
                // @TODO
                break;
            case BAG:
                bagManager.tick();
                break;
        }
        
    }
    
    private void render(){
        Graphics2D g = ( Graphics2D )strategy.getDrawGraphics();
          
        // Render screen according to state
        switch( state ){
            case MAP:
                mapManager.render( g );
                break;
            case BATTLE:
                // @TODO
                break;
            case POKEMON_BELT:
                // @TODO
                break;
            case BAG:
                mapManager.render( g );
                bagManager.render( g );
                break;
        }
        
        // Finally, show the contents in g and destroy it
        strategy.show();
        g.dispose();
    }

    /* Getters & Setters */
    public State getState() {
        return state;
    }
    public void setState( State newState ) {
        state = newState;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public BagManager getBagManager() {
        return bagManager;
    }
    
    
    public static void main( String args[] ){
//        new Login().setVisible( true );
        Game game = new Game();
        game.start();
    }
}
