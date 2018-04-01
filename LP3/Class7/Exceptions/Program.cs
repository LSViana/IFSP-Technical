using Exceptions.ExerciseManager;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            var actions = new Dictionary<string, Action>();
            //
            actions["Class 4"] = Class4;
            actions["Class 5"] = Class5;
            actions["Class 6"] = Class6;
            //
            var menu = new ConsoleMenu(actions, "Select an option", "Invalid option selected", "0");
            menu.Run();
        }

        private static void Class6()
        {
            Exceptions.Class6.Program.Run(null);
        }

        private static void Class5()
        {
            Exceptions.Class5.Program.Run(null);
        }

        private static void Class4()
        {
            var actions = new Dictionary<string, Action>();
            //
            actions["Exercise 1"] = Exercise4_1;
            actions["Exercise 2"] = Exercise4_4;
            //
            var menu = new ConsoleMenu(actions, "Select an option", "Invalid option selected", "0");
            menu.Run();
        }

        private static void Exercise4_4()
        {
            Exceptions.Class4.Inicio4.Run();
        }

        private static void Exercise4_1()
        {
            Exceptions.Class4.Inicio1.Run();
        }
    }
}