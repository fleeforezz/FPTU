namespace Music // Namespce là tên thư mục chứa file source code này, nỏ chỉ ra nơi tập tin source đang nằm, chỉ ra hộ khẩu thường trú
                // Mặc định 1 tập tin source code sẽ lấy project, thư mục project làm hộ khẩu
                // Tương đương khái niệm package bên java: package music
                // 1 thư mục chứa nhiều tập tin
                // Do đó 1 namespace có thể chứa nhiều tập tin, xem điều này sau
                // 1 tập tin chứa class bên trong, nhiều class bên trong
{
    // Class khác viết ở đây

    public class Student
    {

    }

    internal class Program
    {
        // trong class ta viết code: biến và hàm, OOP: field and method
        static void Main(string[] args)
        {
            PrintLyricV5();
        }

        // static chỉ chơi vs static
        public static void PrintLyricV2()
        {
            int publishedYear = 2024;

            Console.WriteLine("Dù chẳng phải là mối tình đầu\r\nHai ta đã từng tan vỡ ngỡ chẳng có người sau\r\nEm ôm mộng về một giấc mơ yêu đương ngọt ngào\r\nAnh cũng học được vài cách yêu thương ai làm sao {0} ", publishedYear); // Điền vào chỗ trống trong chuỗi qua {đánh dấu biến thứ mấy đưa value vào thay thế}
            // {0} {1} {2}, phía ngoài chuỗi là danh sách biến theo thứ tự bạn muốn in
            
        }

        public static void PrintLyricV3()
        {
            int publishedYear = 2024;
            int views = 1000;

            Console.WriteLine($"Dù chẳng phải là mối tình đầu\r\nHai ta đã từng tan vỡ ngỡ chẳng có người sau\r\nEm ôm mộng về một giấc mơ yêu đương ngọt ngào\r\nAnh cũng học được vài cách yêu thương ai làm sao {publishedYear} {views}"); 
            // Interpolation - nội suy chuỗi, tìm ra chỗ nào là biến để thay value vào 
        }

        public static void PrintLyricV4()
        {
            int publishedYear = 2024;
            int views = 1000;

            Console.WriteLine(@"Dù chẳng phải là mối tình đầu
Hai ta đã từng tan vỡ ngỡ chẳng có người sau
Em ôm mộng về một giấc mơ yêu đương ngọt ngào
Anh cũng học được vài cách yêu thương ai làm sao
Vạt áo có nhăn em sẽ là
Anh chăm một vài con cá tưới cho khu vườn hoa
Hai ta cùng cười ngốc nghếch gối tay xem truyện hài
Ôm nhau nằm kể về những lắng lo cho ngày mai
Ngàn lời em nói thương anh là em thương thật mà
Từng ngày nỗi nhớ em đem trao cho anh thật mà
Dù muộn phiền có theo em từ chỗ làm về nhà
Thì chỉ cần nhớ môi anh là u phiền trôi qua");
            // Chuỗi nguyên bản, có sao in vậy
            // Wysiwyg - raw string, verbatim string
        }

        public static void PrintLyricV5()
        {
            // tui muốn lưu đường dẫn thư mục C:\news; -> và in ra màn hình
            //string path = "C:\\news";
            string path = @"C:\news";
            Console.WriteLine(path); // cw + tab -> sout bên java
        }

        public static void PrintLyric()
        {
            int publishedYear = 2024;

            Console.WriteLine("Dù chẳng phải là mối tình đầu\r\nHai ta đã từng tan vỡ ngỡ chẳng có người sau\r\nEm ôm mộng về một giấc mơ yêu đương ngọt ngào\r\nAnh cũng học được vài cách yêu thương ai làm sao " + publishedYear); // System.out.println(); của bên java
            // Ghép chuỗi vs biến dùng dấu +: concatenation ghép chuỗi
        }
    }

    // Class khác viết ở đây

    public class Lecturer
    {

    }
}


