// See https://aka.ms/new-console-template for more information
using Jso.StudentManagement.FullProperty.Entities;

namespace Jso.StudentManager.FullProperty
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Student student = new();

            Student binh = new Student()
            {
                Id = "32S",
                Name = "Binh",
                Yob = 2004,
                Gpa = 2.3
            };
            Console.WriteLine(binh.ToString());

            Student nam = new Student
            (
                yob: 2005,
                gpa: 8.8,
                id: "SE3",
                name: "nam"
            );

            Console.WriteLine(nam.ToString());
        }
    }
}