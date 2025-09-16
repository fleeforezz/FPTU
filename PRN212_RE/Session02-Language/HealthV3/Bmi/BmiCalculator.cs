namespace Bmi
{
    /// <summary>
    /// This class offer method to measure health status base on weight and height
    /// </summary>

    public class BmiCalculator
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="weight">kg</param>
        /// <param name="height">metre</param>
        /// <returns></returns>
        public static double GetBmi(double weight, double height) =>
            weight / Math.Pow(height, 2);
    }
}
