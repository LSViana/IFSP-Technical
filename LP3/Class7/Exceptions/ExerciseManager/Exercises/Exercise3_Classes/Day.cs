using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise3_Classes
{
    public class Day : Time
    {
        public TimeSpan Interval { get; set; }
        public Day(TimeSpan Interval)
        {
            this.Interval = Interval;
        }
        public void CalculateInterval()
        {
            var days = Interval.TotalDays;
            Console.WriteLine("Time Interval: " + days + " " + (days > 1 ? "days" : "day"));
        }
    }
}
