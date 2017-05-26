package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.SpriteSheet;
import com.grupox.pokemonv.model.Tile;
import com.grupox.pokemonv.model.User;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
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
    
    private Map map;
    private User user;
    
    public Game(){
        // Main loop
        running = false;
        
        // UI
        initUI();
        
        // Keyboard
        input = new InputHandler();
        this.addKeyListener(input);
        
        // Initialization
        map = new Map();
        user = new Player(input);
        Tile tile = map.getGrid()[0][0];
        tile.setUser(user);
        user.setTile(tile);
    }
    
    public void start(){
        running = true;
        Thread thread = new Thread(this);   // Start this class as a new thread
        thread.run();   // Calls Game.run();
    }
    
    public void initUI(){
        frame = new JFrame("Pokemon V");
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setIgnoreRepaint(true);
        this.setFocusable(true);
        
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        // Needed to render
        this.createBufferStrategy(2);
        strategy = this.getBufferStrategy();
    }
    
    @Override
    public void run() {
        last = System.nanoTime();
        ticks = 0;
        fps = 0;
        lastInfoPrint = System.nanoTime();
        shouldRender = false;
        while(running){
            now = System.nanoTime();
            elapsed += now - last;   // Time elapsed since last loop
            last = now;
            
            // Tick as many times as it should in "TIME_PER_FRAME" interval
            while(elapsed > TIME_PER_FRAME){
                elapsed -= TIME_PER_FRAME;
                ticks++;
                tick();
                shouldRender = true;
            }
            
            if(shouldRender){
                fps++;
                render();
                shouldRender = false;
            }
            
            // If one second has passed since the last info print, print again and update counters
            if(System.nanoTime() - lastInfoPrint > 1000000000){
                lastInfoPrint += 1000000000;
                System.out.println("ticks:" + ticks + ",fps:" + fps);
                fps = 0;
                ticks = 0;
            }
        }
    }
    
    private void tick(){
        user.tick();
    }
    
    private void render(){
        Graphics2D g = ( Graphics2D )strategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        map.render(g, user);
        
        
        // Finally, show the contents in g and destroy it
        strategy.show();
        g.dispose();
        
//        // Test
//        g.drawImage(SpriteSheet.getInstance().getSubImage(0, 0), 0, 0, 14*4,21*4, null);
//        strategy.show();
//        g.dispose();
    }
    
    public static void main( String args[] ){
        Game game = new Game();
        game.start();
    }
}
