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

            StudentListDataGrid.ItemsSource = join_bag;
        }

        private void Create_Button_Click(object sender, RoutedEventArgs e)
        {
            Prn212BookStoreContext ctx = new();

            Book newBook = new Book()
            {
                BookId = 100,
                BookName = "Test",
                Description = "Book Descrition",
                PublicationDate = DateTime.Now,
                Quantity = 1,
                Price = 1000,
                Author = "Jso",
                BookCategoryId = 1,
            };

            var book = ctx.Books.FirstOrDefault(b => b.BookId == newBook.BookId);
            if (book == null)
            {
                ctx.Books.Add(newBook);
                ctx.SaveChanges();

                MessageBox.Show("A book has been added successfully");

                // F5, để refresh lại grid để cập nhật thông tin mới
                ctx = new();
                List<Book> join_bag = ctx.Books.Include("BookCategory").ToList();
                StudentListDataGrid.ItemsSource = join_bag;
            }
            else
            {
                MessageBox.Show($"Book with id already exist: BookID({newBook.BookId})");
            }
        }

        private void Update_Button_Click(object sender, RoutedEventArgs e)
        {
            Prn212BookStoreContext ctx = new();

            Book? selected = StudentListDataGrid.SelectedItem as Book;

            if (selected == null)
            {
                MessageBox.Show("Please select a book in order to update");
                return;
            }

            selected.BookName = "Harry Potter";
            selected.Author = "Jso";
            ctx.Books.Update(selected);

            ctx = new();
            List<Book> join_bag = ctx.Books.Include("BookCategory").ToList();
            StudentListDataGrid.ItemsSource = join_bag;
        }

        private void Delete_Button_Click(object sender, RoutedEventArgs e)
        {
            Prn212BookStoreContext ctx = new();

            Book? selected = StudentListDataGrid.SelectedItem as Book;

            if (selected != null)
            {
                ctx.Books.Remove(selected);
                ctx.SaveChanges();

                MessageBox.Show("Delete success");

                // F5, để refresh lại grid để cập nhật thông tin mới
                ctx = new();
                List<Book> join_bag = ctx.Books.Include("BookCategory").ToList();
                StudentListDataGrid.ItemsSource = join_bag;
            }
            else
            {
                MessageBox.Show("Please select a book in order to update");
            }
        }
    }
}