using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.Class4
{
    public class Inicio1
    {
        public static void Run()
        {
            Produto p1 = new Produto(), p2 = new Produto();
            p1.SetCodigo(1);
            p2.SetCodigo(2);
            p1.SetPreco(10);
            p2.SetPreco(20);
            //
            var products = new List<Produto>() { p1, p2 };
            //
            foreach (var product in products)
            {
                Console.WriteLine(product.Describe());
            }
            //
            Console.ReadKey();
        }
    }

    class Produto
    {
        private long codigo;
        private string descricao;
        private decimal preco;
        private bool ativo;

        public void SetCodigo(long value) { this.codigo = value; }
        public void SetDescricao(string value) { this.descricao = value; }
        public void SetPreco(decimal value) { this.preco = value; }
        public void SetAtivo(bool value) { this.ativo = value; }
        public long GetCodgio() { return codigo; }
        public string GetDescricao() { return descricao; }
        public decimal GetPreco() { return preco; }
        public bool GetAtivo() { return ativo; }

        public string Describe()
        {
            return $"{{ Código: {codigo}, Descricao: {descricao}, Preco: {preco}, Ativo: {ativo} }}";
        }
    }
}
