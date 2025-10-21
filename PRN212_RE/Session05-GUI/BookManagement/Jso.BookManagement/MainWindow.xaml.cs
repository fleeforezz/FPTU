using Jso.BookManagement.Entities;
using Microsoft.EntityFrameworkCore;
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

namespace Jso.BookManagement
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

        private void StudentListDataGrid_Loaded(object sender, RoutedEventArgs e)
        {
            Prn212BookStoreContext ctx = new();

            List<Book> bag = ctx.Books.ToList();

            List<Book> join_bag = ctx.Books.Include("BookCategory").ToList();

            StudentListDataGrid.ItemsSource = bag;
        }
    }
}