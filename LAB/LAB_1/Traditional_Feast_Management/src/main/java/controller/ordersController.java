/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.I_List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import model.orders;
import java.util.ArrayList;
import java.util.List;
import model.customers;
import model.setMenu;
import utils.acceptable;
import utils.inputter;

/**
 *
 * @author jso
 */
public class ordersController extends ArrayList<orders> implements I_List<orders> {

    // Katana Laptop
//    public static final String FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";
    // Shadow Window Desktop
    private static final String FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";
    // Shadow linux Desktop
//    private static final String FILE_PATH = "/home/jso/Documents/GitHub/FPTU/LAB/LAB_1/Traditional_Feast_Management/src/main/java/data/Customers.dat";

    @Override
    public boolean addRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ####################################################
     * Load .dat file from machine and add to Orders List
     * ####################################################
     */
    @Override
    public boolean removeRec(orders code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
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
    @Override
    public void loadRecFromFileAndAddToList() {
        List<orders> loadedOrderList = loadRecFromFile();

        this.clear();
        this.addAll(loadedOrderList);
    }

    @Override
    public List<orders> sortRec(ArrayList<orders> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void searchRecByName(ArrayList<orders> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public orders searchRecById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayRec(ArrayList<orders> ordersList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ###########################################
     * Check if input date is in the future or not
     * ###########################################
     */
    public boolean checkFutureDate(String inputDateTime) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Current date and time: " + now);

        return true;
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

            if (existCustomers != null) {
                if (!acceptable.isValid(customerID, acceptable.CUS_VALID_ID)) {
                    System.out.println("Customer ID must start with C,G,K and 4 number after that");
                }
                continue;
            } else {
                System.out.println("There is no Customer with code " + customerID + " in the system");
            }

            break;

        }

        // Input Set menu code
        String setMenuCode;

        while (true) {
            setMenuCode = inputter.getString(
                    "Input Set Menu to be order",
                    "Input must not be empty",
                    false
            );

            setMenu existSetMenu = setMenuList.searchRecById(setMenuCode);

            if (existSetMenu != null) {
                break;
            } else {
                System.out.println("There is no Set menu with code " + setMenuCode + " in the system");
                break;
            }
        }

        // Input number of tables
        int numberOfTable = inputter.getInt(
                "Input number of tables",
                1, 100
        );

        // Input preferred event date (Event date must be in the futrue)
        String eventDate;

        while (true) {
            eventDate = inputter.getString(
                    "Input preferred event date (must be in the future)",
                    "Input must not be empty",
                    false
            );

            checkFutureDate(eventDate);

        }

    }

    /*
     * ###############################
     * Save Orders list to .dat file
     * ###############################
     */
    @Override
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
