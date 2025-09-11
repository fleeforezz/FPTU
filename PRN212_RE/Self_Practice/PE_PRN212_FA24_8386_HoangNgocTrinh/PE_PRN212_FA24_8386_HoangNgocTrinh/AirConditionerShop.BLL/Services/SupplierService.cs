using AirConditionerShop.DAL.Entities;
using AirConditionerShop.DAL.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.BLL.Services
{
    public class SupplierService
    {
        //GUI GỌI SERVIC --- REPO  ---- DBCONTEXT
        private SupplierRepository _repo = new();

        public List<SupplierCompany> GetAllNCC()
        {
            return _repo.GetAll();
        }



    }
}
