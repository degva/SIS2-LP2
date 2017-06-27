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


            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\mystic.jpg");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;

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

        private void BTNpalyersitem_Click(object sender, EventArgs e)
        {
            FrmAdminPlayerxItem form = new FrmAdminPlayerxItem();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

            }
        }

        private void BTNmanageattack_Click(object sender, EventArgs e)
        {
            FrmAdminAttack form = new FrmAdminAttack();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

            }
        }

        protected override void WndProc(ref Message message)
        {
            const int WM_SYSCOMMAND = 0x0112;
            const int SC_MOVE = 0xF010;

            switch (message.Msg)
            {
                case WM_SYSCOMMAND:
                    int command = message.WParam.ToInt32() & 0xfff0;
                    if (command == SC_MOVE)
                        return;
                    break;
            }

            base.WndProc(ref message);
        }
    }
}
