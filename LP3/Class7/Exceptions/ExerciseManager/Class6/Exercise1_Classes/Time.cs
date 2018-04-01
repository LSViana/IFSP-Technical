using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise1_Classes
{
    public abstract class Time
    {
        public TimeSpan Interval { get; set; }
        private Time()
        {
            // Not allowed default constructor
        }
        public Time(TimeSpan Interval)
        {
            this.Interval = Interval;
        }
        public abstract void CalculateInterval();
    }
}
