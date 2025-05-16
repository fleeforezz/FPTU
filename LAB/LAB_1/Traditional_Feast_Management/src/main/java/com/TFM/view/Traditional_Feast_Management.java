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
        
        Customers customers = new Customers() {};
        CustomersController customerController = new CustomersController();

        do {
            System.out.println("1. Register customers");
            System.out.println("2. Update customer information");
            System.out.println("3. Search for customer information by name");
            System.out.println("4. Display feast menus");
            System.out.println("5. Place a feast menu");
            System.out.println("6. Update order information");
            System.out.println("7. Save data to file");
            System.out.println("8. Display customer or Order lists");
            
            choice = Utils.getInt("Enter your choice: ", Utils.MIN, Utils.MAX);
            
            switch (choice) {
                case 1:
                    customers.input();
                    break;
                case 8: 
                    customerController.displayCustomerMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            
        } while (choice >= 1 && choice <= 8);
    }
}
