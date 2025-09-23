using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// Tên hộ khẩu mà class đang ở mặc định đc dùng là hộ khẩu, namespace con, sub package
// Nơi nào khác muốn xài class này thì phải import/ using
namespace Jso.StudentManager.Entities
{
    public class Student
    {
        // class xem như là một template
        // 1 class đại diện cho 1 nhóm object đồng dạng, kiểu giống nhau
        // 1 class chứa đặt tính và hành vi, vì object nào cũng có màu lông, giống, kg, hành vi: vẫy đuôi,...
        private string _id;
        private string _name;
        private string yob;
        private double gpa;

        // constructor dùng để đổ info vào trong object, đổ vào class để tạo thành object
        public Student(string id, string name, string yob, double gpa)
        {
            _id = id; // Ko cần sử dụng this để phân biệt biến bên ngoài
            _name = name;
            this.yob = yob;
            this.gpa = gpa;
        }

        // Form có chứa chỗ để ai đó điền info vào.Hành động điền vào gọi là Constructor. Tạo dựng 1 object
        // Ctrl + . để tạo constructor nhanh

        // new chính là clone ra form riêng cho mỗi người điền info vào

        // coi như ctor đc gọi trc để đổ info vào object, thì object đã có info

    }
}
