using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Class7
{
    public partial class Start : Form
    {
        public Start()
        {
            InitializeComponent();
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            BackgroundPaint(e.Graphics);
        }

        private void BackgroundPaint(Graphics g)
        {
            g.FillRectangle(new LinearGradientBrush(PointF.Empty, new Point(ClientSize), Color.Orange, Color.OrangeRed), ClientRectangle);
        }
    }
}
