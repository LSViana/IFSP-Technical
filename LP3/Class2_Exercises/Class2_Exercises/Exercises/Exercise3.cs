using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise3 : IExercise
    {
        private const int peopleAmount = 10;

        public void Run()
        {
            var names = new string[peopleAmount];
            var ages = new byte[peopleAmount];
            var userInput = String.Empty;
            var mininumAge = (byte)0;
            //
            for (int i = 0; i < peopleAmount; i++)
            {
                Console.Write($"\tInsert name {i + 1}: ");
                names[i] = Console.ReadLine();
                do
                {
                    Console.Write($"\tInsert age {i + 1}: ");
                    userInput = Console.ReadLine();
                }
                while (!byte.TryParse(userInput, out ages[i]));
            }
            //
            do
            {
                Console.Write("\tInsert the mininum age: ");
                userInput = Console.ReadLine();
            }
            while (!byte.TryParse(userInput, out mininumAge));
            //
            for (int i = 0; i < peopleAmount; i++)
            {
                if (ages[i] >= mininumAge)
                {
                    Console.WriteLine($"\tName: {names[i]} | Age: {ages[i]}");
                }
            }
        }
    }
}
