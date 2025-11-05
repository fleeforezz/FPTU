using AirConditionerShop.BLL.Services;
using AirConditionerShop.DAL.Entities;
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

namespace AirConditionerShop.TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public int? Role { get; set; }
        private AirConditionerService _acService = new();

        public MainWindow()
        {
            InitializeComponent();
        }

        /*
         * Load data to DataGrid
         */
        private void ACDataGrid_Loaded(object sender, RoutedEventArgs e)
        {
            ACDataGrid.ItemsSource = _acService.GetAllAirConditioners();

            if (Role == 2)
            {
                CreateButton.IsEnabled = false;
                UpdateButton.IsEnabled = false;
                DeleteButton.IsEnabled = false;
            }
        }

        /*
         * Auto refresh the DataGrid
         */
        public void FillDataGrid(List<AirConditioner> airConditioners)
        {
            ACDataGrid.ItemsSource = airConditioners;
        }

        /*
         * Create button event
         */
        private void CreateButton_Click(object sender, RoutedEventArgs e)
        {
            DetailWindow detailWindow = new();
            detailWindow.ShowDialog();

            FillDataGrid(_acService.GetAllAirConditioners());
        }

        /*
         * Update button event
         */
        private void UpdateButton_Click(object sender, RoutedEventArgs e)
        {

        }

        /*
         * Delete button event
         */
        private void DeleteButton_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}