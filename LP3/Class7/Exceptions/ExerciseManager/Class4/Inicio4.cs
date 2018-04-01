using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Exceptions.Class4
{
    public static class Inicio4
    {
        private static List<Cliente> clients;

        public static void Run()
        {
            string userInput = string.Empty;
            clients = new List<Cliente>();
            //
            var actions = new Dictionary<string, Action>();
            actions["1"] = InserirCliente;
            actions["2"] = ConsultarCliente;
            actions["3"] = ListarClientes;
            //
            do
            {
                try
                {
                    Console.WriteLine("Choose an option: ");
                    Console.WriteLine("\t1) Inserir Cliente");
                    Console.WriteLine("\t2) Consultar Cliente");
                    Console.WriteLine("\t3) Listar Clientes");
                    //
                    Console.Write("\tQual é a sua decisão? ");
                    userInput = Console.ReadLine();
                    //
                    Action action;
                    if (actions.TryGetValue(userInput, out action))
                    {
                        action.Invoke();
                    }
                    else
                    {
                        throw new InvalidOperationException("The option selected isn't right");
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
            while (userInput != "0");
        }

        private static void ListarClientes()
        {
            foreach (var client in clients)
            {
                Console.WriteLine(client.Describe());
            }
        }

        private static void ConsultarCliente()
        {
            Console.WriteLine("Consultando um cliente");
            //
            Console.Write("\nDigite o nome para filtrar: ");
            var filter = Console.ReadLine();
            var filtered = clients.Where(a => a.GetNome().ToLower().Contains(filter.ToLower()));
            //
            foreach (var client in filtered)
            {
                Console.WriteLine(client.Describe());
            }
        }

        private static void InserirCliente()
        {
            Console.WriteLine("\tInserindo um cliente");
            var c = new Cliente();
            do
            {
                try
                {
                    Console.Write("Nome: ");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
            while (!c.SetNome(Console.ReadLine()));
            do
            {
                try
                {
                    Console.Write("CPF: ");
                }
                catch (Exception e)
                {
                    Console.WriteLine(e.Message);
                }
            }
            while (!c.SetCPF(Console.ReadLine()));
            //
            clients.Add(c);
        }
    }

    public class Cliente
    {
        private static int codigoCounter = 0;
        private int codigo;
        private string nome;
        private string cpf;

        public Cliente() : this("Standard", "000.000.000-00") { }

        public Cliente(string nome, string cpf)
        {
            this.codigo = ++codigoCounter;
            this.nome = nome;
            this.cpf = cpf;
        }

        public int GetCodigo() { return codigo; }
        public string GetNome() { return nome; }
        public string GetCPF() { return cpf; }
        public void SetCodigo(int value) { this.codigo = value; }
        public bool SetNome(string value)
        {
            var result = value.Contains(' ');
            if (result)
            {
                this.nome = value;
            }
            else
            {
                throw new InvalidOperationException("\tInvalid name, it must contain spaces!");
            }
            return result;
        }
        public bool SetCPF(string value)
        {
            var result = value.Length == 11; if (result) { this.cpf = value; }
            else
            {
                throw new InvalidOperationException("\tInvalid CPF, it must contain only numbers and 11!");
            }
            return result;
        }

        public string Describe()
        {
            return $"{{ Código: {codigo}, Nome: {nome}, CPF: {cpf} }}";
        }
    }
}
