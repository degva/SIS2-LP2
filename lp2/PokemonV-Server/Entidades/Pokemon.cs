using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public enum TypeofPokemon { Fire, Water, Earth, Wind };
    public class Pokemon
    {
        public Pokemon(int attack1_pts,string attack1_name, string attack2_name, int attack2_pts, int defense_pts, int life, string name, TypeofPokemon type, int deleted)
        {
            this.attack1_pts = attack1_pts;
            this.attack1_name = attack1_name;
            this.attack2_pts = attack2_pts;
            this.attack2_name = attack2_name;
            this.defense_pts = defense_pts;
            this.life = life;
            this.name = name;
            this.type = type;
            this.Deleted = deleted;
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
        private int attack1_pts;
        public int Attack_pts
        {
            get { return attack1_pts; }
            set { attack1_pts = value; }
        }
        private int defense_pts;
        public int Defense_pts
        {
            get { return defense_pts; }
            set { defense_pts = value; }
        }
        private int life;
        public int Life
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
        private TypeofPokemon type;
        public TypeofPokemon Type
        {
            get { return type; }
            set { type = value; }
        }

        public int Deleted { get => deleted; set => deleted = value; }
        public int Attack2_pts { get => attack2_pts; set => attack2_pts = value; }
        public string Attack1_name { get => attack1_name; set => attack1_name = value; }
        public string Attack2_name { get => attack2_name; set => attack2_name = value; }

        private int deleted;

        private int attack2_pts;
        private string attack1_name;
        private string attack2_name;
    }
}
