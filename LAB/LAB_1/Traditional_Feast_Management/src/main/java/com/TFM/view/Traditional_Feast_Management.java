/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.TFM.view;

import com.TFM.controller.CustomersController;
import com.TFM.model.Customers;
import com.TFM.utils.Utils;
import java.util.Scanner;

/**
 *
 * @author jso
 */
public class Traditional_Feast_Management {

    public static void main(String[] args) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        
        CustomersController customerController = new CustomersController();
        
        customerController.loadRecFromFile();

        do {
            System.out.println("1. Register customers");
            System.out.println("2. Update customer information");
            System.out.println("3. Search for customer information by name");
            System.out.println("4. Display feast menus");
            System.out.println("5. Place a feast menu");
            System.out.println("6. Update order information");
            System.out.println("7. Save data to file");
            System.out.println("8. Display customer or Order lists");
            System.out.println("9. Exit");
            
            choice = Utils.getInt("Enter your choice: ", Utils.MIN, Utils.MAX);
            
            switch (choice) {
                case 1:
                    customerController.addRec();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    customerController.saveToFile();
                    break;
                case 8:
                    customerController.displayRec();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            
        } while (choice >= 1 && choice <= 8);
    }
}
