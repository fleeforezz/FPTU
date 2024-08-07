using Repositoriy;
using Repositoriy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class AirConditionerService
    {
        private AirConditionerRepository _airconditionerRepository;
        public AirConditionerService()
        {
            _airconditionerRepository = new AirConditionerRepository();
        }
        public List<AirConditioner> GetAirConditioners()
        {
            return _airconditionerRepository.getAll();
        }
        public void DeleteAirConditioner(AirConditioner airConditioner)
        {
            _airconditionerRepository.Delete(airConditioner);
        }
        public void AddAirConditioner(AirConditioner airConditioner)
        {
            _airconditionerRepository.Add(airConditioner);
        }
        public void UpdateAirConditioner(AirConditioner airConditioner)
        {
            _airconditionerRepository.Update(airConditioner);
        }
        public AirConditioner? GetAirConditionerById(int id)
        {
            return _airconditionerRepository.GetById(id);
        }
    }
}
