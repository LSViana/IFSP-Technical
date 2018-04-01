using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises.Exercise3_Classes
{
    public class Hour : Time
    {
        public TimeSpan Interval { get; set; }
        public Hour(TimeSpan Interval)
        {
            this.Interval = Interval;
        }
        public void CalculateInterval()
        {
            var hours = Interval.TotalHours;
            Console.WriteLine("Time Interval: " + hours + " " + (hours > 1 ? "hours" : "hour"));
        }
    }
}
