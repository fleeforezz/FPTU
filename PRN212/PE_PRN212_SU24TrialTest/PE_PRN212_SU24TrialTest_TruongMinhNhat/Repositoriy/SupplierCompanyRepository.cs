using Repositoriy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositoriy
{
    public class SupplierCompanyRepository
    {
        private AirConditionerShop2024DBContext _context;
        public SupplierCompanyRepository()
        {
            _context = new AirConditionerShop2024DBContext();
        }
        public List<SupplierCompany> GetAll()
        {
            return _context.SupplierCompanies.ToList();
        }
    }
}
