using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise6 : IExercise
    {
        private const int peopleAmount = 2;

        public void Run()
        {
            var userData = new string[peopleAmount, 4];
            //
            Console.WriteLine("Insert user data:");
            for (int i = 0; i < peopleAmount; i++)
            {
                Console.Write($"{i + 1}\tName: ");
                userData[i, 0] = Console.ReadLine();
                Console.Write($"{i + 1}\tCPF: ");
                userData[i, 1] = Console.ReadLine();
                Console.Write($"{i + 1}\tE-mail: ");
                userData[i, 2] = Console.ReadLine();
                Console.Write($"{i + 1}\tTelephone: ");
                userData[i, 3] = Console.ReadLine();
            }
            //
            Console.WriteLine("Choose the search option [insert -1 to quit]: ");
            ShowSearchMenu();
            var userInput = String.Empty;
            var userOption = 0;
            do
            {
                do
                {
                    userInput = Console.ReadLine();
                }
                while (!int.TryParse(userInput, out userOption));
                //
                if (userOption == -1)
                {
                    return;
                }
                else if (userOption < 0 || userOption > userData.GetLength(1))
                {
                    Console.WriteLine("Invalid option to filter.");
                }
                else
                {
                    Console.Write("\tInsert filter: ");
                    var filter = Console.ReadLine().ToLower();
                    //
                    for (int i = 0; i < peopleAmount; i++)
                    {
                        if(userData[i, userOption - 1].ToLower().Contains(filter))
                        {
                            Console.WriteLine($"[{i + 1}] {userData[i, 0]}");
                            Console.WriteLine($"[{i + 1}] {userData[i, 1]}");
                            Console.WriteLine($"[{i + 1}] {userData[i, 2]}");
                            Console.WriteLine($"[{i + 1}] {userData[i, 3]}");
                        }
                    }
                }
            }
            while (userOption != -1);
        }

        private void ShowSearchMenu()
        {
            Console.WriteLine("\t1 - Name");
            Console.WriteLine("\t2 - CPF");
            Console.WriteLine("\t3 - E-mail");
            Console.WriteLine("\t4 - Telephone");
        }
    }
}
