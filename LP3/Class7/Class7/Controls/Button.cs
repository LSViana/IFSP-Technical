using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Class7.Controls
{
    public class Button : System.Windows.Forms.Button
    {
        private float borderRadius;
        private GraphicsPath bgPath;

        public Button() : base()
        {
            BorderRadius = 0;
        }

        [Browsable(true)]
        [Category("Appearance")]
        public float BorderRadius
        {
            get
            {
                return borderRadius;
            }
            set
            {
                this.borderRadius = value;
                SetBorderRadius();
                Invalidate();
            }
        }

        private void SetBorderRadius()
        {
            bgPath = new GraphicsPath();
            var width = (int)(ClientRectangle.Width * (1 - borderRadius));
            var height = (int)(ClientRectangle.Height * (1 - borderRadius));
            bgPath.AddRectangle(new Rectangle((ClientRectangle.Width - width) / 2, 0, width, ClientRectangle.Height));
            bgPath.AddRectangle(new Rectangle(0, (ClientRectangle.Height - height) / 2, height, ClientRectangle.Width));
            //
            Region = new Region(bgPath);
        }

        protected override void OnPaint(PaintEventArgs pevent)
        {
            DrawBackground(pevent.Graphics);
        }

        private void DrawBackground(Graphics g)
        {
            if (bgPath == null)
                SetBorderRadius();
            g.FillPath(new SolidBrush(BackColor), bgPath);
        }
    }
}
