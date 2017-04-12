using System.ComponentModel;

namespace PokemonV
{
    class Player : User
    {
        public Player(string username, string password, string name, string email) : base(username, password, name, email) {}

        public bool catchPokemon() {
            return true;
        }
        public bool catchItem() {
            return true;
        }

        protected BindingList<Pokemon> pokemons;
        public BindingList<Pokemon> Pokemons
        {
            get { return pokemons; }
            set { pokemons = value; }
        }
    }
}
