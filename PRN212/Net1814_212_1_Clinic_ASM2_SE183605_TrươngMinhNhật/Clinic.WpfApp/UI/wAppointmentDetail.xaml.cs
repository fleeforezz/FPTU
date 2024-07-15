using Clinic.Business;
using Clinic.Data.Models;
//using System;
//using System.Collections.Generic;
using System.IO;
//using System.Linq;
//using System.Text;
using System.Text.Json;
//using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
//using System.Windows.Data;
//using System.Windows.Documents;
//using System.Windows.Input;
//using System.Windows.Media;
//using System.Windows.Media.Imaging;
//using System.Windows.Shapes;
//using System.Xml;
//using System.Xml.Linq;
using System.Xml.Serialization;

namespace Clinic.WpfApp.UI
{
    /// <summary>
    /// Interaction logic for wAppointmentDetail.xaml
    /// </summary>
    public partial class wAppointmentDetail : Window
    {
        private readonly IAppointmentDetailBusiness _appointmentDetailBusiness;
        private List<AppointmentDetail> _appointmentDetailList;
        private const string JSONfilepath = "AppointmentDetailJSON.json";
        private const string XMLfilepath = "AppointmentDetailXML.XML";
        public wAppointmentDetail()
        {
            InitializeComponent();
            _appointmentDetailBusiness = new AppointmentDetailBusiness();
            _appointmentDetailList = new List<AppointmentDetail>();
            GetAllData();
        }

        //######################### Delete Button #########################\\
        private async void ButtonDelete_Click(object sender, RoutedEventArgs e)
        {
            AppointmentDetail appointmentDetail = AppointmentDetailList.SelectedItem as AppointmentDetail;
            if (appointmentDetail == null)
            {
                MessageBox.Show("AppointmentDetailID not found", "Warning");
                return;
            }

            var result = await _appointmentDetailBusiness.DeleteById(appointmentDetail.AppointmentDetailId);
            MessageBox.Show(result.Message, "Delete");
            GetAllData();
        }

        //######################### Cancel Button #########################\\
        private void ButtonCancel_Click(object sender, RoutedEventArgs e)
        {
            AppointmentDetailId.Text = string.Empty;
            AppointmentId.Text = string.Empty;
            ServiceId.Text = string.Empty;
            IsPeriodic.Text = string.Empty;
            Day.Text = string.Empty;
            Month.Text = string.Empty;
            Year.Text = string.Empty;
        }

        //######################### Select Button #########################\\
        private void ButtonSelect_Click(object sender, RoutedEventArgs e)
        {
            AppointmentDetail appointmentDetail = AppointmentDetailList.SelectedItem as AppointmentDetail;
            AppointmentDetailId.Text = appointmentDetail.AppointmentDetailId.ToString();
            AppointmentId.Text = appointmentDetail.AppointmentId.ToString();
            ServiceId.Text = appointmentDetail.ServiceId.ToString();
            IsPeriodic.Text = appointmentDetail.IsPeriodic.ToString();
            Day.Text = appointmentDetail.Day.ToString();
            Month.Text = appointmentDetail.Month.ToString();
            Year.Text = appointmentDetail.Year.ToString();
        }

        //######################### Update Button #########################\\
        private async void ButtonUpdate_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                var appointmentDetailUpdate = new AppointmentDetail()
                {
                    AppointmentDetailId = Int32.Parse(AppointmentDetailId.Text),
                    AppointmentId = Int32.Parse(AppointmentId.Text),
                    ServiceId = Int32.Parse(ServiceId.Text),
                    IsPeriodic = Boolean.Parse(IsPeriodic.Text),
                    Day = Int32.Parse(Day.Text),
                    Month = Int32.Parse(Month.Text),
                    Year = Int32.Parse(Year.Text),
                };

                var existingAppointmentDetail = await _appointmentDetailBusiness.GetById(appointmentDetailUpdate.AppointmentDetailId);
                var appointmentDetail = existingAppointmentDetail.Data as AppointmentDetail;
                if (existingAppointmentDetail.Data == null)
                {
                    System.Windows.MessageBox.Show("Appointemnt Detail ID doesn't exist", "Warning");
                    return;
                }
                var temp = await _appointmentDetailBusiness.GetById(appointmentDetailUpdate.AppointmentId);
                if (temp.Data == null)
                {
                    System.Windows.MessageBox.Show("Appointment ID doesn't exist", "Warning");
                    return;
                }
                temp = await _appointmentDetailBusiness.GetById(appointmentDetailUpdate.ServiceId);
                if (temp.Data == null)
                {
                    System.Windows.MessageBox.Show("Service ID doesn't exist", "Warning");
                    return;
                }

                //update
                appointmentDetail.AppointmentDetailId = appointmentDetailUpdate.AppointmentDetailId;
                appointmentDetail.AppointmentId = appointmentDetailUpdate.AppointmentId;
                appointmentDetail.ServiceId = appointmentDetailUpdate.ServiceId;
                appointmentDetail.IsPeriodic = appointmentDetailUpdate.IsPeriodic;
                appointmentDetail.Day = appointmentDetailUpdate.Day;
                appointmentDetail.Month = appointmentDetailUpdate.Month;
                appointmentDetail.Year = appointmentDetailUpdate.Year;

                var result = await _appointmentDetailBusiness.Update(appointmentDetail);
                System.Windows.MessageBox.Show(result.Message, "Update");

