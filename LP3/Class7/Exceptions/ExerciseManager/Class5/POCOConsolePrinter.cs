using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;
using System.Threading.Tasks;

namespace Exceptions
{
    public class POCOConsolePrinter
    {
        public static void Print<T>(T obj, Boolean ShowTypeName = true, Boolean ShowPropertyName = true, string Prefix = "\t[", string Suffix = "]\n")
        {
            var type = typeof(T);
            var properties = type.GetProperties();
            //
            if(ShowTypeName)
                Console.WriteLine(string.Format("{0}:", type.Name));
            //
            foreach (var property in properties)
            {
                var attr = property.GetCustomAttribute<IgnorePOCOPrinterAttribute>();
                if (attr != null)
                    continue;
                //
                Console.Write(Prefix);
                if(ShowPropertyName)
                    Console.Write(string.Format("{0}: ", property.Name));
                var value = property.GetValue(obj);
                if(value != null)
                    Console.Write(value);
                else
                    Console.Write("");
                Console.Write(Suffix);
            }
        }
    }
}
