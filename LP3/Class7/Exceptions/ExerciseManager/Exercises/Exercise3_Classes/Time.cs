using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise3_Classes
{
    public interface Time
    {
        TimeSpan Interval { get; set; }
        void CalculateInterval();
    }
}
