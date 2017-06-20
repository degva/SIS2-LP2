using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Player : User
    {
        public Player(string username, string password, string name, string email, int deleted, int isAdmin) : base(username, password, name, email, deleted, isAdmin) { }

        public bool catchPokemon()
        {
            return true;
        }
        public bool catchItem()
        {
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
