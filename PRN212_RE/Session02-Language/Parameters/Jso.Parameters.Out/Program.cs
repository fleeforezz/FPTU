namespace Jso.Parameters.Out
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int n; // KO cần gán value vì 
            PowerByTwo(out n);
            Console.WriteLine("After calling method, n now is: {0}", n);

            PowerByTwo(out int y); // Kỹ thuật khai báo biến style inline ngay trong tham số hàm out. ChatGPT hay dùng cách này
            Console.WriteLine("After calling method, y now is: {0}", y);
        }

        public static void PowerByTwo(out int x)
        {
            // out: hàm hứa sẽ có 1 giá trị x đc tạo ra
            // và return ra ngoài !!!
            //Console.WriteLine(x); // Báo lỗi vì chưa có giá trị x đc gán, đc taojm lấy gì mà in
            
            x = 8123;
            //Console.WriteLine(x); // hàm chạy đc vì đã có value truyền vào
        }

        // Hàm dưới là truyền tham trị, trong hàm mà sửa, bên ngoài giữ nguyên
        //public static void PowerByTwo(int x)
        //{
        //    Console.WriteLine(x);
        //}
    }
}
