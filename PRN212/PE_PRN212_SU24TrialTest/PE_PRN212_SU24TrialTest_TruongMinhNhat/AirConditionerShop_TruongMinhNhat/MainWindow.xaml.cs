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
        private AirConditionerService _airConditionerService;
        private SupplierCompanyService _supplierCompanyService;
        public List<AirConditioner> airConditioners { get; set; }
        public MainWindow()
        {
            InitializeComponent();
            _airConditionerService = new AirConditionerService();
            _supplierCompanyService = new SupplierCompanyService();
        }

        private void LoadData()
        {
            SupplierId.ItemsSource = _supplierCompanyService.GetSupplierCompanies();
            SupplierName.DisplayMemberPath = "SupplierName";
            Supplier.SelectedValuePath = "SupplierId";
            if (AirConditioner != null)
            {
                var suppliers = _supplierCompanyService.GetSupplierCompanies();
                AirConditionerId.Text = AirConditioner.AirConditionerId.ToString();
                AirConditionerName.Text = AirConditioner.AirConditionerName;
                Warranty.Text = AirConditioner.Warranty;
                SoundPressureLevel.Text = AirConditioner.SoundPressureLevel;
                FeatureFunction.Text = AirConditioner.FeatureFunction;
                Quantity.Text = AirConditioner.Quantity.ToString();
                DollarPrice.Text = AirConditioner.DollarPrice.ToString();
                Supplier.SelectedIndex = suppliers.FindIndex(x => x.SupplierId == AirConditioner.SupplierId);
            }
            else
            {
                Supplier.SelectedIndex = 0;
            }
        }

        private AirConditioner GetAirConditionerFromInput()
        {
            return new AirConditioner
            {
                AirConditionerId = int.Parse(AirCondionerIdTextBox.Text),
                AirConditionerName = AirConditionerNameTextBox.Text,
                SupplierId = SupplierIdTextBox.Text,
                Warranty = WarrantyTextBox.Text,
                SoundPressureLevel = SoundPressureLevelTextBox.Text,
                FeatureFunction = FeatureFunctionTextBox.Text,
                Quantity = int.Parse(QuantityTextBox.Text),
                DollarPrice = int.Parse(DollarPriceTextBox.Text)
            };
        }

        private void AddButton_Click(object sender, RoutedEventArgs e)
        {
            var airConditioner = GetAirConditionerFromInput();
            if (airConditioner != null)
            {
                airConditioners.Add(airConditioner);
                System.Windows.MessageBox.Show("Add Successful");
                LoadData();
                clearInput();
            }
        }

        private void UpdateButton_Click(Object sender, RoutedEventArgs e)
        {
            if (AirConditionerDataGrid.SelectedItems is AirConditioner selectedAirConditioner)
            {
                AirCondionerIdTextBox.Text = selectedAirConditioner.AirConditionerId.ToString();
                AirConditionerNameTextBox.Text = selectedAirConditioner.AirConditionerName.ToString();
                SupplierIdTextBox.Text = selectedAirConditioner.SupplierId.ToString();
                WarrantyTextBox.Text = selectedAirConditioner.Warranty.ToString();
                SoundPressureLevelTextBox.Text = selectedAirConditioner.SoundPressureLevel.ToString();
                FeatureFunctionTextBox.Text = selectedAirConditioner.FeatureFunction.ToString();
                QuantityTextBox.Text = selectedAirConditioner.Quantity.ToString();
                DollarPriceTextBox.Text = selectedAirConditioner.DollarPrice.ToString();
                System.Windows.MessageBox.Show("Update Successful");
                clearInput();
            } 
            else
            {
                System.Windows.MessageBox.Show("Update Fail");
            }
        }

        private void DeleteButton_Click(Object sender, RoutedEventArgs e)
        {
            if (AirConditionerDataGrid.SelectedItems is AirConditioner selectedAirConditioner)
            {
                airConditioners.Remove(selectedAirConditioner);
                clearInput();
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