using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises.Exercise4_Classes
{
    public class SearchStart : Search
    {
        public sealed override bool SearchString(string Text)
        {
            return this.Text.StartsWith(Text);
        }
    }
}
