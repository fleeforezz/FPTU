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

namespace AirConditionerShop_HoangNgocTrinh
{
    /// <summary>
    /// Interaction logic for DetailWindow.xaml
    /// </summary>
    public partial class DetailWindow : Window
    {
        //CLASS DETAIL CẦN ĐẾN 2 SERVICE, SERVICE CHÍNH DÀNH CHO AIR-CON TABLE
        //SERVICE PHỤ DÀNH CHO COMBOBOX, HỘP XỔ XUỐNG, DROPDOWN, LIỆT KÊ TOÀN BỘ NCC
        private AirConService _service = new();
        private SupplierService _sup = new();

        //MÀN HÌNH DETAIL CÓ 2 MODE: MODE EDIT VÀ MODE CREATE
        //MODE CREATE CHỈ LÀ LOAD MÀN HÌNH TRẮNG, CÓ THÊM COMBO CÓ SẴN 5 NCC, MÌNH CHỌN DEFAULT NCC ĐẦU TIÊN
        //MODE EDIT LÀ MÀN HÌNH SẼ ĐC FILL ĐẦY INFO VÀO CÁC Ô TEXT
        //INFO NÀY LẤY TỪ OBJECT SELECTED BÊN MAIN GỬI SANG
        //BÊN MAIN, CÓ BIẾN AirCon select = trỏ sẵn đến cái dòng đc select
        //BÊN MÀN HÌNH NÀY PHẢI TRỎ VÀO BIẾN SELECTED BÊN KIA, TRỎ ĐC THÌ CHẤM TỪNG MIẾNG .ID, .NAME .PRICE ĐỂ ĐỔ VÀO Ô TEXT

        //VẬY BÊN MÀN HÌNH DETAIL TA CẦN KHAI BÁO 1 BIẾN STYLE KIỂU
        //AirCon, ví dụ AirCon x sẽ = selected bên Main
        //Để sờ đc biến x thì x phải là public để ta .x = selected
        //nó là hình thức của hàm Set()
        //DO ĐÓ, BÊN DETAIL NÀY TA KHAI BAÓ 1 PROPERTY KIỂU AIR-CON
        public AirConditioner EditedOne { get; set; }
        //EditedOne là 1 prop hứng cái selected bên Main vì chúng cùng đều là AirCon

        //VÌ ĐÂY LÀ 1 PROP, NÊN KHI NEW MÀN HÌNH DETAIL, NEW CLASS DETAIL MÀ KO NÓI NĂNG GÌ CẢ, THÌ THẰNG NÀY MANG GIÁ TRỊ NULL
        //TỨC LÀ TA ĐANG Ở CREATE MODE

        //CÒN NẾU TA SET NÓ = SELECTED KHI TA NEW, TỨC LÀ TA ĐANG Ở EDIT MODE
        //BIẾN  EDITEDONE CÒN LÀ BIẾN PHẤT CỜ, BIẾN FLAG, DÙNG ĐỂ KIỂM SOÁT STATE, TRẠNG THÁI CỦA OBJECT
        //IF MÀY == NULL, TẠO MỚI
        //IF MÀY == SELECTED  ! NULL, UPDATE 

        //THAY THẾ BIẾN BOOLEAN ĐỂ CHECK CREATE|UPDATE

