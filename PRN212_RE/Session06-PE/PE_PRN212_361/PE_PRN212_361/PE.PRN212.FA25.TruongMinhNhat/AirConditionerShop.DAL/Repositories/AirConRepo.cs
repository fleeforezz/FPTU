using AirConditionerShop.DAL.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.DAL.Repositories
{
    public class AirConRepo
    {
        // GUI / Controller --> Servcice --> REPO --> TABLE
        // ur here

        // Chứa hàm CRUD table AirCon, Chắc chắn phải xài DbContext
        // Xài thì phải khai báo biến và new

        public AirConditionerShopDbContext _db;

        //public AirConRepo(AirConditionerShopDbContext db)
        //{
        //    _db = db;
        //}

        // Get All AirConditioner
        public List<AirConditioner> GetAll()
        {
            _db = new AirConditionerShopDbContext();
            return _db.AirConditioners.Include("Supplier").ToList();
        }

        // Create new AirConditioner
        public void Create(AirConditioner obj)
        {
            _db = new(); // luôn new lại DbContext để đảm bảo tính đồng bộ trong ram và table
            _db.AirConditioners.Add(obj);
            _db.SaveChanges();
        }


        // Update an AirConditioner
        

        // Delete an AirConditioner
        // Các hàm trong repo thường đặt tên ngắn gọn, vì nó gần vs table, mà table thì có 4 lệnh cơ bản (insert into, value) 
        // Update Aircon set cột-x = value-mới, cột-y = value-mới Where cột-key = key-dòng-muốn-xóa
        // Delete FROM AIRCON WHERE cột-key = key-dòng-muốn-xóa
        // SELECT * FROM -> GetAll
        // SELECT * FROM AIRCON WHERE KEY = ... cột-khác = ...KEYWORD
        //                                  -> Tìm kiếm 1 dòng hay nhiều dòng
        // Tên hàm trong repo đặt ngắn gọn như lệnh SQL vì nó thao tác trên table
        // Tên hàm trong service đặt chi tiết hơn, rõ ràng hơn do đó gắn UI / Gần GUI, hướng về ng dùng
        // DELETE phải nhớ: ko WHERE là toang toàn bộ table
        // DELETE trong ORM / OBJECT RELATIONAL MAPPING, chơi CDL style OOP thì
        // hoặc 
        public void Delete(int key)
        {
            // Future implement
        }
        
        public void Delete(AirConditioner obj)
        {
            _db = new(); // luôn new lại DbContext để đảm bảo tính đồng bộ trong ram và table
            _db.AirConditioners.Remove(obj);
            _db.SaveChanges();
        }

        // Find AirCondition By Id
    }
}
