using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Potion : Item
    {
        public Potion(string name, string descrip,TypeofItem type, int points)
            : base(name, descrip,type)
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
