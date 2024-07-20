using Repositories.Models;
using Services;
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

namespace BookManagement_TruongMinhNhat
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public BookService _bookService;
        public List<Book> Books { get; set; }

        public MainWindow()
        {
            _bookService = new BookService();
            InitializeComponent();
            LoadData();
        }

        private void LoadData()
        {
            Books = new List<Book>();
            Books = _bookService.GetAll();
            if (Books != null)
            {
                BooksDataGrid.ItemsSource = Books;
            }
        }

        private Book GetBookFromInput()
        {
            return new Book
            {
                BookId = int.Parse(BookIdTextBox.Text),
                BookCategoryId = int.Parse(CategoryIdTextBox.Text),
                BookName = BookNameTextBox.Text,
                Description = DescriptionTextBox.Text,
                PublicationDate = DateTime.Now,
                Quantity = int.Parse(QuantityTextBox.Text),
                Price = int.Parse(PriceTextBox.Text),
                Author = AuthorTextBox.Text
            };
        }

        private void clearInput()
        {
            BookIdTextBox.Clear();
            CategoryIdTextBox.Clear();
            BookNameTextBox.Clear();
            DescriptionTextBox.Clear();
            PublicationDatePicker.SelectedDate = null;
            QuantityTextBox.Clear();
            PriceTextBox.Clear();
            AuthorTextBox.Clear();
        }

        private void AddButton_Click(object sender, RoutedEventArgs e)
        {
            var book = GetBookFromInput();
            if (book != null && (book.Price >= 0 && book.Price < 4000000))
            {
                Books.Add(book);
                MessageBox.Show("Add Successful");
                clearInput();
            }
        }

        private void UpdateButton_Click(Object sender, RoutedEventArgs e)
        {
            if (BooksDataGrid.SelectedItems is Book selectedBook)
            {
                BookIdTextBox.Text = selectedBook.BookId.ToString();
                CategoryIdTextBox.Text = selectedBook.BookCategory.ToString();
                BookNameTextBox.Text = selectedBook.BookName.ToString();
                DescriptionTextBox.Text = selectedBook.Description.ToString();
                PublicationDatePicker.Text = selectedBook.PublicationDate.ToString();
                QuantityTextBox.Text = selectedBook.Quantity.ToString();
                PriceTextBox .Text = selectedBook.Price.ToString();
                AuthorTextBox .Text = selectedBook.Author.ToString();
                MessageBox.Show("Update Successful");
                clearInput();
            } 
            else
            {
                MessageBox.Show("Update Fail");
            }
        }

        private void DeleteButton_Click(Object sender, RoutedEventArgs e)
        {
            if (BooksDataGrid.SelectedItems is Book selectedBook)
            {
                Books.Remove(selectedBook);
                clearInput();
            }
        }

        private void ClearButton_Click(object sender, RoutedEventArgs e)
        {
            clearInput();
        }
    }
}