using Repositories.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class UserAccountRepository
    {
        private BookManagementDbContext _context;
        public UserAccountRepository()
        {
            _context = new BookManagementDbContext();
        }
        public UserAccount? Login(String Email, String Password)
        {
            return _context.UserAccounts.Where(x => x.Email == Email && x.Password == Password).FirstOrDefault();
        }
    }
}
