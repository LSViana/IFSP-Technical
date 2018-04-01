using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise1_Classes
{
    public class Hour : Time
    {
        public Hour(TimeSpan Interval) : base(Interval) { }
        public override void CalculateInterval()
        {
            var hours = Interval.TotalHours;
            Console.WriteLine("Time Interval: " + hours + " " + (hours > 1 ? "hours" : "hour"));
        }
    }
}
