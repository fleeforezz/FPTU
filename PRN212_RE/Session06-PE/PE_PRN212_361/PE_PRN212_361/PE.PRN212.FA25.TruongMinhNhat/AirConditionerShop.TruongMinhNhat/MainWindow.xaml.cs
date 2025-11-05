using AirConditionerShop.BLL.Services;
using AirConditionerShop.DAL.Entities;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace AirConditionerShop.TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // Khai báo 1 prop để hứng role gửi từ login sang
        // Biến int là role, hoặc biến staffmemeber, thì phải chấm role

        public int? Role { get; set; } // 1:admin, 2:Staff
        private AirConService _airConService = new();
        // OOP: khai báo biến và new mới đc xài

        public MainWindow()
        {
            InitializeComponent();
        }

        private void AirConDataGrid_Loaded(object sender, RoutedEventArgs e)
        {
            AirConDataGrid.ItemsSource = _airConService.GetAllAirCons();

            if (Role == 2)
            {
                CreateButton.IsEnabled = false;
                UpdateButton.IsEnabled = false;
                DeleteButton.IsEnabled = false;
            }
        }

        public void FillDataGrid(List<AirConditioner> data)
        {
            AirConDataGrid.ItemsSource = null;
            AirConDataGrid.ItemsSource = data;
        }

        private void CreateButton_Click(object sender, RoutedEventArgs e)
        {
            DetailWindow detailWindow = new();
            // Ko có và ko cần gửi editedOne sang detail do tạo mới 
            // Thì để màn hình bên detail trống trơn chờ nhập vào
            // 3 chàng 1 nàng: EditedOne, selected, grid có 1 con trỏ -> trỏ vùng new AirCon đang cần edit
            detailWindow.ShowDialog();

            FillDataGrid(_airConService.GetAllAirCons());
        }

        private void UpdateButton_Click(object sender, RoutedEventArgs e)
        {
            // Check xem đã click đúng dòng chưa
            // Chọn 1 dòng gửi nó sang màn hình detail -> học ròi
            // nhờ service update, service đi nhờ repo

            AirConditioner selected = AirConDataGrid.SelectedItem as AirConditioner;

            if (selected == null)
            {
                MessageBox.Show("Please select a row before deleting", "Select One", MessageBoxButton.OK, MessageBoxImage.Stop);
                return;
            }

            DetailWindow detailWindow = new();
            //Gửi selected sang
            detailWindow.EditedOne = selected;
            // 3 chàng 1 nàng: EditedOne, selected, grid có 1 con trỏ -> trỏ vùng new AirCon đang cần edit
            detailWindow.ShowDialog();

            FillDataGrid(_airConService.GetAllAirCons());
        }

        private void DeleteButton_Click(object sender, RoutedEventArgs e)
        {
            // Check xem đã click đúng dòng chưa
            // hiện are you sure
            // nhờ service xóa, service đi nhờ repo

            AirConditioner selected = AirConDataGrid.SelectedItem as AirConditioner;

            if (selected == null)
            {
                MessageBox.Show("Please select a row before deleting", "Select One", MessageBoxButton.OK, MessageBoxImage.Stop);
                return;
            }

            MessageBoxResult answer = MessageBox.Show("Are you sure ?", "Confirm", MessageBoxButton.YesNo, MessageBoxImage.Question);

            if (answer == MessageBoxResult.No)
            {
                return;
            }

            // MessageBox.Show($"Real Delete: ${selected.AirConditionerId}, ${selected.AirConditionerName}", "Select One", MessageBoxButton.OK, MessageBoxImage.Stop);
            _airConService.DeleteAirCon(selected);

            // F5 - Refresh để thấy dòng đã mất
            // Việc refresh GRID này xuất hiện ở:
            // Nút Create (Thêm mới thì phải cho thấy đã thêm)
            // Nút Delete (Mất dòng trên GRID luôn)
            // Nút Search (Lưới phải hiển thị 1 - N dòng search thấy)
            // Loaded (Màn hình mở lên, lưới phải đc đổ sẵn data)
            // Giúp code trong sáng về ý nghĩa 
            FillDataGrid(_airConService.GetAllAirCons());
        }
    }
}