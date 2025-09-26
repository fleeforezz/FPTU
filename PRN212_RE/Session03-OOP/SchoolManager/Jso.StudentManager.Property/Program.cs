using Jso.StudentManager.Property.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jso.StudentManager.Property
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine();
            CreateObject();
            CreateStudentV2();
        }

        public static void CreateObject()
        {
            Student an = new Student();
            //an.SetId("asd22");
            //an.SetName("something_name");

            //Console.WriteLine(an.ToString());

            //Console.WriteLine(an.GetName);

            an.Id = "1020";
            an.Name = "Test";
            an.Gpa = 1;
            an.Yob = 2;

            Console.WriteLine(an.ToString());



            // Get la lấy về 1 value của đặc tính bên trong object thông qua tên hàm tên Get'
            // Ví dụ: muốn lấy _name to viết hàm string GetName() => _name; {return _name}
            // Kết luận: tên biến chính là Get r
            // Hàm get chẳng qua là ném ra tên biến

            // Get là thay đổi value cảu 1 đặc tính bên trong object thông qua hàm tên set
            // Ví dụ muốn thay đổi _name, ta viết hàm
            // void SetName(string value) => _name = value;

            // 1 biến bất kì đã bao hàm khái niệm GET/SET

            // - int yob = 2005
            // get biến yob để xài: cw(yob); (Tên biến chính là Set)
            // Thay vì viết 2 hàm GET SET dài dòng, tại sao ko dùng ngay tên biến đẻ có sãn GET SET cho code viết tự nhiên hơn, đỡ nhàm chán hơn
        
            
            // an.Yob => link vs _yob
            // an.Yob = 2007
            // Property là 1 biến mới thêm vào trong class vì là biến nên nó mang luôn ý nghĩa của Get/SET 
            //Biến này thêm đoạn code ngắn để link vs biến
        }

        public static void CreateStudentV2()
        {
            // ki thuat vua new vua set dc goi la object init
            Student a = new Student()
            {
                Id = "1020",
                Name = "Test",
                Gpa = 1,
                Yob = 2
            };

            Console.WriteLine(a.ToString());
            
        }
    }
}
