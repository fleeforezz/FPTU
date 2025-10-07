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
            //MainWindow main = new();
            //for (int i = 1; i <= 20; i++)
            //{
            //    MainWindow main = new();
            //    main.Show();
            //}

            MainWindow main = new();
            //main.Show();
            this.Hide(); // Giấu login r mới show main
            main.ShowDialog(); // modal cấm quay về màn hình trc nếu chưa tắt màn hình hiện tại
            
        }
    }
}
