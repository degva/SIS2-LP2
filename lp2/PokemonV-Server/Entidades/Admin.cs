using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Admin : User
    {
        public Admin(string username, string password, string name, string email, int deleted, int isAdmin) : base(username, password, name, email, deleted, isAdmin) { }

        public void kick()
        {

        }
        public void addSpawn()
        {

        }
    }
}
