namespace Vista
{
    partial class FrmAdminPlayerxItem
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmAdminPlayerxItem));
            this.DGVplayerxitem = new System.Windows.Forms.DataGridView();
            this.TXTitemid = new System.Windows.Forms.TextBox();
            this.TXTplayerid = new System.Windows.Forms.TextBox();
            this.LBLplayerid = new System.Windows.Forms.Label();
            this.LBLitemid = new System.Windows.Forms.Label();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNdelete = new System.Windows.Forms.Button();
            this.BTNsave = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.BTNnew = new System.Windows.Forms.Button();
            this.TXTquantity = new System.Windows.Forms.TextBox();
            this.LBLquantity = new System.Windows.Forms.Label();
            this.BTNback = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVplayerxitem)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVplayerxitem
            // 
            this.DGVplayerxitem.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVplayerxitem.Location = new System.Drawing.Point(410, 44);
            this.DGVplayerxitem.Name = "DGVplayerxitem";
            this.DGVplayerxitem.Size = new System.Drawing.Size(363, 143);
            this.DGVplayerxitem.TabIndex = 0;
            // 
            // TXTitemid
            // 
            this.TXTitemid.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTitemid.Location = new System.Drawing.Point(177, 147);
            this.TXTitemid.Name = "TXTitemid";
            this.TXTitemid.Size = new System.Drawing.Size(190, 21);
            this.TXTitemid.TabIndex = 24;
            // 
            // TXTplayerid
            // 
            this.TXTplayerid.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTplayerid.Location = new System.Drawing.Point(177, 76);
            this.TXTplayerid.Name = "TXTplayerid";
            this.TXTplayerid.Size = new System.Drawing.Size(190, 21);
            this.TXTplayerid.TabIndex = 23;
            // 
            // LBLplayerid
            // 
            this.LBLplayerid.AutoSize = true;
            this.LBLplayerid.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLplayerid.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLplayerid.Location = new System.Drawing.Point(12, 76);
            this.LBLplayerid.Name = "LBLplayerid";
            this.LBLplayerid.Size = new System.Drawing.Size(82, 20);
            this.LBLplayerid.TabIndex = 22;
            this.LBLplayerid.Text = "Player ID";
            // 
            // LBLitemid
            // 
            this.LBLitemid.AutoSize = true;
            this.LBLitemid.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLitemid.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLitemid.Location = new System.Drawing.Point(12, 145);
            this.LBLitemid.Name = "LBLitemid";
            this.LBLitemid.Size = new System.Drawing.Size(69, 20);
            this.LBLitemid.TabIndex = 21;
            this.LBLitemid.Text = "Item ID";
            // 
            // BTNcancel
            // 
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.Location = new System.Drawing.Point(249, 428);
            this.BTNcancel.Name = "BTNcancel";
            this.BTNcancel.Size = new System.Drawing.Size(103, 31);
            this.BTNcancel.TabIndex = 36;
            this.BTNcancel.Text = "Cancel";
            this.BTNcancel.UseVisualStyleBackColor = true;
            this.BTNcancel.Click += new System.EventHandler(this.BTNcancel_Click);
            // 
            // BTNupdate
            // 
            this.BTNupdate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNupdate.Location = new System.Drawing.Point(249, 352);
            this.BTNupdate.Name = "BTNupdate";
            this.BTNupdate.Size = new System.Drawing.Size(103, 31);
            this.BTNupdate.TabIndex = 35;
            this.BTNupdate.Text = "Update";
            this.BTNupdate.UseVisualStyleBackColor = true;
            this.BTNupdate.Click += new System.EventHandler(this.BTNupdate_Click);
            // 
            // BTNdelete
            // 
            this.BTNdelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNdelete.Location = new System.Drawing.Point(90, 428);
            this.BTNdelete.Name = "BTNdelete";
            this.BTNdelete.Size = new System.Drawing.Size(103, 32);
            this.BTNdelete.TabIndex = 34;
            this.BTNdelete.Text = "Delete";
            this.BTNdelete.UseVisualStyleBackColor = true;
            this.BTNdelete.Click += new System.EventHandler(this.BTNdelete_Click);
            // 
            // BTNsave
            // 
            this.BTNsave.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNsave.Location = new System.Drawing.Point(249, 282);
            this.BTNsave.Name = "BTNsave";
            this.BTNsave.Size = new System.Drawing.Size(103, 32);
            this.BTNsave.TabIndex = 33;
            this.BTNsave.Text = "Save";
            this.BTNsave.UseVisualStyleBackColor = true;
            this.BTNsave.Click += new System.EventHandler(this.BTNsave_Click);
            // 
            // BTNrecover
            // 
            this.BTNrecover.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNrecover.Location = new System.Drawing.Point(90, 352);
            this.BTNrecover.Name = "BTNrecover";
            this.BTNrecover.Size = new System.Drawing.Size(103, 31);
            this.BTNrecover.TabIndex = 32;
            this.BTNrecover.Text = "Recover";
            this.BTNrecover.UseVisualStyleBackColor = true;
            this.BTNrecover.Click += new System.EventHandler(this.BTNrecover_Click);
            // 
            // BTNnew
            // 
            this.BTNnew.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNnew.Location = new System.Drawing.Point(90, 282);
            this.BTNnew.Name = "BTNnew";
            this.BTNnew.Size = new System.Drawing.Size(103, 32);
            this.BTNnew.TabIndex = 31;
            this.BTNnew.Text = "New";
            this.BTNnew.UseVisualStyleBackColor = true;
            this.BTNnew.Click += new System.EventHandler(this.BTNnew_Click);
            // 
            // TXTquantity
            // 
            this.TXTquantity.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTquantity.Location = new System.Drawing.Point(177, 211);
            this.TXTquantity.Name = "TXTquantity";
            this.TXTquantity.Size = new System.Drawing.Size(190, 21);
            this.TXTquantity.TabIndex = 38;
            // 
            // LBLquantity
            // 
            this.LBLquantity.AutoSize = true;
            this.LBLquantity.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLquantity.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.LBLquantity.Location = new System.Drawing.Point(12, 209);
            this.LBLquantity.Name = "LBLquantity";
            this.LBLquantity.Size = new System.Drawing.Size(76, 20);
            this.LBLquantity.TabIndex = 37;
            this.LBLquantity.Text = "Quantity";
            // 
            // BTNback
            // 
            this.BTNback.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNback.Location = new System.Drawing.Point(21, 12);
            this.BTNback.Name = "BTNback";
            this.BTNback.Size = new System.Drawing.Size(73, 28);
            this.BTNback.TabIndex = 44;
            this.BTNback.Text = "Back";
            this.BTNback.UseVisualStyleBackColor = true;
            this.BTNback.Click += new System.EventHandler(this.BTNback_Click);
            // 
            // FrmAdminPlayerxItem
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(785, 566);
            this.Controls.Add(this.BTNback);
            this.Controls.Add(this.TXTquantity);
            this.Controls.Add(this.LBLquantity);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.BTNdelete);
            this.Controls.Add(this.BTNsave);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.BTNnew);
            this.Controls.Add(this.TXTitemid);
            this.Controls.Add(this.TXTplayerid);
            this.Controls.Add(this.LBLplayerid);
            this.Controls.Add(this.LBLitemid);
            this.Controls.Add(this.DGVplayerxitem);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmAdminPlayerxItem";
            this.Text = "Admin Player\'s Item";
            ((System.ComponentModel.ISupportInitialize)(this.DGVplayerxitem)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVplayerxitem;
        private System.Windows.Forms.TextBox TXTitemid;
        private System.Windows.Forms.TextBox TXTplayerid;
        private System.Windows.Forms.Label LBLplayerid;
        private System.Windows.Forms.Label LBLitemid;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNdelete;
        private System.Windows.Forms.Button BTNsave;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.Button BTNnew;
        private System.Windows.Forms.TextBox TXTquantity;
        private System.Windows.Forms.Label LBLquantity;
        private System.Windows.Forms.Button BTNback;
    }
}