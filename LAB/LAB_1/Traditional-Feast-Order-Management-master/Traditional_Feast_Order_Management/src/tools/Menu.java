/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;

/*
    menu là một cái khuôn chuyên đúc ra anh quản lí menu 
    + có danh sách lựa chon là optionsList 
    + có tên tên của meny là title 
    + có những hàm thao tác với option list 
    + hàn thu thâp các lựa chon của người dùng 
*/
public class Menu {
    // mảng luuuw các sự lựa chọn 
    public ArrayList<String> optionList = new ArrayList<>();
    // prop lưu tên của menu 
    public String title;

    public Menu(String title) {
        this.title = title;
    }
    // các method của nó 
    // method thêm một optionList 
    public void addNewOption (String newOption){
        optionList.add(newOption);
    }
    // method hiển thị danh sách option 
    public void print(){
        int count = 1;
        System.out.println("_____________~" + title + "~_____________");
        for (String item : optionList) {
            System.out.println("" + count+ ".   " + item );
            count++;
        }
    }
    // method thu thập lựa chọn của người dùng 
     public int getChoice (){
         int choice = Inputter.getAnInteger("Input your choice: ", 
                 "Your choice must be 1 and" + optionList.size(), 1 , optionList.size());
         return choice;
     }
    
}
