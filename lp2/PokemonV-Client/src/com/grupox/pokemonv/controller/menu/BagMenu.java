package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.manager.BattleManager;
import com.grupox.pokemonv.model.Player;

public class BagMenu extends QuantityMenu {

    /* Attributes */
    private Game game;
    private Player player;
    private final int pokeballsIndex, potionsIndex, closeIndex;
    private boolean battleAgainstPlayer;

    /* Constructors */
    public BagMenu(Player player, int topOffset, int rightOffset, boolean typeOfBattle, Game game) {
        super(player.getInput(), topOffset, rightOffset);

        this.player = player;
        this.game = game;
        this.battleAgainstPlayer = typeOfBattle;

        pokeballsIndex = this.addItem(player.getPokeballs().getName(), player.getPokeballs().getQuantity());
        potionsIndex = this.addItem(player.getPotions().getName(), player.getPotions().getQuantity());
        closeIndex = this.addItem("Close");
    }

    /* Methods */
    @Override
    public void tick() {
        super.tick();

        updateQuantities();

        if (Game.getState() == Game.State.BAG) {
            if (input.action.isFirstPressed && !items.isEmpty()) {
                if (items.get(selectedIndex).getDescription().equals("Close")) {
                    game.setState(Game.State.MAP);
                }
            } else if (input.back.isFirstPressed) {
                game.setState(Game.State.MAP);
            }
        } else if (Game.getState() == Game.State.BATTLE) {
            if (input.action.isFirstPressed && this.selectedIndex > -1) {
                if (selectedIndex == pokeballsIndex) {
                    if (battleAgainstPlayer == false) {
                        int dis = player.getPokeballs().getQuantity() - 1;
                        if (dis >= 0) {
                            //Si tengo pokeballs
                            //Verificar vida del otro jugador
                            //Referencia de vida
                            int minimoDamage = 112;
                            int vidaPok2 = game.getBattleManager().getVidaPok2();
                            int danioActual = game.getBattleManager().getRespectiveLife(2, vidaPok2, 140);
                            if (danioActual>=minimoDamage){
                                game.getBattleManager().setInitialSpriteForBattle();
                                game.getBattleManager().setState(BattleManager.State.P1_CAPTURE);
                                player.getPokeballs().setQuantity(dis);
                            }
                            else {
                                game.getBattleManager().setState(BattleManager.State.POKEMON_NOT_WEAK);
                                game.getBattleManager().inicializeTicks();
                            }
                            
                        }
                        else {
                            game.getBattleManager().setState(BattleManager.State.P1_NOT_ENOUGH_POKEBALLS);
                            game.getBattleManager().inicializeTicks();
                        }

                    }
                } else if (selectedIndex == potionsIndex) {
                    if (!game.getBattleManager().isAlreadyHealed()) {
                        int dis = player.getPotions().getQuantity() - 1;
                        if (dis >= 0) {
                            game.getBattleManager().setState(BattleManager.State.P1_HEAL);
                            int effect = player.getPotions().getHp();
                            player.getPotions().setQuantity(dis);
                            game.getBattleManager().setHealEffect(effect);
                        }
                        else{
                            game.getBattleManager().setState(BattleManager.State.P1_NOT_ENOUGH_POTIONS);
                            game.getBattleManager().inicializeTicks();
                        }
                    } else {
                        game.getBattleManager().setState(BattleManager.State.P1_ALREADY_HEALED);
                        game.getBattleManager().inicializeTicks();
                    }
                } else if (selectedIndex == closeIndex) {
                    game.getBattleManager().setState(BattleManager.State.P1_IDLE);
                }
            }
        }
    }

    private void updateQuantities() {
        QuantityMenuItem item = (QuantityMenuItem) items.get(pokeballsIndex);
        item.setQuantity(player.getPokeballs().getQuantity());

        item = (QuantityMenuItem) items.get(potionsIndex);
        item.setQuantity(player.getPotions().getQuantity());
    }
}
