using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Item
    {
        public enum TypeofItem { Potion, Pokeball, Repellent};
        public Item(string name, string description, TypeofItem typePoke)
        {
            this.name = name;
            this.description = description;
            this.type = typePoke;
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

        public TypeofItem Type { get => type; set => type = value; }

        protected TypeofItem type;

    }
}
