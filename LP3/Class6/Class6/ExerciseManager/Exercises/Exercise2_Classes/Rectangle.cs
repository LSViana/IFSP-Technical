﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise2_Classes
{
    public class Rectangle : Shape
    {
        public Rectangle(String Color, Int32 Sides, params Single[] Dimensions) : base(Color, Sides, Dimensions) { }
        public override float CalculateArea()
        {
            return Area = Dimensions[0] * Dimensions[1];
        }
    }
}
