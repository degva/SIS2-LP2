namespace Vista
{
    partial class FrmAdminItem
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
            this.DGVitem = new System.Windows.Forms.DataGridView();
            this.CMBtype = new System.Windows.Forms.ComboBox();
            this.LBLtype = new System.Windows.Forms.Label();
            this.TXTname = new System.Windows.Forms.TextBox();
            this.LBLname = new System.Windows.Forms.Label();
            this.TXTcatchprob = new System.Windows.Forms.TextBox();
            this.LBLcatchprob = new System.Windows.Forms.Label();
            this.TXThp = new System.Windows.Forms.TextBox();
            this.LBLhp = new System.Windows.Forms.Label();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNdelete = new System.Windows.Forms.Button();
            this.BTNsave = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.BTNnew = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVitem)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVitem
            // 
            this.DGVitem.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVitem.Location = new System.Drawing.Point(504, 41);
            this.DGVitem.Name = "DGVitem";
            this.DGVitem.Size = new System.Drawing.Size(539, 235);
            this.DGVitem.TabIndex = 0;
            // 
            // CMBtype
            // 
            this.CMBtype.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.CMBtype.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.CMBtype.FormattingEnabled = true;
            this.CMBtype.Items.AddRange(new object[] {
            "Potion",
            "Pokeball"});
            this.CMBtype.Location = new System.Drawing.Point(203, 88);
            this.CMBtype.Name = "CMBtype";
            this.CMBtype.Size = new System.Drawing.Size(190, 23);
            this.CMBtype.TabIndex = 34;
            this.CMBtype.SelectedIndexChanged += new System.EventHandler(this.CMBtype_SelectedIndexChanged);
            // 
            // LBLtype
            // 
            this.LBLtype.AutoSize = true;
            this.LBLtype.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLtype.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLtype.Location = new System.Drawing.Point(38, 91);
            this.LBLtype.Name = "LBLtype";
            this.LBLtype.Size = new System.Drawing.Size(47, 20);
            this.LBLtype.TabIndex = 33;
            this.LBLtype.Text = "Type";
            // 
            // TXTname
            // 
            this.TXTname.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTname.Location = new System.Drawing.Point(203, 29);
            this.TXTname.Name = "TXTname";
            this.TXTname.Size = new System.Drawing.Size(190, 21);
            this.TXTname.TabIndex = 32;
            // 
            // LBLname
            // 
            this.LBLname.AutoSize = true;
            this.LBLname.BackColor = System.Drawing.SystemColors.Menu;
            this.LBLname.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLname.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLname.Location = new System.Drawing.Point(38, 29);
            this.LBLname.Name = "LBLname";
            this.LBLname.Size = new System.Drawing.Size(55, 20);
            this.LBLname.TabIndex = 31;
            this.LBLname.Text = "Name";
            // 
            // TXTcatchprob
            // 
            this.TXTcatchprob.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTcatchprob.Location = new System.Drawing.Point(203, 152);
            this.TXTcatchprob.Name = "TXTcatchprob";
            this.TXTcatchprob.Size = new System.Drawing.Size(190, 21);
            this.TXTcatchprob.TabIndex = 29;
            // 
            // LBLcatchprob
            // 
            this.LBLcatchprob.AutoSize = true;
            this.LBLcatchprob.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLcatchprob.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLcatchprob.Location = new System.Drawing.Point(38, 152);
            this.LBLcatchprob.Name = "LBLcatchprob";
            this.LBLcatchprob.Size = new System.Drawing.Size(144, 20);
            this.LBLcatchprob.TabIndex = 27;
            this.LBLcatchprob.Text = "Catch Probability";
            // 
            // TXThp
            // 
            this.TXThp.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXThp.Location = new System.Drawing.Point(203, 209);
            this.TXThp.Name = "TXThp";
            this.TXThp.Size = new System.Drawing.Size(190, 21);
            this.TXThp.TabIndex = 36;
            // 
            // LBLhp
            // 
            this.LBLhp.AutoSize = true;
            this.LBLhp.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLhp.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLhp.Location = new System.Drawing.Point(38, 209);
            this.LBLhp.Name = "LBLhp";
            this.LBLhp.Size = new System.Drawing.Size(33, 20);
            this.LBLhp.TabIndex = 35;
            this.LBLhp.Text = "HP";
            // 
            // BTNcancel
            // 
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.Location = new System.Drawing.Point(357, 393);
            this.BTNcancel.Name = "BTNcancel";
            this.BTNcancel.Size = new System.Drawing.Size(103, 31);
            this.BTNcancel.TabIndex = 42;
            this.BTNcancel.Text = "Cancel";
            this.BTNcancel.UseVisualStyleBackColor = true;
            this.BTNcancel.Click += new System.EventHandler(this.BTNcancel_Click);
            // 
            // BTNupdate
            // 
            this.BTNupdate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNupdate.Location = new System.Drawing.Point(200, 393);
            this.BTNupdate.Name = "BTNupdate";
            this.BTNupdate.Size = new System.Drawing.Size(103, 31);
            this.BTNupdate.TabIndex = 41;
            this.BTNupdate.Text = "Update";
            this.BTNupdate.UseVisualStyleBackColor = true;
            this.BTNupdate.Click += new System.EventHandler(this.BTNupdate_Click);
            // 
            // BTNdelete
            // 
            this.BTNdelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNdelete.Location = new System.Drawing.Point(357, 323);
            this.BTNdelete.Name = "BTNdelete";
            this.BTNdelete.Size = new System.Drawing.Size(103, 32);
            this.BTNdelete.TabIndex = 40;
            this.BTNdelete.Text = "Delete";
            this.BTNdelete.UseVisualStyleBackColor = true;
            this.BTNdelete.Click += new System.EventHandler(this.BTNdelete_Click);
            // 
            // BTNsave
            // 
            this.BTNsave.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNsave.Location = new System.Drawing.Point(41, 392);
            this.BTNsave.Name = "BTNsave";
            this.BTNsave.Size = new System.Drawing.Size(103, 32);
            this.BTNsave.TabIndex = 39;
            this.BTNsave.Text = "Save";
            this.BTNsave.UseVisualStyleBackColor = true;
            this.BTNsave.Click += new System.EventHandler(this.BTNsave_Click);
            // 
            // BTNrecover
            // 
            this.BTNrecover.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNrecover.Location = new System.Drawing.Point(200, 324);
            this.BTNrecover.Name = "BTNrecover";
            this.BTNrecover.Size = new System.Drawing.Size(103, 31);
            this.BTNrecover.TabIndex = 38;
            this.BTNrecover.Text = "Recover";
            this.BTNrecover.UseVisualStyleBackColor = true;
            this.BTNrecover.Click += new System.EventHandler(this.BTNrecover_Click);
            // 
            // BTNnew
            // 
            this.BTNnew.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNnew.Location = new System.Drawing.Point(41, 323);
            this.BTNnew.Name = "BTNnew";
            this.BTNnew.Size = new System.Drawing.Size(103, 32);
            this.BTNnew.TabIndex = 37;
            this.BTNnew.Text = "New";
            this.BTNnew.UseVisualStyleBackColor = true;
            this.BTNnew.Click += new System.EventHandler(this.BTNnew_Click);
            // 
            // FrmAdminItem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1064, 500);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.BTNdelete);
            this.Controls.Add(this.BTNsave);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.BTNnew);
            this.Controls.Add(this.TXThp);
            this.Controls.Add(this.LBLhp);
            this.Controls.Add(this.CMBtype);
            this.Controls.Add(this.LBLtype);
            this.Controls.Add(this.TXTname);
            this.Controls.Add(this.LBLname);
            this.Controls.Add(this.TXTcatchprob);
            this.Controls.Add(this.LBLcatchprob);
            this.Controls.Add(this.DGVitem);
            this.Name = "FrmAdminItem";
            this.Text = "Admin Item";
            ((System.ComponentModel.ISupportInitialize)(this.DGVitem)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVitem;
        private System.Windows.Forms.ComboBox CMBtype;
        private System.Windows.Forms.Label LBLtype;
        private System.Windows.Forms.TextBox TXTname;
        private System.Windows.Forms.Label LBLname;
        private System.Windows.Forms.TextBox TXTcatchprob;
        private System.Windows.Forms.Label LBLcatchprob;
        private System.Windows.Forms.TextBox TXThp;
        private System.Windows.Forms.Label LBLhp;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNdelete;
        private System.Windows.Forms.Button BTNsave;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.Button BTNnew;
    }
}