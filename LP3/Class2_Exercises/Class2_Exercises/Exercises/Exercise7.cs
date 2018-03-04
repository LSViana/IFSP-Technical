using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise7 : IExercise
    {
        private const int peopleAmount = 10;

        public void Run()
        {
            var names = new string[peopleAmount];
            //
            Console.WriteLine("Insert people's names:");
            for (int i = 0; i < peopleAmount; i++)
            {
                Console.Write($"\tName {i}: ");
                names[i] = Console.ReadLine();
            }
            //
            Console.Write("Insert name to filter: ");
            var filter = Console.ReadLine().ToLower();
            //
            var index = 0;
            while (index < peopleAmount - 1)
            {
                if(names[index++].ToLower().Contains(filter))
                {
                    index--;
                    break;
                }
            }
            if(index == names.Length)
            {
                Console.WriteLine("Any result found.");
            }
            else
            {
                Console.WriteLine($"Name found at index {index}.");
            }
        }
    }
}
