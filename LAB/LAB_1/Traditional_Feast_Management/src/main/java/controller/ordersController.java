/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.orders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import model.customers;
import model.setMenu;
import utils.acceptable;
import utils.inputter;

/**
 *
 * @author jso
 */
public class ordersController extends ArrayList<orders> implements Serializable {

    // Katana Laptop
//    public static final String FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";
    // Shadow Window Desktop
    private static final String FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";
    // Shadow linux Desktop
//    private static final String FILE_PATH = "/home/jso/Documents/GitHub/FPTU/LAB/LAB_1/Traditional_Feast_Management/src/main/java/data/Customers.dat";

    public boolean updateRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * #####################################
     * Auto generated OrderId using datetime
     * #####################################
     */
    private String generateOrderCode() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(acceptable.ORDER_CODE_DATETIME_FORMAT);

        return sdf.format(now);
    }

    /*
     * ####################################################
     * Load .dat file from machine and add to Orders List
     * ####################################################
     */
    public List<orders> loadRecFromFile() {

        List<orders> ordersList = new ArrayList<>();

        File orderFile = new File(FILE_PATH);

        if (!orderFile.exists()) {
            System.out.println("Cannot read feast_order_service.dat. Please check it.");
            return this;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ordersList = (List<orders>) ois.readObject();
            this.clear();
            this.addAll(ordersList);
            System.out.println("Order List loaded: " + ordersList.size() + " records");
        } catch (Exception e) {
            System.out.println("Cannot load from file: " + e.getMessage());
        }

        return ordersList;
    }

    /*
     * ###########################################
     * Check if input date is in the future or not
     * ###########################################
     */
    public boolean checkFutureDate(String inputDate) {

        LocalDate date = null;

        LocalDate now = LocalDate.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(acceptable.DATETIME_FORMAT);

        try {
            date = LocalDate.parse(inputDate, dateTimeFormatter);

            if (date.isAfter(now)) {
                return true;
            } else {
                System.out.println("Input date must be in the future.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format date. Please try again.");
        }

        return false;
    }

    /*
     * ###################
     * Place a feast order
     * ###################
     */
    public void placeFeastOrder(customersController customersList, setMenuController setMenuList) {

        customers currentCustomer = null;
        setMenu currentSetMenu = null;

        // Input Customer code
        String customerID;

        while (true) {
            customerID = inputter.getString(
                    "Input Customer Code: ",
                    "Input must not be empty",
                    false
            );

            customers existCustomers = customersList.searchRecById(customerID);

            if (acceptable.isValid(customerID, acceptable.CUS_VALID_ID)) {
                if (existCustomers != null) {
                    currentCustomer = existCustomers;
                    break;
                } else {
                    System.out.println("There is no Customer with code " + customerID + " in the system");
                }

            } else {
                System.out.println("Customer ID must start with C,G,K and 4 number after that");
            }
        }

        // Input Set menu code
        String setMenuCode;

        while (true) {
            setMenuCode = inputter.getString(
                    "Input Set Menu to be order: ",
                    "Input must not be empty",
                    false
            );

            setMenu existSetMenu = setMenuList.searchRecById(setMenuCode);

            if (existSetMenu != null) {
                currentSetMenu = existSetMenu;
                break;
            } else {
                System.out.println("There is no Set menu with code " + setMenuCode + " in the system");
            }
        }

        // Input number of tables
        int numberOfTable = inputter.getInt(
                "Input number of tables: ",
                1, 100
        );

        // Input preferred event date (Event date must be in the futrue)
        String eventDate;

        while (true) {
            eventDate = inputter.getString(
                    "Input preferred event date (must be in the future with dd/MM/yyyy format): ",
                    "Input must not be empty",
                    false
            );

            boolean isValidFutureDate = checkFutureDate(eventDate);

            if (isValidFutureDate) {
                break;
            }
        }

        // Parse eventDate string into Date 
        Date parseEventDate = null;
        try {
            parseEventDate = new SimpleDateFormat("dd/MM/yyyy").parse(eventDate);
        } catch (ParseException e) {
            System.out.println("Unexpected date parse error: " + e.getMessage());
        }

        // Check if order info already exist
        boolean isDuplicate = false;

        for (orders order : this) {
            boolean duplicateCustomer = order.getCustomerId().matches(customerID);
            boolean duplicateSetMenu = order.getSetMenuId().matches(setMenuCode);
            boolean duplicateEventDate = order.getEventDate().equals(parseEventDate);

            if (duplicateCustomer && duplicateSetMenu && duplicateEventDate) {
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate) {
            System.out.println("Duplicate data !");
        } else {
            String orderId = generateOrderCode();

            double totalCost = currentSetMenu.getPrice() * numberOfTable;

            orders order = new orders(
                    orderId, customerID, setMenuCode,
                    numberOfTable, parseEventDate, totalCost
            );

            // Display 
            StringTokenizer stringTokenizer = new StringTokenizer(currentSetMenu.getIngredients(), "#");
            DecimalFormat formatter = new DecimalFormat("#, ###, ### Vnd");

            String appetizer = stringTokenizer.nextToken().trim();
            String mainCourse = stringTokenizer.nextToken().trim();
            String desert = stringTokenizer.nextToken().trim();

            String priceFormat = formatter.format(currentSetMenu.getPrice());
            String totalCostFormat = formatter.format(totalCost);

            String displayOrderMenu = String.format(
                    """
                    ------------------------------------------------------------------------------------------
                    Customer order information [Order ID: %s]
                    ------------------------------------------------------------------------------------------
                      Customer Code   :   %s
                      Customer Name   :   %s
                      Phone Number    :   %s
                      Email           :   %s
                    ------------------------------------------------------------------------------------------
                      Code of the Set Menu  :   %s
                      Set Menu name         :   %s
                      Event date            :   %s
                      Price                 :   %s
                      Ingredients:
                        %s
                        %s
                        %s
                    ------------------------------------------------------------------------------------------
                    Total Cost  :   %s
                    ------------------------------------------------------------------------------------------
                    """,
                    orderId,
                    customerID,
                    currentCustomer.getName(),
                    currentCustomer.getPhone(),
                    currentCustomer.getEmail(),
                    currentSetMenu.getId(),
                    currentSetMenu.getName(),
                    parseEventDate,
                    priceFormat,
                    appetizer,
                    mainCourse,
                    desert,
                    totalCostFormat
            );

            boolean isPlacedSuccessfull = this.add(order);

            if (isPlacedSuccessfull) {
                System.out.println("\nOrder place successfully !!!");
                System.out.println("Here's the preview of your placed order\n");
                System.out.println(displayOrderMenu);

                inputter.confirmSaveFile("Order", this, FILE_PATH);

                inputter.askToContinue(() -> this.placeFeastOrder(customersList, setMenuList));
            } else {
                System.out.println("Something when wrong while placing your order. Please try again !!!");
            }
        }

    }

    public void displayRec(ArrayList<orders> orderList) {

        String header = String.format(
                """
            
                --------------------------------------------------------------------------------------------------
                ID              | Event date  | Customer ID  | Set Menu  | Price          | Tables |          Cost 
                --------------------------------------------------------------------------------------------------
                """
        );

        String footer = String.format(
                """
                --------------------------------------------------------------------------------------------------         
                """
        );

        if (orderList.isEmpty()) {
            System.out.println(header);
            System.out.println("No data in the system");
            System.out.println(footer);
        } else {
            System.out.println(header);
            for (orders order : orderList) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedEventDate = dateFormat.format(order.getEventDate());
                
                DecimalFormat formatter = new DecimalFormat("#, ###, ###");

                String priceFormat = formatter.format(order.getTotalCost() / order.getNumberOfTables());
                
                String totalPriceFormat = formatter.format(order.getTotalCost());

                String orderDetail = String.format(
                        """
                        %-15s | %-11s | %-12s | %-9s | %14s | %6s | %15s
                        """,
                        order.getOrderId(),
                        formattedEventDate,
                        order.getCustomerId(),
                        order.getSetMenuId(),
                        priceFormat,
                        order.getNumberOfTables(),
                        totalPriceFormat
                );

                System.out.println(orderDetail);
            }
            System.out.println(footer);
        }
    }
}
