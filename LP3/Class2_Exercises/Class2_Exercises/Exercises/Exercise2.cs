using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class Exercise2 : IExercise
    {
        public void Run()
        {
            var months = new String[]
            {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December",
            };
            Console.Write("\tType month name: ");
            var monthName = Console.ReadLine();
            var month = months
                .Select((a, b) => new { Month = a, Index = b })
                .FirstOrDefault(a => a.Month.Equals(monthName, StringComparison.InvariantCultureIgnoreCase));
            if(month is null)
            {
                Console.WriteLine($"Month not found");
            }
            else
            {
                var season = GetSeason(month.Index);
                Console.WriteLine($"Predominating season at {month.Month}: {season}");
            }
        }

        private String GetSeason(int index)
        {
            if (index < 3)
                return "Summer";
            else if (index < 6)
                return "Autumn";
            else if (index < 9)
                return "Winter";
            else
                return "Spring";
        }
    }
}
