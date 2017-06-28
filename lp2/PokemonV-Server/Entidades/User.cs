using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public enum Direction { UP, DOWN, RIGHT, LEFT };
    public abstract class User
    {
        public User(string username, string password, string name, string email, int deleted, int isAdmin, string npc, int can_battle,
                        int battle_dialog_id, int defeat_dialog_id, Direction direction)
        {
            this.username = username;
            this.password = password;
            this.name = name;
            this.email = email;
            this.deleted = deleted;
            this.isAdmin = isAdmin;
            this.npc_type = npc;
            this.direction = direction;
            this.can_battle = can_battle;
            this.battle_dialog_id = battle_dialog_id;
            this.defeat_dialog_id = defeat_dialog_id;
        }

        public bool move()
        {
            return true;
        }
        public void login()
        {

        }
        public void logout()
        {

        }
        public void talk()
        {
        }


        protected string username;
        public string Username
        {
            get { return username; }
            set { username = value; }
        }

        protected string password;
        public string Password
        {
            get { return password; }
            set { password = value; }
        }
        protected string name;
        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        protected string email;
        public string Email
        {
            get { return email; }
            set { email = value; }
        }

        private int deleted;

        protected float pos_x;
        public float Pos_x
        {
            get { return pos_x; }
            set { pos_x = value; }
        }

        protected float pos_y;
        public float Pos_y
        {
            get { return pos_y; }
            set { pos_y = value; }
        }

        protected Direction direction;
        public Direction Direction
        {
            get { return direction; }
            set { direction = value; }
        }

        protected BindingList<Item> bag;
        public BindingList<Item> Bag
        {
            get { return bag; }
            set { bag = value; }
        }

        
        public int IsAdmin { get => isAdmin; set => isAdmin = value; }
        public int Deleted { get => deleted; set => deleted = value; }
        public string Npc_type { get => npc_type; set => npc_type = value; }
        public int Can_battle { get => can_battle; set => can_battle = value; }
        public int Battle_dialog_id { get => battle_dialog_id; set => battle_dialog_id = value; }
        public int Defeat_dialog_id { get => defeat_dialog_id; set => defeat_dialog_id = value; }

        protected int isAdmin;

        private string npc_type;

        private int can_battle;

        private int battle_dialog_id;

        private int defeat_dialog_id;
    }
}
