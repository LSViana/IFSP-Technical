using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NETFrameworkIntro
{
    public partial class UI : Form
    {
        public UI()
        {
            InitializeComponent();
            var a = 233.23;
            Text = String.Format("{0:C}", a);
        }
    }
}
