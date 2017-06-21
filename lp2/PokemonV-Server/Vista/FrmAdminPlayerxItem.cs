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
        }


        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT PLAYER_USER_ID,ITEM_ID FROM PLAYER_X_ITEM WHERE DELETED = 0 ", connection);

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

        public void inicio()
        {
            TXTitemid.Enabled = false;
            TXTplayerid.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTitemid.Text = "";
            TXTplayerid.Text = "";

        }

        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTitemid.Enabled = true;
            TXTplayerid.Enabled = true;

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            inicio();
        }

        private void BTNdelete_Click(object sender, EventArgs e)
        {
            int iditem = (int)DGVplayerxitem.CurrentRow.Cells["ITEM_ID"].Value;
            int idplayer = (int)DGVplayerxitem.CurrentRow.Cells["PLAYER_USER_ID"].Value;

            PlayersItemDA playersItem = new PlayersItemDA();
            playersItem.deleteItemOfPlayer(iditem, idplayer);

            load();
            inicio();
        }

        

        private void BTNrecover_Click(object sender, EventArgs e)
        {
            int playerid = (int)DGVplayerxitem.CurrentRow.Cells["PLAYER_USER_ID"].Value;
            int itemid = (int)DGVplayerxitem.CurrentRow.Cells["ITEM_ID"].Value;
            
            TXTitemid.Text = itemid.ToString();
            TXTplayerid.Text = playerid.ToString();

            TXTitemid.Enabled = true;
            TXTplayerid.Enabled = true;

            BTNdelete.Enabled = false;
            BTNrecover.Enabled = false;
            BTNnew.Enabled = false;
            BTNsave.Enabled = false;
            BTNupdate.Enabled = true;
            BTNcancel.Enabled = true;

            lastitemid = Convert.ToInt32(TXTitemid.Text);
            lastplayerid = Convert.ToInt32(TXTplayerid.Text);
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



            if (flag == 1)
            {
                PlayersItemDA playersItemDA = new PlayersItemDA();

                playersItemDA.updatePlayersItem(Convert.ToInt32(TXTitemid.Text),Convert.ToInt32(TXTplayerid.Text), lastitemid, lastplayerid);

                load();
                inicio();

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


            if (flag == 1)
            {
                PlayersItemDA playersItemDA = new PlayersItemDA();
                playersItemDA.addPlayersItem(Convert.ToInt32(TXTplayerid.Text), Convert.ToInt32(TXTitemid.Text));

                load();
                inicio();

            }
        }
    }
}
