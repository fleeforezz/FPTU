namespace Delegates.AnonymousMethod
{
    internal class Program
    {
        public delegate void NoInputNoOuput();

        static void Main(string[] args)
        {
            NoInputNoOuput f1 = PrintEvens;
            f1();

            NoInputNoOuput f2 = delegate
            {
                Console.WriteLine("The list of numbers from 1 to 100");
                for (int i = 0; i <= 100; i++)
                {
                    if (i % 2 == 0)
                    {
                        Console.Write($"{i} ");
                    }
                }
                Console.WriteLine();
            };
            f2();
            // Hàm số lẻ, lẽ ra viết riêng 1 chỗ, gọi là hàm r, nay bán linh hồn, mất luôn cái tên, chỉ còn đc nhận viết qua luật sư
            // Hàm ẩn danh, hàm vô danh, Anonymous Delegate
        }
        // Challenge: Hãy viết hàm in ra các số chẵn, ko gọi trực tiếp

        public static void PrintEvens()
        {
            Console.WriteLine("The list of numbers from 1 to 100");
            for (int i = 0; i <= 100; i++)
            {
                if (i % 2 == 0)
                {
                    Console.Write($"{i} ");
                }
            }
            Console.WriteLine();
        }
    }
}
