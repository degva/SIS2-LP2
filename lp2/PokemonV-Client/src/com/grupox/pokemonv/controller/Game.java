package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.BD.DataAccess;
import com.grupox.pokemonv.controller.manager.PokemonBeltManager;
import com.grupox.pokemonv.model.Player;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import com.grupox.pokemonv.controller.manager.*;
import com.grupox.pokemonv.model.Pokemon;
import com.grupox.pokemonv.model.SpriteSheet;
import com.grupox.pokemonv.model.Tile;
import com.grupox.pokemonv.view.FrmLogin;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Canvas implements Runnable {
    /* Enum declaration */
    public enum State {
        MAP, BATTLE, POKEMON_BELT, BAG
    };

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
    public final double TIME_PER_FRAME = 1000000000 / FPS;    // 1 second as nanosecond / 60 frames

    private MapManager mapManager;
    private BagManager bagManager;
    private BattleManager battleManager;
    private Player player;
    private static State state;
    private PokemonBeltManager pokemonBeltManager;
    private ArrayList<Pokemon> allPokemons;

    public static int player_id=0;
    
    /* Constructors */
    public Game() {
        // Main loop
        running = false;

        // Keyboard
        input = new InputHandler();
        this.addKeyListener(input);
        
        // WindowsListener

        // Initialization
        allPokemons = new DataAccess().loadAllPokemons();
        mapManager = new MapManager(this);
        pokemonBeltManager = new PokemonBeltManager(player, this);
        bagManager = new BagManager(player, this);
        battleManager = new BattleManager(this);
    }

    /* Methods */
    public void start() {
        // UI
        initUI();
        Sound.getInstance().stop(Sound.AUDIO.INTRO);
        Sound.getInstance().start(Sound.AUDIO.MAP);
        setState(State.MAP);
        
        running = true;
        Thread thread = new Thread(this);   // Start this class as a new thread
        thread.run();   // Calls Game.run();
    }
    
    public void stop() {
        running = false;
        frame.setVisible(false);
        Sound.getInstance().stop(Sound.AUDIO.BATTLE);
        Sound.getInstance().stop(Sound.AUDIO.BEFORE_BATTLE);
        Sound.getInstance().stop(Sound.AUDIO.MAP);
    }

    public void initUI() {
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
        frame.setIconImage(SpriteSheet.getInstance().getSubImage(7, 0));

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
        while (running) {
            now = System.nanoTime();
            elapsed += now - last;   // Time elapsed since last loop
            last = now;

            // Tick as many times as it should in "TIME_PER_FRAME" interval
            while (elapsed > TIME_PER_FRAME) {
                elapsed -= TIME_PER_FRAME;
                ticks++;
                tick();
                shouldRender = true;
            }

            if (shouldRender) {
                fps++;
                render();
                shouldRender = false;
            }

            // If one second has passed since the last info print, print again and update counters
            if (System.nanoTime() - lastInfoPrint > 1000000000) {
                lastInfoPrint += 1000000000;
                System.out.println("ticks:" + ticks + ",fps:" + fps);
                fps = 0;
                ticks = 0;
            }
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
        }
    }

    private void tick() {
        // Update input
        input.tick();

        // Update objects
        switch (state) {
            case MAP:
                mapManager.tick();
                break;
            case BATTLE:
                battleManager.tick();
                break;
            case POKEMON_BELT:
                pokemonBeltManager.tick();
                break;
            case BAG:
                bagManager.tick();
                break;
        }
    }

    private void render() {
        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        // Render screen according to state
        switch (state) {
            case MAP:
                mapManager.render(g);
                break;
            case BATTLE:
                battleManager.render(g);
                break;
            case POKEMON_BELT:
                pokemonBeltManager.render(g);
                break;
            case BAG:
                mapManager.render(g);
                bagManager.render(g);
                break;
        }
        // Finally, show the contents in g and destroy it
        strategy.show();
        g.dispose();
    }
    
    /* Getters & Setters */
    public static State getState() {
        return state;
    }

    public static void setState(State newState) {
        switch (newState) {
            case BATTLE:
                Sound.getInstance().stop(Sound.AUDIO.MAP);
                Sound.getInstance().stop(Sound.AUDIO.BEFORE_BATTLE);
                Sound.getInstance().start(Sound.AUDIO.BATTLE);
                break;
            case MAP:
                Sound.getInstance().stop(Sound.AUDIO.BATTLE);
                Sound.getInstance().start(Sound.AUDIO.MAP);
                break;
            default:
                break;
        }
        state = newState;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public PokemonBeltManager getPokemonBeltManager() {
        return pokemonBeltManager;
    }

    public BattleManager getBattleManager() {
        return battleManager;
    }

    public BagManager getBagManager() {
        return bagManager;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public InputHandler getInput() {
        return input;
    }

    public void setInput(InputHandler input) {
        this.input = input;
    }

    public ArrayList<Pokemon> getAllPokemons() {
        return allPokemons;
    }

    public void setAllPokemons(ArrayList<Pokemon> allPokemons) {
        this.allPokemons = allPokemons;
    }

    public static void main(String args[]) {
//        new Login().setVisible( true );
//        Game game = new Game();
//        game.start();
        FrmLogin frame = new FrmLogin();

        while (true) {
            if (frame.getA() == 1) {
                Game game = new Game();
                game.start();
                break;
            }
            try{
                Thread.sleep(1000);
            }catch(Exception exp){
            
            }
        }
    }

    public int getNumTicks() {
        return ticks;
    }
}
