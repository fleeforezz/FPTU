using AirConditionerShop.DAL.Entities;
using AirConditionerShop.DAL.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.BLL.Services
{
    public class StaffMemberService
    {
        private StaffMemberRepo _repo = new();

        /*
         * Auth with email
         */
        public StaffMember? Authenticate(string email)
        {
            return _repo.FindByEmail(email);
        }

        /*
         * Auth with email/password
         */
        public StaffMember? Authenticate(string email, string password)
        {
            return _repo.FindByEmailAndPassword(email, password);
        }
    }
}
