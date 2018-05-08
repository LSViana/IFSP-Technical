using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalculate_Click(object sender, EventArgs e)
        {
            var value1 = 0d;
            var value2 = 0d;
            var result = 0d;
            //
            if(Double.TryParse(txtValue1.Text, out value1))
            {
                if(Double.TryParse(txtValue2.Text, out value2))
                {
                    if(cbOperations.SelectedItem is String operationText)
                    {
                        switch (operationText)
                        {
                            case "+":
                                result = value1 + value2;
                                break;
                            case "-":
                                result = value1 - value2;
                                break;
                            case "/":
                                result = value1 / value2;
                                break;
                            case "*":
                                result = value1 * value2;
                                break;
                            case "%":
                                result = value1 % value2;
                                break;
                            default:
                                Message("Invalid operation");
                                return;
                        }
                        lbFinalResult.Text = result.ToString();
                    }
                    else
                    {
                        Message("Select a valid operation!");
                    }
                }
                else
                {
                    Message("Invalid value 2, try again!");
                }
            }
            else
            {
                Message("Invalid value 1, try again!");
            }
        }

        private void Message(string message, MessageBoxButtons buttons = MessageBoxButtons.OK, MessageBoxIcon icon = MessageBoxIcon.Information)
        {
            MessageBox.Show(message, "Calculator", buttons, icon);
        }
    }
}
