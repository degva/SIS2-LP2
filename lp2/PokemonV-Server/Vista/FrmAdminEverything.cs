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
    public partial class FrmAdminEverything : Form
    {
        public FrmAdminEverything()
        {
            InitializeComponent();
        }

        private void BTNmanageusers_Click(object sender, EventArgs e)
        {
            FrmAdminUser form = new FrmAdminUser();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

            }
        }

        private void BTNmanagepokemon_Click(object sender, EventArgs e)
        {
            FrmAdminPokemon form = new FrmAdminPokemon();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

            }
        }

        private void BTNmanageplayerspokemon_Click(object sender, EventArgs e)
        {
            FrmAdminPlayerxPokemon form = new FrmAdminPlayerxPokemon();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

            }
        }

        private void BTNmanageitem_Click(object sender, EventArgs e)
        {
            FrmAdminItem form = new FrmAdminItem();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

            }
        }
    }
}
