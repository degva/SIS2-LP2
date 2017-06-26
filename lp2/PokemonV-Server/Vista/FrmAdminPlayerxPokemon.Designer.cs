namespace Vista
{
    partial class FrmAdminPlayerxPokemon
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
            this.DGVpokemons = new System.Windows.Forms.DataGridView();
            this.BTNcancel = new System.Windows.Forms.Button();
            this.BTNupdate = new System.Windows.Forms.Button();
            this.BTNdelete = new System.Windows.Forms.Button();
            this.BTNsave = new System.Windows.Forms.Button();
            this.BTNrecover = new System.Windows.Forms.Button();
            this.BTNnew = new System.Windows.Forms.Button();
            this.TXTplayerid = new System.Windows.Forms.TextBox();
            this.LBLplayerid = new System.Windows.Forms.Label();
            this.TXTorder = new System.Windows.Forms.TextBox();
            this.TXTpokemonid = new System.Windows.Forms.TextBox();
            this.LBLpokemonid = new System.Windows.Forms.Label();
            this.LBLorder = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.DGVpokemons)).BeginInit();
            this.SuspendLayout();
            // 
            // DGVpokemons
            // 
            this.DGVpokemons.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVpokemons.Location = new System.Drawing.Point(406, 46);
            this.DGVpokemons.Name = "DGVpokemons";
            this.DGVpokemons.Size = new System.Drawing.Size(349, 236);
            this.DGVpokemons.TabIndex = 0;
            // 
            // BTNcancel
            // 
            this.BTNcancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNcancel.Location = new System.Drawing.Point(253, 417);
            this.BTNcancel.Name = "BTNcancel";
            this.BTNcancel.Size = new System.Drawing.Size(103, 31);
            this.BTNcancel.TabIndex = 32;
            this.BTNcancel.Text = "Cancel";
            this.BTNcancel.UseVisualStyleBackColor = true;
            this.BTNcancel.Click += new System.EventHandler(this.BTNcancel_Click);
            // 
            // BTNupdate
            // 
            this.BTNupdate.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNupdate.Location = new System.Drawing.Point(73, 417);
            this.BTNupdate.Name = "BTNupdate";
            this.BTNupdate.Size = new System.Drawing.Size(103, 31);
            this.BTNupdate.TabIndex = 31;
            this.BTNupdate.Text = "Update";
            this.BTNupdate.UseVisualStyleBackColor = true;
            this.BTNupdate.Click += new System.EventHandler(this.BTNupdate_Click);
            // 
            // BTNdelete
            // 
            this.BTNdelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNdelete.Location = new System.Drawing.Point(253, 362);
            this.BTNdelete.Name = "BTNdelete";
            this.BTNdelete.Size = new System.Drawing.Size(103, 32);
            this.BTNdelete.TabIndex = 30;
            this.BTNdelete.Text = "Delete";
            this.BTNdelete.UseVisualStyleBackColor = true;
            this.BTNdelete.Click += new System.EventHandler(this.BTNdelete_Click);
            // 
            // BTNsave
            // 
            this.BTNsave.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNsave.Location = new System.Drawing.Point(253, 305);
            this.BTNsave.Name = "BTNsave";
            this.BTNsave.Size = new System.Drawing.Size(103, 32);
            this.BTNsave.TabIndex = 29;
            this.BTNsave.Text = "Save";
            this.BTNsave.UseVisualStyleBackColor = true;
            this.BTNsave.Click += new System.EventHandler(this.BTNsave_Click);
            // 
            // BTNrecover
            // 
            this.BTNrecover.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNrecover.Location = new System.Drawing.Point(73, 363);
            this.BTNrecover.Name = "BTNrecover";
            this.BTNrecover.Size = new System.Drawing.Size(103, 31);
            this.BTNrecover.TabIndex = 28;
            this.BTNrecover.Text = "Recover";
            this.BTNrecover.UseVisualStyleBackColor = true;
            this.BTNrecover.Click += new System.EventHandler(this.BTNrecover_Click);
            // 
            // BTNnew
            // 
            this.BTNnew.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNnew.Location = new System.Drawing.Point(73, 305);
            this.BTNnew.Name = "BTNnew";
            this.BTNnew.Size = new System.Drawing.Size(103, 32);
            this.BTNnew.TabIndex = 27;
            this.BTNnew.Text = "New";
            this.BTNnew.UseVisualStyleBackColor = true;
            this.BTNnew.Click += new System.EventHandler(this.BTNnew_Click);
            // 
            // TXTplayerid
            // 
            this.TXTplayerid.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTplayerid.Location = new System.Drawing.Point(187, 57);
            this.TXTplayerid.Name = "TXTplayerid";
            this.TXTplayerid.Size = new System.Drawing.Size(190, 21);
            this.TXTplayerid.TabIndex = 40;
            // 
            // LBLplayerid
            // 
            this.LBLplayerid.AutoSize = true;
            this.LBLplayerid.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLplayerid.Location = new System.Drawing.Point(22, 57);
            this.LBLplayerid.Name = "LBLplayerid";
            this.LBLplayerid.Size = new System.Drawing.Size(82, 20);
            this.LBLplayerid.TabIndex = 39;
            this.LBLplayerid.Text = "Player ID";
            // 
            // TXTorder
            // 
            this.TXTorder.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTorder.Location = new System.Drawing.Point(187, 217);
            this.TXTorder.Name = "TXTorder";
            this.TXTorder.Size = new System.Drawing.Size(190, 21);
            this.TXTorder.TabIndex = 38;
            // 
            // TXTpokemonid
            // 
            this.TXTpokemonid.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TXTpokemonid.Location = new System.Drawing.Point(187, 135);
            this.TXTpokemonid.Name = "TXTpokemonid";
            this.TXTpokemonid.Size = new System.Drawing.Size(190, 21);
            this.TXTpokemonid.TabIndex = 36;
            // 
            // LBLpokemonid
            // 
            this.LBLpokemonid.AutoSize = true;
            this.LBLpokemonid.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLpokemonid.Location = new System.Drawing.Point(22, 135);
            this.LBLpokemonid.Name = "LBLpokemonid";
            this.LBLpokemonid.Size = new System.Drawing.Size(107, 20);
            this.LBLpokemonid.TabIndex = 34;
            this.LBLpokemonid.Text = "Pokemon ID";
            // 
            // LBLorder
            // 
            this.LBLorder.AutoSize = true;
            this.LBLorder.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LBLorder.Location = new System.Drawing.Point(22, 215);
            this.LBLorder.Name = "LBLorder";
            this.LBLorder.Size = new System.Drawing.Size(154, 20);
            this.LBLorder.TabIndex = 33;
            this.LBLorder.Text = "Order of Pokemon";
            // 
            // FrmAdminPlayerxPokemon
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(767, 472);
            this.Controls.Add(this.TXTplayerid);
            this.Controls.Add(this.LBLplayerid);
            this.Controls.Add(this.TXTorder);
            this.Controls.Add(this.TXTpokemonid);
            this.Controls.Add(this.LBLpokemonid);
            this.Controls.Add(this.LBLorder);
            this.Controls.Add(this.BTNcancel);
            this.Controls.Add(this.BTNupdate);
            this.Controls.Add(this.BTNdelete);
            this.Controls.Add(this.BTNsave);
            this.Controls.Add(this.BTNrecover);
            this.Controls.Add(this.BTNnew);
            this.Controls.Add(this.DGVpokemons);
            this.Name = "FrmAdminPlayerxPokemon";
            this.Text = "Admin Player\'s Pokemon";
            ((System.ComponentModel.ISupportInitialize)(this.DGVpokemons)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView DGVpokemons;
        private System.Windows.Forms.Button BTNcancel;
        private System.Windows.Forms.Button BTNupdate;
        private System.Windows.Forms.Button BTNdelete;
        private System.Windows.Forms.Button BTNsave;
        private System.Windows.Forms.Button BTNrecover;
        private System.Windows.Forms.Button BTNnew;
        private System.Windows.Forms.TextBox TXTplayerid;
        private System.Windows.Forms.Label LBLplayerid;
        private System.Windows.Forms.TextBox TXTorder;
        private System.Windows.Forms.TextBox TXTpokemonid;
        private System.Windows.Forms.Label LBLpokemonid;
        private System.Windows.Forms.Label LBLorder;
    }
}