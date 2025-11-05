using AirConditionerShop.BLL.Services;
using AirConditionerShop.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace AirConditionerShop.TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for Login.xaml
    /// </summary>
    public partial class Login : Window
    {
        private AccountService _service = new();

        public Login()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Lấy email hoặc pass đã nhập gưir cho service giúp 
            string email = EmailTextBox.Text;
            string pass = PasswordTextBox.Text;

            if (string.IsNullOrWhiteSpace(email) || string.IsNullOrWhiteSpace(pass))
            {
                MessageBox.Show("Both email and password are required!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            StaffMember? acc = _service.Authenticate(email, pass);
            if (acc == null)
            {
                MessageBox.Show("Email does not exist, Sign-up please", "Wrong credentials", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (acc.Password != pass)
            {
                MessageBox.Show("Invalidate password, Reset it, please", "Wrong credentials", MessageBoxButton.OK, MessageBoxImage.Error);
                // count++; // Số lần sai
                return;

                // Brute force tấn công dô password
            }
            
            // Phân quyền 1 phần ở đây
            // Nếu là member, ko cho vào App, VÌ đây là app quản lý
            // Staff hoặc Admin mới đc vào
            // bài này mình ko cho manager role 3 vào
            if (acc.Role == 3)
            {
                MessageBox.Show("You have no permission to access", "Wrong credentials", MessageBoxButton.OK, MessageBoxImage.Error);
            }


            MainWindow main = new();
            
            // Gửi role
            main.Role = acc.Role;

            main.Show();
            this.Hide(); // do chạy từ đầu giống như hàm Main
        }
    }
}
