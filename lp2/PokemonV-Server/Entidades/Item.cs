using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Item
    {
        public Item(string name, string description)
        {
            this.name = name;
            this.description = description;
        }

        protected string name;
        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        protected string description;
        public string Description
        {
            get { return description; }
            set { description = value; }
        }
    }
}
