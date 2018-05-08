namespace DeliveryForm
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
            this.txProductValue = new System.Windows.Forms.TextBox();
            this.cbFidelityCustomer = new System.Windows.Forms.CheckBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cmbStates = new System.Windows.Forms.ComboBox();
            this.gbPostingKind = new System.Windows.Forms.GroupBox();
            this.rbSedex10 = new System.Windows.Forms.RadioButton();
            this.rbSedex = new System.Windows.Forms.RadioButton();
            this.btnCalculate = new System.Windows.Forms.Button();
            this.lblProductValue = new System.Windows.Forms.Label();
            this.lblFreightValue = new System.Windows.Forms.Label();
            this.lblTotalValue = new System.Windows.Forms.Label();
            this.lblProductValueResult = new System.Windows.Forms.Label();
            this.lblFreightValueResult = new System.Windows.Forms.Label();
            this.lblTotalValueResult = new System.Windows.Forms.Label();
            this.gbPostingKind.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(23, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(77, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Product Value:";
            // 
            // txProductValue
            // 
            this.txProductValue.Location = new System.Drawing.Point(106, 18);
            this.txProductValue.Name = "txProductValue";
            this.txProductValue.Size = new System.Drawing.Size(150, 20);
            this.txProductValue.TabIndex = 1;
            // 
            // cbFidelityCustomer
            // 
            this.cbFidelityCustomer.AutoSize = true;
            this.cbFidelityCustomer.Location = new System.Drawing.Point(26, 44);
            this.cbFidelityCustomer.Name = "cbFidelityCustomer";
            this.cbFidelityCustomer.Size = new System.Drawing.Size(105, 17);
            this.cbFidelityCustomer.TabIndex = 2;
            this.cbFidelityCustomer.Text = "Fidelity Customer";
            this.cbFidelityCustomer.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(23, 73);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(40, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Estado";
            // 
            // cmbStates
            // 
            this.cmbStates.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbStates.FormattingEnabled = true;
            this.cmbStates.Items.AddRange(new object[] {
            "SP",
            "RJ",
            "MG",
            "ES"});
            this.cmbStates.Location = new System.Drawing.Point(69, 70);
            this.cmbStates.Name = "cmbStates";
            this.cmbStates.Size = new System.Drawing.Size(62, 21);
            this.cmbStates.TabIndex = 4;
            // 
            // gbPostingKind
            // 
            this.gbPostingKind.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.gbPostingKind.Controls.Add(this.rbSedex10);
            this.gbPostingKind.Controls.Add(this.rbSedex);
            this.gbPostingKind.Location = new System.Drawing.Point(26, 97);
            this.gbPostingKind.Name = "gbPostingKind";
            this.gbPostingKind.Size = new System.Drawing.Size(200, 100);
            this.gbPostingKind.TabIndex = 5;
            this.gbPostingKind.TabStop = false;
            this.gbPostingKind.Text = "Posting Kind";
            // 
            // rbSedex10
            // 
            this.rbSedex10.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbSedex10.AutoSize = true;
            this.rbSedex10.Location = new System.Drawing.Point(70, 58);
            this.rbSedex10.Name = "rbSedex10";
            this.rbSedex10.Size = new System.Drawing.Size(76, 17);
            this.rbSedex10.TabIndex = 0;
            this.rbSedex10.Text = "SEDEX 10";
            this.rbSedex10.UseVisualStyleBackColor = true;
            // 
            // rbSedex
            // 
            this.rbSedex.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.rbSedex.AutoSize = true;
            this.rbSedex.Location = new System.Drawing.Point(70, 25);
            this.rbSedex.Name = "rbSedex";
            this.rbSedex.Size = new System.Drawing.Size(61, 17);
            this.rbSedex.TabIndex = 0;
            this.rbSedex.Text = "SEDEX";
            this.rbSedex.UseVisualStyleBackColor = true;
            // 
            // btnCalculate
            // 
            this.btnCalculate.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.btnCalculate.Location = new System.Drawing.Point(25, 203);
            this.btnCalculate.Name = "btnCalculate";
            this.btnCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnCalculate.TabIndex = 6;
            this.btnCalculate.Text = "&Calculate";
            this.btnCalculate.UseVisualStyleBackColor = true;
            this.btnCalculate.Click += new System.EventHandler(this.btnCalculate_Click);
            // 
            // lblProductValue
            // 
            this.lblProductValue.AutoSize = true;
            this.lblProductValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblProductValue.ForeColor = System.Drawing.Color.Blue;
            this.lblProductValue.Location = new System.Drawing.Point(276, 21);
            this.lblProductValue.Name = "lblProductValue";
            this.lblProductValue.Size = new System.Drawing.Size(91, 13);
            this.lblProductValue.TabIndex = 7;
            this.lblProductValue.Text = "Product Value:";
            // 
            // lblFreightValue
            // 
            this.lblFreightValue.AutoSize = true;
            this.lblFreightValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblFreightValue.ForeColor = System.Drawing.Color.Blue;
            this.lblFreightValue.Location = new System.Drawing.Point(276, 45);
            this.lblFreightValue.Name = "lblFreightValue";
            this.lblFreightValue.Size = new System.Drawing.Size(86, 13);
            this.lblFreightValue.TabIndex = 7;
            this.lblFreightValue.Text = "Freight Value:";
            // 
            // lblTotalValue
            // 
            this.lblTotalValue.AutoSize = true;
            this.lblTotalValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTotalValue.ForeColor = System.Drawing.Color.Blue;
            this.lblTotalValue.Location = new System.Drawing.Point(276, 69);
            this.lblTotalValue.Name = "lblTotalValue";
            this.lblTotalValue.Size = new System.Drawing.Size(76, 13);
            this.lblTotalValue.TabIndex = 7;
            this.lblTotalValue.Text = "Total Value:";
            // 
            // lblProductValueResult
            // 
            this.lblProductValueResult.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblProductValueResult.Location = new System.Drawing.Point(373, 21);
            this.lblProductValueResult.Name = "lblProductValueResult";
            this.lblProductValueResult.Size = new System.Drawing.Size(66, 13);
            this.lblProductValueResult.TabIndex = 8;
            this.lblProductValueResult.Text = "0";
            // 
            // lblFreightValueResult
            // 
            this.lblFreightValueResult.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblFreightValueResult.Location = new System.Drawing.Point(373, 45);
            this.lblFreightValueResult.Name = "lblFreightValueResult";
            this.lblFreightValueResult.Size = new System.Drawing.Size(66, 13);
            this.lblFreightValueResult.TabIndex = 8;
            this.lblFreightValueResult.Text = "0";
            // 
            // lblTotalValueResult
            // 
            this.lblTotalValueResult.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblTotalValueResult.Location = new System.Drawing.Point(373, 69);
            this.lblTotalValueResult.Name = "lblTotalValueResult";
            this.lblTotalValueResult.Size = new System.Drawing.Size(66, 13);
            this.lblTotalValueResult.TabIndex = 8;
            this.lblTotalValueResult.Text = "0";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(451, 247);
            this.Controls.Add(this.lblTotalValueResult);
            this.Controls.Add(this.lblFreightValueResult);
            this.Controls.Add(this.lblProductValueResult);
            this.Controls.Add(this.lblTotalValue);
            this.Controls.Add(this.lblFreightValue);
            this.Controls.Add(this.lblProductValue);
            this.Controls.Add(this.btnCalculate);
            this.Controls.Add(this.gbPostingKind);
            this.Controls.Add(this.cmbStates);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cbFidelityCustomer);
            this.Controls.Add(this.txProductValue);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.ShowIcon = false;
            this.Text = "Delivery Data";
            this.gbPostingKind.ResumeLayout(false);
            this.gbPostingKind.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txProductValue;
        private System.Windows.Forms.CheckBox cbFidelityCustomer;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cmbStates;
        private System.Windows.Forms.GroupBox gbPostingKind;
        private System.Windows.Forms.RadioButton rbSedex;
        private System.Windows.Forms.RadioButton rbSedex10;
        private System.Windows.Forms.Button btnCalculate;
        private System.Windows.Forms.Label lblProductValue;
        private System.Windows.Forms.Label lblFreightValue;
        private System.Windows.Forms.Label lblTotalValue;
        private System.Windows.Forms.Label lblProductValueResult;
        private System.Windows.Forms.Label lblFreightValueResult;
        private System.Windows.Forms.Label lblTotalValueResult;
    }
}

