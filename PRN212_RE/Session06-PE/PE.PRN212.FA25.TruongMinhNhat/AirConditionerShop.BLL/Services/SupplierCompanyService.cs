using AirConditionerShop.DAL.Entities;
using AirConditionerShop.DAL.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.BLL.Services
{
    public class SupplierCompanyService
    {
        private SupplierCompanyRepo _repo = new();

        /*
         * Get all suppliers
         */
        public List<SupplierCompany> GetAllSupplierCompanies()
        {
            return _repo.GetAll();
        }
    }
}