                //reset text box
                AppointmentDetailId.Text = string.Empty;
                AppointmentId.Text = string.Empty;
                ServiceId.Text = string.Empty;
                IsPeriodic.Text = string.Empty;
                Day.Text = string.Empty;
                Month.Text = string.Empty;
                Year.Text = string.Empty;
                GetAllData();
            }
            catch (Exception ex)
            {
                System.Windows.MessageBox.Show($"{ex.Message}", "Error");
            }
        }

        private void ClearInputs()
        {
            AppointmentDetailId.Text = "";
            AppointmentId.Text = "";
            ServiceId.Text = "";
            IsPeriodic.Text = "";
            Day.Text = "";
            Month.Text = "";
            Year.Text = "";
        }


        //######################### Add Button #########################\\
        private void btnAdd_Click(object sender, RoutedEventArgs e)
        {
            var appointmentDetail = new AppointmentDetail
            {
                AppointmentDetailId = Int32.Parse(AppointmentDetailId.Text),
                AppointmentId = Int32.Parse(AppointmentId.Text),
                ServiceId = Int32.Parse(ServiceId.Text),
                IsPeriodic = Boolean.Parse(IsPeriodic.Text),
                Day = Int32.Parse(Day.Text),
                Month = Int32.Parse(Month.Text),
                Year = Int32.Parse(Year.Text)
            };

            _appointmentDetailList.Add(appointmentDetail);
            AppointmentDetailList.Items.Refresh();
            ClearInputs();
        }



        //######################### SaveJSON Button #########################\\
        private async void btnSaveJSON_Click(object sender, RoutedEventArgs e)
        {
            var result = _appointmentDetailList;
            if (result.Count > 0)
            {
                var appointmentDetails = result as List<AppointmentDetail>;
                var json = JsonSerializer.Serialize(appointmentDetails);
                File.WriteAllText(JSONfilepath, json);
                MessageBox.Show("Saved successfully", "Save JSON");
            }
            else
            {
                MessageBox.Show("No services to save", "Save JSON");
            }
        }

        //######################### LoadJSON Button #########################\\
        private void btnLoadJSON_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (File.Exists(JSONfilepath))
                {
                    string json = File.ReadAllText(JSONfilepath);
                    _appointmentDetailList = JsonSerializer.Deserialize<List<AppointmentDetail>>(json);
                    AppointmentDetailList.ItemsSource = _appointmentDetailList;
                    MessageBox.Show("Load successfully", "Load JSON");
                }
                else
                {
                    MessageBox.Show("JSON file not found", "Load JSON");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString(), "Error");
            }
        }

        //######################### SaveXML Button #########################\\
        private void btnSaveXML_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (_appointmentDetailList.Count > 0)
                {

                    XmlSerializer serializer = new XmlSerializer(typeof(List<AppointmentDetail>), new XmlRootAttribute("AppointmentDetails"));
                    using (FileStream f = File.Create(XMLfilepath))
                    {
                        serializer.Serialize(f, _appointmentDetailList);
                        MessageBox.Show("AppointmentDetail saved to XML file successfully!");
                    }

                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error saving XML file: {ex.Message}");
            }
        }

        //######################### LoadXML Button #########################\\
        private void btnLoadXML_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (File.Exists(XMLfilepath))
                {
                    XmlSerializer serializer = new XmlSerializer(typeof(List<AppointmentDetail>), new XmlRootAttribute("AppointmentDetails"));
                    using FileStream xmlLoad = File.Open(XMLfilepath, FileMode.Open);
                    var loadedAppointmentDetail = (List<AppointmentDetail>)serializer.Deserialize(xmlLoad);
                    _appointmentDetailList = loadedAppointmentDetail;
                    AppointmentDetailList.ItemsSource = _appointmentDetailList;
                    MessageBox.Show("AppointmentDetails loaded from XML file successfully!");
                }
                else
                {
                    MessageBox.Show("XML File Not Found!");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error loading XML file: {ex.Message}");
            }
        }

        //######################### Get All Data #########################\\
        private async void GetAllData()
        {
            var result = await _appointmentDetailBusiness.GetAll();

            if (result.Status > 0 && result.Data != null)
            {
                AppointmentDetailList.ItemsSource = result.Data as List<AppointmentDetail>;
            }
            else
            {
                AppointmentDetailList.ItemsSource = new List<AppointmentDetail>();
            }
        }

        private void AppointmentDetailList_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void txtInput_TextChanged(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(AppointmentDetailId.Text))
            {
                tbPlaceholder1.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder1.Visibility = Visibility.Hidden;
            }

            if (string.IsNullOrEmpty(AppointmentId.Text))
            {
                tbPlaceholder2.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder2.Visibility = Visibility.Hidden;
            }

            if (string.IsNullOrEmpty(ServiceId.Text))
            {
                tbPlaceholder3.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder3.Visibility = Visibility.Hidden;
            }

            if (string.IsNullOrEmpty(IsPeriodic.Text))
            {
                tbPlaceholder4.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder4.Visibility = Visibility.Hidden;
            }

            if (string.IsNullOrEmpty(Day.Text))
            {
                tbPlaceholder5.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder5.Visibility = Visibility.Hidden;
            }

            if (string.IsNullOrEmpty(Month.Text))
            {
                tbPlaceholder6.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder6.Visibility = Visibility.Hidden;
            }

            if (string.IsNullOrEmpty(Year.Text))
            {
                tbPlaceholder7.Visibility = Visibility.Visible;
            }
            else
            {
                tbPlaceholder7.Visibility = Visibility.Hidden;
            }
        }
    }
}
