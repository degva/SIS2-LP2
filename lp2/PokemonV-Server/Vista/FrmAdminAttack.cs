using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using AccesoDatos;
using MySql.Data.MySqlClient;
using Entidades;

namespace Vista
{
    public partial class FrmAdminAttack : Form
    {
        public FrmAdminAttack()
        {
            InitializeComponent();
            load();
            init();

            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\gengar.jpg");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            LBLid.BackColor = Color.Transparent;
            LBLname.BackColor = Color.Transparent;
            LBLpoints.BackColor = Color.Transparent;

        }



        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT ID,NAME,POINTS FROM ATTACK ", connection);

                DataSet ds = new DataSet();
                adapter.Fill(ds, "ATTACK");
                DGVattack.DataSource = ds.Tables["ATTACK"];

                connection.Close();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        public void init()
        {

            TXTname.Enabled = false;
            TXTpoints.Enabled = false;
            TXTid.Enabled = false;

            BTNrecover.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;

            TXTname.Text = "";
            TXTpoints.Text = "";
            TXTid.Text = "";


        }

        private void BTNrecover_Click(object sender, EventArgs e)
        {
            if (DGVattack.Rows.Count > 1)
            {

                string CADname = (string)DGVattack.CurrentRow.Cells["NAME"].Value;
                int points = (int)DGVattack.CurrentRow.Cells["POINTS"].Value;
                int id = (int)DGVattack.CurrentRow.Cells["ID"].Value;


                TXTname.Text = CADname;
                TXTpoints.Text = points.ToString();
                TXTid.Text = id.ToString();


                TXTname.Enabled = true;
                TXTpoints.Enabled = true;

                BTNrecover.Enabled = false;
                BTNupdate.Enabled = true;
                BTNcancel.Enabled = true;

            }
        }

        private void BTNupdate_Click(object sender, EventArgs e)
        {
            int id = (int)DGVattack.CurrentRow.Cells["ID"].Value;

            int flag = 1;

            if (TXTname.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if(TXTname.Text.Length > 13)
            {
                MessageBox.Show("Name cant have more than 13 characters", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }


            if (TXTpoints.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTpoints.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTpoints.Text)) < 1)
            {
                MessageBox.Show("Attack points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            if (flag == 1)
            {

                AttackDA attackadmin = new AttackDA();
                attackadmin.updateAttack(id, TXTname.Text, Convert.ToInt32(TXTpoints.Text));
                load();
                init();
            }
        }

        protected override void WndProc(ref Message message)
        {
            const int WM_SYSCOMMAND = 0x0105;
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

        private void BTNback_Click(object sender, EventArgs e)
        {
            FrmAdminEverything form = new FrmAdminEverything();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);

            this.Hide();
            form.ShowDialog();
            this.Close();
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            init();
        }
    }

}
