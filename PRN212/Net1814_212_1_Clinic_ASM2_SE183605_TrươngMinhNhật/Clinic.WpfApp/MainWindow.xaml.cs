using Clinic.Data.Models;
using Clinic.WpfApp.UI;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Clinic.WpfApp
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Open_wAppointmentDetail_Click(object sender, RoutedEventArgs e)
        {
            var p = new wAppointmentDetail();
            p.Owner = this;
            p.Show();
        }

        //private void txtInput_TextChanged(object sender, EventArgs e)
        //{
        //    if (string.IsNullOrEmpty(Search.Text))
        //    {
        //        tbPlaceholder.Visibility = Visibility.Visible;
        //    }
        //    else
        //    {
        //        tbPlaceholder.Visibility = Visibility.Hidden;
        //    }
        //}
    }
}