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

    private static final String FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\Customers.dat";

    /*
        ################
        Add new Customer
        ################
     */
    @Override
    public boolean addRec() {

        String customerID;
        String customerName;
        String customerEmail;

        do {
            customerID = Utils.getString("Input Customer Code: ", "Input must not be empty");

            Customers existCustomers = searchRecById(customerID);

            if (existCustomers != null) {
                System.out.println("Customer already exists !");
                customerID = null;
            }

            if (!Acceptable.idValid(customerID, Acceptable.CUS_VALID_ID)) {
                System.out.println("Customer ID must start with C,G,K and 4 number after that");
                customerID = null;
            }

        } while (customerID == null);

        do {
            customerName = Utils.getString("Input name: ", "Input must not be empty");
            
            if (!Acceptable.idValid(customerName, Acceptable.NAME_VALID)) {
                System.out.println("Name must be from 2 to 25 characters");
                customerName = null;
            }
            
        } while (customerName == null);
        
        int customerPhoneNumber = Utils.getInt("Input phone number: ", 0, 10);
        
        do {            
            customerEmail = Utils.getString("Input email", "Input must not be empty");
            
            if (!Acceptable.idValid(customerEmail, Acceptable.EMAIL_VALID)) {
                System.out.println("Email must be example@domain.com");
                customerEmail = null;
            }
        } while (customerEmail == null);
        
        

        return true;
    }

    /*
        ###############
        Update Customer
        ###############
     */
    @Override
    public boolean updateRec(Customers code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
        ###############
        Remove Customer
        ###############
     */
    @Override
    public boolean removeRec(Customers code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
        ####################################################
        Load .dat file from machine and add to Customer List
        ####################################################
     */
    @Override
    public List<Customers> loadRecFromFile() {

        List<Customers> customersList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            customersList = (List<Customers>) ois.readObject();
            System.out.println("List loaded: " + customersList);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load from file: " + e.getMessage());
        }

        Collections.sort(customersList);

        return customersList;
    }

    /*
        #############
        Sort Customer 
        #############
     */
    @Override
    public void sortRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
        #######################
        Search Customer by Name
        #######################
     */
    @Override
    public List<Customers> searchRecByName(Customers inputCustomerName) {

        List<Customers> customerList = new ArrayList<>();
        String searchName = inputCustomerName.getName().toLowerCase();

        for (Customers customers : this) {
            if (customers.getName().toLowerCase().contains(searchName)) {
                customerList.add(customers);
            }
        }

        return customerList;
    }

    /*
        #####################
        Search Customer by Id
        #####################
     */
    @Override
    public Customers searchRecById(String inputCustomerId) {

        List<Customers> customerList = new ArrayList<>();
        String searchId = inputCustomerId.toLowerCase();

        for (Customers customers : this) {
            if (customers.getId().toLowerCase().contains(searchId)) {
                return customers;
            }
        }

        return null;
    }

    /*
        #####################
        Display Customer list
        #####################
     */
    @Override
    public void displayRec() {

        String display_1 = String.format("""
                                        \n
                                        ---------------------------------------------------
                                        Code     | Customer Name      | Phone      | Email
                                        ---------------------------------------------------
                                        """
        );

        String display_2 = String.format("""
                                         --------------------------------------------------
                                         """
        );

        if (this.isEmpty()) {
            System.out.print(display_1);
            System.out.println("No data in system");
            System.out.println(display_2);
        } else {
            System.out.print(display_1);

            for (Customers customers : this) {
                System.out.println(customers.display());
            }
        }
    }

    /*
        ###############################
        Save Customer list to .dat file
        ###############################
     */
    @Override
    public boolean saveToFile() {

        FileOutputStream file = null;
        ObjectOutputStream oos = null;

        try {
            file = new FileOutputStream(FILE_PATH);
            oos = new ObjectOutputStream(file);

            oos.writeObject(this);
            System.out.println("Customers saved successfully to file");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving customers to file: " + e.getMessage());
            return false;
        }
    }

}
