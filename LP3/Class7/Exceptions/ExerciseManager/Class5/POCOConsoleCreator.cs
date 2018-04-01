using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Exceptions
{
    public class POCOConsoleCreator
    {
        public static T Generate<T>()
        {
            var ignoreAttribute = new IgnorePOCOCreatorAttribute();
            var type = typeof(T);
            var properties = type.GetProperties();
            //
            Console.WriteLine(string.Format("\tInitializing a {0}:", type.Name));
            T instance = (T)Activator.CreateInstance(type);
            //
            foreach (var property in properties)
            {
                var attr = property.GetCustomAttribute<IgnorePOCOCreatorAttribute>();
                if (attr != null)
                {
                    continue;
                }
                //
                var converted = false;
                //
                Object value = null;
                do
                {
                    Console.Write(string.Format("\t{0}: ", property.Name));
                    var userInput = Console.ReadLine();
                    //
                    var pType = property.PropertyType;
                    if (pType == typeof(byte))
                    {
                        byte _value = 0;
                        value = _value;
                        converted = byte.TryParse(userInput, out _value);
                    }
                    else if (pType == typeof(int))
                    {
                        int _value = 0;
                        value = _value;
                        converted = int.TryParse(userInput, out _value);
                    }
                    else if (pType == typeof(long))
                    {
                        long _value = 0;
                        value = _value;
                        converted = long.TryParse(userInput, out _value);
                    }
                    else if (pType == typeof(float))
                    {
                        float _value = 0;
                        value = _value;
                        converted = float.TryParse(userInput, out _value);
                    }
                    else if (pType == typeof(double))
                    {
                        double _value = 0;
                        value = _value;
                        converted = double.TryParse(userInput, out _value);
                    }
                    else if (pType == typeof(string))
                    {
                        string _value = userInput;
                        value = _value;
                        converted = true;
                    }
                    else if (pType == typeof(DateTime))
                    {
                        DateTime _value = DateTime.MinValue;
                        value = _value;
                        converted = DateTime.TryParse(userInput, out _value);
                    }
                    if(!converted)
                    {
                        throw new FormatException("The data inserted wasn't a valid format to " + pType.Name + " data");
                    }
                }
                while (!converted);
                property.SetValue(instance, value);
            }
            //
            return instance;
        }
    }
}
