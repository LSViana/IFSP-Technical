using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager
{
    public static class Extensions
    {
        public static int GetInt32(string v)
        {
            var userInput = String.Empty;
            var value = 0;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
            }
            while (!int.TryParse(userInput, out value));
            return value;
        }

        public static float GetSingle(string v)
        {
            var userInput = String.Empty;
            var value = 0f;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
            }
            while (!float.TryParse(userInput, out value));
            return value;
        }

        public static double GetDouble(string v)
        {
            var userInput = String.Empty;
            var value = 0.0;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
            }
            while (!double.TryParse(userInput, out value));
            return value;
        }

        public static DateTime GetDateTime(string v)
        {
            var userInput = String.Empty;
            var value = DateTime.MinValue;
            do
            {
                Console.Write(v);
                userInput = Console.ReadLine();
            }
            while (!DateTime.TryParse(userInput, out value));
            return value;
        }
    }
}
