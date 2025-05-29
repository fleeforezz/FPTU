/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package view;

import controller.customersController;
import controller.ordersController;
import controller.setMenuController;
import model.customers;
import utils.inputter;
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

        customersController customerController = new customersController();
        setMenuController setMenuController = new setMenuController();
        ordersController ordersController = new ordersController();

        customerController.loadRecFromFile();
        setMenuController.loadRecFromFile();
        ordersController.loadRecFromFile();

        do {
            System.out.println("\n");
            System.out.println("-------------------------------------------");
            System.out.println("Traditional Feast Management System");
            System.out.println("-------------------------------------------");
            System.out.println("  1. Register customers"); // Done
            System.out.println("  2. Update customer information"); // Done
            System.out.println("  3. Search for customer information by name"); // Done
            System.out.println("  4. Display feast menus"); // Done
            System.out.println("  5. Place a feast menu");
            System.out.println("  6. Update order information");
            System.out.println("  7. Save data to file");
            System.out.println("  8. Display customer or Order lists"); // Done
            System.out.println("  9. Exit"); // Done
            System.out.println("-------------------------------------------");

            choice = inputter.getInt("Enter your choice: ", inputter.MIN, inputter.MAX);
            System.out.println("-------------------------------------------");

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

                        customerId = inputter.getString(
                                "Enter customer id: ",
                                "Invalid input customer code ! Please type again",
                                true
                        );

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
                    ArrayList<customers> searchResult = new ArrayList<>();
                    customerController.searchRecByName(searchResult);
                    break;
                case 4:
                    setMenuController.displayRec(setMenuController);
                    break;
                case 5:
                    ordersController.placeFeastOrder(customerController, setMenuController);
                    break;
                case 6:
                    String orderId;

                    while (true) {
                        orderId = inputter.getString(
                                "Enter order id",
                                "Input must not be empty",
                                false
                        );
                        
                        boolean isUpdatedOrder = ordersController.updateRec(orderId);
                        
                        if (isUpdatedOrder) {
                            System.out.println("\nOrder update successfully !!!\n");
                            break;
                        }
                    }

                    break;
                case 7:
//                    customerController.saveToFile();
                    break;
                case 8:
                    int subMenuChoice = 0;

                    do {
                        System.out.println("1. Display Customers List");
                        System.out.println("2. Display Orders List");
                        System.out.println("3. Return to main menu");

                        subMenuChoice = inputter.getInt("Enter your choice: ", inputter.MIN, inputter.MAX);

                        switch (subMenuChoice) {
                            case 1:
                                customerController.displayRec(customerController);
                                break;
                            case 2:
                                ordersController.displayRec(ordersController);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }

                    } while (subMenuChoice >= 1 && subMenuChoice <= 2);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice >= 1 && choice <= 8);
    }
}
