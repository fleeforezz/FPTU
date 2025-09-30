using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jso.StudentManager.AutoProperties.Entities
{
    public class Student
    {
        public string Id { get; set; } // Backing field _id tự sinh ngầm giúp khi compile và run, ko cần lặp lại điều nhàm chán
        public string Name { get; set; }
        public int Yob { get; set; }
        public double Gpa { get; set; }

        // Kĩ thuật tạo ngầm backing field khi build và run cái app giúp viết get set ngắn gọn đến mức tối thiểu gọi là Auto-Implemeted property, ngắn gọn là auto property

        public override string? ToString()
        {
            return $"{Id} | {Name} | {Yob} | {Gpa}";
        }
    }
}
