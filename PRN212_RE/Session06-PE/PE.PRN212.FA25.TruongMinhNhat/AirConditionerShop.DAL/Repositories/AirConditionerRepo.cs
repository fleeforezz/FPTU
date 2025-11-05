using AirConditionerShop.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.DAL.Repositories
{
    public class AirConditionerRepo
    {
        private AirConditionerShopDbContext _db;

        /*
         * Get All 
         */
        public List<AirConditioner> GetAll()
        {
            _db = new AirConditionerShopDbContext();
            return _db.AirConditioners.ToList();
        }

        /*
         * Create
         */
        public void Create(AirConditioner airConditioner)
        {
            _db = new AirConditionerShopDbContext();
            _db.AirConditioners.Add(airConditioner);
            _db.SaveChanges();
        }

        /*
         * Update
         */
        public void Update(AirConditioner airConditioner)
        {
            _db = new AirConditionerShopDbContext();
            var existAC = _db.AirConditioners.FirstOrDefault(a => a.AirConditionerId == airConditioner.AirConditionerId);

            if (existAC  != null)
            {
                existAC.AirConditionerName = airConditioner.AirConditionerName;
                existAC.Warranty = airConditioner.Warranty;
                existAC.SoundPressureLevel = airConditioner.SoundPressureLevel;
                existAC.FeatureFunction = airConditioner.FeatureFunction;
                existAC.Quantity = airConditioner.Quantity;
                existAC.DollarPrice = airConditioner.DollarPrice;

                _db.AirConditioners.Update(existAC);
                _db.SaveChanges();
            }
        }

        /*
         * Delete
         */
        public void Delete(AirConditioner airConditioner)
        {
            _db = new AirConditionerShopDbContext();
            _db.AirConditioners.Remove(airConditioner);
            _db.SaveChanges();
        }

        /*
         * Find By Id
         */
    }
}
