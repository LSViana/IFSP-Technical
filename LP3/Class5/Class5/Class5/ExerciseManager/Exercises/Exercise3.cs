using Class2_Exercises.Exercises;
using Class3.ExerciseManager;
using Class5.ExerciseManager.Exercises.Exercise3_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises
{
    public class Exercise3 : IExercise
    {
        public Calculus Calculus { get; set; }

        public Exercise3()
        {
            Calculus = new Calculus();
        }

        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Calculate square root"] = SquareRoot;
            actions["Calculate power"] = Power;
            actions["Factorial"] = Factorial;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select an option",
                "Invalid option selected",
                "0"
                );
            menu.Run();
        }

        private void Factorial()
        {
            var value = Extensions.GetInt32("Insert the value to calculate factorial: ");
            var result = Calculus.Calculate(value);
            //
            Console.WriteLine("Result: " + result);
        }

        private void Power()
        {
            var @base = Extensions.GetDouble("Insert the value to be the power's base: ");
            var exponent = Extensions.GetDouble("Insert the value to be the power's exponent: ");
            var result = Calculus.Calculate(@base, exponent);
            //
            Console.WriteLine("Result: " + result);
        }

        private void SquareRoot()
        {
            var value = Extensions.GetDouble("Insert the value to calculate square root: ");
            var result = Calculus.Calculate(value);
            //
            Console.WriteLine("Result: " + result);
        }
    }
}