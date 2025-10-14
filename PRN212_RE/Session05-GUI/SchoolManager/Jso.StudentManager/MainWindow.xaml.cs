using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using Jso.StudentManager;
using Jso.StudentManager.DAL.Entities;

namespace Jso.StudentManager
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    /// 
    //  mọi của sổ hay màn hình window trong app GUI WPF đều dựa trên cửa sổ mẫu đc cung cấp bởi hệ điều hành windows
    //  HĐH windows cung cấp 1 class tên window là cửa sổ mẫu mà mọi app GUI cần kế thừa
    // class Dog extend Pet
    // class Dog : extend Pet
    // class windows này có 2 hàm đặt biệt: .Show() và .ShowDialog()
    // GỌi 2 hàm này, HĐH window nó viện trợ ngay card đồ họa, để render ra 1 cửa sổ trên desktop
    // Mỗi cửa sổ xuất hiện trong app, trên desktop bản chất là 1 object của class mà kế thừa class window
    // Cửa sổ đang đứng tên là MainWidow đứng phía sau đó là 1 class cùng tên
    // Khi run, class này đc new và .Show()
    // 1 cửa sổ - 1 window là 1 class kế thừa 1 cửa sổ gốc tên là window 
    // nó sẽ có nhiều món đồ bày lên trên: Nút bấm, nhấn, ô nhập, checkbox, bấm và xổ - combobox - dropdown, Grid-Table-Grid, Radio-Button -> mỗi món đồ này là 1 property của class window x
    // Đặc điểm/PROP của Student là ID, Gpa, Yob, Address,....
    // Đặc điểm/PROP của Window x là: button1, button2, checkbox1, checkbox2, textbox1, Grid1
    // Để design đc cửa sổ x ta phải khai báo các prop là nút bấm, ô nhập bằng code -> khổ!!!!
    // VS cung cấp sẵn 1 UI giúp ta design UI, bằng cách kéo thả,
    // WYSIWYG, nhưng đằng sau đều là code
    // Và mỗi nút bấm, ô nhập, hộp kiểm checkbox,... đề là object, đều là class
    // Student chứa String address, Name, ...
    // class này window x chỉ chứa button, checkbox, label,... object của class tương ứng


    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void QuitButton_Click(object sender, RoutedEventArgs e)
        {
            MessageBoxResult result = MessageBox.Show("Are you sure?", "Confirm?", MessageBoxButton.YesNo, MessageBoxImage.Question);

            if (result == MessageBoxResult.Yes)
            {
                Application.Current.Shutdown();
            }

            // Nhớ đoạn code này để làm tính năng delete
            // thang điểm chấm cho tính năng delete là khi delete phải hỏi có chắc xóa ko, yes mới xóa, no ko làm gì. thiếu confirm, xóa ko hỏi, bị trừ 0.5
        }

        private void LoadDataButton_Click(object sender, RoutedEventArgs e)
        {
            // Chuẩn bị 1 list student từ db đem lên, tạm thời hardcode, cho data sãn vào
            // Gửi cái list chứa hồ sơ nhiều sinh viên cho datagrid

            List<Student> students = new();

            students.Add(new Student()
            {
                Id = "SE1",
                Name = "User1",
                Yob = 2005,
                Gpa = 8.12
            });

            students.Add(new Student()
            {
                Id = "SE2",
                Name = "User2",
                Yob = 2005,
                Gpa = 4.0
            });

            students.Add(new Student()
            {
                Id = "SE3",
                Name = "User3",
                Yob = 2005,
                Gpa = 9.0
            });

            students.Add(new Student()
            {
                Id = "SE4",
                Name = "User1",
                Yob = 2005,
                Gpa = 8.12
            });

            StudentListDataGrid.ItemsSource = students;

        }

        private void DeleteeButton_Click(object sender, RoutedEventArgs e)
        {
            // 1. Kiểm tra xem user đã chọn 1 dòng trên grid chưa, nếu chưa thì hiện thông báo chưa chọn
            // 2. Hiển thị are you sure to delete/update ?
            // 3. Nếu Yes thì xóa trong DB, và F5(Refresh) lại cái grid, nếu no thì ko làm gì!
            // StudentListDataGrid nó lắng nghe xem user có chọn hay ko, và mỗi dòng nếu chọn thì là 1 Student x, vì mình đưa 1 cái bag student vào!!!
            // Mình chỉ việc hỏi nó có dòng chọn hay ko, qua cái Property

            Student? selected = StudentListDataGrid.SelectedItem as Student; // as: ép kiểu 1 dòng về Student, hoặc ép ko đc thì là null, nghĩa là chưa chọn dòng cụ thể


            if (selected == null)
            {
                // Nhấn nút delete mà ko chọn dòng, hiện thông báo lỗi
                MessageBox.Show("Please select a student before deleting", "Alert", MessageBoxButton.OK, MessageBoxImage.Error);
                return; // Thoát hàm nút delete
            }

            MessageBox.Show($"Delete Successfully {selected.Id}, {selected.Name}", "Success", MessageBoxButton.OK, MessageBoxImage.Information);
        }

        private void CreateButton_Click(object sender, RoutedEventArgs e)
        {
            DetailWindow detailWindow = new();

            detailWindow.Show();
        }

        private void UpdateButton_Click(object sender, RoutedEventArgs e)
        {
            Student? selected = StudentListDataGrid.SelectedItem as Student; // as: ép kiểu 1 dòng về Student, hoặc ép ko đc thì là null, nghĩa là chưa chọn dòng cụ thể


            if (selected == null)
            {
                // Nhấn nút delete mà ko chọn dòng, hiện thông báo lỗi
                MessageBox.Show("Please select a student before updating", "Alert", MessageBoxButton.OK, MessageBoxImage.Error);
                return; // Thoát hàm nút delete
            }

            // Đã chọn 1 dòng gửi nó sang Detail
            DetailWindow detailWindow = new();
            detailWindow.EditOne = selected; // Gửi student sang detail, ko tạo mới
            detailWindow.ShowDialog();
        }
    }
}