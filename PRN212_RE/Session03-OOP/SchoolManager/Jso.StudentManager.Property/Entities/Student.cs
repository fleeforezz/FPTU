using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jso.StudentManager.Property.Entities
{
    public class Student
    {
        private string _id;
        private string _name;
        private int _yob;
        private double _gpa;

        public Student()
        {
            // nếu xài const này, để new thì toàn bộ các field mang giá trị mặc định: số->0,chữ->rổng
            // Tương đương việc là mình photo đem về nhà chưa điền 
        }

        public Student(string id, string name, int yob, double gpa)
        {
            _id = id;
            _name = name;
            _yob = yob;
            _gpa = gpa;
        }

        public Student(string id, string name)
        {
            _id = id;
            _name = name;
        }
        
        // Get set kiểu mới thì vẫn cần field _ phía sau để chống lưng cái vakue
        // Id: đống vai tiếp tân, bồi tbanfm;
        // _id là nhà bếp, lo haayu tường
        public string Id { 
            get 
            { 
                return _id; 
            } 
            set
            {
                _id = value;
            }
        }

        public string Name
        {
            get { return _name; } // coi chung expression body
            set { _name = value; }
        }

        public int Yob
        {
            get => _yob;
            set => _yob = value;
        }

        public double Gpa
        {
            get => _gpa;
            set => _gpa = value;
        }

        public override string ToString()
        {
            string profile = $"{_id} {_name}";
            return profile;
        }
    }
}
