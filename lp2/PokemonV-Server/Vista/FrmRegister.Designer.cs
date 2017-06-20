namespace Vista
{
    partial class FrmRegister
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
            this.LBLusername = new System.Windows.Forms.Label();
            this.LBLemail = new System.Windows.Forms.Label();
            this.LBLpassword = new System.Windows.Forms.Label();
            this.TXTusername = new System.Windows.Forms.TextBox();
            this.TXTpassword = new System.Windows.Forms.TextBox();
            this.TXTemail = new System.Windows.Forms.TextBox();
            this.BTNregister = new System.Windows.Forms.Button();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.TXTname = new System.Windows.Forms.TextBox();
            this.LBLname = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // LBLusername
            // 
            this.LBLusername.AutoSize = true;
            this.LBLusername.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLusername.Location = new System.Drawing.Point(124, 132);
            this.LBLusername.Name = "LBLusername";
            this.LBLusername.Size = new System.Drawing.Size(105, 24);
            this.LBLusername.TabIndex = 0;
            this.LBLusername.Text = "Username";
            this.LBLusername.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // LBLemail
            // 
            this.LBLemail.AutoSize = true;
            this.LBLemail.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLemail.Location = new System.Drawing.Point(124, 263);
            this.LBLemail.Name = "LBLemail";
            this.LBLemail.Size = new System.Drawing.Size(62, 24);
            this.LBLemail.TabIndex = 1;
            this.LBLemail.Text = "Email";
            this.LBLemail.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // LBLpassword
            // 
            this.LBLpassword.AutoSize = true;
            this.LBLpassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLpassword.Location = new System.Drawing.Point(124, 196);
            this.LBLpassword.Name = "LBLpassword";
            this.LBLpassword.Size = new System.Drawing.Size(100, 24);
            this.LBLpassword.TabIndex = 2;
            this.LBLpassword.Text = "Password";
            this.LBLpassword.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // TXTusername
            // 
            this.TXTusername.Location = new System.Drawing.Point(249, 132);
            this.TXTusername.Name = "TXTusername";
            this.TXTusername.Size = new System.Drawing.Size(168, 20);
            this.TXTusername.TabIndex = 3;
            // 
            // TXTpassword
            // 
            this.TXTpassword.Location = new System.Drawing.Point(249, 200);
            this.TXTpassword.Name = "TXTpassword";
            this.TXTpassword.Size = new System.Drawing.Size(168, 20);
            this.TXTpassword.TabIndex = 4;
            // 
            // TXTemail
            // 
            this.TXTemail.Location = new System.Drawing.Point(249, 266);
            this.TXTemail.Name = "TXTemail";
            this.TXTemail.Size = new System.Drawing.Size(168, 20);
            this.TXTemail.TabIndex = 5;
            this.TXTemail.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TXTemail_KeyPress);
            // 
            // BTNregister
            // 
            this.BTNregister.BackColor = System.Drawing.Color.MediumSeaGreen;
            this.BTNregister.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNregister.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.BTNregister.Location = new System.Drawing.Point(112, 333);
            this.BTNregister.Name = "BTNregister";
            this.BTNregister.Size = new System.Drawing.Size(96, 32);
            this.BTNregister.TabIndex = 6;
            this.BTNregister.Text = "Register";
            this.BTNregister.UseVisualStyleBackColor = false;
            this.BTNregister.Click += new System.EventHandler(this.BTNregister_Click);
            // 
            // BTNcancel
            // 
            this.BTNcancel.BackColor = System.Drawing.Color.Red;
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.BTNcancel.Location = new System.Drawing.Point(323, 333);
            this.BTNcancel.Name = "BTNcancel";
            this.BTNcancel.Size = new System.Drawing.Size(94, 32);
            this.BTNcancel.TabIndex = 7;
            this.BTNcancel.Text = "Cancel";
            this.BTNcancel.UseVisualStyleBackColor = false;
            this.BTNcancel.Click += new System.EventHandler(this.BTNcancel_Click);
            // 
            // TXTname
            // 
            this.TXTname.Location = new System.Drawing.Point(249, 76);
            this.TXTname.Name = "TXTname";
            this.TXTname.Size = new System.Drawing.Size(168, 20);
            this.TXTname.TabIndex = 9;
            // 
            // LBLname
            // 
            this.LBLname.AutoSize = true;
            this.LBLname.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLname.Location = new System.Drawing.Point(124, 76);
            this.LBLname.Name = "LBLname";
            this.LBLname.Size = new System.Drawing.Size(65, 24);
            this.LBLname.TabIndex = 8;
            this.LBLname.Text = "Name";
            this.LBLname.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // FrmRegister
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(512, 436);
            this.Controls.Add(this.TXTname);
            this.Controls.Add(this.LBLname);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNregister);
            this.Controls.Add(this.TXTemail);
            this.Controls.Add(this.TXTpassword);
            this.Controls.Add(this.TXTusername);
            this.Controls.Add(this.LBLpassword);
            this.Controls.Add(this.LBLemail);
            this.Controls.Add(this.LBLusername);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmRegister";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Register";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label LBLusername;
        private System.Windows.Forms.Label LBLemail;
        private System.Windows.Forms.Label LBLpassword;
        private System.Windows.Forms.TextBox TXTusername;
        private System.Windows.Forms.TextBox TXTpassword;
        private System.Windows.Forms.TextBox TXTemail;
        private System.Windows.Forms.Button BTNregister;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.TextBox TXTname;
        private System.Windows.Forms.Label LBLname;
    }
}