        public DetailWindow()
        {
            InitializeComponent();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            //1. ĐỔ TOÀN BỘ SUPPLIER VÀO CÁI COMBOBOX
            //2. NẾU LÀ CREATE MODE, KO CẦN LÀM GÌ THÊM, ĐỂ MÀN HÌNH TRẮNG CHO USER GÕ MÁY LANH MỚI
            //3. NẾU LÀ EDIT MODE, THÌ PẢI LÔI CỔ CÁI THẰNG SELECTED Ở BÊN MAIN
            //   ĐEM SANG ĐÂY, LẤY PROP CỦA SELECTED ĐỔ VÀO CÁC Ô TEXT
            //  CÁC Ô TEXT CHẤM . TEXT = "CÁI CẦN ĐỔ"; VÍ DỤ ID, NAME, BẢO HÀNH, GIÁ TIỀN... LÀ NHỮNG INFO CỦA MÁY LẠNH ĐC SELECTED
            // 3.1 PHẢI NHẢY ĐẾN CÁI SUPPLIER TƯƠNG ỨNG CỦA MÁY LẠNH ĐANG EDIT
            //     VÍ DỤ MÁY LẠNH SELECTED ĐANG EDIT THUỘC DÒNG MISUBISHI
            //     Ở VỊ TRÍ THỨ 3, THÌ CÁI COMBOBOX PHẢI HIỂN THỊ SẴN MISUBISH
            //Y CHANG MÌNH Ở TIỀN GIANG, THÌ COMBO PHẢI SHOW TIỀN GIANG
            //TẠO MỚI THÌ SHOW CÁI NÀO CX ĐC, THƯỜNG SHOW CÁI ĐẦU

            //ĐỔ COMBO Y CHANG ĐỔ GRID, ĐỀU LÀ HÀNG CỘt, THẰNG NÀY CHỈ 1 CỘT NHƯNG NHIỀU HÀNG

            SupplierIdComboBox.ItemsSource = _sup.GetAllNCC();
            //MẶC ĐỊNH SHOW HẾT CÁC CỘT, DƯỚI DẠNG TOSTRING() MÀY LÀ OBJECT LOẠI GÌ, VẬY TA CẦN SHOW 1 CỘT HOY, CHỌN 1 CỘT KHÁC ĐỂ LẤY KHOÁ NGOẠI
            //đem tặng cho thằng AirCon
            SupplierIdComboBox.DisplayMemberPath = "SupplierName"; //cột show ra
            SupplierIdComboBox.SelectedValuePath = "SupplierId"; //cột lấy value làm fk

            //ĐỔ CÁC Ô TEXT LẤY VALUE TỪ SELECTED CHUYỂN SANG, NAY ĐANG ĐC TRỎ BỞI EDITEDONE
            //NHỚ ĐIỀN ĐỦ CÁC Ô TEXT ỨNG VỚI CÁC CỘT TRONG TABLE CHÍNH

            //CHECK STATUS: MODE EDIT HAY CREATE
            if (EditedOne == null)
                return;  //= null mode create, thoat ko làm gì cả, show màn hình trắng

            //SỐNG SÓT ĐẾN ĐÂY LÀ EDIT!!!
            AirConditionerIdTextBox.Text = EditedOne.AirConditionerId.ToString();
            AirConditionerNameTextBox.Text = EditedOne.AirConditionerName;
            WarrantyTextBox.Text = EditedOne.Warranty;
            FeatureFunctionTextBox.Text = EditedOne.FeatureFunction;
            QuantityTextBox.Text = EditedOne.Quantity.ToString();
            DollarPriceTextBox.Text = EditedOne.DollarPrice.ToString();
            SoundPressureLevelTextBox.Text = EditedOne.SoundPressureLevel;

            //jump đến đúng cái value của COMBOBOX, VÍ DỤ MÌNH SINH Ở KIÊN GIANG
            //THÌ LÚC EDIT HỒ SƠ MÌNH, DANH SÁCH 63 TỈNH CÓ TỈNH HÀ GIANG ĐẦU BẢNG
            //NHƯNG, PHẢI SET DANH SÁCH ĐANG CHỌN LÀ KIÊN GIANG, DO ĐANG EDIT, THÌ PHẢI SHOW DATA HIỆN CÓ, MÌNH ĐANG CÓ KIÊN GIANG, PHẢI SELECT SẴN KIÊN GIANG CHO MÌNH
            //SUPPLIER Y CHANG, PHẢI NHẢY ĐẾN NCC MÀ THẰNG EDITED ĐANG CÓ!!!
            //MÀN HÌNH NEW THÌ CỨ SET THẰNG ĐẦU TIÊN, MÁY LẠNH MỚI THÌ  CHỦ ĐỘNG CHỌN NCC

            //TODO: TỰ LÀM THỬ, HOẶC XEM YT, HOẶC CHỦ NHẬT LIVE



        }

