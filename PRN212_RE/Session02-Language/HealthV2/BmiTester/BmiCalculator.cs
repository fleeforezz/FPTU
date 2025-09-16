using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BmiTester
{
    public class BmiCalculator
    {
        // Hàm tính BMI
        // Bodied expression method
        public static double GetBMI(double weight, double height) =>
            weight / Math.Pow(height, 2);
    }
}
