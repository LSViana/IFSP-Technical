using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DeliveryForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalculate_Click(object sender, EventArgs e)
        {
            if(cmbStates.SelectedIndex == -1)
            {
                Message("You must select a valid State to continue!");
                return;
            }
            if(!rbSedex.Checked && !rbSedex10.Checked)
            {
                Message("You must select a valid freight system to continue!");
                return;
            }
            Double productValue = 0;
            if(String.IsNullOrWhiteSpace(txProductValue.Text) || !Double.TryParse(txProductValue.Text, out productValue))
            {
                Message("You must fill a valid value to Product Price!");
                return;
            }
            // Fidelity Customer
            if (cbFidelityCustomer.Checked)
                productValue *= .9;
            // Values
            Double freightValue = 0;
            Double totalValue = CalculateProductPrice(productValue, out freightValue);
            // Screen Handling
            lblProductValueResult.Text = String.Format("{0:C3}", productValue);
            lblFreightValueResult.Text = String.Format("{0:C3}", freightValue);
            lblTotalValueResult.Text = String.Format("{0:C3}", totalValue);
        }

        private double CalculateProductPrice(Double productPrice, out Double freightValue)
        {
            var result = productPrice;
            // State Calculus
            switch(cmbStates.Text)
            {
                case "SP":
                    freightValue = result * .1;
                    break;
                case "RJ":
                    freightValue = result * .15;
                    break;
                case "MG":
                    freightValue = result * .15;
                    break;
                case "ES":
                    freightValue = result * .2;
                    break;
                default:
                    Message("Internal Error, State Not Found");
                    return freightValue = - 1;
            }
            // Sedex 10
            if(rbSedex10.Checked)
            {
                freightValue *= 1.2;
            }
            return result + freightValue;
        }

        private void Message(string message, MessageBoxButtons buttons = MessageBoxButtons.OK, MessageBoxIcon icon = MessageBoxIcon.Information)
        {
            MessageBox.Show(message, "Product Price Calculator", buttons, icon);
        }
    }
}