        private void SaveButton_Click(object sender, RoutedEventArgs e)
        {
            //CHECK COMBOBOX XEM USER CHỌN VÀ MÌNH GET ĐÚNG CÁI ID NCC
            //CHỌN GÌ THÌ NẰM TRONG SELECTED-VALUE
            //MessageBox.Show("BẠN ĐÃ CHỌN MÃ NCC: " + SupplierIdComboBox.SelectedValue);

            //CÁC BƯỚC XỬ LÍ Ở NÚT BẤM NÀY
            //1. TẠO MỚI AIR-CON OBJECT, THU NẠP CÁC INFO TỪ CÁC Ô NHẬP THẢ VÀO OBJECT, HÀM SET AIR-CON
            //2. TUỲ LÀ EDIT HAY CREATE ĐỂ GỌI SERVICE TƯƠNG ỨNG ĐỂ SAVE XUỐNG DB
            //3. ĐÓNG MÀN HÌNH NÀY LẠI
            //4. TRỞ LẠI MÀN HÌNH MAIN VÀ F5 CÁI GRID ĐỂ CÓ ĐC INFO MỚI NHẤT TỪ DB
            //LƯU Ý: CÁI VALIDATION (LƯỢNG ĐIỂM KHA KHÁ)
            //TÍNH VALIDATION RIÊNG CHO CREATE, UPDATE, MẶC DÙ 100% GIỐNG NHAU, NHƯNG KHÁC TÍNH NĂNG
            //VÍ DỤ: QUANTITY LÀ CON SỐ TỪ 100...1000
            //       GÕ CHỮ, GÕ SỐ NẰM NGOÀI BIÊN
            //LƯU Ý: PK - PRIMARY KEY: TRÙNG HAY KO KHI TẠO MỚI
            //       KO CHO EDIT KHI UPDATE

            //AirConditioner obj = new() { AirConditionerId = ???, AirConditionerName = ???};
            //tui ko làm new theo style object initialization, tại sao???
            //vì lấy ô text code nó dài, chưa kể là kiểu số thì phải ép kiểu, nếu gộp gán trị lúc new, code khó theo dõi
            //ta chơi hàm Set() lẻ bên ngoài sau khi new xong cho dễ viết code
            //NÓ NGƯỢC LẠI VỚI LÚC VIẾT CODE TỪ EDITED VÀO Ô TEXT

            AirConditioner obj = new();
            obj.AirConditionerId = int.Parse(AirConditionerIdTextBox.Text);
            obj.AirConditionerName = AirConditionerIdTextBox.Text;
            obj.Warranty = WarrantyTextBox.Text; 
            obj.FeatureFunction = FeatureFunctionTextBox.Text;
            obj.Quantity = int.Parse(QuantityTextBox.Text);
            obj.DollarPrice = double.Parse(DollarPriceTextBox.Text);
            obj.SoundPressureLevel = SoundPressureLevelTextBox.Text;

            obj.SupplierId = SupplierIdComboBox.SelectedValue.ToString();
            //COMBO XỔ XUỐNG CÓ DISPLAY NAME LÀ SHOW NAME, NHƯNG CÓ 
            //SELECTED VALUE PATH -> CỘT ID CỦA NCC
            //KHI USER CHỌN 1 DÒNG TRONG COMBO, THÌ SELECTEDVALUE MANG FK CẦN DÙNG, MANG MÃ SỐ NHÀ CUNG CẤP, VÀ TA ĐEM MÃ SỐ NCC, FK VÀO OBJECT ĐỂ CHUẨN BỊ GỬI XUỐNG DB

            if (EditedOne == null)
                _service.CreateAirCon(obj); 
            else
                _service.UpdateAirCon(obj);

            //đóng cửa sổ này lại
            this.Close(); //mình gọi hàm của class Cha Window
            //this vào cho rõ ràng thêm, hàm của Cha

        }
    }
}
