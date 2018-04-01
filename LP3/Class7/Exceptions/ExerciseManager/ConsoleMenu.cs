using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager
{
    public class ConsoleMenu
    {
        public Dictionary<string, Action> Actions { get; set; }
        public string ErrorMessage { get; set; }
        public string LeaveCommand { get; set; }
        public string HeaderMessage { get; set; }

        public ConsoleMenu(Dictionary<string, Action> Actions, string HeaderMessage, string ErrorMessage, string LeaveCommand)
        {
            this.Actions = Actions;
            this.ErrorMessage = ErrorMessage;
            this.LeaveCommand = LeaveCommand;
            this.HeaderMessage = HeaderMessage;
        }

        public void Run()
        {
            string userInput;
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
                        var kvp = Actions.ElementAtOrDefault(option - 1);
                        if (kvp.Value != null)
                            try
                            {
                                kvp.Value.Invoke();
                            }
                            catch (Exception e)
                            {
                                Console.WriteLine(e.Message);
                            }
                        else
                            RunErrorMessage();
                    }
                }
                else
                {
                    RunErrorMessage();
                }
            }
            while (userInput != LeaveCommand);
        }

        private void RunErrorMessage()
        {
            Console.WriteLine(ErrorMessage);
        }

        private void PrintMenu()
        {
            Console.WriteLine(HeaderMessage + " [Type '" + LeaveCommand + "' to exit]");
            var index = 1;
            foreach (var kvp in Actions)
            {
                Console.WriteLine(string.Format("\t{0} – {1}", index++, kvp.Key));
            }
        }
    }
}
