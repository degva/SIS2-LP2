using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;


namespace Vista
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            //Application.Run(new FrmAdminUser());
            Application.Run(new FrmLogin());
            //Application.Run(new FrmAdminPokemon());
            //Application.Run(new FrmAdminPlayerxItem());
            //Application.Run(new FrmAdminPlayerxPokemon());
            //Application.Run(new FrmAdminEverything());
            //Application.Run(new FrmAdminItem());
            //Application.Run(new FrmAdminAttack());

        }
    }
}