using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Entidades;
using AccesoDatos;

namespace Vista
{
    public partial class FrmLogueo : Form
    {
        public FrmLogueo()
        {
            InitializeComponent();

            


            TXTpassword.Text = "";
            TXTpassword.PasswordChar = '*';
            TXTpassword.MaxLength = 30;

            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\fondo2.png");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;


        }

        

        private void BTNlogin_Click(object sender, EventArgs e)
        {
            
                UsuarioDA con = new UsuarioDA();
                if ((con.verificarLogin(TXTusername.Text, TXTpassword.Text) == 1))
                {

                MessageBox.Show("Login satisfactorio");

                //aqui se abriria la ventana del juego

                    this.Close();
                }
                else
                {
                    MessageBox.Show("Usuario y/o contraseña incorrectas");
                }
            
        }

        private void BTNregister_Click(object sender, EventArgs e)
        {
            FrmRegister form = new FrmRegister();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);
            if (form.ShowDialog() == DialogResult.OK)
            {

            }
            else
            {

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
