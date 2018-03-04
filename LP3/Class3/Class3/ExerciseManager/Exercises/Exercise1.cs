using Class2_Exercises.Exercises;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager.Exercises
{
    public class Exercise1 : IExercise
    {
        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Round Number"] = RoundNumber;
            actions["Square Root"] = SquareRootNumber;
            actions["Power"] = PowerNumber;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select one of the next options:",
                "Verify your last action!",
                "0");
            //
            menu.Run();
        }

        private void PowerNumber()
        {
            var userInput = String.Empty;
            //
            Console.WriteLine("Insert a number to be the base: ");
            decimal @base = 0m;
            do
            {
                userInput = Console.ReadLine();
            }
            while (!decimal.TryParse(userInput, out @base));
            Console.WriteLine("Insert a number to be the exponent: ");
            decimal exponent = 0m;
            do
            {
                userInput = Console.ReadLine();
            }
            while (!decimal.TryParse(userInput, out exponent));
            //
            Console.WriteLine(String.Format("Result: {0:F2}", Math.Pow((double)@base, (double)exponent)));
        }

        private void SquareRootNumber()
        {
            var userInput = String.Empty;
            //
            Console.WriteLine("Insert a number to be round: ");
            decimal value = 0m;
            do
            {
                do
                {
                    userInput = Console.ReadLine();
                }
                while (!decimal.TryParse(userInput, out value));
                //
                if (value < 0m)
                {
                    Console.WriteLine("You must insert a positive value.");
                }
            }
            while (value < 0m);
            //
            Console.WriteLine(String.Format("Square Root: {0:F10}", Math.Sqrt((double)value)));
        }

        private void RoundNumber()
        {
            var userInput = String.Empty;
            //
            Console.WriteLine("Insert a number to be round: ");
            decimal value = 0m;
            do
            {
                userInput = Console.ReadLine();
            }
            while (!decimal.TryParse(userInput, out value));
            Console.WriteLine("Insert a number to define how many decimal digits: ");
            decimal digits = 0m;
            do
            {
                userInput = Console.ReadLine();
            }
            while (!decimal.TryParse(userInput, out digits));
            String numberMask = "0";
            for (int i = 0; i < digits; i++)
            {
                if (i == 0)
                {
                    numberMask += ".";
                }
                numberMask += "0";
            }
            //
            Console.WriteLine(String.Format("Result: {0:" + numberMask + "}", value));
        }
    }
}
