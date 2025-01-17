
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jso
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // Scanner
        Scanner sc = new Scanner(System.in);

        Order order = new Order();

        // Initialize firstMenuChoice
        int firstMenuChoice = 0;

        do {
            System.out.println("\n");
            System.out.println("1. Order Menu");
            System.out.println("2. Product Menu");
            System.out.println("3. Exit");
            System.out.print("--> Your input: ");
            firstMenuChoice = sc.nextInt();

            switch (firstMenuChoice) {
                case 1:
                    int orderMenuChoice = 0;

                    do {
                        System.out.println("\n");
                        System.out.println("1. Create Order");
                        System.out.println("2. List all Order");
                        System.out.println("3. Remove Order");
                        System.out.println("4. Exit");
                        System.out.print("--> Your input: ");
                        orderMenuChoice = sc.nextInt();

                        switch (orderMenuChoice) {
                            case 1:

                                // Create new order - input field
                                sc = new Scanner(System.in); // Refresh scanner

                                System.out.print("Order ID: ");
                                order.setOrderId(sc.nextLine());
                                System.out.print("Order Date: ");
                                order.setCreatedDate(sc.nextLine());
                                System.out.print("Customer Name: ");
                                order.setCustomerName(sc.nextLine());
                                System.out.print("Customer Address: ");
                                order.setCustomerAddress(sc.nextLine());
                                System.out.println("Add product to order by select a product from below list");
                                System.out.println("Product ID \t Product Name \t Product Price");

                                int isAdd = order.addRec(order);
                                if (isAdd == 1) {
                                    System.out.println("Order add to list successfully");
                                } else {
                                    System.out.println("Failed to add order to list");
                                }

                                // Save to file
                                System.out.print("Save order to file? (Y/n): ");
                                String saveChoice = sc.nextLine();
                                if (saveChoice.equalsIgnoreCase("y")) {

                                    // Check if the fileDB exist
                                    boolean fileDBExist = order.isFileDBExist();

                                    if (fileDBExist) {
                                        boolean success = order.saveOrdersToFile("orderDB.txt");
                                        if (success) {
                                            System.out.println("Order saved successfully");
                                        } else {
                                            System.out.println("Failed to save orders");
                                        }
                                    } else {
                                        System.out.println("FileDB not exist");
                                    }
                                }

                                break;
                            case 2:

                                System.out.println("\n");
                                System.out.println("----Order List----");
                                order.listAll();

                                break;
                            case 3:

                                sc = new Scanner(System.in); // Refresh scanner
                                System.out.print("Select order ID to delete: ");
                                String orderID_raw = sc.nextLine();

                                int isRemove = order.deleteRec(orderID_raw);
                                if (isRemove == 1) {
                                    System.out.println("Remove success");
                                } else {
                                    System.out.println("Remove failed");
                                }

                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }

                    } while (orderMenuChoice > 0 && orderMenuChoice < 4);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } while (firstMenuChoice > 0 && firstMenuChoice < 3);
    }

}
