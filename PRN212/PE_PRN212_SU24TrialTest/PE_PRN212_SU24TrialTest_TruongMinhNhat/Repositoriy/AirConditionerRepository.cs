using Microsoft.EntityFrameworkCore;
using Repositoriy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositoriy
{
    public class AirConditionerRepository
    {
        private AirConditionerShop2024DBContext _context;
        public AirConditionerRepository()
        {
            _context = new AirConditionerShop2024DBContext();
        }
        public List<AirConditioner> getAll()
        {
            return _context.AirConditioners.Include(x => x.Supplier).ToList();
        }
        public void Delete(AirConditioner airConditioner)
        {
            _context.AirConditioners.Remove(airConditioner);
            _context.SaveChanges();
        }
        public void Add(AirConditioner airConditioner)
        {
            _context.AirConditioners.Add(airConditioner);
            _context.SaveChanges();
        }
        public void Update(AirConditioner airConditioner)
        {
            _context.AirConditioners.Update(airConditioner);
            _context.SaveChanges();
        }
        public AirConditioner? GetById(int id)
        {
            return _context.AirConditioners.Find(id);
        }
    }
}
