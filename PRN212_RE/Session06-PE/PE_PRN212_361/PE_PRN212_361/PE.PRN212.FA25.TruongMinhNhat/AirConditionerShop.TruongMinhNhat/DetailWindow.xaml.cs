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
using AirConditionerShop.BLL.Services;
using AirConditionerShop.DAL.Entities;

namespace AirConditionerShop.TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for CreateWindow.xaml
    /// </summary>
    public partial class CreateWindow : Window
    {
        // private AirConditioner _editedOne;

        public AirConditioner EditedOne { get; set; }

        // Cần 2 service bên detail
        // SupplierService dành cho treo đầu dê
        // AirConService dành cho nút [save] -> create, update AirCon
        private AirConService _airConServ = new();
        private SupplierService _supServ = new();

        public CreateWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEvenArgs e)
        {
            // Phải đổ vào combo cả 2 mode
            // Tạo mới cũng chọn, edit cũng chọn ncc
            SupplierComboBox.ItemsSource = _supServ.GetAllSuppliers();
            // Thg grid rất giống datagrid là show nhiều dòng
            // Thg combo show 1 cột
            SupplierComboBox.DisplayMemberPath = "SupplierName";
            SupplierComboBox.SelectedValuePath = "SupplierId";

            // Lưu ý biến EditedOne chính là biến flagm biến cờ ddaasnh dấu trạng thái, mode của màn hình này
            // nếu biến này == null, tạo mới, vì ko có selected đc gửi sang
            // Khác null là do đi từ nút bấm [Update], thì có gửi sang selected
            // Mình dùng biến này đẻe biết khi nào create, update khi ấn nút [save] do màn hình này sài chung cho tạo mới và update
            if (EditedOne != null)
            {
                DetailWindowMode.Content = "Edit Airconditioner";
                AirconditionerIdTextBox.Text = EditedOne.AirconditionerIdTextBox.ToString();
                AirConditionerIdTextBox.IsEnable = false;

                AirConditionerNameTextBox.Text = EditedOne.AirConditionerNameTextBox.ToString();
                QuantityTextBox.Text = EditedOne.QuantityTextBox.ToString();
                DollarTextBox.Text = EditedOne.DollarTextBox.ToString();
                WarrantyTextBox.Text = EditedOne.WarrantyTextBox;
                SoundPressureTextBox.Text = EditedOne.SoundPressureTextBox;
                FeatureFunctionTextBox.Text = EditedOne.FeatureFunctionTextBox;

                // Nhảy đến đúng supplier mà sản phẩm thuộc về
                SupplierComboBox.SelectedValue = EditedOne.SupplierId;

                // Còn cái FK, ko show FK vào ô text, mà show qua treo đầu dê bán thịt heo
                // Vì category, hay nhà sản xuất , nhà cung cấp là 1 bảng khác
            }
            else
            {
                DetailWindowMode.Content = "Create new Airconditioner";
            }

        }

        private void SaveButton_Click(object sender, RoutedEvenArgs e)
        {
            AirConditioner obj = new() { };
            obj.AirConditionerId = int.Parse(AirconditionerIdTextBox);
            obj.AirConditionerName = AirconditionerNameTextBox.Text;
            obj.Quantity = int.Parse(QuantityTextBox);
            obj.DollarPrice = int.Parse(DollarTextBox);
            obj.Warranty = WarrantyTextBox.Text;
            obj.SoundPressureLevel = SoundPressureTextBox.Text;
            obj.FeatureFunction = FeatureFunctionTextBox.Text;

            // 
            obj.SupplierId = (string)SupplierComboBox.SelectedValue;

            if (EditedOne == null)
            {
                _airConServ.CreateAirCon(obj);
            }
            else
            {
                _airConServ.UpdateAirCon(obj);
            }

            this.Close();
        }
    }
}
