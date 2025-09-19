namespace Jso.Parameters.Out.InUse
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int countA, countE, sumA, sumE;

            countA = CalculateIntList(out sumA, out countE, out sumE);

            Console.WriteLine("Count all: " + countA);
            Console.WriteLine("Sum all: " + sumA);
            Console.WriteLine("Count evens: " + countE);
            Console.WriteLine("Sum evens: " + sumE);
        }

        // challenge: Viết hàm đếm à tính trong dãy số từ 1 đến 100 có bao nhiêu con số
        // Tổng từ 1 đến 100
        // Có bao nhiêu số chẵn
        // số lẽ
        public static int CalculateIntList(out int allSum, out int evenCount, out int evenSum)
        {

            allSum = 0;
            evenCount = 0;
            evenSum = 0;
            int allCount = 0;

            // Tính, đếm, dùng for, và if để check
            for (int i = 0; i < 10; i++)
            {
                allCount++; // Cứ có 1 con số đếm luôn
                allSum += i; // Cứ có 1 còn số, cộng luôn, tổng all
                if (i%2 == 0)
                {
                    evenCount++;
                    evenSum += i;
                }
            }

            return allCount;
        }
    }
}
