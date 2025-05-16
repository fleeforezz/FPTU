/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.TFM.view;

import com.TFM.controller.Menu;
import com.TFM.business.I_Menu;

/**
 *
 * @author jso
 */
public class Traditional_Feast_Management {

    public static void main(String[] args) {
        
        I_Menu menu = new Menu();
        
        menu.addItem("1. Register customers");
        menu.addItem("2. Update customer information");
        menu.addItem("3. Search for customer information by name");
        menu.addItem("4. Display feast menus");
        menu.addItem("5. Place a feast menu");
        menu.addItem("6. Update order information");
        menu.addItem("7. Save data to file");
        menu.addItem("8. Display customer or Order lists");
        
        int choice = 0;
        boolean cont = true;
        
        do {            
            menu.showMenu();
            choice = menu.getChoice();
            
            switch (choice) {
                case 1:
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (choice > 0 && choice <= 8 && cont);
    }
}
