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
            this.TXTdefensepts = new System.Windows.Forms.TextBox();
            this.TXTlife = new System.Windows.Forms.TextBox();
            this.LBLdefensepts = new System.Windows.Forms.Label();
            this.LBLlife = new System.Windows.Forms.Label();
            this.LBLtype = new System.Windows.Forms.Label();
            this.CMBtype = new System.Windows.Forms.ComboBox();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNdelete = new System.Windows.Forms.Button();
            this.BTNsave = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.BTNnew = new System.Windows.Forms.Button();
            this.TXTid = new System.Windows.Forms.TextBox();
            this.LBLid = new System.Windows.Forms.Label();
            this.TXTattack1id = new System.Windows.Forms.TextBox();
            this.LBLattack1id = new System.Windows.Forms.Label();
            this.TXTattack2id = new System.Windows.Forms.TextBox();
            this.LBLattack2id = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.DGVpokemon)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVpokemon
            // 
            this.DGVpokemon.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVpokemon.Location = new System.Drawing.Point(396, 12);
            this.DGVpokemon.Name = "DGVpokemon";
            this.DGVpokemon.Size = new System.Drawing.Size(744, 207);
            this.DGVpokemon.TabIndex = 0;
            // 
            // TXTname
            // 
            this.TXTname.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTname.Location = new System.Drawing.Point(177, 74);
            this.TXTname.Name = "TXTname";
            this.TXTname.Size = new System.Drawing.Size(190, 21);
            this.TXTname.TabIndex = 22;
            // 
            // LBLname
            // 
            this.LBLname.AutoSize = true;
            this.LBLname.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLname.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLname.Location = new System.Drawing.Point(12, 74);
            this.LBLname.Name = "LBLname";
            this.LBLname.Size = new System.Drawing.Size(55, 20);
            this.LBLname.TabIndex = 21;
            this.LBLname.Text = "Name";
            // 
            // TXTdefensepts
            // 
            this.TXTdefensepts.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTdefensepts.Location = new System.Drawing.Point(177, 181);
            this.TXTdefensepts.Name = "TXTdefensepts";
            this.TXTdefensepts.Size = new System.Drawing.Size(190, 21);
            this.TXTdefensepts.TabIndex = 19;
            // 
            // TXTlife
            // 
            this.TXTlife.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTlife.Location = new System.Drawing.Point(177, 125);
            this.TXTlife.Name = "TXTlife";
            this.TXTlife.Size = new System.Drawing.Size(190, 21);
            this.TXTlife.TabIndex = 18;
            // 
            // LBLdefensepts
            // 
            this.LBLdefensepts.AutoSize = true;
            this.LBLdefensepts.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLdefensepts.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLdefensepts.Location = new System.Drawing.Point(12, 181);
            this.LBLdefensepts.Name = "LBLdefensepts";
            this.LBLdefensepts.Size = new System.Drawing.Size(132, 20);
            this.LBLdefensepts.TabIndex = 17;
            this.LBLdefensepts.Text = "Defense Points";
            // 
            // LBLlife
            // 
            this.LBLlife.AutoSize = true;
            this.LBLlife.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLlife.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLlife.Location = new System.Drawing.Point(12, 125);
            this.LBLlife.Name = "LBLlife";
            this.LBLlife.Size = new System.Drawing.Size(39, 20);
            this.LBLlife.TabIndex = 16;
            this.LBLlife.Text = "Life";
            // 
            // LBLtype
            // 
            this.LBLtype.AutoSize = true;
            this.LBLtype.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLtype.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLtype.Location = new System.Drawing.Point(12, 232);
            this.LBLtype.Name = "LBLtype";
            this.LBLtype.Size = new System.Drawing.Size(47, 20);
            this.LBLtype.TabIndex = 23;
            this.LBLtype.Text = "Type";
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
            this.CMBtype.Location = new System.Drawing.Point(177, 229);
            this.CMBtype.Name = "CMBtype";
            this.CMBtype.Size = new System.Drawing.Size(190, 23);
            this.CMBtype.TabIndex = 24;
            // 
            // BTNcancel
            // 
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.Location = new System.Drawing.Point(811, 429);
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
            this.BTNupdate.Location = new System.Drawing.Point(654, 429);
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
            this.BTNdelete.Location = new System.Drawing.Point(811, 359);
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
            this.BTNsave.Location = new System.Drawing.Point(495, 428);
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
            this.BTNrecover.Location = new System.Drawing.Point(654, 360);
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
            this.BTNnew.Location = new System.Drawing.Point(495, 359);
            this.BTNnew.Name = "BTNnew";
            this.BTNnew.Size = new System.Drawing.Size(103, 32);
            this.BTNnew.TabIndex = 25;
            this.BTNnew.Text = "New";
            this.BTNnew.UseVisualStyleBackColor = true;
            this.BTNnew.Click += new System.EventHandler(this.BTNnew_Click);
            // 
            // TXTid
            // 
            this.TXTid.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTid.Location = new System.Drawing.Point(177, 32);
            this.TXTid.Name = "TXTid";
            this.TXTid.Size = new System.Drawing.Size(190, 21);
            this.TXTid.TabIndex = 32;
            // 
            // LBLid
            // 
            this.LBLid.AutoSize = true;
            this.LBLid.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLid.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLid.Location = new System.Drawing.Point(12, 32);
            this.LBLid.Name = "LBLid";
            this.LBLid.Size = new System.Drawing.Size(28, 20);
            this.LBLid.TabIndex = 31;
            this.LBLid.Text = "ID";
            // 
            // TXTattack1id
            // 
            this.TXTattack1id.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTattack1id.Location = new System.Drawing.Point(177, 293);
            this.TXTattack1id.Name = "TXTattack1id";
            this.TXTattack1id.Size = new System.Drawing.Size(190, 21);
            this.TXTattack1id.TabIndex = 34;
            // 
            // LBLattack1id
            // 
            this.LBLattack1id.AutoSize = true;
            this.LBLattack1id.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLattack1id.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLattack1id.Location = new System.Drawing.Point(12, 293);
            this.LBLattack1id.Name = "LBLattack1id";
            this.LBLattack1id.Size = new System.Drawing.Size(95, 20);
            this.LBLattack1id.TabIndex = 33;
            this.LBLattack1id.Text = "Attack1 ID";
            // 
            // TXTattack2id
            // 
            this.TXTattack2id.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTattack2id.Location = new System.Drawing.Point(177, 350);
            this.TXTattack2id.Name = "TXTattack2id";
            this.TXTattack2id.Size = new System.Drawing.Size(190, 21);
            this.TXTattack2id.TabIndex = 36;
            // 
            // LBLattack2id
            // 
            this.LBLattack2id.AutoSize = true;
            this.LBLattack2id.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLattack2id.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLattack2id.Location = new System.Drawing.Point(12, 350);
            this.LBLattack2id.Name = "LBLattack2id";
            this.LBLattack2id.Size = new System.Drawing.Size(95, 20);
            this.LBLattack2id.TabIndex = 35;
            this.LBLattack2id.Text = "Attack2 ID";
            // 
            // FrmAdminPokemon
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1152, 490);
            this.Controls.Add(this.TXTattack2id);
            this.Controls.Add(this.LBLattack2id);
            this.Controls.Add(this.TXTattack1id);
            this.Controls.Add(this.LBLattack1id);
            this.Controls.Add(this.TXTid);
            this.Controls.Add(this.LBLid);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.BTNdelete);
            this.Controls.Add(this.BTNsave);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.BTNnew);
            this.Controls.Add(this.CMBtype);
            this.Controls.Add(this.LBLtype);
            this.Controls.Add(this.TXTname);
            this.Controls.Add(this.LBLname);
            this.Controls.Add(this.TXTdefensepts);
            this.Controls.Add(this.TXTlife);
            this.Controls.Add(this.LBLdefensepts);
            this.Controls.Add(this.LBLlife);
            this.Controls.Add(this.DGVpokemon);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
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
        private System.Windows.Forms.TextBox TXTdefensepts;
        private System.Windows.Forms.TextBox TXTlife;
        private System.Windows.Forms.Label LBLdefensepts;
        private System.Windows.Forms.Label LBLlife;
        private System.Windows.Forms.Label LBLtype;
        private System.Windows.Forms.ComboBox CMBtype;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNdelete;
        private System.Windows.Forms.Button BTNsave;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.Button BTNnew;
        private System.Windows.Forms.TextBox TXTid;
        private System.Windows.Forms.Label LBLid;
        private System.Windows.Forms.TextBox TXTattack1id;
        private System.Windows.Forms.Label LBLattack1id;
        private System.Windows.Forms.TextBox TXTattack2id;
        private System.Windows.Forms.Label LBLattack2id;
    }
}