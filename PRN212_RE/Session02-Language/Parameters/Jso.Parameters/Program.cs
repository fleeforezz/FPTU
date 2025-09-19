namespace Jso.Parameters
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int x = 10;
            PowerByTwo(x); // Gọi hàm, hy vọng nhận về bình phương

            Console.WriteLine("In main, after calling method, x finally = " + x);
        }

        // Challenge: Viết 1 hàm nhận vào 1 con số, thay đổi con số đó thành bình phương, in ra kết quả
        public static void PowerByTwo(int x)
        {
            Console.WriteLine("In method, before raising by 2, x = " + x);
            x = x * x;

            Console.WriteLine("In method, after raising by 2, x = " + x);
            // Bên trong hàm đổi, bên ngoài giữ nguyên -> truyền tham trị
            // Tạo hàm chỉ xin giá trị của biến bên ngoài
            // Sau đó trong hàm tự xử lí mà ko ảnh hưởng biến gốc bên ngoài
        }
    }
}
