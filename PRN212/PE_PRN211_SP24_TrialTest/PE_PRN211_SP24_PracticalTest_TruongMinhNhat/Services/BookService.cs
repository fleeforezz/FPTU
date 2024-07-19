using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Repositories;
using Repositories.Models;

namespace Services
{
    public class BookService
    {
        private BookRepository _bookRepo;
        public BookService()
        {
            _bookRepo = new BookRepository();
        }

        public List<Book> GetAll()
        {
            return _bookRepo.GetAll();
        }
    }
}
