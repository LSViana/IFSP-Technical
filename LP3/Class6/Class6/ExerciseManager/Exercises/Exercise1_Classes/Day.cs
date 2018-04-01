using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise1_Classes
{
    public class Day : Time
    {
        public Day(TimeSpan Interval) : base(Interval) { }
        public override void CalculateInterval()
        {
            var days = Interval.TotalDays;
            Console.WriteLine("Time Interval: " + days + " " + (days > 1 ? "days" : "day" ));
        }
    }
}
