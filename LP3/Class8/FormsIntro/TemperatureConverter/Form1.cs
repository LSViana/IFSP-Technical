using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TemperatureConverter
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public RadioButton[] RadioOperations { get; private set; }

        private void Form1_Shown(object sender, EventArgs e)
        {
            RadioOperations = new RadioButton[] { rbCtoF, rbCtoK, rbFtoC, rbFtoK, rbKtoC, rbKtoF };
            //
            foreach (var rb in RadioOperations)
            {
                rb.CheckedChanged += (obj, ev) =>
                {
                    if (rb.Checked)
                    {
                        Double? result = null;
                        var temperature = 0d;
                        // Getting Temperature
                        if (!Double.TryParse(txTemperature.Text, out temperature))
                        {
                            MessageBox.Show("Invalid temperature value!");
                        }
                        else
                        {
                            var operations = rb.Tag.ToString().Split(',');
                            if (operations[0] == "F")
                            {
                                if (operations[1] == "C")
                                {
                                    result = (temperature - 32) / 1.8;
                                }
                                else if (operations[1] == "K")
                                {
                                    result = (temperature + 459.67) / 1.8;
                                }
                            }
                            else if (operations[0] == "C")
                            {
                                if (operations[1] == "F")
                                {
                                    result = temperature * 1.8 + 32;
                                }
                                else if (operations[1] == "K")
                                {
                                    result = temperature + 273.15;
                                }
                            }
                            else if (operations[0] == "K")
                            {
                                if (operations[1] == "C")
                                {
                                    result = temperature - 273.15;
                                }
                                else if (operations[1] == "F")
                                {
                                    result = temperature * 1.8 - 459.67;
                                }
                            }
                            //
                            MessageBox.Show($"Result: {result}{operations[1]}", "Temperature Converter", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        }
                    }
                    //
                    foreach (var _rb in RadioOperations)
                    {
                        _rb.Checked = false;
                    }
                };
            }
        }
    }
}
