using Bmi;

namespace BmiTester
{
    internal class Program
    {
        static void Main(string[] args)
        {
            double bmi = BmiCalculator.GetBmi(70, 1.72);
            Console.WriteLine(bmi);
            Console.ReadLine();
        }
    }
}
