using AirConditionerShop.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.DAL.Repositories
{
    public class SupplierRepository
    {
        private AirConditionerShop2024DbContext _context; //ko new, lúc nào dùng thì new

        //lấy tất cả hàng và cột của table SupplierCompany
        //4 cột, 5 dòng
        public List<SupplierCompany> GetAll()
        {
            _context = new();  //viết ngắn
            return _context.SupplierCompanies.ToList();
        }
    }
}
