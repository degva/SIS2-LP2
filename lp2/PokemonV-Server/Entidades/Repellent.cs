using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Repellent : Item
    {
        public Repellent(string name, string descrip, TypeofItem type, int steps)
            : base(name, descrip,type)
        {
            this.steps = steps;
        }


        protected int steps;
        public int Steps
        {
            get { return steps; }
            set { steps = value; }
        }
    }
}
