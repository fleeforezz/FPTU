using AirConditionerShop.DAL.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AirConditionerShop.DAL.Repositories
{
    public class AirConRepository
    {
        //THẰNG NÀY CHƠI TRỰC TIẾP VỚI DBCONTEXT, NHỜ NÓ CRUD TABLE MÁY LẠNH
        //NẾU A NHỜ B, THÌ A PHẢI KHAI BÁO BIẾN CỦA B
        private AirConditionerShop2024DbContext _context; //lúc nào xài mới new

        //CRUD MÁY LẠNH, nhờ thằng context giúp
        public List<AirConditioner> GetAll()
        {
            _context = new AirConditionerShop2024DbContext();
            return _context.AirConditioners.ToList();
        }  //select * from table AirCon 
           //trả về DbSet, giống List, ta convert sang List

        //HÀM NHẬN VÀO 1 OBJECT CẦN XOÁ, LÀ 1 VÙNG NEW AIR-CON
        //TRONG BIẾN OBJ MUỐN XOÁ ĐƯA VÀO HÀM, THÌ PHÍA HẬU TRƯỜNG CỦA DBCONTEXT, NÓ obj.GetID máy lạnh và where trên table thật
        public void Delete(AirConditioner obj)
        {
            _context = new();  //mỗi lần xài 1 lần new _context
            _context.AirConditioners.Remove(obj); //trong ram
            _context.SaveChanges(); //chính thức xoá trong db
        }
        public void Create(AirConditioner obj)
        {
            _context = new();  //mỗi lần xài 1 lần new _context
            _context.AirConditioners.Add(obj); //trong ram
            _context.SaveChanges(); //chính thức tạo mới trong db
        }

        public void Update(AirConditioner obj)
        {
            _context = new();  //mỗi lần xài 1 lần new _context
            _context.AirConditioners.Update(obj); //trong ram
            _context.SaveChanges(); //chính thức update trong db
        }
    }
}
