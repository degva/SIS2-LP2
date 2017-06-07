namespace Vista
{
    partial class FrmLogueo
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.LBLusername = new System.Windows.Forms.Label();
            this.LBLpassword = new System.Windows.Forms.Label();
            this.TXTusername = new System.Windows.Forms.TextBox();
            this.TXTpassword = new System.Windows.Forms.TextBox();
            this.BTNlogin = new System.Windows.Forms.Button();
            this.BTNregister = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // LBLusername
            // 
            this.LBLusername.AutoSize = true;
            this.LBLusername.BackColor = System.Drawing.Color.Transparent;
            this.LBLusername.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLusername.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.LBLusername.Location = new System.Drawing.Point(183, 188);
            this.LBLusername.Name = "LBLusername";
            this.LBLusername.Size = new System.Drawing.Size(105, 24);
            this.LBLusername.TabIndex = 0;
            this.LBLusername.Text = "Username";
            // 
            // LBLpassword
            // 
            this.LBLpassword.AutoSize = true;
            this.LBLpassword.BackColor = System.Drawing.Color.Transparent;
            this.LBLpassword.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLpassword.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.LBLpassword.Location = new System.Drawing.Point(183, 239);
            this.LBLpassword.Name = "LBLpassword";
            this.LBLpassword.Size = new System.Drawing.Size(100, 24);
            this.LBLpassword.TabIndex = 1;
            this.LBLpassword.Text = "Password";
            // 
            // TXTusername
            // 
            this.TXTusername.Location = new System.Drawing.Point(318, 192);
            this.TXTusername.Name = "TXTusername";
            this.TXTusername.Size = new System.Drawing.Size(149, 20);
            this.TXTusername.TabIndex = 2;
            // 
            // TXTpassword
            // 
            this.TXTpassword.Location = new System.Drawing.Point(318, 243);
            this.TXTpassword.Name = "TXTpassword";
            this.TXTpassword.Size = new System.Drawing.Size(149, 20);
            this.TXTpassword.TabIndex = 3;
            // 
            // BTNlogin
            // 
            this.BTNlogin.BackColor = System.Drawing.Color.LawnGreen;
            this.BTNlogin.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.BTNlogin.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.BTNlogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.BTNlogin.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.BTNlogin.Location = new System.Drawing.Point(180, 317);
            this.BTNlogin.Name = "BTNlogin";
            this.BTNlogin.Size = new System.Drawing.Size(108, 27);
            this.BTNlogin.TabIndex = 4;
            this.BTNlogin.Text = "Login";
            this.BTNlogin.UseVisualStyleBackColor = false;
            this.BTNlogin.Click += new System.EventHandler(this.BTNlogin_Click);
            // 
            // BTNregister
            // 
            this.BTNregister.BackColor = System.Drawing.Color.LimeGreen;
            this.BTNregister.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.BTNregister.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.BTNregister.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.BTNregister.Location = new System.Drawing.Point(370, 317);
            this.BTNregister.Name = "BTNregister";
            this.BTNregister.Size = new System.Drawing.Size(108, 27);
            this.BTNregister.TabIndex = 5;
            this.BTNregister.Text = "Register";
            this.BTNregister.UseVisualStyleBackColor = false;
            this.BTNregister.Click += new System.EventHandler(this.BTNregister_Click);
            // 
            // FrmLogueo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(639, 407);
            this.Controls.Add(this.BTNregister);
            this.Controls.Add(this.BTNlogin);
            this.Controls.Add(this.TXTpassword);
            this.Controls.Add(this.TXTusername);
            this.Controls.Add(this.LBLpassword);
            this.Controls.Add(this.LBLusername);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmLogueo";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Login";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label LBLusername;
        private System.Windows.Forms.Label LBLpassword;
        private System.Windows.Forms.TextBox TXTusername;
        private System.Windows.Forms.TextBox TXTpassword;
        private System.Windows.Forms.Button BTNlogin;
        private System.Windows.Forms.Button BTNregister;
    }
}

