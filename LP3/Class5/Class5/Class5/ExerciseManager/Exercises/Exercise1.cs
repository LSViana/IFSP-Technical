using Class2_Exercises.Exercises;
using Class3.ExerciseManager;
using Class5.ExerciseManager.Exercises.Exercise1_Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises
{
    public class Exercise1 : IExercise
    {
        private List<PhysicalPerson> PhysicalPeople = new List<PhysicalPerson>(10);
        private List<LegalPerson> LegalPeople = new List<LegalPerson>(10);

        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            //
            actions.Add("Insert Client", InsertClient);
            actions.Add("Remove Client", RemoveClient);
            actions.Add("Query Clients", QueryClients);
            //
            var menu = new ConsoleMenu(
                actions,
                "Select an option",
                "Invalid option selected",
                "0");
            //
            menu.Run();
        }

        private void QueryClients()
        {
            Console.WriteLine(">> Physical People: ");
            foreach (var person in PhysicalPeople)
            {
                POCOConsolePrinter.Print(person);
            }
            Console.WriteLine(">> Legal People: ");
            foreach (var person in LegalPeople)
            {
                POCOConsolePrinter.Print(person);
            }
        }

        private void RemoveClient()
        {
            var actions = new Dictionary<String, Action>();
            //
            actions.Add("Remove Physical Person", RemovePhysical);
            actions.Add("Remove Legal Person", RemoveLegal);
            //
            var menu = new ConsoleMenu(
                actions,
                "Choose the kind of person",
                "Invalid kind of person selected",
                "0"
                );
            menu.Run();
        }

        private void RemoveLegal()
        {
            var userInput = String.Empty;
            var value = 0L;
            do
            {
                Console.Write("Insert the Legal Person Code: ");
                userInput = Console.ReadLine();
            }
            while (!long.TryParse(userInput, out value));
            //
            var peopleIndex = LegalPeople.FindIndex((person) => person.Code == value);
            if (peopleIndex == -1)
            {
                // Not found
                Console.WriteLine("Legal Person not found"); ;
            }
            else
            {
                Console.WriteLine(String.Format("Legal Person {0} successfully removed", LegalPeople[peopleIndex].SocialReason));
                LegalPeople[peopleIndex] = null;
            }
        }

        private void RemovePhysical()
        {
            var userInput = String.Empty;
            var value = 0L;
            do
            {
                Console.Write("Insert the Physical Person Code: ");
                userInput = Console.ReadLine();
            }
            while (!long.TryParse(userInput, out value));
            //
            var peopleIndex = PhysicalPeople.FindIndex((person) => person.Code == value);
            if (peopleIndex == -1)
            {
                // Not found
                Console.WriteLine("Physical Person not found"); ;
            }
            else
            {
                Console.WriteLine(String.Format("Physical Person {0} successfully removed", PhysicalPeople[peopleIndex].Name));
                PhysicalPeople[peopleIndex] = null;
            }
        }

        private void InsertClient()
        {
            var actions = new Dictionary<String, Action>();
            //
            actions.Add("Insert Physical Person", InsertPhysical);
            actions.Add("Insert Legal Person", InsertLegal);
            //
            var menu = new ConsoleMenu(
                actions,
                "Choose the kind of person",
                "Invalid kind of person selected",
                "0"
                );
            menu.Run();
        }

        private void InsertLegal()
        {
            var legalPerson = POCOConsoleCreator.Generate<LegalPerson>();
            LegalPeople.Add(legalPerson);
            //
            Console.WriteLine();
        }

        private void InsertPhysical()
        {
            var physicalPerson = POCOConsoleCreator.Generate<PhysicalPerson>();
            PhysicalPeople.Add(physicalPerson);
            //
            Console.WriteLine();
        }
    }
}
