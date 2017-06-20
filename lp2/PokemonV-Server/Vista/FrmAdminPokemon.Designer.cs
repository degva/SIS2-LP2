namespace Vista
{
    partial class FrmAdminPokemon
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.DGVpokemon = new System.Windows.Forms.DataGridView();
            this.TXTname = new System.Windows.Forms.TextBox();
            this.LBLname = new System.Windows.Forms.Label();
            this.TXTattackpts = new System.Windows.Forms.TextBox();
            this.TXTdeffensepts = new System.Windows.Forms.TextBox();
            this.TXTlife = new System.Windows.Forms.TextBox();
            this.LBLemail = new System.Windows.Forms.Label();
            this.LBLlife = new System.Windows.Forms.Label();
            this.LBLpassword = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.CMBtype = new System.Windows.Forms.ComboBox();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNdelete = new System.Windows.Forms.Button();
            this.BTNsave = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.BTNnew = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVpokemon)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVpokemon
            // 
            this.DGVpokemon.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVpokemon.Location = new System.Drawing.Point(396, 37);
            this.DGVpokemon.Name = "DGVpokemon";
            this.DGVpokemon.Size = new System.Drawing.Size(658, 266);
            this.DGVpokemon.TabIndex = 0;
            // 
            // TXTname
            // 
            this.TXTname.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTname.Location = new System.Drawing.Point(177, 59);
            this.TXTname.Name = "TXTname";
            this.TXTname.Size = new System.Drawing.Size(190, 21);
            this.TXTname.TabIndex = 22;
            // 
            // LBLname
            // 
            this.LBLname.AutoSize = true;
            this.LBLname.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLname.Location = new System.Drawing.Point(12, 59);
            this.LBLname.Name = "LBLname";
            this.LBLname.Size = new System.Drawing.Size(55, 20);
            this.LBLname.TabIndex = 21;
            this.LBLname.Text = "Name";
            // 
            // TXTattackpts
            // 
            this.TXTattackpts.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTattackpts.Location = new System.Drawing.Point(177, 168);
            this.TXTattackpts.Name = "TXTattackpts";
            this.TXTattackpts.Size = new System.Drawing.Size(190, 21);
            this.TXTattackpts.TabIndex = 20;
            // 
            // TXTdeffensepts
            // 
            this.TXTdeffensepts.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTdeffensepts.Location = new System.Drawing.Point(177, 231);
            this.TXTdeffensepts.Name = "TXTdeffensepts";
            this.TXTdeffensepts.Size = new System.Drawing.Size(190, 21);
            this.TXTdeffensepts.TabIndex = 19;
            // 
            // TXTlife
            // 
            this.TXTlife.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTlife.Location = new System.Drawing.Point(177, 110);
            this.TXTlife.Name = "TXTlife";
            this.TXTlife.Size = new System.Drawing.Size(190, 21);
            this.TXTlife.TabIndex = 18;
            // 
            // LBLemail
            // 
            this.LBLemail.AutoSize = true;
            this.LBLemail.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLemail.Location = new System.Drawing.Point(12, 231);
            this.LBLemail.Name = "LBLemail";
            this.LBLemail.Size = new System.Drawing.Size(138, 20);
            this.LBLemail.TabIndex = 17;
            this.LBLemail.Text = "Deffense Points";
            // 
            // LBLlife
            // 
            this.LBLlife.AutoSize = true;
            this.LBLlife.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLlife.Location = new System.Drawing.Point(12, 110);
            this.LBLlife.Name = "LBLlife";
            this.LBLlife.Size = new System.Drawing.Size(39, 20);
            this.LBLlife.TabIndex = 16;
            this.LBLlife.Text = "Life";
            // 
            // LBLpassword
            // 
            this.LBLpassword.AutoSize = true;
            this.LBLpassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLpassword.Location = new System.Drawing.Point(12, 166);
            this.LBLpassword.Name = "LBLpassword";
            this.LBLpassword.Size = new System.Drawing.Size(116, 20);
            this.LBLpassword.TabIndex = 15;
            this.LBLpassword.Text = "Attack Points";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 300);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(47, 20);
            this.label1.TabIndex = 23;
            this.label1.Text = "Type";
            // 
            // CMBtype
            // 
            this.CMBtype.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.CMBtype.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.CMBtype.FormattingEnabled = true;
            this.CMBtype.Items.AddRange(new object[] {
            "Earth",
            "Fire",
            "Water",
            "Wind"});
            this.CMBtype.Location = new System.Drawing.Point(177, 297);
            this.CMBtype.Name = "CMBtype";
            this.CMBtype.Size = new System.Drawing.Size(190, 23);
            this.CMBtype.TabIndex = 24;
            // 
            // BTNcancel
            // 
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.Location = new System.Drawing.Point(412, 428);
            this.BTNcancel.Name = "BTNcancel";
            this.BTNcancel.Size = new System.Drawing.Size(103, 31);
            this.BTNcancel.TabIndex = 30;
            this.BTNcancel.Text = "Cancel";
            this.BTNcancel.UseVisualStyleBackColor = true;
            this.BTNcancel.Click += new System.EventHandler(this.BTNcancel_Click);
            // 
            // BTNupdate
            // 
            this.BTNupdate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNupdate.Location = new System.Drawing.Point(255, 428);
            this.BTNupdate.Name = "BTNupdate";
            this.BTNupdate.Size = new System.Drawing.Size(103, 31);
            this.BTNupdate.TabIndex = 29;
            this.BTNupdate.Text = "Update";
            this.BTNupdate.UseVisualStyleBackColor = true;
            this.BTNupdate.Click += new System.EventHandler(this.BTNupdate_Click);
            // 
            // BTNdelete
            // 
            this.BTNdelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNdelete.Location = new System.Drawing.Point(412, 358);
            this.BTNdelete.Name = "BTNdelete";
            this.BTNdelete.Size = new System.Drawing.Size(103, 32);
            this.BTNdelete.TabIndex = 28;
            this.BTNdelete.Text = "Delete";
            this.BTNdelete.UseVisualStyleBackColor = true;
            this.BTNdelete.Click += new System.EventHandler(this.BTNdelete_Click);
            // 
            // BTNsave
            // 
            this.BTNsave.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNsave.Location = new System.Drawing.Point(96, 427);
            this.BTNsave.Name = "BTNsave";
            this.BTNsave.Size = new System.Drawing.Size(103, 32);
            this.BTNsave.TabIndex = 27;
            this.BTNsave.Text = "Save";
            this.BTNsave.UseVisualStyleBackColor = true;
            this.BTNsave.Click += new System.EventHandler(this.BTNsave_Click);
            // 
            // BTNrecover
            // 
            this.BTNrecover.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNrecover.Location = new System.Drawing.Point(255, 359);
            this.BTNrecover.Name = "BTNrecover";
            this.BTNrecover.Size = new System.Drawing.Size(103, 31);
            this.BTNrecover.TabIndex = 26;
            this.BTNrecover.Text = "Recover";
            this.BTNrecover.UseVisualStyleBackColor = true;
            this.BTNrecover.Click += new System.EventHandler(this.BTNrecover_Click);
            // 
            // BTNnew
            // 
            this.BTNnew.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNnew.Location = new System.Drawing.Point(96, 358);
            this.BTNnew.Name = "BTNnew";
            this.BTNnew.Size = new System.Drawing.Size(103, 32);
            this.BTNnew.TabIndex = 25;
            this.BTNnew.Text = "New";
            this.BTNnew.UseVisualStyleBackColor = true;
            this.BTNnew.Click += new System.EventHandler(this.BTNnew_Click);
            // 
            // FrmAdminPokemon
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1066, 490);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.BTNdelete);
            this.Controls.Add(this.BTNsave);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.BTNnew);
            this.Controls.Add(this.CMBtype);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.TXTname);
            this.Controls.Add(this.LBLname);
            this.Controls.Add(this.TXTattackpts);
            this.Controls.Add(this.TXTdeffensepts);
            this.Controls.Add(this.TXTlife);
            this.Controls.Add(this.LBLemail);
            this.Controls.Add(this.LBLlife);
            this.Controls.Add(this.LBLpassword);
            this.Controls.Add(this.DGVpokemon);
            this.Name = "FrmAdminPokemon";
            this.Text = "Admin Pokemon";
            ((System.ComponentModel.ISupportInitialize)(this.DGVpokemon)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVpokemon;
        private System.Windows.Forms.TextBox TXTname;
        private System.Windows.Forms.Label LBLname;
        private System.Windows.Forms.TextBox TXTattackpts;
        private System.Windows.Forms.TextBox TXTdeffensepts;
        private System.Windows.Forms.TextBox TXTlife;
        private System.Windows.Forms.Label LBLemail;
        private System.Windows.Forms.Label LBLlife;
        private System.Windows.Forms.Label LBLpassword;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox CMBtype;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNdelete;
        private System.Windows.Forms.Button BTNsave;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.Button BTNnew;
    }
}