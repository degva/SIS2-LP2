namespace Vista
{
    partial class FrmAdminUser
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
            this.DGVadmin = new System.Windows.Forms.DataGridView();
            this.LBLpassword = new System.Windows.Forms.Label();
            this.LBLusername = new System.Windows.Forms.Label();
            this.LBLemail = new System.Windows.Forms.Label();
            this.TXTusername = new System.Windows.Forms.TextBox();
            this.TXTemail = new System.Windows.Forms.TextBox();
            this.TXTpassword = new System.Windows.Forms.TextBox();
            this.BTNnew = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.BTNsave = new System.Windows.Forms.Button();
            this.BTNdelete = new System.Windows.Forms.Button();
            this.TXTname = new System.Windows.Forms.TextBox();
            this.LBLname = new System.Windows.Forms.Label();
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.BTNback = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVadmin)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVadmin
            // 
            this.DGVadmin.AllowUserToAddRows = false;
            this.DGVadmin.AllowUserToDeleteRows = false;
            this.DGVadmin.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVadmin.Location = new System.Drawing.Point(487, 290);
            this.DGVadmin.Name = "DGVadmin";
            this.DGVadmin.ReadOnly = true;
            this.DGVadmin.Size = new System.Drawing.Size(544, 159);
            this.DGVadmin.TabIndex = 0;
            // 
            // LBLpassword
            // 
            this.LBLpassword.AutoSize = true;
            this.LBLpassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLpassword.Location = new System.Drawing.Point(12, 166);
            this.LBLpassword.Name = "LBLpassword";
            this.LBLpassword.Size = new System.Drawing.Size(100, 24);
            this.LBLpassword.TabIndex = 1;
            this.LBLpassword.Text = "Password";
            // 
            // LBLusername
            // 
            this.LBLusername.AutoSize = true;
            this.LBLusername.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLusername.Location = new System.Drawing.Point(12, 110);
            this.LBLusername.Name = "LBLusername";
            this.LBLusername.Size = new System.Drawing.Size(105, 24);
            this.LBLusername.TabIndex = 2;
            this.LBLusername.Text = "Username";
            // 
            // LBLemail
            // 
            this.LBLemail.AutoSize = true;
            this.LBLemail.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLemail.Location = new System.Drawing.Point(12, 231);
            this.LBLemail.Name = "LBLemail";
            this.LBLemail.Size = new System.Drawing.Size(62, 24);
            this.LBLemail.TabIndex = 3;
            this.LBLemail.Text = "Email";
            // 
            // TXTusername
            // 
            this.TXTusername.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTusername.Location = new System.Drawing.Point(177, 110);
            this.TXTusername.Name = "TXTusername";
            this.TXTusername.Size = new System.Drawing.Size(190, 21);
            this.TXTusername.TabIndex = 4;
            // 
            // TXTemail
            // 
            this.TXTemail.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTemail.Location = new System.Drawing.Point(177, 231);
            this.TXTemail.Name = "TXTemail";
            this.TXTemail.Size = new System.Drawing.Size(190, 21);
            this.TXTemail.TabIndex = 5;
            // 
            // TXTpassword
            // 
            this.TXTpassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTpassword.Location = new System.Drawing.Point(177, 168);
            this.TXTpassword.Name = "TXTpassword";
            this.TXTpassword.Size = new System.Drawing.Size(190, 21);
            this.TXTpassword.TabIndex = 6;
            // 
            // BTNnew
            // 
            this.BTNnew.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.BTNnew.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNnew.Location = new System.Drawing.Point(54, 290);
            this.BTNnew.Name = "BTNnew";
            this.BTNnew.Size = new System.Drawing.Size(103, 32);
            this.BTNnew.TabIndex = 7;
            this.BTNnew.Text = "New";
            this.BTNnew.UseVisualStyleBackColor = true;
            this.BTNnew.Click += new System.EventHandler(this.BTNnew_Click);
            // 
            // BTNrecover
            // 
            this.BTNrecover.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNrecover.Location = new System.Drawing.Point(54, 348);
            this.BTNrecover.Name = "BTNrecover";
            this.BTNrecover.Size = new System.Drawing.Size(103, 31);
            this.BTNrecover.TabIndex = 10;
            this.BTNrecover.Text = "Recover";
            this.BTNrecover.UseVisualStyleBackColor = true;
            this.BTNrecover.Click += new System.EventHandler(this.BTNupdate_Click);
            // 
            // BTNsave
            // 
            this.BTNsave.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNsave.Location = new System.Drawing.Point(234, 290);
            this.BTNsave.Name = "BTNsave";
            this.BTNsave.Size = new System.Drawing.Size(103, 32);
            this.BTNsave.TabIndex = 11;
            this.BTNsave.Text = "Save";
            this.BTNsave.UseVisualStyleBackColor = true;
            this.BTNsave.Click += new System.EventHandler(this.BTNsave_Click);
            // 
            // BTNdelete
            // 
            this.BTNdelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNdelete.Location = new System.Drawing.Point(234, 347);
            this.BTNdelete.Name = "BTNdelete";
            this.BTNdelete.Size = new System.Drawing.Size(103, 32);
            this.BTNdelete.TabIndex = 12;
            this.BTNdelete.Text = "Delete";
            this.BTNdelete.UseVisualStyleBackColor = true;
            this.BTNdelete.Click += new System.EventHandler(this.BTNdelete_Click);
            // 
            // TXTname
            // 
            this.TXTname.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTname.Location = new System.Drawing.Point(177, 59);
            this.TXTname.Name = "TXTname";
            this.TXTname.Size = new System.Drawing.Size(190, 21);
            this.TXTname.TabIndex = 14;
            // 
            // LBLname
            // 
            this.LBLname.AutoSize = true;
            this.LBLname.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLname.Location = new System.Drawing.Point(12, 59);
            this.LBLname.Name = "LBLname";
            this.LBLname.Size = new System.Drawing.Size(65, 24);
            this.LBLname.TabIndex = 13;
            this.LBLname.Text = "Name";
            // 
            // BTNupdate
            // 
            this.BTNupdate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNupdate.Location = new System.Drawing.Point(54, 402);
            this.BTNupdate.Name = "BTNupdate";
            this.BTNupdate.Size = new System.Drawing.Size(103, 31);
            this.BTNupdate.TabIndex = 15;
            this.BTNupdate.Text = "Update";
            this.BTNupdate.UseVisualStyleBackColor = true;
            this.BTNupdate.Click += new System.EventHandler(this.BTNupdate_Click_1);
            // 
            // BTNcancel
            // 
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.Location = new System.Drawing.Point(234, 402);
            this.BTNcancel.Name = "BTNcancel";
            this.BTNcancel.Size = new System.Drawing.Size(103, 31);
            this.BTNcancel.TabIndex = 16;
            this.BTNcancel.Text = "Cancel";
            this.BTNcancel.UseVisualStyleBackColor = true;
            this.BTNcancel.Click += new System.EventHandler(this.BTNcancel_Click);
            // 
            // BTNback
            // 
            this.BTNback.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNback.Location = new System.Drawing.Point(16, 12);
            this.BTNback.Name = "BTNback";
            this.BTNback.Size = new System.Drawing.Size(73, 28);
            this.BTNback.TabIndex = 44;
            this.BTNback.Text = "Back";
            this.BTNback.UseVisualStyleBackColor = true;
            this.BTNback.Click += new System.EventHandler(this.BTNback_Click);
            // 
            // FrmAdminUser
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1052, 466);
            this.Controls.Add(this.BTNback);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.TXTname);
            this.Controls.Add(this.LBLname);
            this.Controls.Add(this.BTNdelete);
            this.Controls.Add(this.BTNsave);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.BTNnew);
            this.Controls.Add(this.TXTpassword);
            this.Controls.Add(this.TXTemail);
            this.Controls.Add(this.TXTusername);
            this.Controls.Add(this.LBLemail);
            this.Controls.Add(this.LBLusername);
            this.Controls.Add(this.LBLpassword);
            this.Controls.Add(this.DGVadmin);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmAdminUser";
            this.Text = "Admin Player";
            ((System.ComponentModel.ISupportInitialize)(this.DGVadmin)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVadmin;
        private System.Windows.Forms.Label LBLpassword;
        private System.Windows.Forms.Label LBLusername;
        private System.Windows.Forms.Label LBLemail;
        private System.Windows.Forms.TextBox TXTusername;
        private System.Windows.Forms.TextBox TXTemail;
        private System.Windows.Forms.TextBox TXTpassword;
        private System.Windows.Forms.Button BTNnew;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.Button BTNsave;
        private System.Windows.Forms.Button BTNdelete;
        private System.Windows.Forms.TextBox TXTname;
        private System.Windows.Forms.Label LBLname;
        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.Button BTNback;
    }
}