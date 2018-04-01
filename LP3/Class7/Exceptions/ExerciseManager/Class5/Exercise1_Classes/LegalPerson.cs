using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise1_Classes
{
    public class LegalPerson : Client
    {
        public LegalPerson()
            : base()
        {

        }

        public LegalPerson(string SocialReason, string CNPJ, string Address, string Telephone) : base(Address, Telephone)
        {
            this.SocialReason = SocialReason;
            this.CNPJ = CNPJ;
        }

        public string SocialReason { get; set; }

        public string CNPJ { get; set; }
    }
}
