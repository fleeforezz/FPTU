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
    }
}