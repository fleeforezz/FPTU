using AirConditionerShop.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.DAL.Repositories
{
    public class StaffMemberRepo
    {
        private AirConditionerShopDbContext _db;

        /*
         * Find by email
         */
        public StaffMember? FindByEmail(string email)
        {
            _db = new();
            return _db.StaffMembers.FirstOrDefault(acc => acc.EmailAddress  == email);
        }

        /*
         * Find by email and password
         */
        public StaffMember? FindByEmailAndPassword(string email, string password)
        {
            _db = new();
            return _db.StaffMembers.FirstOrDefault(acc => acc.EmailAddress == email && acc.Password == password);
        }
    }
}
