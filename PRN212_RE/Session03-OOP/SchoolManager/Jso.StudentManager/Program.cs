using Jso.StudentManager.Entities;
using System.Transactions;

namespace Jso.StudentManager
{
    public class Program
    {
        static void Main(string[] args)
        {
            CreateStudent();
        }

        public static void CreateStudent()
        {
            var an = new Student("SE12", "Yay", "2005", 8.6);
            an.ToString();
        }

        public static void CreateStudentV2()
        {
            Student an = new Student("SE12", "Yay", "2005", 8.6);
            an.ToString();
        }

        public static void CreateStudentV3()
        {
            // truyền data vào đc hàm đc quyền lộn xộn thứ tự ko tuân theo thứ tự của hàm gốc, nhưng muốn làm z thì ghi chú thêm tên biến đầu vào kèm theo 2 chấm
            // mang ý nghĩa biến này nhận value này
            // kĩ thuật này gọi là: Named arguement, tryền tham số và nêu luôn thêm tham số
            Student an = new(gpa: 8.6, yob: "2005", name: "test", id: "SE1");
            Console.WriteLine(an.ToString());
        }

        public static void CreateStudentV4()
        {

        }
    }
}
