package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.BattleManager;

public class TypeAttackMenuP1 extends DoubleColumnBattle {

    /* Attributes */
    private Game game;
    private final int radipAttackIndex, otherAttackIndex;
    private final int closeIndex;

    /* Constructors */
    public TypeAttackMenuP1(InputHandler input, int topOffset, int rightOffset,String attack1_name,String attack2_name, Game game) {
        super(input, topOffset, rightOffset);
        //BULBASAUR
        this.game = game;

//        radipAttackIndex = this.addItem("Rapid Attack");
//        otherAttackIndex = this.addItem("Vine Whip");

        radipAttackIndex = this.addItem(attack1_name);
        otherAttackIndex = this.addItem(attack2_name);
        closeIndex = this.addItem("Close");
    }

    /* Methods */
    public void tick() {
        super.tick();

        if (input.action.isFirstPressed && this.selectedIndex > -1) {
            if (selectedIndex == radipAttackIndex) {
                game.getBattleManager().setState(BattleManager.State.P1_ATTACK_FIRST);
            } else if (selectedIndex == otherAttackIndex) {
                game.getBattleManager().setState(BattleManager.State.P1_ATTACK_SECOND);
            } 
            else if (selectedIndex == closeIndex) {
                game.getBattleManager().setState(BattleManager.State.P1_IDLE);
            }
        }
    }
}
