using Net1814_212_ASM3_SE183605_TruongMinhNhat.Models;
using Net1814_212_ASM3_SE183605_TruongMinhNhat.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

public class AppointmentDetailUpdate
{
    public AppointmentDetailUpdate()
    {
        _repository = new AppointmentDetailRepository();
    }
    private readonly AppointmentDetailRepository _repository;
    private readonly object _lockObject = new object();
    public void Update(AppointmentDetail updateAppointmentDetail)
    {
        //lock (_lockObject)
        Monitor.Enter(_lockObject);
        try
        {
            var prevAppointmentDetail = _repository.getById(updateAppointmentDetail.AppointmentDetailId);
            Console.WriteLine($"{Thread.CurrentThread.Name} - AppointmentDetail name before update: " + prevAppointmentDetail);
            var afterAppointmentDetail = _repository.Update(updateAppointmentDetail);
            Console.WriteLine($"{Thread.CurrentThread.Name} - AppointmentDetail name after update: " + afterAppointmentDetail);

            Console.WriteLine();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message);
        }
        finally
        {
            Monitor.Exit(_lockObject);
        }
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        AppointmentDetailUpdate appointmentDetailUpdate = new AppointmentDetailUpdate();
        var appointmentDetail1 = new AppointmentDetail()
        {
            AppointmentDetailId = 4,
            AppointmentId = 12,
            ServiceId = 40,
            IsPeriodic = true,
            Day = 3,
            Month = 12,
            Year = 2004
        };

        var appointmentDetail2 = new AppointmentDetail()
        {
            AppointmentDetailId = 3,
            AppointmentId = 12,
            ServiceId = 40,
            IsPeriodic = true,
            Day = 24,
            Month = 1,
            Year = 2014
        };

        var appointmentDetail3 = new AppointmentDetail()
        {
            AppointmentDetailId = 2,
            AppointmentId = 12,
            ServiceId = 40,
            IsPeriodic = false,
            Day = 30,
            Month = 3,
            Year = 2024
        };

        var appointmentDetail4 = new AppointmentDetail()
        {
            AppointmentDetailId = 1,
            AppointmentId = 12,
            ServiceId = 40,
            IsPeriodic = false,
            Day = 17,
            Month = 5,
            Year = 2024
        };

        Thread t1 = new Thread(() => appointmentDetailUpdate.Update(appointmentDetail1)) { Name = "Thread #1" };
        Thread t2 = new Thread(() => appointmentDetailUpdate.Update(appointmentDetail2)) { Name = "Thread #2" };
        Thread t3 = new Thread(() => appointmentDetailUpdate.Update(appointmentDetail3)) { Name = "Thread #3" };
        Thread t4 = new Thread(() => appointmentDetailUpdate.Update(appointmentDetail4)) { Name = "Thread #4" };

        t1.Start();
        t2.Start();
        t3.Start();
        t4.Start();

        t1.Join();
        t2.Join();
        t3.Join();
        t4.Join();

        Console.ReadLine();
    }
}
