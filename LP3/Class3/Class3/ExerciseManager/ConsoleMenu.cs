using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager
{
    public class ConsoleMenu
    {
        public Dictionary<String, Action> Actions { get; set; }
        public String ErrorMessage { get; set; }
        public string LeaveCommand { get; set; }
        public string HeaderMessage { get; set; }

        public ConsoleMenu(Dictionary<String, Action> Actions, String HeaderMessage, String ErrorMessage, String LeaveCommand)
        {
            this.Actions = Actions;
            this.ErrorMessage = ErrorMessage;
            this.LeaveCommand = LeaveCommand;
            this.HeaderMessage = HeaderMessage;
        }

        public void Run()
        {
            String userInput;
            //
            do
            {
                PrintMenu();
                userInput = Console.ReadLine();
                var option = 0;
                //
                if (userInput == LeaveCommand)
                {
                    // Just skip the tests
                }
                else if (int.TryParse(userInput, out option))
                {
                    if (option > Actions.Count)
                    {
                        Console.WriteLine(ErrorMessage);
                    }
                    else
                    {
                        var kvp = Actions.ElementAt(option - 1);
                        if (kvp.Value != null)
                            kvp.Value.Invoke();
                    }
                }
                else
                {
                    Console.WriteLine(ErrorMessage);
                }
            }
            while (userInput != LeaveCommand);
        }

        private void PrintMenu()
        {
            Console.WriteLine(HeaderMessage + " [Type '" + LeaveCommand + "' to exit]");
            var index = 1;
            foreach (var kvp in Actions)
            {
                Console.WriteLine(String.Format("\t{0} – {1}", index++, kvp.Key));
            }
        }
    }
}
