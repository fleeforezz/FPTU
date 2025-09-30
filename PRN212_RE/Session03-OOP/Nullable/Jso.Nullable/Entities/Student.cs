using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jso.Nullable.Entities
{
    public class Student
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public int? Yob { get; set; }
        public double Gpa { get; set; }

        public override string? ToString()
        {
            return $"{Id} | {Name} | {Yob} | {Gpa}";
        }

        // Tự động sinh giúp mình ctor rỗng. Để giúp chúng ta new default
        // OOP java cũng z


    }
}
