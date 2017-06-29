package com.grupox.pokemonv.controller.manager;

import com.grupox.pokemonv.BD.DataAccess;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.Sound;
import com.grupox.pokemonv.controller.menu.MapMenu;
import com.grupox.pokemonv.model.Dialog;
import com.grupox.pokemonv.model.Map;
import com.grupox.pokemonv.model.Player;
import com.grupox.pokemonv.model.Renderable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapManager {
    /* Enum declaration */
    public enum State { MENU, MOVING, BATTLE_DIALOG, DEFEAT_DIALOG, SAVING };
    
    /* Attributes */
    private Game game;
    private Map map;
    private Player player;
    private InputHandler input;
    private DataAccess da;
    
    private MapMenu menu;
    private State state;
    private Dialog dialog;
    private Player enemy;
    
    /* Constructors */
    public MapManager( Game game ){
        this.game = game;
        this.input = game.getInput();
        this.dialog = new Dialog("");
        
        da = new DataAccess();
        map = da.loadMap(1, Game.player_id, input, game);
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
            if(enemy != null){
                enemy.setDirection(map.getDirectionFacingPlayer(player, enemy));
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
            case SAVING:
                dialog.render(g);
                break;
        }
    }
    
    public void updateMap(){
        setState(State.SAVING);
        dialog.setContent("SAVING. DO NOT CLOSE THE GAME.");
        try {
            da.updatePlayers(map);
        } catch (SQLException ex) {
            Logger.getLogger(MapManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.setContent("GAME SAVED SUCCESSFULLY!");
        setState(State.DEFEAT_DIALOG);
    }
    
    
    /* Getters && Setters */
    public State getState() {
        return state;
    }
    public void setState( State state ) {
        switch(state){
            case BATTLE_DIALOG:
                Sound.getInstance().stop(Sound.AUDIO.MAP);
                Sound.getInstance().start(Sound.AUDIO.BEFORE_BATTLE);
                break;
        }
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

    public DataAccess getDa() {
        return da;
    }

    public void setDa(DataAccess da) {
        this.da = da;
    }
    
    
}
