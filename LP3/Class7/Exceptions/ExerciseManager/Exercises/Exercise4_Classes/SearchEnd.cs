using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises.Exercise4_Classes
{
    public class SearchEnd : Search
    {
        public sealed override bool SearchString(string Text)
        {
            return this.Text.EndsWith(Text);
        }
    }
}
