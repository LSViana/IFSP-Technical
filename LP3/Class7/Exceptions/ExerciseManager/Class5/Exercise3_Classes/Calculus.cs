using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise3_Classes
{
    public class Calculus
    {
        public double Calculate(double value)
        {
            return Math.Sqrt(value);
        }

        public double Calculate(double @base, double exponent)
        {
            return Math.Pow(@base, exponent);
        }

        public double Calculate(int value)
        {
            if (value <= 0)
                return 1d;
            //
            var result = 1d;
            //
            for (int i = 2; i <= value; i++)
            {
                result *= i;
            }
            //
            return result;
        }

    }
}
