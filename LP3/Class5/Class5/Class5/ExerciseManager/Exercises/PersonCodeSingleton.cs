using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class5.ExerciseManager.Exercises
{
    public static class PersonCodeSingleton
    {
        public static Int64 PersonCode { get { return ++personCode; } }

        private static Int64 personCode = 0;
    }
}
