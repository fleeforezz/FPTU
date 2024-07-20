using Repositoriy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositoriy
{
    public class StaffMemberRepository
    {
        private AirConditionerShop2024DBContext _context;
        public StaffMemberRepository()
        {
            _context = new AirConditionerShop2024DBContext();
        }
        public StaffMember? Login(String Email, String Password)
        {
            return _context.StaffMembers.Where(x => x.EmailAddress == Email && x.Password == Password).FirstOrDefault();
        }
    }
}
