package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.BD.DataAccess;
import com.grupox.pokemonv.BD.MapDA;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.menu.MapMenu;
import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Player;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapManager {
    /* Enum declaration */
    public enum State { MENU, MOVING };
    
    /* Attributes */
    private Game game;
    private Map map;
    private Player player;
    private InputHandler input;
    
    private MapMenu menu;
    private State state;
    
    /* Constructors */
    public MapManager( Player player, Game game ){
        this.player = player;
        this.game = game;
        input = player.getInput();
        
        //MapDA mapDA = new MapDA();
        //map = mapDA.getMap();
        DataAccess da = new DataAccess();
        map = da.loadMap(1, 5, input);
        
        menu = new MapMenu( input, 20, Game.WIDTH / 80, game );
        state = State.MOVING;
    }
    
    /* Methods */
    public void tick(){
        
        // Listen to input and set the inner state
        if( state == State.MOVING && input.menu.isFirstPressed ){
            // Set first element as selected
              menu.setSelectedItem( 0 );
            
            state = State.MENU;
        }else if( state == State.MOVING && input.action.isFirstPressed ){
            Player enemy = map.tryBattle((Player)player, player.getDirection());
            if(enemy != null){
                Game.setState(Game.State.BATTLE);
                game.getBattleManager().startBattle((Player)player, enemy);
            }
        }else if( state == State.MENU && ( input.back.isFirstPressed || input.menu.isFirstPressed) ){
            state = State.MOVING;
        }
        
        // Tick according to state
        switch ( state ){
            case MENU:
                menu.tick();
                break;
            case MOVING:
                player.tick();
                break;
        }
    }
    
    public void render( Graphics2D g){
        // Print background
        g.setColor( Color.black );
        g.fillRect( 0, 0, Game.WIDTH, Game.HEIGHT );
        
        map.render(g, player );
        
        if( state == State.MENU ){
            menu.render(g);
        }
    }
    
    /* Getters && Setters */

    public State getState() {
        return state;
    }
    public void setState( State state ) {
        this.state = state;
    }

    public Map getMap() {
        return map;
    }
    
}
