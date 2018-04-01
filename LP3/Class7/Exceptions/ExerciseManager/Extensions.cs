using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager
{
    public static class Extensions
    {
        public static int GetInt32(string v)
        {
            var userInput = string.Empty;
            var value = 0;
            var result = false;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
                result = int.TryParse(userInput, out value);
                if (!result)
                {
                    throw new FormatException("The data inserted isn't a valid int");
                }
            }
            while (!result);
            return value;
        }

        public static float GetSingle(string v)
        {
            var userInput = string.Empty;
            var value = 0f;
            var result = false;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
                result = float.TryParse(userInput, out value);
                if (!result)
                {
                    throw new FormatException("The data inserted isn't a valid float");
                }
            }
            while (!result);
            return value;
        }

        public static double GetDouble(string v)
        {
            var userInput = string.Empty;
            var value = 0.0;
            var result = false;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
                result = double.TryParse(userInput, out value);
                if (!result)
                {
                    throw new FormatException("The data inserted isn't a valid double");
                }
            }
            while (!result);
            return value;
        }

        public static DateTime GetDateTime(string v)
        {
            var userInput = string.Empty;
            var value = DateTime.MinValue;
            var result = false;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
                result = DateTime.TryParse(userInput, out value);
                if(!result)
                {
                    throw new FormatException("The data inserted isn't a valid DateTime");
                }
            }
            while (!result);
            return value;
        }
    }
}
