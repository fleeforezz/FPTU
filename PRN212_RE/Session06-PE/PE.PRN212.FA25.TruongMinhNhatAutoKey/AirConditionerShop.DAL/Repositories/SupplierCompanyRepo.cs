using AirConditionerShop.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.DAL.Repositories
{
    public class SupplierCompanyRepo
    {
        private AirConditionerShopDbautoKeyContext _db;

        /*
         * Get all
         */
        public List<SupplierCompany> GetAll()
        {
            _db = new();
            return _db.SupplierCompanies.ToList();
        }
    }
}
