using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise5 : IExercise
    {
        private const int exitOption = 0;
        private Option[] options = new Option[]
        {
            new Option("Insert Customer", 1),
            new Option("Edit Customer", 2),
            new Option("Delete Customer", 3),
            new Option("Exit", exitOption)
        };

        public void Run()
        {
            var userInput = String.Empty;
            var userOption = exitOption;
            //
            do
            {
                do
                {
                    ShowMenu();
                    userInput = Console.ReadLine();
                }
                while (!int.TryParse(userInput, out userOption));
                ProcessInput(userOption);
            }
            while (userOption != exitOption);
        }

        private void ProcessInput(int userOption)
        {
            if (userOption == exitOption)
                return;
            var option = options.FirstOrDefault(a => a.Number == userOption);
            if (option is null)
            {
                Console.WriteLine("\tInexistent option.");
            }
            else
            {
                Console.WriteLine($"\tOption: {option.Name}");
            }
        }

        private void ShowMenu()
        {
            Console.WriteLine("Welcome to LP3 Classes with C#");
            foreach (var option in options)
            {
                Console.WriteLine($"\t{option.Number} – {option.Name}");
            }
        }

        private class Option
        {
            public Option(string name, int option)
            {
                Name = name;
                Number = option;
            }

            public string Name { get; }
            public int Number { get; }
        }
    }
}
