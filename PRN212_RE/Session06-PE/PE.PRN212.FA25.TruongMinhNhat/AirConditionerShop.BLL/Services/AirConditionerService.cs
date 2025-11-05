using AirConditionerShop.DAL.Entities;
using AirConditionerShop.DAL.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.BLL.Services
{
    public class AirConditionerService
    {
        private AirConditionerRepo _repo = new();

        /*
         * Get All ACs
         */
        public List<AirConditioner> GetAllAirConditioners()
        {
            return _repo.GetAll();
        }

        /*
         * Create AC
         */
        public void CreateAirConditioner(AirConditioner airConditioner)
        {
            _repo.Create(airConditioner);
        }

        /*
         * Update AC
         */
        public void UpdateAirConditioner(AirConditioner airConditioner)
        {
            _repo.Update(airConditioner);
        }

        /*
         * Delete AC
         */
        public void DeleteAirConditioner(AirConditioner airConditioner)
        {
            _repo.Delete(airConditioner);
        }
    }
}
