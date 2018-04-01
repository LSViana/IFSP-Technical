using Exceptions.Exercises;
using Exceptions.ExerciseManager;
using Exceptions.ExerciseManager.Exercises.Exercise1_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Class6
{
    public class Exercise1 : IExercise
    {
        public void Run()
        {
            var actions = new Dictionary<string, Action>();
            actions["Calculate days"] = CalculateDateDays;
            actions["Calculate hours"] = CalculateDateHours;
            //
            var menu = new ConsoleMenu(actions, "Select an option", "Invalid option selected", "0");
            menu.Run();
        }

        private DateTime GetDateTime(string momentName)
        {
            var userInput = string.Empty;
            DateTime result;
            var conversionResult = false;
            do
            {
                Console.Write("Insert the " + momentName + " date and time [dd/MM/yy hh:mm]: ");
                userInput = Console.ReadLine();
                conversionResult = DateTime.TryParse(userInput, out result);
                if(!conversionResult)
                {
                    throw new FormatException("Inserted a valid DateTime");
                }
            }
            while (!conversionResult);
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
