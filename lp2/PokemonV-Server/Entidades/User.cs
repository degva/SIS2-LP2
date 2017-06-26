using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public enum Direction { Up, Down, Right, Left };
    public abstract class User
    {
        public User(string username, string password, string name, string email, int deleted, int isAdmin, int npc)
        {
            this.username = username;
            this.password = password;
            this.name = name;
            this.email = email;
            this.deleted = deleted;
            this.isAdmin = isAdmin;
            this.npc_type = npc;
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
        public int Npc_type { get => npc_type; set => npc_type = value; }

        protected int isAdmin;

        protected int npc_type;
    }
}
