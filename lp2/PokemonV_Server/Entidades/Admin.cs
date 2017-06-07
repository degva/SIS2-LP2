using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Admin : User
    {
        public Admin(string username, string password, string name, string email) : base(username, password, name, email) { }

        public void kick()
        {

        }
        public void addSpawn()
        {

        }
    }
}
