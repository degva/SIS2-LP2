﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public enum TypeofPokemon { Fire, Water, Earth, Wind };
    public class Pokemon
    {
        public Pokemon(int attack_pts, int defense_pts, int life, string name, TypeofPokemon type, int deleted)
        {
            this.attack_pts = attack_pts;
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
        private int attack_pts;
        public int Attack_pts
        {
            get { return attack_pts; }
            set { attack_pts = value; }
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

        private int deleted;
    }
}
