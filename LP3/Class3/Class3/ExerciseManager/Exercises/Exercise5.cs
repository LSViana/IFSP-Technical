using Class2_Exercises.Exercises;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager.Exercises
{
    public class Exercise5 : IExercise
    {
        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Convert to Int32"] = ConvertInt32;
            actions["Convert to Single"] = ConvertSingle;
            actions["Convert to Double"] = ConvertDouble;
            actions["Convert to DateTime (date)"] = ConvertDate;
            actions["Convert to DateTime (time)"] = ConvertTime;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select one of the next options:",
                "Verify your last action!",
                "0");
            //
            menu.Run();
        }

        private void ConvertTime()
        {
            var value = Extensions.GetDateTime("Type DateTime (time) value: ");
            Console.WriteLine($"Value: {value.TimeOfDay}");
        }

        private void ConvertDate()
        {
            var value = Extensions.GetDateTime("Type DateTime (date) value: ");
            Console.WriteLine($"Value: {value.ToShortDateString()}");
        }

        private void ConvertDouble()
        {
            var value = Extensions.GetDouble("Type Double value: ");
            Console.WriteLine($"Value: {value}");
        }

        private void ConvertSingle()
        {
            var value = Extensions.GetSingle("Type Single value: ");
            Console.WriteLine($"Value: {value}");
        }

        private void ConvertInt32()
        {
            var value = Extensions.GetInt32("Type Int32 value: ");
            Console.WriteLine($"Value: {value}");
        }
    }
}
