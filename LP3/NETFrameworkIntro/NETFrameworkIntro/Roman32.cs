using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace NETFrameworkIntro
{
    public class Roman32
    {
        public Roman32() { }

        public Roman32(Int32 Value)
        {
            this.Value = Value;
        }

        public int Value { get; set; }

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
