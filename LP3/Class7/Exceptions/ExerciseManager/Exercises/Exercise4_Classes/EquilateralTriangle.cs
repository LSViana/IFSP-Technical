using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise4_Classes
{
    public class EquilateralTriangle : Shape
    {
        public EquilateralTriangle(String Color, Int32 Sides, params Single[] Dimensions)
        {
            this.Sides = Sides;
            if (Dimensions.Length != Sides)
            {
                throw new InvalidOperationException("Dimensions should have the same length as 'Sides'");
            }
            this.Color = Color;
            this.Dimensions = Dimensions;
            CalculateArea();
        }
        
        public float CalculateArea()
        {
            return Area = Dimensions[0] * Dimensions[1] * (Single)Math.Sin(Math.PI / 3) / 2;
        }

        public override string ToString()
        {
            var dimensions = "[";
            for (int i = 0; i < Dimensions.Length; i++)
            {
                dimensions += Dimensions[i];
                if (i != Dimensions.Length - 1)
                    dimensions += ", ";
            }
            dimensions += "]";
            return
                GetType().Name + " { Color : " + Color + ", Sides : " + Sides + ", Area : " + Area + ", Dimensions : " + dimensions + " }";
        }

        public string Color { get; set; }

        public float Area { get; set; }

        public float[] Dimensions { get; set; }

        public int Sides { get; set; }
    }
}
