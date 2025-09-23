namespace Jso.Parameter.In
{
    public class Program
    {
        static void Main(string[] args)
        {
            int y = 10;
            PowerByTwo(y);
        }

        public static void PowerByTwo(in int x)
        {
            // Từ khóa in sẽ biến tham số trở thành readonly
            // Dùng biến đầu vào để tham gia biểu thức, ko thay đổi nó

            // TODO: nếu đầu vào của hàm ntn
            // public void doStudent(in Student s) {....}
            // chữ in nên đc hiểu thế nào nếu biến đầu vào là biến objects
            int y = x * x;
            Console.WriteLine("In method, x now is: " + x);
        }
    }
}
