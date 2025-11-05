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
    public partial class DetailWindow : Window
    {
        // private AirConditioner _editedOne;

        public AirConditioner? EditedOne { get; set; }

        // Cần 2 service bên detail
        // SupplierService dành cho treo đầu dê
        // AirConService dành cho nút [save] -> create, update AirCon
        private AirConService _airConServ = new();
        private SupplierService _supServ = new();

        public DetailWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            // Phải đổ vào combo cả 2 mode
            // Tạo mới cũng chọn, edit cũng chọn ncc
            SupplierComboBox.ItemsSource = _supServ.GetAllSuppliers();
            // Thg grid rất giống datagrid là show nhiều dòng
            // Thg combo show 1 cột
            SupplierComboBox.DisplayMemberPath = "SupplierName";
            SupplierComboBox.SelectedValuePath = "SupplierId";

            // Lưu ý biến EditedOne chính là biến flag biến cờ đánh dấu trạng thái, mode của màn hình này
            // nếu biến này == null, tạo mới, vì ko có selected đc gửi sang
            // Khác null là do đi từ nút bấm [Update], thì có gửi sang selected
            // Mình dùng biến này đẻe biết khi nào create, update khi ấn nút [save] do màn hình này sài chung cho tạo mới và update
            if (EditedOne != null)
            {
                DetailWindowMode.Content = "Edit Airconditioner";
                ACIdTextBox.Text = EditedOne.AirConditionerId.ToString();
                ACIdTextBox.IsEnabled = false;

                ACNameTextBox.Text = EditedOne.AirConditionerName.ToString();
                QuantityTextBox.Text = EditedOne.Quantity.ToString();
                DollarPriceTextBox.Text = EditedOne.DollarPrice.ToString();
                WarrantyTextBox.Text = EditedOne.Warranty;
                SoundPressureLevelTextBox.Text = EditedOne.SoundPressureLevel;
                FeatureFunctionTextBox.Text = EditedOne.FeatureFunction;

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

        private bool CheckVar()
        {
            // Toàn bộ các câu lệnh kiểm tra tính hợp lệ của các ô nhập -> đề thi yêu cầu: ko ô nào đc bỏ trống
            // Name thì từ 5...50 characters, số từ 50...100..
            // Sai cái nào chửi cái đó, return false ngay!!!
            // Check required, ô nhập đã gõ chưa ta dùng hàm is null or whitespace
            if (string.IsNullOrWhiteSpace(ACIdTextBox.Text))
            {
                MessageBox.Show("Id is required!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return false;
            }

            if (string.IsNullOrWhiteSpace(ACNameTextBox.Text))
            {
                MessageBox.Show("Name is required!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return false;
            }

            int len = ACNameTextBox.Text.Length;
            if (len < 5 || len > 50)
            {
                MessageBox.Show("Name must be 5 to 50 characters length!", "Validation", MessageBoxButton.OK, MessageBoxImage.Error);
                return false;
            }

            // ChatGpt: Kiểm tra 1 ô nhập bắt buộc phải là số
            // B1: Đảm bảo nhập số
            // Hàm int.Parse() nguy hiểm -> ném ra ngoài lệ khi nó convert chữ số, Java y chang -> phải try catch
            // int.TryParse() ko ném ngoại lệ, nhưng cách nhập phức tạp hơn xíu
            // B2: Đảm bảo số > MIN và < MAX
            // if (num < 5 || num > 100) thì messageBox

            return true;
        }

        private void SaveButton_Click(object sender, RoutedEventArgs e)
        {
            if (!CheckVar())
            {
                return; // vi phạm nhập dữ liệu -> thoát, ko save
            }

            AirConditioner obj = new() { };
            obj.AirConditionerId = int.Parse(ACIdTextBox.Text);
            obj.AirConditionerName = ACNameTextBox.Text;
            obj.Quantity = int.Parse(QuantityTextBox.Text);
            obj.DollarPrice = int.Parse(DollarPriceTextBox.Text);
            obj.Warranty = WarrantyTextBox.Text;
            obj.SoundPressureLevel = SoundPressureLevelTextBox.Text;
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
