package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.BattleManager;

public class BattleMenu extends DoubleColumnBattle {

    /* Attributes */
    private Game game;
    private final int attackIndex, bagIndex, giveUpIndex;
    private boolean battleAgainstPlayer;

    /* Constructors */
    public BattleMenu(InputHandler input, int topOffset, int rightOffset, boolean value, Game game) {
        super(input, topOffset, rightOffset);

        this.game = game;
        this.battleAgainstPlayer = value;
        attackIndex = this.addItem("Atacar");
        bagIndex = this.addItem("Mochila");
        giveUpIndex = this.addItem("Huir");
    }

    /* Methods */
    public void tick() {
        super.tick();

        if (input.action.isFirstPressed && this.selectedIndex > -1) {
            if (selectedIndex == attackIndex) {
                game.getBattleManager().setState(BattleManager.State.TYPE_ATTACK_MENU);
            } else if (selectedIndex == bagIndex) {
                game.getBattleManager().setState(BattleManager.State.BAG_MENU);
            } else if (selectedIndex == giveUpIndex) {
                if (battleAgainstPlayer == false) {
                    game.getBattleManager().setState(BattleManager.State.P1_GIVEUP);
                    game.getBattleManager().inicializeTicks();
                } else {
                    game.getBattleManager().setState(BattleManager.State.YOU_CANT_GIVEUP);
                    game.getBattleManager().inicializeTicks();
                }

            }
        }
    }
}
