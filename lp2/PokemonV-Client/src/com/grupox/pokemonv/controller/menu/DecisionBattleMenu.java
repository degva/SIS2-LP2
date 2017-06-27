/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.BattleManager;
import com.grupox.pokemonv.model.Player;

/**
 *
 * @author Kevin
 */
public class DecisionBattleMenu extends DoubleColumnBattle{
     /* Attributes */
    private Game game;
    private Player player;
    private final int yesIndex, noIndex;
    /* Constructors */
    public DecisionBattleMenu(Player player, int topOffset, int rightOffset, Game game) {
        super(player.getInput(), topOffset, rightOffset);
        
        this.player = player;
        this.game = game;

        yesIndex = this.addItem("YES");
        noIndex = this.addItem("NO");
    }

    /* Methods */
    public void tick() {
        super.tick();

        if (input.action.isFirstPressed && this.selectedIndex > -1) {
            if (selectedIndex == yesIndex) {
                int dis = player.getPokeballs().getQuantity() - 1;
                if (dis >= 0) {
                    game.getBattleManager().setInitialSpriteForBattle();
                    game.getBattleManager().setState(BattleManager.State.P1_CAPTURE);
                    player.getPokeballs().setQuantity(dis);
                }else{
                     game.getBattleManager().setState(BattleManager.State.P2_DEAD);
                     game.getBattleManager().inicializeTicks();
                }
            } else if (selectedIndex == noIndex) {
                    game.getBattleManager().setState(BattleManager.State.P2_DEAD);
            } 
        }
    }
}
