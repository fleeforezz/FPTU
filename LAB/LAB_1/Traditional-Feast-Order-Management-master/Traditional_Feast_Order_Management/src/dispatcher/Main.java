package dispatcher;

import business.Customers;
import business.FeastMenus;
import business.Orders;
import java.util.ArrayList;
import model.Customer;
import model.FeastMenu;
import tools.Inputter;
import tools.Menu;

public class Main {

    public static void main(String[] args) {
        // tạo menu
        Menu menu = new Menu("Traditional Feast Order Management..");
        // thêm option nha 
        menu.addNewOption("Register customers");
        menu.addNewOption("Update customer information");
        menu.addNewOption("Search for customer information by name");
        menu.addNewOption("Display feast menus");
        menu.addNewOption("Place a feast order");
        menu.addNewOption("Update order information");
        menu.addNewOption("Save data to file");
        menu.addNewOption("Display Customer or Order lists");
        menu.addNewOption("Exit the Program");
        // tạo ra các anh quản lý 
        Customers cusManagement = new Customers();
        FeastMenus feastMenuManagement = new FeastMenus();
        Orders orderManagement = new Orders();
        // đọc file 
        cusManagement.readFromFile();
        feastMenuManagement.readFromFile();
        orderManagement.readFromFile();

        int choice = 0;
        while (true) {
            menu.print();
            choice = menu.getChoice();
            switch (choice) {
                case 1: {
                    cusManagement.addNewCustomer();
                    break;

                }
                case 2: {
                    cusManagement.updateCustomer();
                    break;
                }

                case 3: {
                    cusManagement.seachByName(cusManagement.cusList);
                    break;
                }
                case 4: {
                    feastMenuManagement.displayFeastMenus(feastMenuManagement.feaMenu);
                    break;
                }
                case 5: {
                    boolean isTrue;
                    String text = "";
                    do {
                        isTrue = false;
                        orderManagement.placeAFeastOrder(feastMenuManagement.feaMenu, cusManagement.cusList);
                        text = Inputter.getString("Do you want to place another order? (Y/N): ", "Data is invalid! Re-enter...");
                        if (text.trim().equalsIgnoreCase("N")) {
                            isTrue = true;
                        }
                    } while (!isTrue);
                    break;
                }
                case 6: {

                    orderManagement.updateOrderInfor(orderManagement.orderList, feastMenuManagement.feaMenu);
                    break;
                }
                case 7: {
                    cusManagement.saveToFile();
                    orderManagement.saveToFile();
                    System.out.println("successfully saved.");
                    break;
                }
                case 8: {
                    Menu menu1 = new Menu("===== Display Options =====");
                    menu1.addNewOption(" Display Customer List");
                    menu1.addNewOption(" Display Order List");
                    menu1.print();
                    int selection = Inputter.getAnInteger("Input your choice(1/2):  ", 
                            "This function is not available");
                    switch (selection) {
                        case 1: {
                            cusManagement.displayCustomerList(cusManagement.cusList);
                            break;
                        }
                        case 2: {
                            orderManagement.disPlayAOrder(orderManagement.orderList);
                            break;
                        }
                        default: {
                            System.out.println("This function is not available");
                            break;
                        }
                    }
                    break;
                }
                case 9: {
                     boolean isSavedCustomer = cusManagement.isIsSaved() ;
                     boolean isSavedOrder = orderManagement.isIsSaved();

                    if (isSavedCustomer == false || isSavedOrder == false) {
                        String result = "";
                        result = Inputter.getString("Do you want to save the changes before exiting? (Y/N):", "Data is invalid! Re-enter...");

                        if (result.matches("[yY]")) {
                            cusManagement.saveToFile();
                            orderManagement.saveToFile();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    
                    
                }
                default: {
                    System.out.println("This function is not available");
                    break;
                }
            }

        }
    }
}
