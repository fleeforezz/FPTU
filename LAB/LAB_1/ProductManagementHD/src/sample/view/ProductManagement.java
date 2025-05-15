package sample.view;

import java.util.List;
import sample.dto.I_List;
import sample.dto.I_Menu;
import sample.controllers.Menu;
import sample.controllers.ProductList;
import sample.dto.Product;
import sample.utils.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public class ProductManagement {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1. Add new product");
        menu.addItem("2. Display");
        menu.addItem("3. Remove");
        menu.addItem("4. Remove");
        menu.addItem("5. Quit");
        int choice;
        boolean cont = true;
        
        I_List list = new ProductList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    boolean check= list.add();
                    if(check){
                        System.out.println("Add thanh cong roi !");
                    }else{
                        System.out.println("Sai roi !");
                    }
                    break;
                case 2:
                    list.diplay();
                    break;
                case 3:
                    String code= Utils.getString("Input delete code:");
                   list.remove(code);
                    break;
                case 4:
                    String name= Utils.getString("Input search Name:");
                    List<Object> searchList=list.searchByName(name);
                    if(searchList.size()>0){
                        for (Object object : searchList) {
                            ((Product)object).display();
                        }
                    }else{
                        System.out.println("Ko tim thay !!!!");
                    }
                    break;
                case 5:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N)");
                    break;
            }
            
        } while (choice >= 0 && choice <= 5 && cont);
    }
}
