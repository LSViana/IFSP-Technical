using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise1_Classes
{
    public class Client
    {
        public Client()
        {
            this.Code = PersonCodeSingleton.PersonCode;
        }

        public Client(string Address, string Telephone) : this()
        {
            this.Address = Address;
            this.Telephone = Telephone;
        }

        public string Address { get; set; }

        public string Telephone { get; set; }

        [IgnorePOCOCreator]
        public long Code { get; set; }
    }
}
