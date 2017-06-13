using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public enum Type { Fire, Water, Earth, Wind };
    public class Pokemon
    {
        public Pokemon(int id, float attack_pts, float defense_pts, float life, string name, Type type)
        {
            this.id = id;
            this.attack_pts = attack_pts;
            this.defense_pts = defense_pts;
            this.life = life;
            this.name = name;
            this.type = type;
        }

        public void attack(Pokemon pokemon)
        {

        }
        public void takeDamage(float attack_pts)
        {

        }



        private int id;
        public int Id
        {
            get { return id; }
            set { id = value; }
        }
        private float attack_pts;
        public float Attack_pts
        {
            get { return attack_pts; }
            set { attack_pts = value; }
        }
        private float defense_pts;
        public float Defense_pts
        {
            get { return defense_pts; }
            set { defense_pts = value; }
        }
        private float life;
        public float Life
        {
            get { return life; }
            set { life = value; }
        }
        private string name;
        public string Name
        {
            get { return name; }
            set { name = value; }
        }
        private Type type;
        public Type Type
        {
            get { return type; }
            set { type = value; }
        }
    }
}
