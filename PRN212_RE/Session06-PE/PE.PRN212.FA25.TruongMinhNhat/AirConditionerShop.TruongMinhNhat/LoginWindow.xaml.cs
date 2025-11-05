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

        public LoginWindow()
        {
            InitializeComponent();
        }

        private void LoginButton_Click(object sender, RoutedEventArgs e)
        {
            // Get from input
            string email = EmailTextBox.Text;
            string password = PasswordTextBox.Text;
            int retryAttempt = 0;

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
                MessageBox.Show("Email does not exist!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Check valid password and retry attempt
            if (account.Password != password)
            {
                MessageBox.Show("Password is incorrect! Please try again", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                retryAttempt++;
                return;
            }

            // Hit max retries
            if (retryAttempt > 3)
            {
                MessageBox.Show("Max tries hit (3) times", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

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
