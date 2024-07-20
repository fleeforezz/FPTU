using Services;
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

namespace AirConditionerShop_TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for Login.xaml
    /// </summary>
    public partial class Login : Window
    {
        private StaffMemberService _userAccountService;
        public Login()
        {
            _userAccountService = new StaffMemberService();
            InitializeComponent();
        }

        private void LoginButton_Click(object sender, RoutedEventArgs e)
        {
            string email = EmailTextBox.Text;
            string password = PasswordBox.Password;

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
