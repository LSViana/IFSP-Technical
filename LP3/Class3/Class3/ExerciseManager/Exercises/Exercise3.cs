using Class2_Exercises.Exercises;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager.Exercises
{
    public class Exercise3 : IExercise
    {
        private DateTime dt;

        public void Run()
        {
            Console.Write("Input a date: ");
            var userInput = Console.ReadLine();
            dt = DateTime.MinValue;
            if (DateTime.TryParse(userInput, out dt))
            {
                var actions = new Dictionary<String, Action>();
                actions["Add Days"] = AddDays;
                actions["Add Months"] = AddMonths;
                actions["Add Years"] = AddYears;
                actions["Subtract Days"] = SubtractDays;
                actions["Subtract Months"] = SubtractMonths;
                actions["Subtract Years"] = SubtractYears;
                actions["Get Day of Week"] = GetDayOfWeek;
                //
                var menu = new ConsoleMenu(
                    actions,
                    "Select one of the next options:",
                    "Verify your last action!",
                    "0");
                //
                menu.Run();
            }
            else
            {
                Console.WriteLine("You typed an invalid date.");
            }
        }

        private void GetDayOfWeek()
        {
            Console.WriteLine($"The day of week is: {dt.DayOfWeek}");
        }

        private void SubtractYears()
        {
            int value = Extensions.GetInt32("Enter the number of years to subtract: ");
            dt = dt.AddYears(-value);
            PrintDateTime();
        }

        private void PrintDateTime()
        {
            Console.WriteLine($"Current date: {dt}");
        }

        private void SubtractMonths()
        {
            int value = Extensions.GetInt32("Enter the number of months to subtract: ");
            dt = dt.AddMonths(-value);
            PrintDateTime();
        }

        private void SubtractDays()
        {
            int value = Extensions.GetInt32("Enter the number of days to subtract: ");
            dt = dt.AddDays(-value);
            PrintDateTime();
        }

        private void AddYears()
        {
            int value = Extensions.GetInt32("Enter the number of years to add: ");
            dt = dt.AddYears(value);
            PrintDateTime();
        }

        private void AddMonths()
        {
            int value = Extensions.GetInt32("Enter the number of months to add: ");
            dt = dt.AddMonths(value);
            PrintDateTime();
        }

        private void AddDays()
        {
            int value = Extensions.GetInt32("Enter the number of days to add: ");
            dt = dt.AddDays(value);
            PrintDateTime();
        }
    }
}
