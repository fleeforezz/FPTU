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

namespace Jso.StudentManager
{
    /// <summary>
    /// Interaction logic for LoginWindow.xaml
    /// </summary>
    public partial class LoginWindow : Window
    {
        public LoginWindow()
        {
            InitializeComponent();
        }

        private void LoginButton_Click(object sender, RoutedEventArgs e)
        {

            // Thông bảo thử xem user gõ email gì, pass gì, .Text
            string email = EmailTextBox.Text; // Lấy email user gõ r bỏ vào biến
            string password = PasswordTextBox.Text;

            MessageBox.Show($"Bạn vừa nhập: {email} : {password}");

            string correctEmail = "fleeforezz@gmail.com";
            string correctPassword = "0822863716";

            if (String.Equals(email, correctEmail, StringComparison.OrdinalIgnoreCase) && String.Equals(password, correctPassword, StringComparison.Ordinal)) {
                MainWindow main = new();
                this.Hide(); // Giấu login r mới show main
                main.ShowDialog(); // modal cấm quay về màn hình trc nếu chưa tắt màn hình hiện tại
            } else
            {
                MessageBox.Show("Wrong email or password");
            }
        }

        private void QuitButton_Click(object sender, RoutedEventArgs e)
        {

            // hỏi confirm trc khi thoát, chọn yes để thoát app
            MessageBoxResult anwser = MessageBox.Show("Are you sure?", "Quit", MessageBoxButton.YesNo, MessageBoxImage.Question);

            if (anwser == MessageBoxResult.Yes)
            {
                Application.Current.Shutdown();
            }
        }
    }
}
