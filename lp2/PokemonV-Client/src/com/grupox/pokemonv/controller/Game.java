package com.grupox.pokemonv.controller;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
    private boolean running = false;
    
    private JFrame frame;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private BufferStrategy strategy;
    
    private double now, last, elapsed, lastInfoPrint;
    private int ticks, fps;
    private boolean shouldRender;
    public final int FPS = 60;
    public final double TIME_PER_FRAME = 1000000000/FPS;    // 1 second as nanosecond / 60 frames
    
    public Game(){
        running = false;
        initUI();
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
        
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        // Needed to render in the future
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
    }
    
    private void render(){
    }
    
    public static void main(String args[]){
        Game game = new Game();
        game.start();
    }
}
