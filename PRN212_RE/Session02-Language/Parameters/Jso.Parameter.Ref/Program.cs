namespace Jso.Parameter.Ref
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int xOut, xRef = 113;

            PowerByTwoOut(out xOut); // chắc chắn có 1 giá trị trả về
            PowerByTwoRef(ref xRef); // Muốn xài ref, biến đưa vào phải có giá trị trc, để phòng hàm ref ko trả về thì ta vẫn 

            Console.WriteLine($"xRef: {xRef}");
        }

        // truyền tham chiếu style out và ref
        public static void PowerByTwoRef(ref int x)
        {
            // ref: ko cam kết sẽ trả về 1 giá trị x, thích làm gì làm
            x = 13454;
            // ko có lệnh này thì giá trị bên ngoài vẫn giá trị cũ
        }

        // truyền tham chiếu style out và ref
        // Biến hứng giá trị thì ko có giá trị khởi đầu
        // Ref ko đc xài inline
        public static void PowerByTwoOut(out int x)
        {
            // out: bắt buộc phải có lệnh gán x = ??? nào đó trc khi tính tiếp!!!!
            x = 2002;
        }
    }
}
