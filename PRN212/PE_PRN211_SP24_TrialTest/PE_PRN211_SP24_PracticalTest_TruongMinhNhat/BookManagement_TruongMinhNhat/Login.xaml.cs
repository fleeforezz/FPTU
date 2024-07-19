using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using Services;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace BookManagement_TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for Login.xaml
    /// </summary>
    public partial class Login : Window
    {
        private UserAccountService _userAccountService;
        public Login()
        {
            _userAccountService = new UserAccountService();
            InitializeComponent();
        }

        private void LoginButton_Click(object sender, RoutedEventArgs e)
        {
            string email = EmailTextBox.Text;
            string password = PasswordBox.Password;
            // Here you would typically validate the login credentials
            // For this example, we'll just check if both fields are filled
            var temp = _userAccountService.Login(email, password);
            if (temp != null && temp.Role == 1)
            {
                MainWindow mainWindow = new MainWindow();
                MessageBox.Show("Login successful!");
                mainWindow.Show();
                this.Close();
            }
            else
            {
                MessageBox.Show("You have no permission to access this function!");
            }
        }
    }
}
