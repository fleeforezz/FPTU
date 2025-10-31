using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AirConditionerShop.DAL.Entities;

namespace AirConditionerShop.DAL.Repositories
{
    public class SupplierRepo
    {
        private AirConditionerShopDbContext _db;

        // CRUD Thêm xóa sửa tìm kiếm nhà cung cấp
        public List<SupplierCompany> GetAll()
        {
            _db = new();
            return _db.SupplierCompanies.ToList();
        }
    }
}
