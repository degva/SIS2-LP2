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

            PlayersPokemonDA playersPokemon = new PlayersPokemonDA();
            playersPokemon.deletePokemonOfPlayer(idpokemon, idplayer);

            load();
            inicio();
        }
    }
}
