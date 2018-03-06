using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise1 : IExercise
    {
        public void Run()
        {
            Console.WriteLine("Insert 12 revenue values:");
            var month = 1;
            var revenues = new decimal[12];
            var userInput = String.Empty;
            do
            {
                do
                {
                    Console.Write($"\tMonth {month}: ");
                    userInput = Console.ReadLine();
                }
                while (!decimal.TryParse(userInput, out revenues[month - 1]));
                month++;
            }
            while (month <= 12);
            var totalRevenue = revenues.Sum();
            //
            var revenueStatus = String.Empty;
            if(totalRevenue <= 50000m)
            {
                revenueStatus = "LOW";
            }
            else if(totalRevenue <= 100000m)
            {
                revenueStatus = "MEDIUM";
            }
            else
            {
                revenueStatus = "HIGH";
            }
            Console.WriteLine($"Total Revenue Status: [{revenueStatus}]");
        }
    }
}
