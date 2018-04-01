using Exceptions.ExerciseManager;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.Exercises
{
    public class Manager : IExercise
    {
        private Type[] types;
        private ConsoleMenu menu;
        private List<IExercise> instances;

        public Manager(int ClassNumber)
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
                a != typeof(Manager) &&
                !a.IsInterface &&
                typeof(IExercise).IsAssignableFrom(a))
                .OrderBy(a => a.Name)
                .ToArray();
            //
            var actions = new Dictionary<string, Action>();
            instances = new List<IExercise>();
            foreach (var type in types)
            {
                IExercise instance = Activator.CreateInstance(type) as IExercise;
                actions[type.Name] = instance.Run;
                instances.Add(instance);
            }
            menu = new ConsoleMenu(actions, "Insert exercise number: ", "Exercise not found, you can type 'exit' to leave.", "exit");
        }

        public int ClassNumber { get; private set; }

        public void Run()
        {
            #region Old implementation
            //Console.WriteLine("Welcome to Class " + ClassNumber + " Exercise Manager [type 'exit' to leave]");
            //string exercise;
            //do
            //{
            //    PrintMenu();
            //    Console.Write("Insert exercise number: ");
            //    exercise = Console.ReadLine();
            //    var exerciseTitle = "Exercise" + exercise;
            //    var type = types.FirstOrDefault(a => a.Name == exerciseTitle);
            //    if(type == null)
            //    {
            //        Console.WriteLine("Exercise not found, you can type 'exit' to leave.");
            //    }
            //    else
            //    {
            //        Console.WriteLine("Start of " + exerciseTitle);
            //        var instance = Activator.CreateInstance(type) as IExercise;
            //        instance.Run();
            //        Console.WriteLine("End of " + exerciseTitle);
            //    }
            //}
            //while (exercise != "exit"); 
            #endregion
            menu.Run();
        }
    }
}