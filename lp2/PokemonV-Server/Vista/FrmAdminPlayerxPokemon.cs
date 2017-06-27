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
    public partial class FrmAdminPlayerxPokemon : Form
    {


        int lastpokemonid;
        int lastorder;
        int lastplayerid;
        public FrmAdminPlayerxPokemon()
        {
            InitializeComponent();
            inicio();
            load();

            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\initial.jpg");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            LBLorder.BackColor = Color.Transparent;
            LBLplayerid.BackColor = Color.Transparent;
            LBLpokemonid.BackColor = Color.Transparent;

        }


        public void inicio()
        {
            TXTorder.Enabled = false;
            TXTplayerid.Enabled = false;
            TXTpokemonid.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTorder.Text = "";
            TXTplayerid.Text = "";
            TXTpokemonid.Text = "";
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            inicio();
        }

        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT PLAYER_ID, POKEMON_ID, ORDER_POKEMON FROM PLAYER_X_POKEMON WHERE DELETED = 0 ", connection);

                DataSet ds = new DataSet();
                adapter.Fill(ds, "PLAYER_X_POKEMON");
                DGVpokemons.DataSource = ds.Tables["PLAYER_X_POKEMON"];

                connection.Close();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }


        private void BTNdelete_Click(object sender, EventArgs e)
        {
            if (DGVpokemons.Rows.Count > 1)
            {
                int idpokemon = (int)DGVpokemons.CurrentRow.Cells["POKEMON_ID"].Value;
                int idplayer = (int)DGVpokemons.CurrentRow.Cells["PLAYER_ID"].Value;
                int order = (int)DGVpokemons.CurrentRow.Cells["ORDER_POKEMON"].Value;

                PlayersPokemonDA playersPokemon = new PlayersPokemonDA();
                playersPokemon.deletePokemonOfPlayer(idpokemon, idplayer, order);

                load();
                inicio();
            }
        }

        private void BTNrecover_Click(object sender, EventArgs e)
        {

            if (DGVpokemons.Rows.Count > 1)
            {
                int playerid = (int)DGVpokemons.CurrentRow.Cells["PLAYER_ID"].Value;
                int pokemonid = (int)DGVpokemons.CurrentRow.Cells["POKEMON_ID"].Value;
                int order = (int)DGVpokemons.CurrentRow.Cells["ORDER_POKEMON"].Value;

                TXTorder.Text = order.ToString();
                TXTplayerid.Text = playerid.ToString();
                TXTpokemonid.Text = pokemonid.ToString();

                TXTorder.Enabled = true;
                TXTplayerid.Enabled = true;
                TXTpokemonid.Enabled = true;

                BTNdelete.Enabled = false;
                BTNrecover.Enabled = false;
                BTNnew.Enabled = false;
                BTNsave.Enabled = false;
                BTNupdate.Enabled = true;
                BTNcancel.Enabled = true;

                lastpokemonid = Convert.ToInt32(TXTpokemonid.Text);
                lastorder = Convert.ToInt32(TXTorder.Text);
                lastplayerid = Convert.ToInt32(TXTplayerid.Text);
            }
        }

        private void BTNupdate_Click(object sender, EventArgs e)
        {

            int flag = 1;


            if (TXTpokemonid.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a pokemon id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTpokemonid.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for life points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            PokemonDA adminPOK = new PokemonDA();
            if (adminPOK.verifyID(Convert.ToInt32(TXTpokemonid.Text)) != 1)
            {
                MessageBox.Show("Doesnt exist that pokemon", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



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



            if (TXTorder.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a pokemon's order", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTorder.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for pokemon's order ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTorder.Text)) > 6)
            {
                MessageBox.Show("Order can't be more than 6", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            if ((Convert.ToInt32(TXTorder.Text)) < 1)
            {
                MessageBox.Show("Order can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (flag == 1)
            {
                PlayersPokemonDA playersPokDA = new PlayersPokemonDA();

                if (playersPokDA.updatePlayersPokemon(Convert.ToInt32(TXTpokemonid.Text), Convert.ToInt32(TXTorder.Text), Convert.ToInt32(TXTplayerid.Text), lastpokemonid, lastplayerid, lastorder) == 0)
                {
                    MessageBox.Show("You can't do that change", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                



                

                load();
                inicio();

            }
        }

        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTorder.Enabled = true;
            TXTplayerid.Enabled = true;
            TXTpokemonid.Enabled = true;

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNsave_Click(object sender, EventArgs e)
        {
            int flag = 1;


            if (TXTpokemonid.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a pokemon id", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTpokemonid.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for life points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            PokemonDA adminPOK = new PokemonDA();
            if (adminPOK.verifyID(Convert.ToInt32(TXTpokemonid.Text)) != 1)
            {
                MessageBox.Show("Doesnt exist that pokemon", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



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



            if (TXTorder.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a pokemon's order", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTorder.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for pokemon's order ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTorder.Text)) > 6)
            {
                MessageBox.Show("Order can't be more than 6", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            if ((Convert.ToInt32(TXTorder.Text)) < 1)
            {
                MessageBox.Show("Order can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }




            if (flag == 1)
            {
                PlayersPokemonDA playersPokDA = new PlayersPokemonDA();

                int deleted = 0;

                if ((playersPokDA.exist(Convert.ToInt32(TXTplayerid.Text), Convert.ToInt32(TXTpokemonid.Text))) == 1)
                {
                    MessageBox.Show("The player already has that pokemon");
                }
                else
                {
                    playersPokDA.addPlayersPokemon(Convert.ToInt32(TXTplayerid.Text), Convert.ToInt32(TXTpokemonid.Text), Convert.ToInt32(TXTorder.Text), deleted);

                }


                load();
                inicio();

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
