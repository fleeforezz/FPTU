using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Jso.StudentManagement.FullProperty.Entities
{
    public class Student
    {
        private string _id;
        private string _name;
        private int _yob;
        private double _gpa;

        // các xếp gạch là default 
        public Student()
        {
            
        }

        public Student(string id, string name, int yob, double gpa)
        {
            _id = id;
            _name = name;
            _yob = yob;
            _gpa = gpa;
        }

        // Get/Set style cũ hoặc mới -> mới gọi là properties
        // (GetId/SetId) biến bao hành động get set vì nó tự nhiên
        public string Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

        public int Yob
        {
            get { return _yob; }
            set { _yob = value; }
        }

        // Gõ propfull tab tab ra gợi ý mẫu về get set kiểu mới
        public double Gpa
        {
            get { return _gpa; }
            set { _gpa = value; }
        }

        // "?" là gì, có thể bỏ đi đc ko
        // đc và ko đc tùy vào ngũ cảnh
        public override string? ToString()
        {
            return $"{_id} | {Name} | {_yob} | {Gpa}";
        }
    }
}
