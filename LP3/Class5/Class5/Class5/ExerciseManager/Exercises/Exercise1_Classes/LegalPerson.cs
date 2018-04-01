using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises.Exercise1_Classes
{
    public class LegalPerson : Client
    {
        public LegalPerson()
            : base()
        {

        }

        public LegalPerson(String SocialReason, String CNPJ, String Address, String Telephone) : base(Address, Telephone)
        {
            this.SocialReason = SocialReason;
            this.CNPJ = CNPJ;
        }

        public string SocialReason { get; set; }

        public string CNPJ { get; set; }
    }
}
