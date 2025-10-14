using Jso.StudentManager.DAL.Entities;
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
    /// Interaction logic for DetailWindow.xaml
    /// </summary>
    public partial class DetailWindow : Window
    {
        // Cửa sổ Detail ~ Class Detail cần 1 biến Student _editedOne để đc set = selected bên MainWindow chuyển sang
        // Nếu bn dùng _backing field thì phải viết thêm hàm Set() để gán value, xài luôn property cho lành cũng đạt mục tiêu code đẹp

        public Student EditOne { get; set; } // _editedOne = ???

        public DetailWindow()
        {
            InitializeComponent();
        }

        private void Grid_Loaded(object sender, RoutedEventArgs e)
        {
            // editedOne: flag variable
            if (EditOne != null)
            {
                // Edit mode
                // Đổ data từ EditedOne lên ô nhập
                TitleLabel.Content = "Edit Student Information";
                IdTextBox.Text = EditOne.Id;
                IdTextBox.IsEnabled = false;
                NameTextBox.Text = EditOne.Name;
                YobTextBox.Text = EditOne.Yob.ToString();
                GpaTextBox.Text = EditOne.Gpa.ToString();
            }
            else
            {
                // New Mode, edited = null, ngu gì mà fill ô nhập, để trống trơn
                TitleLabel.Content = "Create new";
            }
        }

        private void CloseButton_Click(object sender, RoutedEventArgs e)
        {
            Close(); // Hàm của class cha windows, đóng luôn cửa sổ, khác vs .Hide() ẩn mình và show trở lại - Hide() vùng new của sổ còn trong ram, ko show ra mặt
        }

        private void SaveButton_Click(object sender, RoutedEventArgs e)
        {
            // Đề thi yêu cầu phải bắt validation
            // Check xem name có rỗng hay ko, MIN Max
            // Số phải trong khoản nào đó hoặc đoạn nào đó
            // Ngày tháng thì phải trc sau...
            // Chiếm khoản 1-1.5 điểm

            if (CheckVar() == true)
            {
                // Gọi lên save xuống table
                string id, name;
                int yob;
                double gpa;

                id = IdTextBox.Text;
                name = NameTextBox.Text;
                yob = int.Parse(YobTextBox.Text);
                gpa = double.Parse(GpaTextBox.Text);

                MessageBox.Show($"The student info: {id} {name} {yob} {gpa} is saved successfully!!!", "Save status", MessageBoxButton.OK, MessageBoxImage.Information);
            }
        }

        private bool CheckVar()
        {
            if (string.IsNullOrEmpty(NameTextBox.Text))
            {
                MessageBox.Show("Name is required!!", "Invalid input", MessageBoxButton.OK, MessageBoxImage.Stop);
                return false;
            }

            return true;
        }
    }
}
