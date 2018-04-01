using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise4_Classes
{
    public class Search
    {
        public string Text { get; set; }

        public void SetText(string Text)
        {
            this.Text = Text;
        }

        public virtual bool Searchstring(string Text)
        {
            return this.Text.Contains(Text);
        }
    }
}
