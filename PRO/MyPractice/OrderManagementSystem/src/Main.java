
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
    public static void main(String[] args) {

        // Test field
        Order order1 = new Order("O1", "2025-01-01", "John Doe", "123 Main St");
        Order order2 = new Order("O2", "2025-01-02", "Jane Smith", "456 Elm St");
        
        Order orderManager = new Order();
        orderManager.addRec(order1);
        orderManager.addRec(order2);
        
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
                    
                    do{
                        System.out.println("\n");
                        System.out.println("1. Create Order");
                        System.out.println("2. List all Order");
                        System.out.println("3. Exit");
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
                                
                                int isAdd = order.addRec(order);
                                if (isAdd == 1) {
                                    System.out.println("Add success");
                                } else {
                                    System.out.println("Add failed");
                                }
                                
                                break;
                            case 2:
                                
                                System.out.println("\n");
                                System.out.println("----Order List----");
                                order.listAll();
                                
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                        
                    } while (orderMenuChoice > 0 && orderMenuChoice < 3);
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
