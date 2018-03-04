using Class2_Exercises.Exercises;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class3.ExerciseManager.Exercises
{
    public class Exercise2 : IExercise
    {
        private static String Text = "Uma ideia traz outra; o boticário imaginou que, uma vez preso o alienista, viriam também buscá-lo a ele, na qualidade de cúmplice. Esta ideia foi o melhor dos vesicatórios. Crispim Soares ergueu-se, disse que estava bom, que ia sair; e apesar de todos os esforços e protestos da consorte vestiu-se e saiu. Os velhos cronistas são unânimes em dizer que a certeza de que o marido ia colocar-se nobremente ao lado do alienista consolou grandemente a esposa do boticário; e notam com muita perspicácia, o imenso poder moral de uma ilusão; porquanto, o boticário caminhou resolutamente ao palácio do governo, não à casa do alienista. Ali chegando, mostrou-se admirado de não ver o barbeiro, a quem ia apresentar os seus protestos de adesão, não o tendo feito desde a véspera por enfermo. E tossia com algum custo. Os altos funcionários que lhe ouviam esta declaração, sabedores da intimidade do boticário com o alienista, compreenderam toda a importância da adesão nova e trataram a Crispim Soares com apurado carinho; afirmaram-lhe que o barbeiro não tardava; Sua Senhoria tinha ido à Casa Verde, a negócio importante, mas não tardava. Deram-lhe cadeira, refrescos, elogios; disseram-lhe que a causa do ilustre Porfírio era a de todos os patriotas; ao que o boticário ia repetindo que sim, que nunca pensara outra coisa, que isso mesmo mandaria declarar a Sua Majestade.";

        public void Run()
        {
            var actions = new Dictionary<String, Action>();
            actions["Replace \"alienista\" por psiquiatra"] = ReplaceAlienista;
            actions["Return if text contains \"vila\", \"custo\" and \"receio\""] = VerifyWords;
            actions["Return how many times \"não\" appears on text"] = CountingWords;
            actions["How many characters there are in the text"] = CountingCharacters;
            actions["How many white spaces there are in the text"] = CountingWhitespaces;
            //
            var menu = new ConsoleMenu(
                actions,
                "Select one of the next options:",
                "Verify your last action!",
                "0");
            //
            menu.Run();
        }

        private void CountingWhitespaces()
        {
            var word = " ";
            var occurrences = 0;
            var lastIndex = 0;
            //
            while ((lastIndex = Text.IndexOf(word, lastIndex + 1)) != -1 && (lastIndex < Text.Length))
            {
                occurrences++;
            }
            //
            Console.WriteLine("There are " + occurrences + " '" + word + "' occurrences");
        }

        private void CountingCharacters()
        {
            Console.WriteLine("Text contains " + Text.Length + " characters");
        }

        private void CountingWords()
        {
            var word = "não";
            var occurrences = 0;
            var lastIndex = 0;
            //
            while ((lastIndex = Text.IndexOf(word, lastIndex + 1)) != -1 && (lastIndex < Text.Length))
            {
                occurrences++;
            }
            //
            Console.WriteLine("There are " + occurrences + " '" + word + "' occurrences");
        }

        private void VerifyWords()
        {
            Console.WriteLine("Text contains \"vila\", \"custo\" and \"receio\": " +
                (Text.Contains("vila") && Text.Contains("custo") && Text.Contains("receio")));
        }

        private void ReplaceAlienista()
        {
            Console.WriteLine("Fresh Text: \n");
            Console.WriteLine(Text.Replace("alienista", "psiquiatra"));
        }
    }
}
