using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Text;
using System.Threading.Tasks;
using AirConditionerShop.DAL.Entities;

namespace AirConditionerShop.DAL.Repositories
{
    public class AccountRepo
    {
        private AirConditionerShopDbContext _db;

        // ko viết các hàm CRUD vì ko đủ thgian cho PE, SWP làm đủ
        // Đừng quên cái _bag của DB context chứa full data của table staffmember - account 

        public StaffMember? FindByEmail(string email)
        {
            _db = new();
            return _db.StaffMembers.FirstOrDefault(nt => nt.EmailAddress == email);
        }
        
        public StaffMember FindByEmailAndPassword(string email, string password)
        {
            _db = new();
            return _db.StaffMembers.FirstOrDefault(nt => nt.EmailAddress == email && nt.Password == password);
        }
    }
}
