/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.orders;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.customers;
import model.setMenu;
import utils.acceptable;
import utils.inputter;

/**
 *
 * @author jso
 */
public class ordersController extends ArrayList<orders> {

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
        SimpleDateFormat sdf = new SimpleDateFormat(acceptable.DATETIME_FORMAT);
        
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
            System.out.println("Cannot read feast_order_service.dat");
            return this;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            ordersList = (List<orders>) ois.readObject();
            System.out.println("Order List loaded: " + ordersList.size() + " records");
        } catch (Exception e) {
            System.out.println("Cannot load from file: " + e.getMessage());
        }

        return ordersList;
    }

    /*
     * #########################################
     * Call loadRecFromFile() and add to List<T>
     * #########################################
     */
    public void loadRecFromFileAndAddToList() {
        List<orders> loadedOrderList = loadRecFromFile();

        this.clear();
        this.addAll(loadedOrderList);
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
            boolean duplicateCustomer = order.getCustomerId().equalsIgnoreCase(customerID);
            boolean duplicateSetMenu = order.getSetMenuId().equalsIgnoreCase(setMenuCode);
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
            
            orders order = new orders(
                    orderId, customerID, setMenuCode, 
                    numberOfTable, parseEventDate
            );
            
            this.add(order);
        }

    }

    /*
     * ###############################
     * Save Orders list to .dat file
     * ###############################
     */
    public boolean saveToFile() {

        FileOutputStream file = null;
        ObjectOutputStream oos = null;

        try {
            file = new FileOutputStream(FILE_PATH);
            oos = new ObjectOutputStream(file);

            oos.writeObject(this);
            System.out.println("\n Orders saved successfully to file !!! \n");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving orders to file: " + e.getMessage());
        }

        return false;
    }

}
