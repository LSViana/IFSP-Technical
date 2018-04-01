using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise4_Classes
{
    public interface Shape
    {
        Single CalculateArea();
        String Color { get; set; }
        Single Area { get; set; }
        Single[] Dimensions { get; set; }
        int Sides { get; set; }
    }
}
