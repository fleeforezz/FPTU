using Repositoriy;
using Repositoriy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class StaffMemberService
    {
        private StaffMemberRepository _repository;
        public StaffMemberService()
        {
            _repository = new StaffMemberRepository();
        }
        public StaffMember? Login(String Email, String Password)
        {
            return _repository.Login(Email, Password);
        }
    }
}
