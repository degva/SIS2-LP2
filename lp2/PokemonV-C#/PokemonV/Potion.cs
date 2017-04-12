using System;

namespace PokemonV
{
    public class Potion : Item
    {
        public Potion(string name, string descrip, int points)
            : base(name, descrip)
        {
            this.healthPoints = points;
        }

        public void pour()
        {

        }

        protected int healthPoints;
        public int HealthPoints
        {
            get { return healthPoints; }
            set { healthPoints = value; }
        }
    }
}

