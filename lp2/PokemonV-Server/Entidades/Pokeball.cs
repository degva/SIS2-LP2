using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Pokeball : Item
    {
        public Pokeball(string name, string descrip, TypeofItem type, int catch_probability)
            : base(name, descrip,type)
        {
            this.catch_probability = catch_probability;
        }

        public void catchItem()
        {

        }

        protected int catch_probability;
        public int Catch_probability
        {
            get { return catch_probability; }
            set { catch_probability = value; }
        }

    }
}
