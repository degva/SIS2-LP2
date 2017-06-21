using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Vista
{
    public partial class FrmAdminPlayerxPokemon : Form
    {
        public FrmAdminPlayerxPokemon()
        {
            InitializeComponent();
            inicio();
        }


        public void inicio()
        {
            TXTexperience.Enabled = false;
            TXTlevel.Enabled = false;
            

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTexperience.Text = "";
            TXTlevel.Text = "";
        }



    }
}
