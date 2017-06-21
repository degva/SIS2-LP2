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
    public partial class FrmAdminPokemon : Form
    {
        public FrmAdminPokemon()
        {
            //MapDA mapda = new MapDA();
            //mapda.upload();   WOOP
            InitializeComponent();
            load();
            inicio();
        }

        


        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT ID,NAME,LIFE,ATTACK_PTS,DEFFENSE_PTS,TYPE FROM POKEMON WHERE DELETED = 0 ", connection);

                DataSet ds = new DataSet();
                adapter.Fill(ds, "POKEMON");
                DGVpokemon.DataSource = ds.Tables["POKEMON"];

                connection.Close();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        public void inicio()
        {
            TXTattackpts.Enabled = false;
            TXTname.Enabled = false;
            TXTlife.Enabled = false;
            TXTdeffensepts.Enabled = false;
            CMBtype.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTattackpts.Text = "";
            TXTname.Text = "";
            TXTlife.Text = "";
            TXTdeffensepts.Text = "";
            CMBtype.Text = "";

        }


        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTattackpts.Enabled = true;
            TXTname.Enabled = true;
            TXTdeffensepts.Enabled = true;
            TXTlife.Enabled = true;
            CMBtype.Enabled = true;

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNdelete_Click(object sender, EventArgs e)
        {
            int id = (int)DGVpokemon.CurrentRow.Cells["ID"].Value;

            PokemonDA pokemonDA = new PokemonDA();
            pokemonDA.deletePokemon(id);

            load();
            inicio();
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            inicio();
        }

        private void BTNrecover_Click(object sender, EventArgs e)
        {
            string CADname = (string)DGVpokemon.CurrentRow.Cells["NAME"].Value;
            int life = (int)DGVpokemon.CurrentRow.Cells["LIFE"].Value;
            int attackpts = (int)DGVpokemon.CurrentRow.Cells["ATTACK_PTS"].Value;
            int deffensepts = (int)DGVpokemon.CurrentRow.Cells["DEFFENSE_PTS"].Value;
            string CADtype = (string)DGVpokemon.CurrentRow.Cells["TYPE"].Value;


            TXTname.Text = CADname;
            TXTattackpts.Text = attackpts.ToString();
            TXTdeffensepts.Text = deffensepts.ToString();
            TXTlife.Text = life.ToString();
            CMBtype.Text = CADtype;


            TXTattackpts.Enabled = true;
            TXTname.Enabled = true;
            TXTdeffensepts.Enabled = true;
            TXTlife.Enabled = true;
            CMBtype.Enabled = true;

            BTNdelete.Enabled = false;
            BTNrecover.Enabled = false;
            BTNnew.Enabled = false;
            BTNsave.Enabled = false;
            BTNupdate.Enabled = true;
            BTNcancel.Enabled = true;
        }

        private void BTNupdate_Click(object sender, EventArgs e)
        {
            int id = (int)DGVpokemon.CurrentRow.Cells["ID"].Value;


            int flag = 1;

            if (TXTname.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTlife.Text.Trim() == "")
            {
                MessageBox.Show("Must enter life points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTlife.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for life points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTlife.Text)) < 1 )
            {
                MessageBox.Show("Life points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
           



            if (TXTattackpts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattackpts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTattackpts.Text)) < 1)
            {
                MessageBox.Show("Attack points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTdeffensepts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter deffense points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTdeffensepts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for deffense points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTdeffensepts.Text)) < 1)
            {
                MessageBox.Show("Deffense points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            if ((TXTname.Text.Contains('"')) || (TXTname.Text.Contains(' ')))
            {
                MessageBox.Show("Quotation mark and spaces are not allowed in the name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }



            if (flag == 1)
            {
                TypeofPokemon tipo;
                if(CMBtype.Text == "Wind")
                {
                    tipo = TypeofPokemon.Wind;
                }else if (CMBtype.Text == "Water")
                {
                    tipo = TypeofPokemon.Water;
                }
                else if (CMBtype.Text == "Fire")
                {
                    tipo = TypeofPokemon.Fire;
                }
                else
                {
                    tipo = TypeofPokemon.Earth;
                }

                Pokemon pokemon = new Pokemon(Convert.ToInt32(TXTattackpts.Text), Convert.ToInt32(TXTdeffensepts.Text), Convert.ToInt32(TXTlife.Text), TXTname.Text,tipo,0); ;

                PokemonDA pokemonDA = new PokemonDA();
                if ((pokemonDA.verifyRepeatName(pokemon, id )) == 1)
                {
                    MessageBox.Show("That pokemon has already been registered ");
                }
                else
                {
                    pokemonDA.updatePokemon(pokemon, id);

                    load();

                    inicio();
                }

            }
        }

        private void BTNsave_Click(object sender, EventArgs e)
        {

            int flag = 1;

            if (TXTname.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTlife.Text.Trim() == "")
            {
                MessageBox.Show("Must enter life points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTlife.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for life points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTlife.Text)) < 1)
            {
                MessageBox.Show("Life points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTattackpts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattackpts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTattackpts.Text)) < 1)
            {
                MessageBox.Show("Attack points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTdeffensepts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter deffense points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTdeffensepts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for deffense points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTdeffensepts.Text)) > 99)
            {
                MessageBox.Show("Deffense points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            if (TXTname.Text.Contains('"'))
            {
                MessageBox.Show("Quotation mark and spaces are not allowed in the name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }



            if (flag == 1)
            {
                TypeofPokemon tipo;
                if (CMBtype.Text == "Wind")
                {
                    tipo = TypeofPokemon.Wind;
                }
                else if (CMBtype.Text == "Water")
                {
                    tipo = TypeofPokemon.Water;
                }
                else if (CMBtype.Text == "Fire")
                {
                    tipo = TypeofPokemon.Fire;
                }
                else
                {
                    tipo = TypeofPokemon.Earth;
                }

                Pokemon pokemon = new Pokemon(Convert.ToInt32(TXTattackpts.Text), Convert.ToInt32(TXTdeffensepts.Text), Convert.ToInt32(TXTlife.Text), TXTname.Text, tipo,0); ;

                PokemonDA pokemonDA = new PokemonDA();
                if ((pokemonDA.verifyRepeatName2(pokemon)) == 1)
                {
                    MessageBox.Show("That pokemon has already been registered ");
                }
                else
                {
                    pokemonDA.addPokemon(pokemon);

                    load();
                    inicio();
                }

            }
        }

        
    }
}
