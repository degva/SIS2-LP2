namespace Vista
{
    partial class FrmAdminAttack
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
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.TXTname = new System.Windows.Forms.TextBox();
            this.TXTpoints = new System.Windows.Forms.TextBox();
            this.LBLpoints = new System.Windows.Forms.Label();
            this.LBLname = new System.Windows.Forms.Label();
            this.DGVattack = new System.Windows.Forms.DataGridView();
            this.TXTid = new System.Windows.Forms.TextBox();
            this.LBLid = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.DGVattack)).BeginInit();
            this.SuspendLayout();
            // 
            // BTNupdate
            // 
            this.BTNupdate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNupdate.Location = new System.Drawing.Point(271, 334);
            this.BTNupdate.Name = "BTNupdate";
            this.BTNupdate.Size = new System.Drawing.Size(103, 31);
            this.BTNupdate.TabIndex = 29;
            this.BTNupdate.Text = "Update";
            this.BTNupdate.UseVisualStyleBackColor = true;
            this.BTNupdate.Click += new System.EventHandler(this.BTNupdate_Click);
            // 
            // BTNrecover
            // 
            this.BTNrecover.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNrecover.Location = new System.Drawing.Point(67, 334);
            this.BTNrecover.Name = "BTNrecover";
            this.BTNrecover.Size = new System.Drawing.Size(103, 31);
            this.BTNrecover.TabIndex = 24;
            this.BTNrecover.Text = "Recover";
            this.BTNrecover.UseVisualStyleBackColor = true;
            this.BTNrecover.Click += new System.EventHandler(this.BTNrecover_Click);
            // 
            // TXTname
            // 
            this.TXTname.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTname.Location = new System.Drawing.Point(195, 144);
            this.TXTname.Name = "TXTname";
            this.TXTname.Size = new System.Drawing.Size(190, 21);
            this.TXTname.TabIndex = 22;
            // 
            // TXTpoints
            // 
            this.TXTpoints.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTpoints.Location = new System.Drawing.Point(195, 205);
            this.TXTpoints.Name = "TXTpoints";
            this.TXTpoints.Size = new System.Drawing.Size(190, 21);
            this.TXTpoints.TabIndex = 21;
            // 
            // LBLpoints
            // 
            this.LBLpoints.AutoSize = true;
            this.LBLpoints.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLpoints.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLpoints.Location = new System.Drawing.Point(30, 205);
            this.LBLpoints.Name = "LBLpoints";
            this.LBLpoints.Size = new System.Drawing.Size(59, 20);
            this.LBLpoints.TabIndex = 19;
            this.LBLpoints.Text = "Points";
            // 
            // LBLname
            // 
            this.LBLname.AutoSize = true;
            this.LBLname.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLname.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLname.Location = new System.Drawing.Point(30, 142);
            this.LBLname.Name = "LBLname";
            this.LBLname.Size = new System.Drawing.Size(55, 20);
            this.LBLname.TabIndex = 17;
            this.LBLname.Text = "Name";
            // 
            // DGVattack
            // 
            this.DGVattack.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVattack.Location = new System.Drawing.Point(452, 36);
            this.DGVattack.Name = "DGVattack";
            this.DGVattack.Size = new System.Drawing.Size(346, 412);
            this.DGVattack.TabIndex = 31;
            // 
            // TXTid
            // 
            this.TXTid.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTid.Location = new System.Drawing.Point(195, 89);
            this.TXTid.Name = "TXTid";
            this.TXTid.Size = new System.Drawing.Size(190, 21);
            this.TXTid.TabIndex = 33;
            // 
            // LBLid
            // 
            this.LBLid.AutoSize = true;
            this.LBLid.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLid.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLid.Location = new System.Drawing.Point(30, 87);
            this.LBLid.Name = "LBLid";
            this.LBLid.Size = new System.Drawing.Size(28, 20);
            this.LBLid.TabIndex = 32;
            this.LBLid.Text = "ID";
            // 
            // FrmAdminAttack
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(808, 485);
            this.Controls.Add(this.TXTid);
            this.Controls.Add(this.LBLid);
            this.Controls.Add(this.DGVattack);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.TXTname);
            this.Controls.Add(this.TXTpoints);
            this.Controls.Add(this.LBLpoints);
            this.Controls.Add(this.LBLname);
            this.Name = "FrmAdminAttack";
            this.Text = "FrmAdminAttack";
            ((System.ComponentModel.ISupportInitialize)(this.DGVattack)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.TextBox TXTname;
        private System.Windows.Forms.TextBox TXTpoints;
        private System.Windows.Forms.Label LBLpoints;
        private System.Windows.Forms.Label LBLname;
        private System.Windows.Forms.DataGridView DGVattack;
        private System.Windows.Forms.TextBox TXTid;
        private System.Windows.Forms.Label LBLid;
    }
}