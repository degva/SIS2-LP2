namespace PokemonV
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
