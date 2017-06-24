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
    public partial class FrmAdminItem : Form
    {
        public FrmAdminItem()
        {
            InitializeComponent();
            load();
            init();


            Bitmap image = new Bitmap(Application.StartupPath + @"\imagen\fondoFrm.jpg");
            this.BackgroundImage = image;
            this.BackgroundImageLayout = ImageLayout.Stretch;

            LBLname.BackColor = Color.Transparent;
            LBLcatchprob.BackColor = Color.Transparent;
            LBLdescription.BackColor = Color.Transparent;
            LBLhp.BackColor = Color.Transparent;
            LBLtype.BackColor = Color.Transparent;

        }


        public void load()
        {
            try
            {
                MySqlConnection connection = new MySqlConnection("server=quilla.lab.inf.pucp.edu.pe ;user=inf282gx ;database=inf282gx ;port=3306; password =m8h53r9A6xBfeOe6");

                connection.Open();

                MySqlDataAdapter adapter = new MySqlDataAdapter("SELECT ID,NAME,DESCRIPTION,ITEM_TYPE,CATCH_PROB,HP FROM ITEM WHERE DELETED = 0 ", connection);

                DataSet ds = new DataSet();
                adapter.Fill(ds, "ITEM");
                DGVitem.DataSource = ds.Tables["ITEM"];

                connection.Close();
            }
            catch (Exception exp)
            {
                MessageBox.Show(exp.Message);
            }
        }

        public void init()
        {
            TXTcatchprob.Enabled = false;
            TXTdescription.Enabled = false;
            TXThp.Enabled = false;
            TXTname.Enabled = false;
        
            CMBtype.Enabled = false;

            BTNdelete.Enabled = true;
            BTNrecover.Enabled = true;
            BTNsave.Enabled = false;
            BTNnew.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = false;

            
            TXTname.Text = "";
            TXTcatchprob.Text = "";
            TXTdescription.Text = "";
            TXThp.Text = "";
          

        }

        private void BTNnew_Click(object sender, EventArgs e)
        {
            TXTname.Enabled = true;
            CMBtype.Enabled = true;
            TXTdescription.Enabled = true;
            TXThp.Enabled = true;
            TXTcatchprob.Enabled = true;
         

            BTNnew.Enabled = false;
            BTNrecover.Enabled = false;
            BTNdelete.Enabled = false;
            BTNsave.Enabled = true;
            BTNupdate.Enabled = false;
            BTNcancel.Enabled = true;
        }

        private void BTNcancel_Click(object sender, EventArgs e)
        {
            init();
        }

        private void BTNrecover_Click(object sender, EventArgs e)
        {
            if (DGVitem.Rows.Count > 1)
            {


                string CADname = (string)DGVitem.CurrentRow.Cells["NAME"].Value;
                string CADdescription = (string)DGVitem.CurrentRow.Cells["DESCRIPTION"].Value;
                string CADtype = (string)DGVitem.CurrentRow.Cells["ITEM_TYPE"].Value;


                TXTname.Text = CADname;
                TXTdescription.Text = CADdescription;
                CMBtype.Text = CADtype;

                if (CADtype == "Potion")
                {
                    TXThp.Text = ((int)DGVitem.CurrentRow.Cells["HP"].Value).ToString();
                    TXThp.Enabled = true;
                }
                else if (CADtype == "Pokeball")
                {
                    TXTcatchprob.Text = ((int)DGVitem.CurrentRow.Cells["CATCH_PROB"].Value).ToString();
                    TXTcatchprob.Enabled = true;
                }
                




                TXTname.Enabled = true;
                TXTdescription.Enabled = true;
                CMBtype.Enabled = true;

                BTNdelete.Enabled = false;
                BTNrecover.Enabled = false;
                BTNnew.Enabled = false;
                BTNsave.Enabled = false;
                BTNupdate.Enabled = true;
                BTNcancel.Enabled = true;

            }
        }

        private void BTNdelete_Click(object sender, EventArgs e)
        {
            if (DGVitem.Rows.Count > 1)
            {
                int id = (int)DGVitem.CurrentRow.Cells["ID"].Value;

                ItemDA itemda = new ItemDA();
                itemda.deleteItem(id);

                load();
                init();
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

            if (TXTdescription.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a description", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }


            

            if ((CMBtype.Text == "Pokeball"))
            {
                if ((TXTcatchprob.Text.Trim() == ""))
                {
                    MessageBox.Show("Must enter catch probability", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

                try
                {
                    Int32.Parse(TXTcatchprob.Text);
                }
                catch (Exception exp)
                {
                    MessageBox.Show("Must enter a number for catch probability ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }
                if ((Convert.ToInt32(TXTcatchprob.Text)) <= 0)
                {
                    MessageBox.Show("Catch probability can't be 0 or negative", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

            }


            if ((CMBtype.Text == "Potion"))
            {
                if ((TXThp.Text.Trim() == ""))
                {
                    MessageBox.Show("Must enter HP ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

                try
                {
                    Int32.Parse(TXThp.Text);
                }
                catch (Exception exp)
                {
                    MessageBox.Show("Must enter a number for hp ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }
                if ((Convert.ToInt32(TXThp.Text)) <= 0)
                {
                    MessageBox.Show("Hp can't be 0 or negative", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

            }


            if ( (TXTname.Text.Contains('"')) || (TXTdescription.Text.Contains('"')))
            {
                MessageBox.Show("Quotation marks are not allowed in the name and description ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }



            if (flag == 1)
            {
                TypeofItem typeItem;
                
                
                if (CMBtype.Text == "Pokeball")
                {
                    typeItem = TypeofItem.Pokeball;


                    Pokeball poke = new Pokeball (TXTname.Text,TXTdescription.Text, typeItem, Convert.ToInt32(TXTcatchprob.Text));

                    ItemDA itemDA= new ItemDA();
                    if ((itemDA.verifyRepeatName2(poke)) == 1)
                    {
                        MessageBox.Show("That item has already been registered");
                    }
                    else
                    {
                        itemDA.addItem1(poke);

                        load();
                        init();
                    }


                }
                
                else if (CMBtype.Text == "Potion")
                {
                    typeItem = TypeofItem.Potion;

                    Potion pot = new Potion(TXTname.Text, TXTdescription.Text, typeItem, Convert.ToInt32(TXThp.Text));

                    ItemDA itemDA = new ItemDA();
                    if ((itemDA.verifyRepeatName2(pot)) == 1)
                    {
                        MessageBox.Show("That item has already been registered ");
                    }
                    else
                    {
                        itemDA.addItem2(pot);

                        load();
                        init();
                    }
                }
                

                

            }
        }

        private void BTNupdate_Click(object sender, EventArgs e)
        {

            int id = (int)DGVitem.CurrentRow.Cells["ID"].Value;


            int flag = 1;

            if (TXTname.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a name", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }

            if (TXTdescription.Text.Trim() == "")
            {
                MessageBox.Show("Must enter a description", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }


            

            if ((CMBtype.Text == "Pokeball"))
            {
                if ((TXTcatchprob.Text.Trim() == ""))
                {
                    MessageBox.Show("Must enter catch probability", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

                try
                {
                    Int32.Parse(TXTcatchprob.Text);
                }
                catch (Exception exp)
                {
                    MessageBox.Show("Must enter a number for catch probability ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }
                if ((Convert.ToInt32(TXTcatchprob.Text)) <= 0)
                {
                    MessageBox.Show("Catch probability can't be 0 or negative", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

            }


            if ((CMBtype.Text == "Potion"))
            {
                if ((TXThp.Text.Trim() == ""))
                {
                    MessageBox.Show("Must enter HP ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

                try
                {
                    Int32.Parse(TXThp.Text);
                }
                catch (Exception exp)
                {
                    MessageBox.Show("Must enter a number for hp ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }
                if ((Convert.ToInt32(TXThp.Text)) <= 0)
                {
                    MessageBox.Show("Hp can't be 0 or negative", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return;
                }

            }


            if ((TXTname.Text.Contains('"')) || (TXTdescription.Text.Contains('"')))
            {
                MessageBox.Show("Quotation marks are not allowed in the name and description ", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                flag = 0;
            }



            if (flag == 1)
            {
                TypeofItem typeItem;


                if (CMBtype.Text == "Pokeball")
                {
                    typeItem = TypeofItem.Pokeball;


                    Pokeball poke = new Pokeball(TXTname.Text, TXTdescription.Text, typeItem, Convert.ToInt32(TXTcatchprob.Text));

                    ItemDA itemDA = new ItemDA();
                    if ((itemDA.verifyRepeatName(poke,id)) == 1)
                    {
                        MessageBox.Show("That item has already been registered ");
                    }
                    else
                    {
                        itemDA.updateItem1(poke,id);

                        load();
                        init();
                    }


                }
                else if (CMBtype.Text == "Potion")
                {
                    typeItem = TypeofItem.Potion;

                    Potion pot = new Potion(TXTname.Text, TXTdescription.Text, typeItem, Convert.ToInt32(TXThp.Text));

                    ItemDA itemDA = new ItemDA();
                    if ((itemDA.verifyRepeatName(pot,id)) == 1)
                    {
                        MessageBox.Show("That item has already been registered ");
                    }
                    else
                    {
                        itemDA.updateItem2(pot, id);

                        load();
                        init();
                    }
                }


            }
        }

        private void CMBtype_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (CMBtype.SelectedItem.ToString() == "Potion")
            {
                TXTcatchprob.Enabled = false;
                TXThp.Enabled = true;
                TXTcatchprob.Text = "";
    
                TXThp.Text = "";
            }

            if (CMBtype.SelectedItem.ToString() == "Pokeball")
            {
                TXThp.Enabled = false;
                TXTcatchprob.Enabled = true;
                TXTcatchprob.Text = "";
        
                TXThp.Text = "";
            }
        }
    }
}
