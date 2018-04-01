using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise1_Classes
{
    public class PhysicalPerson : Client
    {
        public PhysicalPerson()
            : base()
        {

        }

        public PhysicalPerson(string Name, string CPF, string Address, string Telephone)
            : base(Address, Telephone)
        {
            this.Name = Name;
            this.CPF = CPF;
        }

        public string Name { get; set; }

        public string CPF { get; set; }
    }
}
