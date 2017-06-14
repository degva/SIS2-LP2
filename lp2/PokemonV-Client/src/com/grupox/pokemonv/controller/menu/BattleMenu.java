
package com.grupox.pokemonv.controller.menu;
import com.grupox.pokemonv.controller.Font;
import com.grupox.pokemonv.controller.Game;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.controller.manager.BattleManager;
import com.grupox.pokemonv.controller.menu.SingleColumnMenu;
import com.grupox.pokemonv.model.Player;

public class BattleMenu extends SingleColumnMenu {
    
    /* Attributes */
    private Game game;
    private Player player;
    private final int attackIndex,bagIndex,giveUpIndex;
   
    
    /* Constructors */
    public BattleMenu( InputHandler input, int topOffset, int rightOffset, Game game ) {
        super( input, topOffset, rightOffset );
        
        this.player = player;
        this.game = game;
        
        attackIndex = this.addItem( "Atacar" );
        bagIndex = this.addItem("Mochila");
        giveUpIndex = this.addItem("Huir");
    }
    
    /* Methods */
    public void tick(){
        super.tick();
        
        if( input.action.isFirstPressed && this.selectedIndex > -1){
            if( selectedIndex == attackIndex){
                //Disminuir vida del jugador
                //Animacion
                game.getBattleManager().setOptionState(BattleManager.OptionS.REG_ATTACK);
                game.getBattleManager().setMessage("Has atacado!");
                System.out.println("Se ha atacado al otro jugador");
            }
            else if (selectedIndex==bagIndex){
                game.getBattleManager().setOptionState(BattleManager.OptionS.REG_BAG);
                System.out.println("Se ha usado la mochila");
                game.getBattleManager().setMessage("Has usado la mochila!");
            }
            else if (selectedIndex == giveUpIndex){
                game.getBattleManager().setOptionState(BattleManager.OptionS.REG_GIVEUP);
                game.getBattleManager().setMessage("Te has rendido!");
                System.out.println("Se ha retirado el usuario");
            }
            
        }
    }
}
