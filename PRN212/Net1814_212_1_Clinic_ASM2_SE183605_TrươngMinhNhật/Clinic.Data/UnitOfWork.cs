using Clinic.Data.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clinic.Data
{
    public class UnitOfWork
    {
        private AppointmentDetailRepository _repository;

        public UnitOfWork()
        {
            
        }

        public AppointmentDetailRepository AppointmentDetailRepository
        {
            get
            {
                return _repository ??= new Repository.AppointmentDetailRepository();
            }
        }
    }
}
