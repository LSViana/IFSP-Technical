namespace TemperatureConverter
{
    partial class Form1
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
            this.label1 = new System.Windows.Forms.Label();
            this.txTemperature = new System.Windows.Forms.TextBox();
            this.gbOperations = new System.Windows.Forms.GroupBox();
            this.rbCtoF = new System.Windows.Forms.RadioButton();
            this.rbFtoC = new System.Windows.Forms.RadioButton();
            this.rbCtoK = new System.Windows.Forms.RadioButton();
            this.rbKtoC = new System.Windows.Forms.RadioButton();
            this.rbFtoK = new System.Windows.Forms.RadioButton();
            this.rbKtoF = new System.Windows.Forms.RadioButton();
            this.gbOperations.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(23, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(67, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Temperature";
            // 
            // txTemperature
            // 
            this.txTemperature.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txTemperature.Location = new System.Drawing.Point(96, 16);
            this.txTemperature.Name = "txTemperature";
            this.txTemperature.Size = new System.Drawing.Size(99, 20);
            this.txTemperature.TabIndex = 1;
            // 
            // gbOperations
            // 
            this.gbOperations.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.gbOperations.Controls.Add(this.rbKtoF);
            this.gbOperations.Controls.Add(this.rbFtoK);
            this.gbOperations.Controls.Add(this.rbKtoC);
            this.gbOperations.Controls.Add(this.rbCtoK);
            this.gbOperations.Controls.Add(this.rbFtoC);
            this.gbOperations.Controls.Add(this.rbCtoF);
            this.gbOperations.Location = new System.Drawing.Point(12, 42);
            this.gbOperations.Name = "gbOperations";
            this.gbOperations.Size = new System.Drawing.Size(194, 189);
            this.gbOperations.TabIndex = 2;
            this.gbOperations.TabStop = false;
            this.gbOperations.Text = "Operations";
            // 
            // rbCtoF
            // 
            this.rbCtoF.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbCtoF.AutoSize = true;
            this.rbCtoF.Location = new System.Drawing.Point(36, 39);
            this.rbCtoF.Name = "rbCtoF";
            this.rbCtoF.Size = new System.Drawing.Size(123, 17);
            this.rbCtoF.TabIndex = 0;
            this.rbCtoF.Tag = "C,F";
            this.rbCtoF.Text = "Celsius to Fahrenheit";
            this.rbCtoF.UseVisualStyleBackColor = true;
            // 
            // rbFtoC
            // 
            this.rbFtoC.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbFtoC.AutoSize = true;
            this.rbFtoC.Location = new System.Drawing.Point(36, 62);
            this.rbFtoC.Name = "rbFtoC";
            this.rbFtoC.Size = new System.Drawing.Size(123, 17);
            this.rbFtoC.TabIndex = 1;
            this.rbFtoC.TabStop = true;
            this.rbFtoC.Tag = "F,C";
            this.rbFtoC.Text = "Fahrenheit to Celsius";
            this.rbFtoC.UseVisualStyleBackColor = true;
            // 
            // rbCtoK
            // 
            this.rbCtoK.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbCtoK.AutoSize = true;
            this.rbCtoK.Location = new System.Drawing.Point(36, 85);
            this.rbCtoK.Name = "rbCtoK";
            this.rbCtoK.Size = new System.Drawing.Size(102, 17);
            this.rbCtoK.TabIndex = 1;
            this.rbCtoK.TabStop = true;
            this.rbCtoK.Tag = "C,K";
            this.rbCtoK.Text = "Celsius to Kelvin";
            this.rbCtoK.UseVisualStyleBackColor = true;
            // 
            // rbKtoC
            // 
            this.rbKtoC.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbKtoC.AutoSize = true;
            this.rbKtoC.Location = new System.Drawing.Point(36, 108);
            this.rbKtoC.Name = "rbKtoC";
            this.rbKtoC.Size = new System.Drawing.Size(102, 17);
            this.rbKtoC.TabIndex = 1;
            this.rbKtoC.TabStop = true;
            this.rbKtoC.Tag = "K,C";
            this.rbKtoC.Text = "Kelvin to Celsius";
            this.rbKtoC.UseVisualStyleBackColor = true;
            // 
            // rbFtoK
            // 
            this.rbFtoK.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbFtoK.AutoSize = true;
            this.rbFtoK.Location = new System.Drawing.Point(36, 131);
            this.rbFtoK.Name = "rbFtoK";
            this.rbFtoK.Size = new System.Drawing.Size(119, 17);
            this.rbFtoK.TabIndex = 1;
            this.rbFtoK.TabStop = true;
            this.rbFtoK.Tag = "F,K";
            this.rbFtoK.Text = "Fahrenheit to Kelvin";
            this.rbFtoK.UseVisualStyleBackColor = true;
            // 
            // rbKtoF
            // 
            this.rbKtoF.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbKtoF.AutoSize = true;
            this.rbKtoF.Location = new System.Drawing.Point(36, 154);
            this.rbKtoF.Name = "rbKtoF";
            this.rbKtoF.Size = new System.Drawing.Size(119, 17);
            this.rbKtoF.TabIndex = 1;
            this.rbKtoF.TabStop = true;
            this.rbKtoF.Tag = "K,F";
            this.rbKtoF.Text = "Kelvin to Fahrenheit";
            this.rbKtoF.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(218, 241);
            this.Controls.Add(this.gbOperations);
            this.Controls.Add(this.txTemperature);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.ShowIcon = false;
            this.Text = "Temperature Converter";
            this.Shown += new System.EventHandler(this.Form1_Shown);
            this.gbOperations.ResumeLayout(false);
            this.gbOperations.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txTemperature;
        private System.Windows.Forms.GroupBox gbOperations;
        private System.Windows.Forms.RadioButton rbCtoF;
        private System.Windows.Forms.RadioButton rbKtoF;
        private System.Windows.Forms.RadioButton rbFtoK;
        private System.Windows.Forms.RadioButton rbKtoC;
        private System.Windows.Forms.RadioButton rbCtoK;
        private System.Windows.Forms.RadioButton rbFtoC;
    }
}

