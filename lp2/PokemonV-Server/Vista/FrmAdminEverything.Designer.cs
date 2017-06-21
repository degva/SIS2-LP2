namespace Vista
{
    partial class FrmAdminEverything
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
            this.BTNmanageusers = new System.Windows.Forms.Button();
            this.BTNmanagepokemon = new System.Windows.Forms.Button();
            this.BTNmanageplayerspokemon = new System.Windows.Forms.Button();
            this.BTNmanageitem = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // BTNmanageusers
            // 
            this.BTNmanageusers.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanageusers.Location = new System.Drawing.Point(169, 63);
            this.BTNmanageusers.Name = "BTNmanageusers";
            this.BTNmanageusers.Size = new System.Drawing.Size(204, 48);
            this.BTNmanageusers.TabIndex = 0;
            this.BTNmanageusers.Text = "Manage Users";
            this.BTNmanageusers.UseVisualStyleBackColor = true;
            this.BTNmanageusers.Click += new System.EventHandler(this.BTNmanageusers_Click);
            // 
            // BTNmanagepokemon
            // 
            this.BTNmanagepokemon.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanagepokemon.Location = new System.Drawing.Point(169, 163);
            this.BTNmanagepokemon.Name = "BTNmanagepokemon";
            this.BTNmanagepokemon.Size = new System.Drawing.Size(204, 48);
            this.BTNmanagepokemon.TabIndex = 1;
            this.BTNmanagepokemon.Text = "Manage Pokemon";
            this.BTNmanagepokemon.UseVisualStyleBackColor = true;
            this.BTNmanagepokemon.Click += new System.EventHandler(this.BTNmanagepokemon_Click);
            // 
            // BTNmanageplayerspokemon
            // 
            this.BTNmanageplayerspokemon.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanageplayerspokemon.Location = new System.Drawing.Point(125, 258);
            this.BTNmanageplayerspokemon.Name = "BTNmanageplayerspokemon";
            this.BTNmanageplayerspokemon.Size = new System.Drawing.Size(286, 48);
            this.BTNmanageplayerspokemon.TabIndex = 2;
            this.BTNmanageplayerspokemon.Text = "Manage Player\'s Pokemon";
            this.BTNmanageplayerspokemon.UseVisualStyleBackColor = true;
            this.BTNmanageplayerspokemon.Click += new System.EventHandler(this.BTNmanageplayerspokemon_Click);
            // 
            // BTNmanageitem
            // 
            this.BTNmanageitem.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanageitem.Location = new System.Drawing.Point(169, 342);
            this.BTNmanageitem.Name = "BTNmanageitem";
            this.BTNmanageitem.Size = new System.Drawing.Size(204, 48);
            this.BTNmanageitem.TabIndex = 3;
            this.BTNmanageitem.Text = "Manage Item";
            this.BTNmanageitem.UseVisualStyleBackColor = true;
            this.BTNmanageitem.Click += new System.EventHandler(this.BTNmanageitem_Click);
            // 
            // FrmAdminEverything
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(562, 450);
            this.Controls.Add(this.BTNmanageitem);
            this.Controls.Add(this.BTNmanageplayerspokemon);
            this.Controls.Add(this.BTNmanagepokemon);
            this.Controls.Add(this.BTNmanageusers);
            this.Name = "FrmAdminEverything";
            this.Text = "Admin Game";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button BTNmanageusers;
        private System.Windows.Forms.Button BTNmanagepokemon;
        private System.Windows.Forms.Button BTNmanageplayerspokemon;
        private System.Windows.Forms.Button BTNmanageitem;
    }
}