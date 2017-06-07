﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using Entidades;
using AccesoDatos;

namespace Vista
{
    public partial class FrmRegister : Form
    {
        Player player;
        public FrmRegister()
        {
            InitializeComponent();

            TXTpassword.Text = "";
            TXTpassword.PasswordChar = '*';
            TXTpassword.MaxLength = 30;


        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
			this.DialogResult =  DialogResult.No;
        }


        private int verifyemail(String cad)
        {
            //colocar todos los domininios de correo que se aceptaran
            Regex reg = new Regex(@"@pucp.pe");
            Regex reg1 = new Regex(@"@pucp.edu.pe");
            Regex reg2 = new Regex(@"@gmail.com");
            Regex reg3 = new Regex(@"@hotmail.com");
            Regex reg4 = new Regex(@"@outlook.com");

            /* ..... */
            if ((!reg.IsMatch(cad)) && (!reg1.IsMatch(cad) ))  return 0;
            if (reg.Matches(cad).Count > 1) return 0;
            if (reg1.Matches(cad).Count > 1) return 0;
            if (Regex.Matches(cad, "@").Count > 1) return 0;

            return 1;
        }


        private void BTNregister_Click(object sender, EventArgs e)
        {
            Regex reg = new Regex(@"@pucp.pe");
            int flag = 1, flag2 = 1;

            
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
            
            if (flag2 == 1) {
                if (verifyemail(TXTemail.Text) == 0)
                {
                    MessageBox.Show("Debe colocar un correo válido", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    flag = 0;
                }
            }

            if (flag == 1)
            {

                player = new Player(TXTusername.Text, TXTpassword.Text, "", TXTemail.Text);
                UsuarioDA playerDA = new UsuarioDA();
                if ((playerDA.verificarRepetido(player)) == 1)
                {
                    MessageBox.Show("Ya se encuentra registrado con ese usuario");
                }else{
                        playerDA.agregarUsuario(player);
                        MessageBox.Show("Registro exitoso");

                }
                this.DialogResult = DialogResult.OK;
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
