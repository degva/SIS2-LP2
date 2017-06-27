package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.BD.DataAccess;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.menu.MapMenu;
import com.grupox.pokemonv.model.Dialog;
import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Renderable;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapManager {
    /* Enum declaration */
    public enum State { MENU, MOVING, BATTLE_DIALOG, DEFEAT_DIALOG };
    
    /* Attributes */
    private Game game;
    private Map map;
    private Player player;
    private InputHandler input;
    
    private MapMenu menu;
    private State state;
    private Dialog dialog;
    private Player enemy;
    
    /* Constructors */
    public MapManager( Game game ){
        this.game = game;
        this.input = game.getInput();
        this.dialog = new Dialog("");
        
        DataAccess da = new DataAccess();
        map = da.loadMap(1, 4, input, game);
        player = game.getPlayer();
        
        menu = new MapMenu( input, 20, Game.WIDTH / 80, game );
        state = State.MOVING;
    }
    
    /* Methods */
    public void tick(){
        
        // Listen to input and set the inner state
        map.tick();
        
        if( state == State.MOVING && input.menu.isFirstPressed ){
            // Set first element as selected
            menu.setSelectedItem( 0 );            
            state = State.MENU;
        }else if( state == State.MOVING && input.action.isFirstPressed ){
            enemy = map.tryBattle(player, player.getDirection());
            enemy.setDirection(map.getDirectionFacingPlayer(player, enemy));
            if(enemy != null){
                if(enemy.getCanBattle()){
                    dialog = enemy.getBattleDialog();
                    setState(State.BATTLE_DIALOG);
                }else{
                    dialog = enemy.getDefeatDialog();
                    setState(State.DEFEAT_DIALOG);
                }
            }
        }else if( state == State.MENU && ( input.back.isFirstPressed || input.menu.isFirstPressed) ){
            state = State.MOVING;
        }else if( state == State.BATTLE_DIALOG){
            if( input.action.isFirstPressed ){
                setState(State.MOVING);
                Game.setState(Game.State.BATTLE);
                game.getBattleManager().startBattle(player, enemy);
            }
        }else if (state == State.DEFEAT_DIALOG){
            if( input.action.isFirstPressed ){
                setState(State.MOVING);
            }
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
    
    public void render( Graphics2D g ){
        // Print background
        g.setColor( Color.black );
        g.fillRect( 0, 0, Game.WIDTH, Game.HEIGHT );
        
        map.render(g, player );
        
        switch (state){
            case MENU:
                menu.render(g);
                break;
            case BATTLE_DIALOG:
            case DEFEAT_DIALOG:
                dialog.render(g);
                break;
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

    public Dialog getDialog() {
        return dialog;
    }
    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
    
}
