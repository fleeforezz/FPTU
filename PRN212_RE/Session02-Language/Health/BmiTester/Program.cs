namespace BmiTester
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");

            Console.WriteLine("BMI v1: " + GetBmiV1(70, 1.7));
            Console.WriteLine("BMI v2: {0}", GetBmiV1(70, 1.7));
            Console.WriteLine($"BMI v3: {GetBmiV1(70, 1.7)}");
        }

        // Challenge: viết hàm chỉ số bmi - Body mass index
        // Chỉ số khối cơ thể, đo mập ốm theo chiều cao và cân nặng 
        // BMI = cân nặng(kg) / chiều cao(M)^2
        // < 18.5 -> ốm; 24.9 -> chuẩn; >= 25 béo, > 30 béo phì
        public static double GetBmiV1(double weight, double height)
        {
            // hàm chuẩn, chỉ nhận vào và trả ra, ko có câu lệnh in gì đó bên trong. Làm vậy sẽ reuse cực tốt trong các biểu thức
            // Hàm sqrt() Sqrt() chỉ trả về, ko in gì cả, ta có thể làm phép cộng Sqrt(25) + Sqrt(100)
            return weight / (height * height);
        }

        // Sử dụng Math.Pow để mũ 2
        public static double GetBmiV2(double weight, double height)
        {
            return weight / Math.Pow(height, 2);
        }

        // Ko có trong java
        // Nếu 1 hàm chỉ có duy nhất 1 câu lệnh, ta có thể rút gonjn cách viết hàm, ăn bớt 1 vài ký hiện để cho hàm nhìn gọn gàng hơn (Do chỉ có 1 lệnh)
        // Ta có thể lược bỏ { return } coi như body / thận hàm chỉ còn lại duy nhất 1 lệnh, và ta nối tên hàm vs thân hàm qua kí hiệu =>, điều này nhìn hàm như 1 biểu thức, còn gọi là
        // Expression bodied (chỉ áp dụng cho hàm 1 lệnh duy nhất)
        // Ko đc nhầm lẫn kí hiệu này với kí hiệu lambda expression cũng xài chung kí hiệu => nhưng ở 1 diễn biến khác, học sau, cực hay
        public static double GetBmiV3(double weight, double height) => 
            weight / Math.Pow(height, 2);
    }
}
