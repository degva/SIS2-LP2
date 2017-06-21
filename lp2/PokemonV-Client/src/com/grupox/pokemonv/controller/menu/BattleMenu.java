package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Font;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.BattleManager;
import com.grupox.pokemonv.controller.menu.SingleColumnMenu;
import com.grupox.pokemonv.model.Player;

public class BattleMenu extends DoubleColumnMenu {

    /* Attributes */
    private Game game;
    private Player player;
    private final int attackIndex, bagIndex, giveUpIndex;

    /* Constructors */
    public BattleMenu(InputHandler input, int topOffset, int rightOffset, Game game) {
        super(input, topOffset, rightOffset);

        this.player = player;
        this.game = game;

        attackIndex = this.addItem("Atacar");
        bagIndex = this.addItem("Mochila");
        giveUpIndex = this.addItem("Huir");
    }

    /* Methods */
    public void tick() {
        super.tick();

        if (input.action.isFirstPressed && this.selectedIndex > -1) {
            if (selectedIndex == attackIndex) {
                //Disminuir vida del jugador
                //Animacion
                game.getBattleManager().setState(BattleManager.State.P1_ATTACK);
                System.out.println("Se ha atacado al otro jugador");
                
            } else if (selectedIndex == bagIndex) {
                game.getBattleManager().setState(BattleManager.State.P1_BAG);
                System.out.println("Se ha usado la mochila");
            } else if (selectedIndex == giveUpIndex) {
                game.getBattleManager().setState(BattleManager.State.P1_GIVEUP);
                System.out.println("Se ha retirado el usuario");
                game.getBattleManager().inicializeTicks();
            }

        }
    }
}
