using AirConditionerShop.DAL.Entities;
using AirConditionerShop.DAL.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.BLL.Services
{
    public class AirConService
    {
        //THẰNG NÀY BỊ GUI GỌI, VÌ NÓ CÓ DATA TRONG RAM
        //NÓ ĐI NHỜ VẢ THẰNG REPO LẤY DATA GIÚP
        //NÓ ĐỨNG GIỮA CHUYỀN BANH
        private AirConRepository _repo = new();

        public List<AirConditioner> GetAllMayLanh()
        {
            return _repo.GetAll();
        }

        public void DeleteAirCon(AirConditioner obj)
        {
            _repo.Delete(obj);
        }

        public void UpdateAirCon(AirConditioner obj) => _repo.Update(obj);

        public void CreateAirCon(AirConditioner obj) => _repo.Create(obj);

    }
}
