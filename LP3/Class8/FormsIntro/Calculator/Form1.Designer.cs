namespace Calculator
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
            this.lbFirstValue = new System.Windows.Forms.Label();
            this.lbSecondValue = new System.Windows.Forms.Label();
            this.txtValue1 = new System.Windows.Forms.TextBox();
            this.txtValue2 = new System.Windows.Forms.TextBox();
            this.lbOperation = new System.Windows.Forms.Label();
            this.cbOperations = new System.Windows.Forms.ComboBox();
            this.lbResult = new System.Windows.Forms.Label();
            this.lbFinalResult = new System.Windows.Forms.Label();
            this.btnCalculate = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lbFirstValue
            // 
            this.lbFirstValue.AutoSize = true;
            this.lbFirstValue.Location = new System.Drawing.Point(12, 15);
            this.lbFirstValue.Name = "lbFirstValue";
            this.lbFirstValue.Size = new System.Drawing.Size(59, 13);
            this.lbFirstValue.TabIndex = 0;
            this.lbFirstValue.Text = "First Value:";
            // 
            // lbSecondValue
            // 
            this.lbSecondValue.AutoSize = true;
            this.lbSecondValue.Location = new System.Drawing.Point(12, 50);
            this.lbSecondValue.Name = "lbSecondValue";
            this.lbSecondValue.Size = new System.Drawing.Size(77, 13);
            this.lbSecondValue.TabIndex = 2;
            this.lbSecondValue.Text = "Second Value:";
            // 
            // txtValue1
            // 
            this.txtValue1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtValue1.Location = new System.Drawing.Point(98, 12);
            this.txtValue1.Name = "txtValue1";
            this.txtValue1.Size = new System.Drawing.Size(143, 20);
            this.txtValue1.TabIndex = 1;
            // 
            // txtValue2
            // 
            this.txtValue2.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtValue2.Location = new System.Drawing.Point(98, 47);
            this.txtValue2.Name = "txtValue2";
            this.txtValue2.Size = new System.Drawing.Size(143, 20);
            this.txtValue2.TabIndex = 3;
            // 
            // lbOperation
            // 
            this.lbOperation.AutoSize = true;
            this.lbOperation.Location = new System.Drawing.Point(12, 85);
            this.lbOperation.Name = "lbOperation";
            this.lbOperation.Size = new System.Drawing.Size(56, 13);
            this.lbOperation.TabIndex = 4;
            this.lbOperation.Text = "Operation:";
            // 
            // cbOperations
            // 
            this.cbOperations.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.cbOperations.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbOperations.FormattingEnabled = true;
            this.cbOperations.Items.AddRange(new object[] {
            "+",
            "-",
            "/",
            "*",
            "%"});
            this.cbOperations.Location = new System.Drawing.Point(98, 82);
            this.cbOperations.Name = "cbOperations";
            this.cbOperations.Size = new System.Drawing.Size(143, 21);
            this.cbOperations.TabIndex = 5;
            // 
            // lbResult
            // 
            this.lbResult.AutoSize = true;
            this.lbResult.Location = new System.Drawing.Point(12, 120);
            this.lbResult.Name = "lbResult";
            this.lbResult.Size = new System.Drawing.Size(40, 13);
            this.lbResult.TabIndex = 6;
            this.lbResult.Text = "Result:";
            // 
            // lbFinalResult
            // 
            this.lbFinalResult.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lbFinalResult.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.lbFinalResult.Location = new System.Drawing.Point(95, 120);
            this.lbFinalResult.Name = "lbFinalResult";
            this.lbFinalResult.Size = new System.Drawing.Size(146, 63);
            this.lbFinalResult.TabIndex = 7;
            this.lbFinalResult.Text = "0";
            this.lbFinalResult.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // btnCalculate
            // 
            this.btnCalculate.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.btnCalculate.Location = new System.Drawing.Point(166, 186);
            this.btnCalculate.Name = "btnCalculate";
            this.btnCalculate.Size = new System.Drawing.Size(75, 23);
            this.btnCalculate.TabIndex = 8;
            this.btnCalculate.Text = "&Calculate";
            this.btnCalculate.UseVisualStyleBackColor = true;
            this.btnCalculate.Click += new System.EventHandler(this.btnCalculate_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(253, 221);
            this.Controls.Add(this.btnCalculate);
            this.Controls.Add(this.lbFinalResult);
            this.Controls.Add(this.lbResult);
            this.Controls.Add(this.cbOperations);
            this.Controls.Add(this.txtValue2);
            this.Controls.Add(this.txtValue1);
            this.Controls.Add(this.lbOperation);
            this.Controls.Add(this.lbSecondValue);
            this.Controls.Add(this.lbFirstValue);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.ShowIcon = false;
            this.Text = "Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbFirstValue;
        private System.Windows.Forms.Label lbSecondValue;
        private System.Windows.Forms.TextBox txtValue1;
        private System.Windows.Forms.TextBox txtValue2;
        private System.Windows.Forms.Label lbOperation;
        private System.Windows.Forms.ComboBox cbOperations;
        private System.Windows.Forms.Label lbResult;
        private System.Windows.Forms.Label lbFinalResult;
        private System.Windows.Forms.Button btnCalculate;
    }
}

