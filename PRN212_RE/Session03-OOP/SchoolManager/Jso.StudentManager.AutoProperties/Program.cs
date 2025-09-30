using Jso.StudentManager.AutoProperties.Entities;

namespace Jso.StudentManager.AutoProperties
{
    public class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student();

            Console.WriteLine(student.ToString());
        }
    }
}
