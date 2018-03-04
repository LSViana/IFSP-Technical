using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise8 : IExercise
    {
        private const int peopleAmount = 10;

        public void Run()
        {
            var names = new string[peopleAmount];
            var heights = new float[peopleAmount];
            var userInput = String.Empty;
            var minimumHeight = 0f;
            //
            int i = 0;
            while(i < peopleAmount)
            {
                Console.Write($"\tInsert name {i + 1}: ");
                names[i] = Console.ReadLine();
                do
                {
                    Console.Write($"\tInsert height {i + 1}: ");
                    userInput = Console.ReadLine();
                }
                while (!float.TryParse(userInput, out heights[i]));
                i++;
            }
            //
            do
            {
                Console.Write("\tInsert the mininum height: ");
                userInput = Console.ReadLine();
            }
            while (!float.TryParse(userInput, out minimumHeight));
            //
            i = 0;
            while(i < peopleAmount)
            {
                if (heights[i] >= minimumHeight)
                {
                    Console.WriteLine($"\tName: {names[i]} | Age: {heights[i]}");
                }
                i++;
            }
        }
    }
}
