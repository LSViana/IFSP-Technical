using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise4 : IExercise
    {
        private const int peopleAmount = 10;

        public void Run()
        {
            var names = new string[peopleAmount];
            var userInput = String.Empty;
            //
            for (int i = 0; i < peopleAmount; i++)
            {
                Console.Write($"\tInsert name {i + 1}: ");
                names[i] = Console.ReadLine();
            }
            //
            foreach (var name in names)
            {
                Console.WriteLine($"\tName: {name}");
            }
        }
    }
}
