namespace Delegate.Basic
{
    public class Student
    {
        // Class nằm trong namespace
        // Id, name, yob, gpa
    }
    // Student an = new Student() {....};
    //public class NoInputNoOuput
    //{
    //    // Tên Hàm
    //    // _fname, _returnType, _parameters, _code
    //    // Đại diện cho hàm void F() ko vào ko ra
    //    // Invoke();
    //}

    public delegate void NoInputNoOuput(); // Y chang cú pháp class ở trên
    // NoInputNoOuput là tên gọi chung / class đại diện 
    // NoInputNoOutput f1 = SayHi;        // 1 Hàm cụ thể
    // NoInputNoOuput f2 = new(PrintLog); // 1 hàm cụ thể
    //                f1 f2 nhận ủy quyền, đại diện cho 2 hàm SayHi và PrintLog, f1 f2 gọi là biến delegate
    //                Biến nhận ủy quyền, biến đại diện cho hàm khác con trỏ hàm, trỏ tới 1 hàm cụ thể nào đó
    //                Luật sư = thân chủ

    internal class Program
    {
        static void Main(string[] args)
        {
            NoInputNoOuput f1 = SayHi; // ko có dấu (), vì nó là run hàm
            //             Luật sử = thân chủ
            // Run hàm, luật sư nhận ủy quyền, luật sư nói, là thân chủ nói
            // a+5 = b+5 -> đúng
            f1();
            f1.Invoke();

            // Cách gọi PrintLog()
            // Cách 1: truyền thống
            PrintLog();
            f1 = PrintLog;
            f1();

            f1 = PrintList;
            f1();

            // Challenge: in các số từ 1 đến 100 thông qua hàm PrintList();
        }

        public static void PrintList()
        {
            Console.WriteLine("The list of numbers from 1 to 100");
            for (int i = 0; i <= 100; i++)
            {
                Console.Write($"{i} ");
            }
            Console.WriteLine();
        }

        // Giả sử ta có hàm void ko vào ko ra, và ta xem nó là data như 5 10 15 20, như sv An, sv Binh.... Vì nó là thứ quanh ta
        public static void SayHi()
        {
            Console.WriteLine("Hello C#, xin chào C#");
        }

        public static void PrintLog()
        {
            Console.WriteLine("2025-11-11 08:37AM Đang học Delegate");
        }
    }
}
