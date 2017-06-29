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
using System.Text.RegularExpressions;

namespace Vista
{
    public partial class FrmAdminPlayerxItem : Form
    {
        int lastitemid, lastplayerid;
        public FrmAdminPlayerxItem()
        {
            InitializeComponent();
            init();
            load();

            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\mewtwo.png");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            LBLitemid.BackColor = Color.Transparent;
            LBLplayerid.BackColor = Color.Transparent;
            LBLquantity.BackColor = Color.Transparent;

        }


        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT PLAYER_ID,ITEM_ID,QUANTITY FROM PLAYER_X_ITEM WHERE QUANTITY > 0 ", connection);

                DataSet ds = new DataSet();
                adapter.Fill(ds, "PLAYER_X_ITEM");
                DGVplayerxitem.DataSource = ds.Tables["PLAYER_X_ITEM"];

                connection.Close();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        public void init()
        {
            TXTitemid.Enabled = false;
            TXTplayerid.Enabled = false;
            TXTquantity.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTitemid.Text = "";
            TXTplayerid.Text = "";
            TXTquantity.Text = "";

        }

        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTitemid.Enabled = true;
            TXTplayerid.Enabled = true;
            TXTquantity.Enabled = true;

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            init();
        }

        private void BTNdelete_Click(object sender, EventArgs e)
        {
            if (DGVplayerxitem.Rows.Count > 1)
            {
                int iditem = (int)DGVplayerxitem.CurrentRow.Cells["ITEM_ID"].Value;
                int idplayer = (int)DGVplayerxitem.CurrentRow.Cells["PLAYER_ID"].Value;

                PlayersItemDA playersItem = new PlayersItemDA();
                playersItem.deleteItemOfPlayer(iditem, idplayer);

                load();
                init();
            }
        }


        private void BTNrecover_Click(object sender, EventArgs e)
        {
            if (DGVplayerxitem.Rows.Count > 1)
            {
                int playerid = (int)DGVplayerxitem.CurrentRow.Cells["PLAYER_ID"].Value;
                int itemid = (int)DGVplayerxitem.CurrentRow.Cells["ITEM_ID"].Value;
                int quantity = (int)DGVplayerxitem.CurrentRow.Cells["QUANTITY"].Value;


                TXTitemid.Text = itemid.ToString();
                TXTplayerid.Text = playerid.ToString();
                TXTquantity.Text = quantity.ToString();

                TXTitemid.Enabled = false;
                TXTplayerid.Enabled = false;
                TXTquantity.Enabled = true;

                BTNdelete.Enabled = false;
                BTNrecover.Enabled = false;
                BTNnew.Enabled = false;
                BTNsave.Enabled = false;
                BTNupdate.Enabled = true;
                BTNcancel.Enabled = true;

                lastitemid = Convert.ToInt32(TXTitemid.Text);
                lastplayerid = Convert.ToInt32(TXTplayerid.Text);
            }
        }
        

        private void BTNupdate_Click(object sender, EventArgs e)
        {
            int flag = 1;


            if (TXTplayerid.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a player id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTplayerid.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for player id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            PlayerDA admin = new PlayerDA();
            if (admin.verifyID(Convert.ToInt32(TXTplayerid.Text)) != 1)
            {
                MessageBox.Show("Doesnt exist that player", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTitemid.Text.Trim() == "")
            {
                MessageBox.Show("Must enter an item id ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTitemid.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for item id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            ItemDA itemda= new ItemDA();
            if (itemda.verifyID(Convert.ToInt32(TXTitemid.Text)) != 1)
            {
                MessageBox.Show("Doesn't exist that item", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            if (TXTquantity.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a quantity", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTquantity.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for quantity", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            if (Convert.ToInt32(TXTquantity.Text) < 1)
            {
                MessageBox.Show("Put a higher number ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            if (flag == 1)
            {
                PlayersItemDA playersItemDA = new PlayersItemDA();

                 playersItemDA.updatePlayersItem(Convert.ToInt32(TXTitemid.Text), Convert.ToInt32(TXTplayerid.Text), Convert.ToInt32(TXTquantity.Text), lastitemid, lastplayerid);
                


                load();
                init();

            }
        }



        private void BTNsave_Click(object sender, EventArgs e)
        {

            int flag = 1;


            if (TXTplayerid.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a player id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTplayerid.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for player id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            PlayerDA admin = new PlayerDA();
            if (admin.verifyID(Convert.ToInt32(TXTplayerid.Text)) != 1)
            {
                MessageBox.Show("Doesnt exist that player", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTitemid.Text.Trim() == "")
            {
                MessageBox.Show("Must enter an item id ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTitemid.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for item id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            ItemDA itemda = new ItemDA();
            if (itemda.verifyID(Convert.ToInt32(TXTitemid.Text)) != 1)
            {
                MessageBox.Show("Doesn't exist that item", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            if (TXTquantity.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a quantity", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTquantity.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for quantity", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            if (Convert.ToInt32(TXTquantity.Text) < 1)
            {
                MessageBox.Show("Put a higher number ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (flag == 1)
            {
                PlayersItemDA playersItemDA = new PlayersItemDA();


                if ((playersItemDA.exist(Convert.ToInt32(TXTplayerid.Text), Convert.ToInt32(TXTitemid.Text))) == 1)
                {
                    MessageBox.Show("The player already has that item");
                }
                else
                {
                    playersItemDA.addPlayersItem(Convert.ToInt32(TXTplayerid.Text), Convert.ToInt32(TXTitemid.Text), Convert.ToInt32(TXTquantity.Text));
                }

                load();
                init();

            }
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
