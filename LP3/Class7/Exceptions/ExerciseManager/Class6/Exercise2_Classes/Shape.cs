using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise2_Classes
{
    public abstract class Shape
    {
        private Shape()
        {
            // Not allowing default constructors
        }
        public Shape(string Color, Int32 Sides, params Single[] Dimensions)
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
        public abstract Single CalculateArea();
        public string Color { get; set; }
        public Single Area { get; set; }
        public Single[] Dimensions { get; set; }
        public int Sides { get; set; }
    }
}
