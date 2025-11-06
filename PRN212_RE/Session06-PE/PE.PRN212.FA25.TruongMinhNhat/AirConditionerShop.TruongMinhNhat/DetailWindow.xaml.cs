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
    /// Interaction logic for DetailWindow.xaml
    /// </summary>
    public partial class DetailWindow : Window
    {

        // Screen mode (to detect with screen mode update mode or create new mode)
        public AirConditioner? EditedOne { get; set; }

        private AirConditionerService _acService = new();
        private SupplierCompanyService _supService = new();

        public DetailWindow()
        {
            InitializeComponent();
        }

        /*
         * On window load event
         */
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            SupplierComboBox.ItemsSource = _supService.GetAllSupplierCompanies();

            SupplierComboBox.DisplayMemberPath = "SupplierName";
            SupplierComboBox.SelectedValuePath = "SupplierId";

            // If not null then switch to update mode
            if (EditedOne != null)
            {
                DetailWindowMode.Content = "Update Air Conditioner";

                ACIdTextBox.Text = EditedOne.AirConditionerId.ToString();
                ACIdTextBox.IsEnabled = false; // Readonly mode

                ACNameTextBox.Text = EditedOne.AirConditionerName.ToString();
                QuantityTextBox.Text = EditedOne.Quantity.ToString();
                DollarPriceTextBox.Text = EditedOne.DollarPrice.ToString();
                WarrantyTextBox.Text = EditedOne.Warranty;
                SoundPressureLevelTextBox.Text = EditedOne.SoundPressureLevel;
                FeatureFunctionTextBox.Text = EditedOne.FeatureFunction;

                SupplierComboBox.SelectedValue = EditedOne.SupplierId;
            }
            else
            {
                DetailWindowMode.Content = "Create new Air Conditioner";
            }
        }

        /*
         * Validation check
         */
        private bool ValidCheck()
        {
            // Id must not empty
            if (string.IsNullOrWhiteSpace(ACIdTextBox.Text))
            {
                MessageBox.Show("Id is required!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return false;
            }

            // Name must not empty
            if (string.IsNullOrEmpty(ACNameTextBox.Text))
            {
                MessageBox.Show("Name is required!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return false;
            }

            // Name must be from 5 to 50 characters lenght
            int length = ACNameTextBox.Text.Length;
            if (length < 5 || length > 50)
            {
                MessageBox.Show("Name must be 5 to 50 characters length!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return false;
            }

            return true;
        }

        /*
         * Save button event
         */
        private void SaveButton_Click(object sender, RoutedEventArgs e)
        {
            if (!ValidCheck())
            {
                return;
            }

            AirConditioner ac = new() { };
            ac.AirConditionerId = int.Parse(ACIdTextBox.Text);
            ac.AirConditionerName = ACNameTextBox.Text;
            ac.Quantity = int.Parse(QuantityTextBox.Text);
            ac.DollarPrice = int.Parse(DollarPriceTextBox.Text);
            ac.Warranty = WarrantyTextBox.Text;
            ac.SoundPressureLevel = SoundPressureLevelTextBox.Text;
            ac.FeatureFunction = FeatureFunctionTextBox.Text;

            ac.SupplierId = (string)SupplierComboBox.SelectedValue;

            if (EditedOne == null)
            {
                _acService.CreateAirConditioner(ac);
            }
            else
            {
                _acService.UpdateAirConditioner(ac);
            }
        }

        /*
         * Quit button event
         */
        private void Button_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
