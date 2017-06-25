package com.grupox.pokemonv.controller;

import com.grupox.pokemonv.controller.manager.PokemonBeltManager;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Player;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import com.grupox.pokemonv.controller.manager.*;
import com.grupox.pokemonv.model.Dialog;
import com.grupox.pokemonv.model.Pokemon;
import com.grupox.pokemonv.model.SpriteSheet;
import com.grupox.pokemonv.model.Tile;

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

    /* Constructors */
    public Game() {
        // Main loop
        running = false;
        // Keyboard
        input = new InputHandler();
        this.addKeyListener(input);

        // Initialization
        mapManager = new MapManager(this);
        pokemonBeltManager = new PokemonBeltManager(player, this);
        bagManager = new BagManager( player, this);
        battleManager = new BattleManager(this);
        
        state = State.MAP;
             
//        HARDCODED
//        player.getPokemons().add(new Pokemon(4, 10, "RAPID ATTACK", 20, "LANZAHOJAS", 20, 120, "Bulbasaur", Pokemon.TypeP.Wind, true));
//        player.getPokemons().add(new Pokemon(4,30,20,46,"Charmander", Pokemon.TypeP.Fire));
//        player.getPokemons().add(new Pokemon(1,10,20,30,"Bulbasaur", Pokemon.TypeP.Earth));
//        player.getPokemons().add(new Pokemon(12,60,22,44,"Butterfree", Pokemon.TypeP.Earth));
//        player.getPokemons().add(new Pokemon(7,10,10,10,"Squirtle5", Pokemon.TypeP.Earth));
//        player.getPokemons().add(new Pokemon(1,10,10,10,"Carlos2", Pokemon.TypeP.Earth));
//        enemy.getPokemons().add(new Pokemon(2,10,10,10,"Bulbasaur", Pokemon.TypeP.Earth));

        // UI
        initUI();
    }

    /* Methods */
    public void start() {
        running = true;
        Thread thread = new Thread(this);   // Start this class as a new thread
        thread.run();   // Calls Game.run();
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
    
    

    public static void main(String args[]) {
//        new Login().setVisible( true );
        Game game = new Game();
        game.start();
        

    }
    public int getNumTicks(){
        return ticks;
    }
}
