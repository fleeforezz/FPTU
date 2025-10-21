using System;
using System.Collections.Generic;

namespace Jso.BookManagement.Entities;

public partial class Book
{
    public int BookId { get; set; }

    public string BookName { get; set; } = null!;

    public string Description { get; set; } = null!;

    public DateTime PublicationDate { get; set; }

    public int Quantity { get; set; }

    public double Price { get; set; }

    public string Author { get; set; } = null!;

    public int BookCategoryId { get; set; } // FK trong table, Góc nhìn DB

    // Góc nhìn OOP: Book thuộc cate
    public virtual BookCategory BookCategory { get; set; } = null!;
}
