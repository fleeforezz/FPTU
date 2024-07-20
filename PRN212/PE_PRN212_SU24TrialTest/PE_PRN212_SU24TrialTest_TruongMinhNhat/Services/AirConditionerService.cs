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

        public List<AirConditioner> GetAll()
        {
            return _airconditionerRepository.GetAll();
        }
    }
}
