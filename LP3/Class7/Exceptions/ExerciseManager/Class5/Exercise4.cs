using Exceptions.Exercises;
using Exceptions.ExerciseManager;
using Exceptions.ExerciseManager.Exercises.Exercise4_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Class5
{
    public class Exercise4 : IExercise
    {
        public Exercise4()
        {
            Search = new Search();
            SearchStart = new SearchStart();
            SearchEnd = new SearchEnd();
        }

        public Search Search { get; }
        public SearchStart SearchStart { get; }
        public SearchEnd SearchEnd { get; }

        public void Run()
        {
            var actions = new Dictionary<string, Action>();
            actions["Set Text"] = ReadText;
            actions["Search string"] = Searchstring;
            actions["Search string Start"] = SearchstringStart;
            actions["Search string End"] = SearchstringEnd;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select an option",
                "Invalid input",
                "0"
                );
            menu.Run();
        }

        private void SearchstringStart()
        {
            Console.WriteLine("\tSearching string at Start");
            var userInput = GetUserInput();
            Console.WriteLine("Result: " + (SearchStart.Searchstring(userInput)));
        }

        private void SearchstringEnd()
        {
            Console.WriteLine("\tSearching string at End");
            var userInput = GetUserInput();
            Console.WriteLine("Result: " + (SearchEnd.Searchstring(userInput)));
        }

        private void Searchstring()
        {
            Console.WriteLine("\tSearching string");
            var userInput = GetUserInput();
            Console.WriteLine("Result: " + (Search.Searchstring(userInput)));
        }

        private void ReadText()
        {
            var userInput = string.Empty;
            userInput = GetUserInput();
            SetText(userInput);
        }

        private static string GetUserInput()
        {
            Console.Write("Input a text: ");
            return Console.ReadLine();
        }

        private void SetText(string text)
        {
            SearchStart.Text = text;
            SearchEnd.Text = text;
            Search.Text = text;
        }
    }
}
