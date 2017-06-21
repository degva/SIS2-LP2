﻿using System;
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
    public partial class FrmAdminUser : Form
    {
        public FrmAdminUser()
        {
            InitializeComponent();
            load();
            inicio();


        }


        public void inicio()
        {
            TXTemail.Enabled = false;
            TXTname.Enabled = false;
            TXTpassword.Enabled = false;
            TXTusername.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            TXTemail.Text = "";
            TXTname.Text = "";
            TXTpassword.Text = "";
            TXTusername.Text = "";

        }
        
        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT ID,NAME,USERNAME,PASSWORD,EMAIL FROM USER WHERE DELETED = 0  AND ISADMIN = 0", connection);

                DataSet ds = new DataSet();
                adapter.Fill(ds, "USER");
                DGVadmin.DataSource = ds.Tables["USER"];

                connection.Close();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        private int verifyemail(String cad)
        {
            cad = cad.ToLower();
            //colocar todos los domininios de correo que se aceptaran
            Regex reg = new Regex(@"@pucp.pe");
            Regex reg1 = new Regex(@"@pucp.edu.pe");
            Regex reg2 = new Regex(@"@gmail.com");
            Regex reg3 = new Regex(@"@hotmail.com");
            Regex reg4 = new Regex(@"@outlook.com");

            /* ..... */
            if ((!reg.IsMatch(cad)) && (!reg1.IsMatch(cad)) && (!reg2.IsMatch(cad)) && (!reg3.IsMatch(cad)) && (!reg4.IsMatch(cad))) return 0;
            if (reg.Matches(cad).Count > 1) return 0;
            if (reg1.Matches(cad).Count > 1) return 0;
            if (reg2.Matches(cad).Count > 1) return 0;
            if (reg3.Matches(cad).Count > 1) return 0;
            if (reg4.Matches(cad).Count > 1) return 0;

            if (Regex.Matches(cad, "@").Count > 1) return 0;

            return 1;
        }


        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTemail.Enabled = true;
            TXTname.Enabled = true;
            TXTpassword.Enabled = true;
            TXTusername.Enabled = true;

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNdelete_Click(object sender, EventArgs e)
        {

            string cadena = (string)DGVadmin.CurrentRow.Cells["USERNAME"].Value;

            PlayerDA playerDA = new PlayerDA();
            playerDA.deletePlayer(cadena);

            load();

            inicio();
        }

        private void BTNsave_Click(object sender, EventArgs e)
        {
            int flag = 1, flag2 = 1;



            if (TXTname.Text == "")
            {
                MessageBox.Show("Debe colocar un nombre", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTusername.Text == "")
            {
                MessageBox.Show("Debe colocar un usuario", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTpassword.Text == "")
            {
                MessageBox.Show("Debe colocar una contraseña", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }


            if (TXTemail.Text == "")
            {
                MessageBox.Show("Debe colocar un correo", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
                flag2 = 0;
            }

            if (flag2 == 1)
            {
                if (verifyemail(TXTemail.Text) == 0)
                {
                    MessageBox.Show("Debe colocar un correo válido", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    flag = 0;
                }


            }

            if ((TXTusername.Text.Contains(" ")) || (TXTusername.Text.Contains('"')))
            {
                MessageBox.Show("No se permiten espacios ni comillas en el nombre de usuario", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTpassword.Text.Contains(" ")) || (TXTpassword.Text.Contains('"')))
            {
                MessageBox.Show("No se permiten espacios ni comillas en la contraseña", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if(flag == 1)
            {
                Player player = new Player(TXTusername.Text, TXTpassword.Text, TXTname.Text, TXTemail.Text, 0, 0);

                PlayerDA playerDA = new PlayerDA();
                if ((playerDA.verifyRepeatUsername(player)) == 1)
                {
                    MessageBox.Show("Ya se encuentra registrado ese usuario");
                }
                else if ((playerDA.verifyRepeatemail(player)) == 1)
                {
                    MessageBox.Show("El correo ya esta registrado. Ingresa uno diferente");
                }
                else
                {
                    playerDA.addPlayer(player);
                    playerDA.addPlayer2(player);
                    MessageBox.Show("Registro exitoso");
                    this.DialogResult = DialogResult.OK;

                    load();

                    TXTemail.Text = "";
                    TXTname.Text = "";
                    TXTpassword.Text = "";
                    TXTusername.Text = "";

                    BTNdelete.Enabled = true;
                    BTNrecover.Enabled = true;
                    BTNsave.Enabled = false;
                    BTNnew.Enabled = true;
                    BTNupdate.Enabled = false;
                    BTNcancel.Enabled = false;

                    TXTemail.Enabled = false;
                    TXTname.Enabled = false;
                    TXTpassword.Enabled = false;
                    TXTusername.Enabled = false;
                }

            }

            
        }

        private void BTNupdate_Click(object sender, EventArgs e)
        {
            string CADname = (string)DGVadmin.CurrentRow.Cells["NAME"].Value;
            string CADusername = (string)DGVadmin.CurrentRow.Cells["USERNAME"].Value;
            string CADpassword = (string)DGVadmin.CurrentRow.Cells["PASSWORD"].Value;
            string CADemail = (string)DGVadmin.CurrentRow.Cells["EMAIL"].Value;

            TXTname.Text = CADname;
            TXTusername.Text = CADusername;
            TXTpassword.Text = CADpassword;
            TXTemail.Text = CADemail;

            TXTemail.Enabled = true;
            TXTname.Enabled = true;
            TXTpassword.Enabled = true;
            TXTusername.Enabled = true;

            BTNdelete.Enabled = false;
            BTNrecover.Enabled = false;
            BTNnew.Enabled = false;
            BTNsave.Enabled = false;
            BTNupdate.Enabled = true;
            BTNcancel.Enabled = true;



        }

        private void BTNupdate_Click_1(object sender, EventArgs e)
        {

            int id = (int)DGVadmin.CurrentRow.Cells["ID"].Value;
           

            int flag = 1, flag2 = 1;

            if (TXTname.Text == "")
            {
                MessageBox.Show("Debe colocar un nombre", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTusername.Text == "")
            {
                MessageBox.Show("Debe colocar un usuario", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTpassword.Text == "")
            {
                MessageBox.Show("Debe colocar una contraseña", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }


            if (TXTemail.Text == "")
            {
                MessageBox.Show("Debe colocar un correo", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
                flag2 = 0;
            }

            if (flag2 == 1)
            {
                if (verifyemail(TXTemail.Text) == 0)
                {
                    MessageBox.Show("Debe colocar un correo válido", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    flag = 0;
                }


            }

            if ((TXTusername.Text.Contains(" ")) || (TXTusername.Text.Contains('"')))
            {
                MessageBox.Show("No se permiten espacios ni comillas en el nombre de usuario", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTpassword.Text.Contains(" ")) || (TXTpassword.Text.Contains('"')))
            {
                MessageBox.Show("No se permiten espacios ni comillas en la contraseña", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (flag == 1)
            {
                Player player = new Player(TXTusername.Text, TXTpassword.Text, TXTname.Text, TXTemail.Text,0, 0);

                PlayerDA playerDA = new PlayerDA();
                if((playerDA.verifyRepeatUsername2(player, id)) == 1)
                {
                    MessageBox.Show("Ya se encuentra registrado ese usuario");
                }
                else if ((playerDA.verifyRepeatemail2(player, id)) == 1)
                {
                    MessageBox.Show("El correo ya esta registrado. Ingresa uno diferente");
                }
                else
                {
                    playerDA.updatePlayer(player, id);

                    load();

                    inicio();
                }
                
            }
  
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            inicio();
        }
    }
}
