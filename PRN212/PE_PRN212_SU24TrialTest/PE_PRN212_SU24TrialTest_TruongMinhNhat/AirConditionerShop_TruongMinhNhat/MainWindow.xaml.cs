using Repositoriy.Models;
using Services;
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
using static System.Reflection.Metadata.BlobBuilder;

namespace AirConditionerShop_TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public AirConditionerService _airConditionerService;
        public List<AirConditioner> airConditioners { get; set; }
        public MainWindow()
        {
            _airConditionerService = new AirConditionerService();
            InitializeComponent();
        }

        private void LoadData()
        {
            airConditioners = new List<AirConditioner>();
            airConditioners = _airConditionerService.GetAll();
            if (airConditioners != null)
            {
                AirConditionerDataGrid.ItemsSource = airConditioners;
            }
        }

        private void clearInput()
        {
            AirCondionerIdTextBox.Clear();
            AirConditionerNameTextBox.Clear();
            SupplierIdTextBox.Clear();
            WarrantyTextBox.Clear();
            SoundPressureLevelTextBox.Clear();
            FeatureFunctionTextBox.Clear();
            QuantityTextBox.Clear();
            DollarPriceTextBox.Clear();
        }
        private void ClearButton_Click(object sender, RoutedEventArgs e)
        {
            clearInput();
        }
    }
}