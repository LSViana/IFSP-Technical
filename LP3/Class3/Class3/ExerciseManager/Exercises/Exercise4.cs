using Class2_Exercises.Exercises;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager.Exercises
{
    public class Exercise4 : IExercise
    {
        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Pattern 1"] = Pattern1;
            actions["Pattern 2"] = Pattern2;
            actions["Pattern 3"] = Pattern3;
            actions["Pattern 4"] = Pattern4;
            actions["Pattern 5"] = Pattern5;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select one of the next options:",
                "Verify your last action!",
                "0");
            //
            menu.Run();
        }

        private void Pattern5()
        {
            String pattern = "ddd, dd/MM/yyyy";
            var testValue = DateTime.MinValue;
            FormatDateTime(pattern, testValue);
        }

        private void Pattern4()
        {
            String pattern = "0.0%";
            var testValue = 1.278f;
            FormatSingle(pattern, testValue);
        }

        private void Pattern3()
        {
            String pattern = "0.000";
            var testValue = 5.6f;
            FormatSingle(pattern, testValue);
        }

        private void Pattern2()
        {
            String pattern = "0,000,000";
            var testValue = 2350000;
            FormatInt32(pattern, testValue);
        }

        private void Pattern1()
        {
            String pattern = "00000";
            var testValue = 257;
            FormatInt32(pattern, testValue);
        }

        private void FormatInt32(string pattern, int testValue)
        {
            var value = Extensions.GetInt32($"Insert a Int32 value to format like [{testValue} : {testValue.ToString(pattern)}]: ");
            Console.WriteLine($"Value '{value}' formatted is: {value.ToString(pattern)}");
        }

        private void FormatSingle(string pattern, Single testValue)
        {
            var value = Extensions.GetSingle($"Insert a Single value to format like [{testValue} : {testValue.ToString(pattern)}]: ");
            Console.WriteLine($"Value '{value}' formatted is: {value.ToString(pattern)}");
        }

        private void FormatDateTime(string pattern, DateTime testValue)
        {
            var value = Extensions.GetDateTime($"Insert a DateTime value to format like [{testValue} : {testValue.ToString(pattern)}]: ");
            Console.WriteLine($"Value '{value}' formatted is: {value.ToString(pattern)}");
        }
    }
}