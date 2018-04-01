using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise4_Classes
{
    public class SearchStart : Search
    {
        public sealed override bool Searchstring(string Text)
        {
            return this.Text.StartsWith(Text);
        }
    }
}
