using System;
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
        Admin admin;
        public FrmRegister()
        {
            InitializeComponent();
            TXTpassword.Text = "";
            TXTpassword.PasswordChar = '*';
            TXTpassword.MaxLength = 30;

            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\snorlax.jpg");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            LBLemail.BackColor = Color.Transparent;
            LBLname.BackColor = Color.Transparent;
            LBLpassword.BackColor = Color.Transparent;
            LBLusername.BackColor = Color.Transparent;

        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            FrmLogin form = new FrmLogin();
            form.StartPosition = FormStartPosition.Manual;
            form.Location = new Point(this.Location.X, this.Location.Y);

            this.Hide();
            form.ShowDialog();
            this.Close();
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


        private void BTNregister_Click(object sender, EventArgs e)
        {
            int flag = 1, flag2 = 1;



            if (TXTname.Text == "")
            {
                MessageBox.Show("Must enter a name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTusername.Text == "")
            {
                MessageBox.Show("Must enter an username", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTpassword.Text == "")
            {
                MessageBox.Show("Must enter a password", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }


            if (TXTemail.Text == "")
            {
                MessageBox.Show("Must enter an email", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
                flag2 = 0;
            }

            if (flag2 == 1)
            {
                if (verifyemail(TXTemail.Text) == 0)
                {
                    MessageBox.Show("Must enter a valid email ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    flag = 0;
                }


            }

            if ((TXTusername.Text.Contains(" ")) || (TXTusername.Text.Contains('"')))
            {
                MessageBox.Show("Spaces and quotation marks are not allowed in the username", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if ((TXTpassword.Text.Contains(" ")) || (TXTpassword.Text.Contains('"')))
            {
                MessageBox.Show("Spaces and quotation marks are not allowed in the password", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }



            if (flag == 1)
            {
                TXTemail.Text = TXTemail.Text.ToLower();
                TXTemail.Text = TXTemail.Text.Trim();
                TXTpassword.Text = TXTpassword.Text.Trim();
                TXTusername.Text = TXTusername.Text.Trim();

                string npc = "PLAYER";
                int can_battle = 1;
                int battle_dialog_id = 1;
                int defeat_dialog_id = 1;
                Direction direction = Direction.DOWN;
                admin = new Admin(TXTusername.Text, TXTpassword.Text,TXTname.Text,TXTemail.Text,0, 1,npc,can_battle, battle_dialog_id,defeat_dialog_id, direction);
                AdminDA AdminDA = new AdminDA();
                if ((AdminDA.verifyRepeatUsername(admin)) == 1)
                {
                    MessageBox.Show("That username has already been registered");
                }
                else if ((AdminDA.verifyRepeatemail(admin)) == 1)
                {
                    MessageBox.Show("That email has already been registered");
                }
                else
                {
                    AdminDA.addAdmin(admin);
                    MessageBox.Show("You're registered");
                    this.DialogResult = DialogResult.OK;
                }

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
