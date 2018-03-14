using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GraphicsHappiness.Material
{
    public partial class MaterialButton : Button
    {
        private SolidBrush backBrush;
        private SolidBrush foreBrush;
        private StringFormat sFormat;

        public MaterialButton()
        {
            InitializeComponent();
            backBrush = new SolidBrush(BackColor);
            foreBrush = new SolidBrush(ForeColor);
            sFormat = new StringFormat()
            {
                Alignment = StringAlignment.Center,
                LineAlignment = StringAlignment.Center
            };
        }

        public override ContentAlignment TextAlign
        {
            get
            {
                return base.TextAlign;
            }
            set
            {
                switch (value)
                {
                    case ContentAlignment.BottomCenter:
                    case ContentAlignment.BottomLeft:
                    case ContentAlignment.BottomRight:
                        sFormat.LineAlignment = StringAlignment.Far;
                        break;
                    case ContentAlignment.MiddleCenter:
                    case ContentAlignment.MiddleLeft:
                    case ContentAlignment.MiddleRight:
                        sFormat.LineAlignment = StringAlignment.Center;
                        break;
                    case ContentAlignment.TopCenter:
                    case ContentAlignment.TopLeft:
                    case ContentAlignment.TopRight:
                        sFormat.LineAlignment = StringAlignment.Near;
                        break;
                }
                switch (value)
                {
                    case ContentAlignment.BottomCenter:
                    case ContentAlignment.MiddleCenter:
                    case ContentAlignment.TopCenter:
                        sFormat.Alignment = StringAlignment.Center;
                        break;
                    case ContentAlignment.BottomLeft:
                    case ContentAlignment.MiddleLeft:
                    case ContentAlignment.TopLeft:
                        sFormat.Alignment = StringAlignment.Near;
                        break;
                    case ContentAlignment.BottomRight:
                    case ContentAlignment.MiddleRight:
                    case ContentAlignment.TopRight:
                        sFormat.Alignment = StringAlignment.Far;
                        break;
                }
                base.TextAlign = value;
            }
        }

        public override Color BackColor
        {
            get
            {
                return base.BackColor;
            }
            set
            {
                backBrush = new SolidBrush(value);
                base.BackColor = value;
            }
        }

        public override Color ForeColor
        {
            get
            {
                return base.ForeColor;
            }
            set
            {
                foreBrush = new SolidBrush(value);
                base.ForeColor = value;
            }
        }

        protected override void OnPaint(PaintEventArgs pe)
        {
            var g = pe.Graphics;
            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
            // Drawing Background
            DrawRoundedRectangle(g);
            // Drawing Text
            g.DrawString(Text, Font, foreBrush, new Rectangle(-1, -1, Bounds.Width + 1, Bounds.Height + 1), sFormat);
        }

        private void DrawRoundedRectangle(Graphics g)
        {
            BorderSize = 10;
            // Background
            g.FillRectangle(backBrush, BorderSize - 1, -1, Bounds.Width + 1 - 2 * BorderSize, Bounds.Height + 1);
            g.FillRectangle(backBrush, -1, BorderSize - 1, Bounds.Width + 1, Bounds.Height + 1 - 2 * BorderSize);
            // Borders
            g.FillEllipse(backBrush, 0, 0, BorderSize * 2, BorderSize * 2);
            g.FillEllipse(backBrush, -1 + Bounds.Width - 2 * BorderSize, 0, 2 * BorderSize, 2 * BorderSize);
            g.FillEllipse(backBrush, 0, -1 + Bounds.Height - 2 * BorderSize, 2 * BorderSize, 2 * BorderSize);
            g.FillEllipse(backBrush, -1 + Bounds.Width - 2 * BorderSize, -1 + Bounds.Height - 2 * BorderSize, 2 * BorderSize, 2 * BorderSize);
        }

        protected override void OnPaintBackground(PaintEventArgs pevent)
        {
            //base.OnPaintBackground(pevent);
        }

        private int borderSize;

        [Category("Appearance")]
        [Browsable(true)]
        public int BorderSize
        {
            get { return borderSize; }
            set { borderSize = value; if(Parent != null) Parent.Invalidate(Bounds); }
        }
        
    }
}
