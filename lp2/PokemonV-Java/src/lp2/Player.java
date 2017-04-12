package lp2;

import javax.swing.DefaultListModel;

public class Player extends User {

    private DefaultListModel<Pokemon> pokemons;

    public DefaultListModel<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(DefaultListModel<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Player(String username, String password, String name, String email, int pos_x, int pos_y, Direction direction, DefaultListModel<Item> bag,DefaultListModel<Pokemon> pok){
        super(username,password,name,email,pos_x,pos_y,direction,bag);
        this.pokemons = pok;
    }
    public void catchPokemon() {

    }

    public void catchItem() {

    }
}
