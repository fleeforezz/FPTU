package sample.dto;

import java.util.List;

/* Interface for a group of objects
 */

/**
 *
 * @author Hoa Doan
 */
public interface I_List {
  // add new element( input from scanner) to I_List
  boolean add(); 
//  // Input the code wanna remove
  Object remove(String code);
//  // input the code want to update, after that update other information--> use set method
//  boolean update(String code);
//  // sort list use Collections.sort(this, new Comparator<Clock>()..., sort based price or make
  void sort();
//  // show detail of each element of List
  void diplay();
//  // tìm những sản phầm nào có tên có chứa chuỗi ký tự nhập từ bàn phím
  List<Object> searchByName(String name);
//  boolean saveToFile();
//  boolean readFromFile(String filePath);
}
