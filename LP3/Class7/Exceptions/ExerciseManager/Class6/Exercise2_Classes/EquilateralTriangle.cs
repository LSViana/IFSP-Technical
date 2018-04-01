using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise2_Classes
{
    public class EquilateralTriangle : Shape
    {
        public EquilateralTriangle(string Color, Int32 Sides, params Single[] Dimensions) : base(Color, Sides, Dimensions) { }
        public override float CalculateArea()
        {
            return Area = Dimensions[0] * Dimensions[1] * (Single)Math.Sin(Math.PI / 3) / 2;
        }
    }
}
