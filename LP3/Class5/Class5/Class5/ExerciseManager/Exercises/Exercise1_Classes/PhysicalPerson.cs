using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises.Exercise1_Classes
{
    public class PhysicalPerson : Client
    {
        public PhysicalPerson()
            : base()
        {

        }

        public PhysicalPerson(String Name, String CPF, String Address, String Telephone)
            : base(Address, Telephone)
        {
            this.Name = Name;
            this.CPF = CPF;
        }

        public string Name { get; set; }

        public string CPF { get; set; }
    }
}
