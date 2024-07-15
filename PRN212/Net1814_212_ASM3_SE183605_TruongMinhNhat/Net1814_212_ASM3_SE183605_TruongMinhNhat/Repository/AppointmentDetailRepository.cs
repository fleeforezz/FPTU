using Net1814_212_ASM3_SE183605_TruongMinhNhat.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net1814_212_ASM3_SE183605_TruongMinhNhat.Repository
{
    public class AppointmentDetailRepository
    {
        Net1814_212_1_ClinicContext _context;
        public AppointmentDetailRepository()
        {
            _context = new Net1814_212_1_ClinicContext();
        }
        public AppointmentDetail? getById(int id)
        {
            var appointmentDetail = _context.AppointmentDetails.Find(id);
            return (appointmentDetail != null) ? appointmentDetail : null;
        }
        public AppointmentDetail Update(AppointmentDetail appointmentDetail)
        {
            var exist = getById(appointmentDetail.AppointmentDetailId);
            exist.AppointmentId = appointmentDetail.AppointmentId;
            exist.ServiceId = appointmentDetail.ServiceId;
            exist.IsPeriodic = appointmentDetail.IsPeriodic;
            exist.Day = appointmentDetail.Day;
            exist.Month = appointmentDetail.Month;
            exist.Year = appointmentDetail.Year;
            _context.AppointmentDetails.Update(exist);
            _context.SaveChanges();
            return exist;
        }
    }
}
