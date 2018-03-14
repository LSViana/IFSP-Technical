using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Reflection;
using System.Threading.Tasks;

namespace Class5
{
    public class POCOConsolePrinter
    {
        public static void Print<T>(T obj, Boolean ShowTypeName = true, Boolean ShowPropertyName = true, String Prefix = "\t[", String Suffix = "]\n")
        {
            var type = typeof(T);
            var properties = type.GetProperties();
            //
            if(ShowTypeName)
                Console.WriteLine(String.Format("{0}:", type.Name));
            //
            foreach (var property in properties)
            {
                var attr = property.GetCustomAttribute<IgnorePOCOPrinterAttribute>();
                if (attr != null)
                    continue;
                //
                Console.Write(Prefix);
                if(ShowPropertyName)
                    Console.Write(String.Format("{0}: ", property.Name));
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
