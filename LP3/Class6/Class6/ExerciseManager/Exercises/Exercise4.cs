using Class2_Exercises.Exercises;
using Class3.ExerciseManager;
using Class6.ExerciseManager.Exercises.Exercise2_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class6.ExerciseManager.Exercises
{
    public class Exercise4 : IExercise
    {
        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Rectangle"] = AddRectangle;
            actions["Circle"] = AddCircle;
            actions["Equilateral Triangle"] = AddEquilateralTriangle;
            //
            var menu = new ConsoleMenu(actions, "Select an option", "Invalid option selected", "0");
            menu.Run();
        }

        private String GetColor()
        {
            var userInput = String.Empty;
            //
            do
            {
                Console.Write("Insert the color name: ");
                userInput = Console.ReadLine();
            }
            while (String.IsNullOrWhiteSpace(userInput));
            return userInput;
        }

        private void AddEquilateralTriangle()
        {
            Console.WriteLine("Registering Equilateral Triangle\n");
            //
            var dimension = Extensions.GetSingle("Insert the size dimension: ");
            var color = GetColor();
            //
            var shape = new EquilateralTriangle(color, 3, dimension, dimension, dimension);
            Console.WriteLine(shape.ToString());
        }

        private void AddCircle()
        {
            Console.WriteLine("Registering Circle\n");
            //
            var radius = Extensions.GetSingle("Insert the radius dimension: ");
            var color = GetColor();
            //
            var shape = new Circle(color, 1, radius);
            Console.WriteLine(shape.ToString());
        }

        private void AddRectangle()
        {
            Console.WriteLine("Registering Rectangle\n");
            //
            var width = Extensions.GetSingle("Insert the width dimension: ");
            var height = Extensions.GetSingle("Insert the height dimension: ");
            var color = GetColor();
            //
            var shape = new Rectangle(color, 4, width, height, width, height);
            Console.WriteLine(shape.ToString());
        }
    }
}
