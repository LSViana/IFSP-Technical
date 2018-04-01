using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions.ExerciseManager.Exercises.Exercise1_Classes
{
    public static class PersonCodeSingleton
    {
        public static Int64 PersonCode { get { return ++personCode; } }

        private static Int64 personCode = 0;
    }
}
