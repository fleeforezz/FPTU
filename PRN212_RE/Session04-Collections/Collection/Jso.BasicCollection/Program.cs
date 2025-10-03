using System.Collections;

namespace Jso.BasicCollection
{
    public class Student()
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public int Yob { get; set; }
        public double Gpa { get; set; }

        public override string ToString()
        {
            return $"Student: {Id} | {Name} | {Yob} | {Gpa}";
        }
    }

    public class Program
    {
        static void Main(string[] args)
        {
            PlayWithArrayList();
            PlayWithList();
        }

        public static void PlayWithList()
        {
            // Đây là túi đa năng đựng nhiều đồ, nhưng chỉ cùng 1 loại
            
            //List<Student> bag = new List<Student>();
            List<Student> bag = new();

            Student student1 = new Student()
            {
                Id = "SE1",
                Name = "Jso",
                Yob = 2005
            };
            bag.Add(student1);

            Student student2 = new Student()
            {
                Id = "SE2",
                Name = "Jso",
                Yob = 2005
            };
            bag.Add(student2);

            bag.Add(new Student()
            {
                Id = "SE3",
                Name = "Binh"
            });

            Console.WriteLine($"There is: " + bag.Count);



            //bag.Remove(student2);
            bag.Remove(bag[1]);

            Console.WriteLine("After removing, the bag now has: ");

            

            Console.WriteLine("Here's student2: " + student2);

            // Làm sao xóa student2 ở ngoài danh sách
            Student sutdent2 = bag[1];
            bag.Remove(sutdent2);

            for (int i = 0; i < bag.Count; i++)
            {
                Console.WriteLine(bag[i].ToString());
            }

            Console.WriteLine("Sutdent2: " + sutdent2);
        }

        public static void PlayWithListV2()
        {
            // Đây là túi đa năng đựng nhiều đồ, nhưng chỉ cùng 1 loại

            //List<Student> bag = new List<Student>();
            List<Student> bag = new();

            Student student1 = new Student()
            {
                Id = "SE1",
                Name = "Jso",
                Yob = 2005
            };
            bag.Add(student1);

            Student student2 = new Student()
            {
                Id = "SE2",
                Name = "Jso",
                Yob = 2005
            };
            bag.Add(student2);

            bag.Add(new Student()
            {
                Id = "SE3",
                Name = "Binh"
            });

            Console.WriteLine($"There is: " + bag.Count);

            for (int i = 0; i < bag.Count; i++)
            {
                //Console.WriteLine(bag.ElementAt(i)); // = get(i) trong java
                Console.WriteLine(bag.ElementAt(i).Name);
            }
        }

        public static void PlayWithArrayList()
        {
            // Java: List<Student> bag = new ArrayList<>();
            //       ArrayList<Student> bag = new ArrayList<>(); // túi bự tromg ram để nhét sv vào
            //       <bắt buộc phải có>, kĩ thuật Generic
            //       1 class tại tại thời điểm chỉ chơi vs 1 class khác
            //  Bên trong List<Student> bag đc hiểu là bag chỉ chứa Student, ko ai khác
            //  List, ArrayList là túi đa năng đựng đc nhiều object bên trong nhưng tại 1 thời điểm chỉ chấp nhận chứa 1 loại: <Student> <Lecturer> <Order> <User> (Kĩ thuật generic)

            // C#: ArrayList hong phải túi generic, tức là chứa đc nhiều và lộn xộn
            // List là túi Generic, tức là nhiều nhưng không lộn xộn
            //                              nhiều nhưng chỉ 1 loại

            ArrayList bag = new ArrayList(); // Nhét nhiều là lộn xộn
            bag.Add(1);
            bag.Add(2);
            bag.Add(3.14);
            bag.Add("A");
            bag.Add("Hoho");
            Student student = new Student()
            {
                Id = "SE1",
                Name = "Jso",
                Yob = 2005
            };
            bag.Add(student);

            bag.Add(new Student()
            {
                Id = "SE2",
                Name = "Binh"
            });

            Console.WriteLine("Bag count: " + bag.Count);

            for (int i = 0; i < bag.Count; i++)
            {
                Console.WriteLine(bag[i]);
            }
        }
    }
}
