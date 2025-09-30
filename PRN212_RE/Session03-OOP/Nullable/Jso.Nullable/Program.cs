using Jso.Nullable.Entities;

namespace Jso.Nullable
{
    public class Program
    {
        static void Main(string[] args)
        {
            PlayWithPrimitiveNullable();
            PlayWithPrimitiveNullableObject();
        }

        public static void PlayWithPrimitiveNullable()
        {
            //int yob = null;
            int? yob = null;
            yob = yob + 2005;
            Console.WriteLine("Yob: " + yob);

            int? yob1 = 0;
            yob1 = yob1 + 2005;
            Console.WriteLine(yob1);

            if (yob ==  null)
            {
                Console.WriteLine("Cannot add value to yob due to null value");
            }
        }

        public static void PlayWithPrimitiveNullableObject()
        {
            Student an = new Student()
            {
                Id = "SE12",
                Name = "Test"
            };

            Console.WriteLine(an.ToString());
            // Điểm, năm sinh default 0 dù nullable hay ko


            // Biến object đc quyền mang null mà cần ? cũng hàm ý ko trỏ đến object nào cả
            // Biến Object đang bằng null mà đem đi xài, toang, null reference
            // Tất nhiên xài if để handle null trong object
            Student binh = null;
            Console.WriteLine(binh.ToString());
        }
    }
}
