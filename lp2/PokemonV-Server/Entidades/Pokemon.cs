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
        public Pokemon(string name, int life, int defense_pts, TypeofPokemon type, int attack1id, int attack2id, int deleted )
        {   
            this.defense_pts = defense_pts;
            this.life = life;
            this.name = name;
            this.type = type;
            this.attack1_id = attack1id;
            this.attack2_id = attack2id;
            this.deleted = deleted;
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
        public int Attack1_id { get => attack1_id; set => attack1_id = value; }
        public int Attack2_id { get => attack2_id; set => attack2_id = value; }

        int attack1_id;
        int attack2_id;
        private int deleted;
    }
}
