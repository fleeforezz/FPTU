using Microsoft.EntityFrameworkCore;
using SE183605ConsoleEFApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SE183605ConsoleEFApp.Base
{
    public class BaseDAO<T> where T : class
    {
        private readonly Net1814_212_1_ClinicContext _context;
        protected readonly DbSet<T> _dbSet;

        public BaseDAO()
        {
            _context = new Net1814_212_1_ClinicContext();
            _dbSet = _context.Set<T>();
        }

        public List<T> GetAll()
        {
            return _dbSet.ToList();
        }
        public void Create(T entity)
        {
            _dbSet.Add(entity);
            _context.SaveChanges();
        }
        public void Update(T entity)
        {
            var tracker = _context.Attach(entity);
            tracker.State = EntityState.Modified;
            _context.SaveChanges();
        }
        public bool Remove(T entity)
        {
            _dbSet.Remove(entity);
            _context.SaveChanges();
            return true;
        }
        public T GetById(int id)
        {
            return _dbSet.Find(id);
        }
        public T GetById(string id)
        {
            return _dbSet.Find(id);
        }
    }
}
