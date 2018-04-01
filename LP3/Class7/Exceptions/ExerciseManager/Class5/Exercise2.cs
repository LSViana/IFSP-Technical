using Exceptions.Exercises;
using Exceptions.ExerciseManager.Exercises.Exercise2_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Class5
{
    public class Exercise2 : IExercise
    {
        public void Run()
        {
            var sale1 = new Sale();
            var sale2 = new Sale();
            // Sum to Static Property
            GetSaleFromMonths(sale1, 3, true);
            GetSaleFromMonths(sale2, 3, true);
            // Sum to Dynamic Property
            GetSaleFromMonths(sale1, 3, false);
            GetSaleFromMonths(sale2, 3, false);
        }

        private void GetSaleFromMonths(Sale sale, int monthAmount, bool useStatic = true)
        {
            if (monthAmount < 0)
                return;
            //
            Console.WriteLine("\tCalculating " + (useStatic ? "static" : "dynamic") + " sale's revenue for " + monthAmount + " " + (monthAmount > 1 ? "months" : "month"));
            var userInput = string.Empty;
            var value = 0f;
            var result = false;
            for (int i = 0; i < monthAmount; i++)
            {
                do
                {
                    Console.Write("Total from month " + (i + 1) + ": ");
                    userInput = Console.ReadLine();
                    result = float.TryParse(userInput, out value);
                    if(!result)
                    {
                        throw new FormatException("The value inserted isn't a valid float");
                    }
                }
                while (!result);
                if (useStatic)
                    Sale.StaticTotal += value;
                else
                    sale.Total += value;
            }
            // Printing total
            Console.WriteLine("Total calculated " + (useStatic ? "statically" : "dinamically") + ": " + (useStatic ? Sale.StaticTotal : sale.Total));
        }
    }
}