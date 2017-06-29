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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmAdminEverything));
            this.BTNmanageusers = new System.Windows.Forms.Button();
            this.BTNmanagepokemon = new System.Windows.Forms.Button();
            this.BTNmanageplayerspokemon = new System.Windows.Forms.Button();
            this.BTNmanageitem = new System.Windows.Forms.Button();
            this.BTNmanageplayersitem = new System.Windows.Forms.Button();
            this.BTNmanageattack = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // BTNmanageusers
            // 
            this.BTNmanageusers.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanageusers.Location = new System.Drawing.Point(176, 50);
            this.BTNmanageusers.Name = "BTNmanageusers";
            this.BTNmanageusers.Size = new System.Drawing.Size(204, 48);
            this.BTNmanageusers.TabIndex = 0;
            this.BTNmanageusers.Text = "Manage Players";
            this.BTNmanageusers.UseVisualStyleBackColor = true;
            this.BTNmanageusers.Click += new System.EventHandler(this.BTNmanageusers_Click);
            // 
            // BTNmanagepokemon
            // 
            this.BTNmanagepokemon.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanagepokemon.Location = new System.Drawing.Point(176, 133);
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
            this.BTNmanageplayerspokemon.Location = new System.Drawing.Point(135, 286);
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
            this.BTNmanageitem.Location = new System.Drawing.Point(176, 450);
            this.BTNmanageitem.Name = "BTNmanageitem";
            this.BTNmanageitem.Size = new System.Drawing.Size(204, 48);
            this.BTNmanageitem.TabIndex = 3;
            this.BTNmanageitem.Text = "Manage Item";
            this.BTNmanageitem.UseVisualStyleBackColor = true;
            this.BTNmanageitem.Click += new System.EventHandler(this.BTNmanageitem_Click);
            // 
            // BTNmanageplayersitem
            // 
            this.BTNmanageplayersitem.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanageplayersitem.Location = new System.Drawing.Point(135, 370);
            this.BTNmanageplayersitem.Name = "BTNmanageplayersitem";
            this.BTNmanageplayersitem.Size = new System.Drawing.Size(286, 48);
            this.BTNmanageplayersitem.TabIndex = 4;
            this.BTNmanageplayersitem.Text = "Manage Player\'s Item";
            this.BTNmanageplayersitem.UseVisualStyleBackColor = true;
            this.BTNmanageplayersitem.Click += new System.EventHandler(this.BTNpalyersitem_Click);
            // 
            // BTNmanageattack
            // 
            this.BTNmanageattack.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BTNmanageattack.Location = new System.Drawing.Point(176, 209);
            this.BTNmanageattack.Name = "BTNmanageattack";
            this.BTNmanageattack.Size = new System.Drawing.Size(204, 48);
            this.BTNmanageattack.TabIndex = 5;
            this.BTNmanageattack.Text = "Manage Attack";
            this.BTNmanageattack.UseVisualStyleBackColor = true;
            this.BTNmanageattack.Click += new System.EventHandler(this.BTNmanageattack_Click);
            // 
            // FrmAdminEverything
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(562, 554);
            this.Controls.Add(this.BTNmanageattack);
            this.Controls.Add(this.BTNmanageplayersitem);
            this.Controls.Add(this.BTNmanageitem);
            this.Controls.Add(this.BTNmanageplayerspokemon);
            this.Controls.Add(this.BTNmanagepokemon);
            this.Controls.Add(this.BTNmanageusers);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmAdminEverything";
            this.Text = "Admin Game";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button BTNmanageusers;
        private System.Windows.Forms.Button BTNmanagepokemon;
        private System.Windows.Forms.Button BTNmanageplayerspokemon;
        private System.Windows.Forms.Button BTNmanageitem;
        private System.Windows.Forms.Button BTNmanageplayersitem;
        private System.Windows.Forms.Button BTNmanageattack;
    }
}