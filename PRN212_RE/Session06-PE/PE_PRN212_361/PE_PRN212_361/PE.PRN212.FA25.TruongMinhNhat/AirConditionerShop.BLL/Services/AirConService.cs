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
        private AirConRepo _repo = new AirConRepo(); // new lun, vì DbContext đã đc new và kiểm soát bởi bên trong repo


        // Get All AirConditioners
        public List<AirConditioner> GetAllAirCons()
        {
            return _repo.GetAll();
        }

        // Create new AirConditioner
        public void CreateAirCon(AirConditioner obj)
        {
            _repo.Create(obj);
        }

        // Update an AirConditioner
        public void UpdateAirCon(AirConditioner obj)
        {

        }

        // Delete an AirConditioner
        public void DeleteAirCon(AirConditioner obj)
        {
            _repo.Delete(obj);
        }

        // Search AirConditions By Id

        // Gọi MOMO, FIREBASE, Tìm VOUCHER
        // Tính toán các If else của business rule
    }
}
