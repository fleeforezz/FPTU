/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TFM.controller;

import com.TFM.business.I_List;
import com.TFM.model.Customers;
import com.TFM.utils.Acceptable;
import com.TFM.utils.Utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jso
 */
public class CustomersController extends ArrayList<Customers> implements I_List<Customers> {

    // Katana Laptop
//    private static final String FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\Customers.dat";
    // Shadow Window Desktop
    private static final String FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\Customers.dat";
    // Shadow linux Desktop
//    private static final String FILE_PATH = "/home/jso/Documents/GitHub/FPTU/LAB/LAB_1/Traditional_Feast_Management/src/main/java/data/Customers.dat";

    /*
     * ################
     * Add new Customer
     * ################
     */
    @Override
    public boolean addRec() {

        String customerID;

        while (true) {
            customerID = Utils.getString(
                    "Input Customer Code: ",
                    "Input must not be empty",
                    false
            );

            Customers existCustomers = searchRecById(customerID);

            if (existCustomers != null) {
                System.out.println("Customer already exists !");
                continue;
            }

            if (!Acceptable.isValid(customerID, Acceptable.CUS_VALID_ID)) {
                System.out.println("Customer ID must start with C,G,K and 4 number after that");
            }

            break;
        }

        String customerName = Utils.getString(
                "Input name: ",
                "Name must be from 2 to 25 characters",
                Acceptable.NAME_VALID,
                false
        );

        String customerPhoneNumber = Utils.getString(
                "Input your phone number: ",
                "Invalid phone number format",
                Acceptable.PHONE_VALID,
                false
        );

        String customerEmail = Utils.getString(
                "Input email: ",
                "Email must be example@domain.com",
                Acceptable.EMAIL_VALID,
                false
        );

        Customers customers = new Customers(
                customerID,
                customerName,
                customerPhoneNumber,
                customerEmail
        );

        this.add(customers);
        
        Utils.askToContinue(() -> this.addRec());
        
        return true;
    }

    /*
     * ###############
     * Update Customer
     * ###############
     */
    @Override
    public boolean updateRec(String customerId) {

        Customers exitsCustomer = searchRecById(customerId);

        if (exitsCustomer != null) {
            String customerName = Utils.getString(
                    "Input name: ",
                    "Name must be from 2 to 25 characters",
                    Acceptable.NAME_VALID,
                    true
            );
            if (!customerName.isEmpty()) {
                exitsCustomer.setName(customerName);
            }

            String customerPhoneNumber = Utils.getString(
                    "Input your phone number: ",
                    "Invalid phone number format",
                    Acceptable.PHONE_VALID,
                    true
            );
            if (!customerPhoneNumber.isEmpty()) {
                exitsCustomer.setPhone(customerPhoneNumber);
            }

            String customerEmail = Utils.getString(
                    "Input email: ",
                    "Email must be example@domain.com",
                    Acceptable.EMAIL_VALID,
                    true
            );
            if (!customerEmail.isEmpty()) {
                exitsCustomer.setEmail(customerEmail);
            }

            this.set(this.indexOf(exitsCustomer), exitsCustomer);
            
            Utils.askToContinue(() -> this.updateRec(customerId));

            return true;
        } else {
            System.out.println("This customer does not exist.");
            return false;
        }

    }

    /*
     * ###############
     * Remove Customer
     * ###############
     */
    @Override
    public boolean removeRec(Customers code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ####################################################
     * Load .dat file from machine and add to Customer List
     * ####################################################
     */
    @Override
    public List<Customers> loadRecFromFile() {

        List<Customers> customersList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            customersList = (List<Customers>) ois.readObject();
            System.out.println("Customers List loaded: " + customersList.size() + " records");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load from file: " + e.getMessage());
        }

        Collections.sort(customersList);

        return customersList;
    }

    /*
     * #########################################
     * Call loadRecFromFile() and add to List<T>
     * #########################################
     */
    @Override
    public void loadRecFromFileAndAddToList() {
        List<Customers> loadedCustomers = loadRecFromFile();

        this.clear();
        this.addAll(loadedCustomers);
    }

    /*
     * #############
     * Sort Customer
     * #############
     */
    @Override
    public void sortRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * #######################
     * Search Customer by Name
     * #######################
     */
    @Override
    public void searchRecByName(ArrayList<Customers> searchList) {

        String searchName = Utils.getString(
                "Input a customer name for searching: ",
                "Invalid input",
                false
        );

        for (Customers customers : this) {
            if (customers.getName().toLowerCase().contains(searchName.toLowerCase())) {
                searchList.add(customers);
            }
        }

        if (searchList.isEmpty()) {
            System.out.println("\nNo one matches the search criteria !!!");
            this.displayRec(this);
        } else {
            System.out.println("\nMatching Customers: " + searchName);
            this.displayRec(searchList);
        }
    }

    /*
     * #####################
     * Search Customer by Id
     * #####################
     */
    @Override
    public Customers searchRecById(String inputCustomerId) {

        List<Customers> customerList = new ArrayList<>();
        String searchId = inputCustomerId.toLowerCase();

        for (Customers customers : this) {
            if (customers.getId().toLowerCase().matches(searchId)) {
                return customers;
            }
        }

        return null;
    }

    /*
     * #####################
     * Display Customer list
     * #####################
     */
    @Override
    public void displayRec(ArrayList<Customers> customerList) {

        String header = String.format("""
                
                -----------------------------------------------------------------------------
                Code     | Customer Name            | Phone         | Email
                -----------------------------------------------------------------------------
                """);

        String footer = String.format("""
                -----------------------------------------------------------------------------
                """);

        if (customerList.isEmpty()) {
            System.out.print(header);
            System.out.println("No data in system");
            System.out.println(footer);
        } else {
            System.out.print(header);

            for (Customers customers : customerList) {
                System.out.print(customers.display());
            }

            System.out.println(footer);
        }
    }

    /*
     * ###############################
     * Save Customer list to .dat file
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
            System.out.println("\nCustomers saved successfully to file !!! \n");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving customers to file: " + e.getMessage());
            return false;
        }
    }

}
