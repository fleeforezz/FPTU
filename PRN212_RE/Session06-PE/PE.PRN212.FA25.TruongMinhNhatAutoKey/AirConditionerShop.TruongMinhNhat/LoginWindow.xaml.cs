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
    /// Interaction logic for LoginWindow.xaml
    /// </summary>
    public partial class LoginWindow : Window
    {
        StaffMemberService _serv = new();

        private int _retryAttempt = 0;

        public LoginWindow()
        {
            InitializeComponent();
        }

        private void LoginButton_Click(object sender, RoutedEventArgs e)
        {
            // Get from input
            string email = EmailTextBox.Text;
            string password = PasswordTextBox.Text;

            // Check if inputs are valid
            if (string.IsNullOrWhiteSpace(email) || string.IsNullOrWhiteSpace(password))
            {
                MessageBox.Show("Both email and password are required!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Check valid email
            StaffMember? account = _serv.Authenticate(email, password);
            if (account == null)
            {
                _retryAttempt++;
                MessageBox.Show($"Email or password is incorrect! ({_retryAttempt}/3)", "Login Failed", MessageBoxButton.OK, MessageBoxImage.Error);
                if (_retryAttempt >= 3)
                {
                    MessageBox.Show("Too many failed attempts. The application will now close.", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                    Application.Current.Shutdown();
                }
                return;
            }

            // Reset retry counter after successful login
            _retryAttempt = 0;

            // Check valid role
            if (account.Role == 3)
            {
                MessageBox.Show("You have no permission to access", "Wrong credentials", MessageBoxButton.OK, MessageBoxImage.Error);
            }

            MainWindow mainWindow = new();

            // TODO: add send role or validate role

            mainWindow.Show();
            this.Hide();
        }
    }
}
