using Repositories;
using Repositories.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class UserAccountService
    {
        private UserAccountRepository _repository;
        public UserAccountService()
        {
            _repository = new UserAccountRepository();
        }
        public UserAccount? Login(String Email, String Password)
        {
            return _repository.Login(Email, Password);
        }
    }
}
