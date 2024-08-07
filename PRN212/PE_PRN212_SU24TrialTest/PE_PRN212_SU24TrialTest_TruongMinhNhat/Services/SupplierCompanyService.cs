using Repositoriy.Models;
using Repositoriy;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class SupplierCompanyService
    {
        private SupplierCompanyRepository _repository;
        public SupplierCompanyService()
        {
            _repository = new SupplierCompanyRepository();
        }
        public List<SupplierCompany> GetSupplierCompanies()
        {
            return _repository.GetAll();
        }
    }
}
