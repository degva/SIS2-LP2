using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Attack
    {

        public Attack(int id, string name, int points)
        {
            this.Id = id;
            this.Name = name;
            this.Points = points;
        }


        private int id;
        private string name;
        private int points;

        public int Points { get => points; set => points = value; }
        public string Name { get => name; set => name = value; }
        public int Id { get => id; set => id = value; }
    }
}
