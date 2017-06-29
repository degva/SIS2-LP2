using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class Admin : User
    {
        public Admin(string username, string password, string name, string email, int deleted, int isAdmin, string npc, int can_battle,
                        int battle_dialog_id, int defeat_dialog_id, Direction direction) : base(username, password, name, email, deleted, isAdmin, npc, can_battle,
                                                                                               battle_dialog_id, defeat_dialog_id, direction) { }

        public void kick()
        {

        }
        public void addSpawn()
        {

        }
    }
}
