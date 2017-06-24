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

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT ID,NAME,LIFE,ATTACK1_PTS,ATTACK1_NAME,ATTACK2_PTS,ATTACK2_NAME,DEFENSE_PTS,TYPE FROM POKEMON WHERE DELETED = 0 ", connection);

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
            TXTattack1pts.Enabled = false;
            TXTname.Enabled = false;
            TXTlife.Enabled = false;
            TXTdefensepts.Enabled = false;
            CMBtype.Enabled = false;
            TXTid.Enabled = false;
            TXTattack1name.Enabled = false;
            TXTattack2name.Enabled = false;
            TXTattack2pts.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTattack1pts.Text = "";
            TXTname.Text = "";
            TXTlife.Text = "";
            TXTdefensepts.Text = "";
            CMBtype.Text = "";
            TXTid.Text = "";
            TXTattack1name.Text = "";
            TXTattack2name.Text = "";
            TXTattack2pts.Text = "";


        }


        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTattack1pts.Enabled = true;
            TXTname.Enabled = true;
            TXTdefensepts.Enabled = true;
            TXTlife.Enabled = true;
            CMBtype.Enabled = true;
            TXTid.Enabled = true;
            TXTattack1name.Enabled = true;
            TXTattack2name.Enabled = true;
            TXTattack2pts.Enabled = true;

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNdelete_Click(object sender, EventArgs e)
        {
            if (DGVpokemon.Rows.Count > 1)
            {
                int id = (int)DGVpokemon.CurrentRow.Cells["ID"].Value;

                PokemonDA pokemonDA = new PokemonDA();
                pokemonDA.deletePokemon(id);

                load();
                inicio();
            }
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            inicio();
        }

        private void BTNrecover_Click(object sender, EventArgs e)
        {
            if (DGVpokemon.Rows.Count > 1)
            {

                string CADname = (string)DGVpokemon.CurrentRow.Cells["NAME"].Value;
                int life = (int)DGVpokemon.CurrentRow.Cells["LIFE"].Value;
                int attack1pts = (int)DGVpokemon.CurrentRow.Cells["ATTACK1_PTS"].Value;
                int attack2pts = (int)DGVpokemon.CurrentRow.Cells["ATTACK2_PTS"].Value;
                string attack1name = (string)DGVpokemon.CurrentRow.Cells["ATTACK1_NAME"].Value;
                string attack2name = (string)DGVpokemon.CurrentRow.Cells["ATTACK2_NAME"].Value;
                int deffensepts = (int)DGVpokemon.CurrentRow.Cells["DEFENSE_PTS"].Value;
                string CADtype = (string)DGVpokemon.CurrentRow.Cells["TYPE"].Value;
                int id = (int)DGVpokemon.CurrentRow.Cells["ID"].Value;



                TXTname.Text = CADname;
                TXTattack1pts.Text = attack1pts.ToString();
                TXTattack2pts.Text = attack2pts.ToString();
                TXTattack1name.Text = attack1name;
                TXTattack2name.Text = attack2name;
                TXTdefensepts.Text = deffensepts.ToString();
                TXTlife.Text = life.ToString();
                CMBtype.Text = CADtype;
                TXTid.Text = id.ToString();


                TXTattack1pts.Enabled = true;
                TXTname.Enabled = true;
                TXTdefensepts.Enabled = true;
                TXTlife.Enabled = true;
                CMBtype.Enabled = true;
                TXTattack1name.Enabled = true;
                TXTattack2name.Enabled = true;
                TXTattack2pts.Enabled = true;



                BTNdelete.Enabled = false;
                BTNrecover.Enabled = false;
                BTNnew.Enabled = false;
                BTNsave.Enabled = false;
                BTNupdate.Enabled = true;
                BTNcancel.Enabled = true;
            }
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

            if (TXTattack1name.Text.Trim() == "")
            {
                MessageBox.Show("Must enter an attack1 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTattack2name.Text.Trim() == "")
            {
                MessageBox.Show("Must enter an attack2 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
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



            if (TXTattack1pts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack1 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack1pts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack1 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTattack1pts.Text)) < 1)
            {
                MessageBox.Show("Attack1 points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTattack2pts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack2 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack2pts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack2 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTattack2pts.Text)) < 1)
            {
                MessageBox.Show("Attack2 points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }




            if (TXTdefensepts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter defense points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTdefensepts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for defense points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTdefensepts.Text)) < 1)
            {
                MessageBox.Show("Defense points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            if ((TXTname.Text.Contains('"')) || (TXTname.Text.Contains(' ')))
            {
                MessageBox.Show("Quotation mark and spaces are not allowed in the name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTattack1name.Text.Contains('"')) )
            {
                MessageBox.Show("Quotation marks are not allowed in the attack1 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTattack2name.Text.Contains('"')))
            {
                MessageBox.Show("Quotation marks are not allowed in the attack2 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
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

                Pokemon pokemon = new Pokemon(Convert.ToInt32(TXTattack1pts.Text),TXTattack1name.Text,TXTattack2name.Text, Convert.ToInt32(TXTattack2pts.Text), Convert.ToInt32(TXTdefensepts.Text),
                                                Convert.ToInt32(TXTlife.Text),TXTname.Text,tipo,0);

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

            if (TXTattack1name.Text.Trim() == "")
            {
                MessageBox.Show("Must enter an attack1 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTattack2name.Text.Trim() == "")
            {
                MessageBox.Show("Must enter an attack2 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
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



            if (TXTattack1pts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack1 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack1pts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack1 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTattack1pts.Text)) < 1)
            {
                MessageBox.Show("Attack1 points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTattack2pts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack2 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack2pts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack2 points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTattack2pts.Text)) < 1)
            {
                MessageBox.Show("Attack2 points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }




            if (TXTdefensepts.Text.Trim() == "")
            {
                MessageBox.Show("Must enter defense points", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTdefensepts.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for defense points ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            if ((Convert.ToInt32(TXTdefensepts.Text)) < 1)
            {
                MessageBox.Show("Defense points can't be less than 1", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }


            if ((TXTname.Text.Contains('"')) || (TXTname.Text.Contains(' ')))
            {
                MessageBox.Show("Quotation mark and spaces are not allowed in the name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTattack1name.Text.Contains('"')))
            {
                MessageBox.Show("Quotation marks are not allowed in the attack1 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTattack2name.Text.Contains('"')))
            {
                MessageBox.Show("Quotation marks are not allowed in the attack2 name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
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

                Pokemon pokemon = new Pokemon(Convert.ToInt32(TXTattack1pts.Text), TXTattack1name.Text, TXTattack2name.Text, Convert.ToInt32(TXTattack2pts.Text), Convert.ToInt32(TXTdefensepts.Text),
                                                Convert.ToInt32(TXTlife.Text), TXTname.Text, tipo, 0);
                pokemon.Id = Convert.ToInt32(TXTid.Text);

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
