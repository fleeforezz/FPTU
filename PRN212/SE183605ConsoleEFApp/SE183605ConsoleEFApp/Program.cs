// See https://aka.ms/new-console-template for more information
/*Console.WriteLine("Hello, World!");*/

using SE183605ConsoleEFApp.DAO;
using SE183605ConsoleEFApp.Models;

var _context = new Net1814_212_1_ClinicContext(new Microsoft.EntityFrameworkCore.DbContextOptions<Net1814_212_1_ClinicContext>());

var AppointmentDetail = _context.AppointmentDetails.ToArray();

int choice = 0;

do
{
    Console.WriteLine("\n");
    Console.WriteLine("1. Create");
    Console.WriteLine("2. Read All");
    Console.WriteLine("3. Read all AppointmentDetail where AppointmentDetailId = 43");
    Console.WriteLine("4. Update Month where AppointmentDetailId = 2");
    Console.WriteLine("5. Delete AppointmentDetail where AppointmentDetailId = 30");
    Console.WriteLine("6. ===> Exit");

    Console.Write("Enter choice: ");
    choice = Convert.ToInt32(Console.ReadLine());

    switch (choice)
    {
        case 1:
            // Create
            Console.WriteLine("\n");
            Console.WriteLine("Q1 ########################### Create #############################");
            var createItem = _context.AppointmentDetails.FirstOrDefault(c => c.AppointmentId == 12);
            if (createItem != null)
            {
                createItem = new AppointmentDetail();
                createItem.AppointmentDetailId = 12;
                createItem.AppointmentId = 12;
                createItem.ServiceId = 40;
                createItem.IsPeriodic = false;
                createItem.Day = 56;
                createItem.Month = 32;
                createItem.Year = 2003;

                if (_context.AppointmentDetails.Any(d => d.AppointmentId == 12 && d.ServiceId == 40))
                {
                    Console.WriteLine("\nItems exists");
                }
                else
                {
                    _context.Add(createItem);
                    _context.SaveChanges();
                    Console.WriteLine("\nCreated");
                }
            }
            else
            {
                Console.WriteLine("Create Fail");
            }
            break;

        case 2:
            // Read
            Console.WriteLine("\n");
            Console.WriteLine("Q2 ########################### Select * from <Table> #############################");
            foreach (var item in AppointmentDetail)
            {
                Console.WriteLine("\nAppointment Detail Id: " + item.AppointmentDetailId);
                Console.WriteLine("Appointment Id: " + item.AppointmentId);
                Console.WriteLine("Service Id: " + item.ServiceId);
                Console.WriteLine("Is Perdiodic: " + item.IsPeriodic);
                Console.WriteLine("Day: " + item.Day);
                Console.WriteLine("Month: " + item.Month);
                Console.WriteLine("Year: " + item.Year);
            }
            break;

        case 3:
            // Read with condition
            Console.WriteLine("\n");
            Console.WriteLine("Q3 ################### Select * from AppointmentDetail where AppointmentDetailId = 43 ###################");
            var targetConditionItem = 43;
            var readItem = _context.AppointmentDetails.FirstOrDefault(c => c.AppointmentDetailId == targetConditionItem);
            if (readItem != null && _context.AppointmentDetails.Any(c => c.AppointmentDetailId == targetConditionItem))
            {
                Console.WriteLine("\nAppointment Detail Id: " + readItem.AppointmentDetailId);
                Console.WriteLine("Appointment Id: " + readItem.AppointmentId);
                Console.WriteLine("Service Id: " + readItem.ServiceId);
                Console.WriteLine("Is Perdiodic: " + readItem.IsPeriodic);
                Console.WriteLine("Day: " + readItem.Day);
                Console.WriteLine("Month: " + readItem.Month);
                Console.WriteLine("Year: " + readItem.Year);
            }
            else
            {
                Console.WriteLine("Cannot find any AppointmentDetailId: " +
                    targetConditionItem + 
                    "\n" + 
                    "In table AppointmentDetail");
            }
            break;

        case 4:
            // Update
            Console.WriteLine("\n");
            Console.WriteLine("Q4 ################### Update Month where AppointmentDetailId = 2 #####################");
            var updateItem = _context.AppointmentDetails.FirstOrDefault(c => c.AppointmentDetailId == 2);
            if (updateItem != null)
            {
                if (_context.AppointmentDetails.Any(d => d.Day == 25))
                {
                    Console.WriteLine("\nDay already updated");
                }
                else
                {
                    updateItem.Day = 25;
                    _context.Update(updateItem);
                    _context.SaveChanges();
                    Console.WriteLine("\nRecord updated !");
                }
            }
            else
            {
                Console.WriteLine("Record update Failed !");
            }
            break;

        case 5:
            //Delete
            Console.WriteLine("\n");
            Console.WriteLine("Q5 ###################### Delete AppointmentDetail where AppointmentDetailId = '30' ######################");
            var targetDeleteItem = 12;
            var deleteItem = _context.AppointmentDetails.FirstOrDefault(c => c.AppointmentDetailId == targetDeleteItem);
            if (_context.AppointmentDetails.Any(d => d.AppointmentDetailId == targetDeleteItem))
            {
                _context.Remove(deleteItem);
                _context.SaveChanges();
                Console.WriteLine("\nDelete Success");
            }
            else
            {
                Console.WriteLine("\nCannot find AppointmentDetailId: " + targetDeleteItem);
            }
            break;
    }

} while (choice <= 5);



// DAO
//Console.WriteLine("Call DAO");
//Console.WriteLine("Dao.GetAll()");

//var appointmentDetailDAO = new AppointmentDetailDAO();
//var itemssss = appointmentDetailDAO.GetAll();

//foreach (var appointmentdetailId in AppointmentDetail)
//{
//    Console.WriteLine(appointmentdetailId.AppointmentId);
//}

//Console.WriteLine("DAO.GetById()");

//var appointmentDetailId = appointmentDetailDAO.GetById(30);

//if (AppointmentDetail != null)
//{
//    Console.WriteLine(AppointmentDetail);
//}



