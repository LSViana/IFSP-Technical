using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Class2_Exercises.Exercises
{
    public class ExerciseManager : IExercise
    {
        private Type[] types;

        public ExerciseManager(int ClassNumber)
        {
            this.ClassNumber = ClassNumber;
            InitializeExercises();
        }

        private void InitializeExercises()
        {
            var assembly = Assembly.GetExecutingAssembly();
            types = assembly
                .GetTypes()
                .Where(a =>
                a != typeof(ExerciseManager) &&
                !a.IsInterface &&
                typeof(IExercise).IsAssignableFrom(a))
                .ToArray();
        }

        public int ClassNumber { get; }

        public void Run()
        {
            Console.WriteLine($"Welcome to Class {ClassNumber} Exercise Manager [type 'exit' to leave]");
            String exercise;
            do
            {
                Console.Write("Insert exercise number: ");
                exercise = Console.ReadLine();
                var exerciseTitle = $"Exercise{exercise}";
                var type = types.FirstOrDefault(a => a.Name == exerciseTitle);
                if(type is null)
                {
                    Console.WriteLine($"Exercise not found, you can type 'exit' to leave.");
                }
                else
                {
                    Console.WriteLine($"Start of {exerciseTitle}");
                    var instance = Activator.CreateInstance(type) as IExercise;
                    instance.Run();
                    Console.WriteLine($"End of {exerciseTitle}");
                }
            }
            while (exercise != "exit");
        }
    }
}