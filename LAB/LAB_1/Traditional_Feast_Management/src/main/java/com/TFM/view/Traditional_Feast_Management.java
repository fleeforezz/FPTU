/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.TFM.view;

import com.TFM.controller.CustomersController;
import com.TFM.controller.FeastMenuController;
import com.TFM.model.Customers;
import com.TFM.utils.Utils;
import java.util.ArrayList;
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
        FeastMenuController feasMenuController = new FeastMenuController();

        System.out.println("Hé lô mình là Trương Minh Nhật");
        customerController.loadRecFromFileAndAddToList();
        feasMenuController.loadRecFromFile();

        do {
            System.out.println("1. Register customers"); // Done
            System.out.println("2. Update customer information"); // Done
            System.out.println("3. Search for customer information by name"); // Done
            System.out.println("4. Display feast menus");
            System.out.println("5. Place a feast menu");
            System.out.println("6. Update order information");
            System.out.println("7. Save data to file"); // Done
            System.out.println("8. Display customer or Order lists"); // 50% Done
            System.out.println("9. Exit"); // Done

            choice = Utils.getInt("Enter your choice: ", Utils.MIN, Utils.MAX);

            switch (choice) {
                case 1:
                    boolean isAdded = customerController.addRec();

                    if (isAdded) {
                        System.out.println("\nCustomer has been created !!!\n");
                    } else {
                        System.out.println("Something went wrong !!!");
                    }

                    break;
                case 2:
                    String customerId;
                    boolean isUpdated;

                    do {
                        isUpdated = false;
                        
                        customerId = Utils.getString("Enter customer id: ", "Invalid input customer code ! Please type again", true);
                        isUpdated = customerController.updateRec(customerId);

                        if (isUpdated) {
                            System.out.println("\nUpdate customer successfully !!!\n");
                            isUpdated = false;
                        } else {
                            isUpdated = true;
                        }
                    } while (isUpdated);

                    break;
                case 3:
                    ArrayList<Customers> searchResult = new ArrayList<>();
                    customerController.searchRecByName(searchResult);
                    break;
                case 4:
                    feasMenuController.displayRec(feasMenuController);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    customerController.saveToFile();
                    break;
                case 8:
                    customerController.displayRec(customerController);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice >= 1 && choice <= 8);
    }
}
