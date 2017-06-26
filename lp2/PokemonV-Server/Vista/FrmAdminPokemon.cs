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

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT ID,NAME,LIFE,DEFENSE_PTS,TYPE, ATTACK_1_ID, ATTACK_2_ID FROM POKEMON WHERE DELETED = 0 ", connection);

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
        
            TXTname.Enabled = false;
            TXTlife.Enabled = false;
            TXTdefensepts.Enabled = false;
            CMBtype.Enabled = false;
            TXTid.Enabled = false;
            TXTattack1id.Enabled = false;
            TXTattack2id.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            
            TXTname.Text = "";
            TXTlife.Text = "";
            TXTdefensepts.Text = "";
            CMBtype.Text = "";
            TXTid.Text = "";
            TXTattack1id.Text = "";
            TXTattack2id.Text = "";


        }


        private void BTNnew_Click(object sender, EventArgs e)
        {
            
            TXTname.Enabled = true;
            TXTdefensepts.Enabled = true;
            TXTlife.Enabled = true;
            CMBtype.Enabled = true;
            TXTid.Enabled = true;
            TXTattack2id.Enabled = true;
            TXTattack1id.Enabled = true;

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
                int attack1id = (int)DGVpokemon.CurrentRow.Cells["ATTACK_1_ID"].Value;
                int attack2id = (int)DGVpokemon.CurrentRow.Cells["ATTACK_2_ID"].Value;
                int deffensepts = (int)DGVpokemon.CurrentRow.Cells["DEFENSE_PTS"].Value;
                string CADtype = (string)DGVpokemon.CurrentRow.Cells["TYPE"].Value;
                int id = (int)DGVpokemon.CurrentRow.Cells["ID"].Value;



                TXTname.Text = CADname;
                TXTattack1id.Text = attack1id.ToString();
                TXTattack2id.Text = attack2id.ToString();
                TXTdefensepts.Text = deffensepts.ToString();
                TXTlife.Text = life.ToString();
                CMBtype.Text = CADtype;
                TXTid.Text = id.ToString();


                
                TXTname.Enabled = true;
                TXTdefensepts.Enabled = true;
                TXTlife.Enabled = true;
                CMBtype.Enabled = true;
                TXTattack1id.Enabled = true;
                TXTattack2id.Enabled = true;



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



            if (TXTattack1id.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack1 ID", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack1id.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack1 ID ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            AttackDA attackadmin = new AttackDA();
            if ((attackadmin.verifyID(Convert.ToInt32(TXTattack1id.Text)) != 1))
            {
                MessageBox.Show("Attack1 ID doesn't exist ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTattack2id.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack2 ID ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack2id.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack2 ID ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            AttackDA attackadmin2 = new AttackDA();
            if ((attackadmin2.verifyID(Convert.ToInt32(TXTattack2id.Text)) != 1))
            {
                MessageBox.Show("Attack2 ID doesn't exist ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
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

                Pokemon pokemon = new Pokemon(TXTname.Text, Convert.ToInt32(TXTlife.Text),
                                                Convert.ToInt32(TXTdefensepts.Text),tipo, Convert.ToInt32(TXTattack1id.Text),
                                                Convert.ToInt32(TXTattack2id.Text), 0);

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


            if (TXTattack1id.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack1 ID", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack1id.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack1 ID ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            AttackDA attackadmin = new AttackDA();
            if ((attackadmin.verifyID(Convert.ToInt32(TXTattack1id.Text)) != 1))
            {
                MessageBox.Show("Attack1 ID doesn't exist ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }



            if (TXTattack2id.Text.Trim() == "")
            {
                MessageBox.Show("Must enter attack2 ID ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            try
            {
                Int32.Parse(TXTattack2id.Text);
            }
            catch (Exception exp)
            {
                MessageBox.Show("Must enter a number for attack2 ID ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            AttackDA attackadmin2 = new AttackDA();
            if ((attackadmin2.verifyID(Convert.ToInt32(TXTattack2id.Text)) != 1))
            {
                MessageBox.Show("Attack2 ID doesn't exist ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
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

                Pokemon pokemon = new Pokemon(TXTname.Text, Convert.ToInt32(TXTlife.Text),
                                                Convert.ToInt32(TXTdefensepts.Text), tipo, Convert.ToInt32(TXTattack1id.Text),
                                                Convert.ToInt32(TXTattack2id.Text), 0);

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
