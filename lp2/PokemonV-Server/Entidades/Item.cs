using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public enum TypeofItem { Potion, Pokeball, Repellent };
    public class Item
    {
        
        public Item(string name, TypeofItem typePoke, int deleted)
        {
            this.deleted = deleted;
            this.name = name;
            this.type = typePoke;
        }


        
        protected string name;
        public string Name
        {
            get { return name; }
            set { name = value; }
        }


        public TypeofItem Type { get => type; set => type = value; }
        public int Deleted { get => deleted; set => deleted = value; }

        private TypeofItem type;

        private int deleted;
    }
}
