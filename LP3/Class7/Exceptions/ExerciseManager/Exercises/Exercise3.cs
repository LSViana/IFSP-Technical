using Class2_Exercises.Exercises;
using Class3.ExerciseManager;
using Class6.ExerciseManager.Exercises.Exercise3_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises
{
    public class Exercise3 : IExercise
    {
        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Calculate days"] = CalculateDateDays;
            actions["Calculate hours"] = CalculateDateHours;
            //
            var menu = new ConsoleMenu(actions, "Select an option", "Invalid option selected", "0");
            menu.Run();
        }

        private DateTime GetDateTime(String momentName)
        {
            var userInput = String.Empty;
            DateTime result;
            do
            {
                Console.Write("Insert the " + momentName + " date and time [dd/MM/yy hh:mm]: ");
                userInput = Console.ReadLine();
            }
            while (!DateTime.TryParse(userInput, out result));
            return result;
        }

        private void CalculateDateHours()
        {
            var start = GetDateTime("start");
            var end = GetDateTime("end");
            //
            var time = new Hour(end - start);
            time.CalculateInterval();
        }

        private void CalculateDateDays()
        {
            var start = GetDateTime("start");
            var end = GetDateTime("end");
            //
            var time = new Day(end - start);
            time.CalculateInterval();
        }
    }
}
