/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.I_List;
import model.customers;
import utils.inputter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import utils.acceptable;
import utils.dataSource;

/**
 *
 * @author jso
 */
public class customersController extends ArrayList<customers> implements I_List<customers>, Serializable {

    private static final long serialVersionUID = 1L;

    String URL_PATH = dataSource.getCUSTOMERS_FILE_PATH();

    /*
     * ################
     * Add new Customer
     * ################
     */
    @Override
    public boolean addRec() {

        String customerID;

        while (true) {
            customerID = inputter.getString(
                    "Input Customer Code: ",
                    "Input must not be empty",
                    false
            );

            customers existCustomers = searchRecById(customerID);

            if (existCustomers != null) {
                System.out.println("Customer already exists !");
                continue;
            }

            if (!acceptable.isValid(customerID, acceptable.CUS_VALID_ID)) {
                System.out.println("Customer ID must start with C,G,K and 4 number after that");
            }

            break;
        }

        String customerName = inputter.getString("Input name: ",
                "Name must be from 2 to 25 characters",
                acceptable.NAME_VALID,
                false
        );

        String customerPhoneNumber = inputter.getString("Input your phone number: ",
                "Invalid phone number format",
                acceptable.PHONE_VALID,
                false
        );

        String customerEmail = inputter.getString("Input email: ",
                "Email must be example@domain.com",
                acceptable.EMAIL_VALID,
                false
        );

        customers customers = new customers(
                customerID,
                customerName,
                customerPhoneNumber,
                customerEmail
        );

        this.add(customers);

        inputter.confirmSaveFile("Customer", this, URL_PATH);
        inputter.askToContinue(() -> this.addRec());

        return true;
    }

    /*
     * ###############
     * Update Customer
     * ###############
     */
    @Override
    public boolean updateRec(String customerId) {

        customers exitsCustomer = searchRecById(customerId);

        if (exitsCustomer != null) {
            String customerName = inputter.getString("Input name: ",
                    "Name must be from 2 to 25 characters",
                    acceptable.NAME_VALID,
                    true
            );
            if (!customerName.isEmpty()) {
                exitsCustomer.setName(customerName);
            }

            String customerPhoneNumber = inputter.getString("Input your phone number: ",
                    "Invalid phone number format",
                    acceptable.PHONE_VALID,
                    true
            );
            if (!customerPhoneNumber.isEmpty()) {
                exitsCustomer.setPhone(customerPhoneNumber);
            }

            String customerEmail = inputter.getString("Input email: ",
                    "Email must be example@domain.com",
                    acceptable.EMAIL_VALID,
                    true
            );
            if (!customerEmail.isEmpty()) {
                exitsCustomer.setEmail(customerEmail);
            }

            this.set(this.indexOf(exitsCustomer), exitsCustomer);

            inputter.confirmSaveFile("Customer", this, URL_PATH);
            inputter.askToContinue(() -> this.updateRec(customerId));

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
    public boolean removeRec(customers code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
     * ####################################################
     * Load .dat file from machine and add to Customer List
     * ####################################################
     */
    @Override
    public List<customers> loadRecFromFile() {

        List<customers> customersList = new ArrayList<>();

        File file = new File(URL_PATH);

        if (!file.exists()) {
            System.out.println("Cannot read data from Customers.dat. Please check it.");
            return this;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URL_PATH))) {
            customersList = (List<customers>) ois.readObject();
            this.clear();
            this.addAll(customersList);
            System.out.println("Customers List loaded: " + customersList.size() + " records");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load from file: " + e.getMessage());
        }

        return customersList;
    }

    /*
     * #############
     * Sort Customer
     * #############
     */
    @Override
    public List<customers> sortRec(ArrayList<customers> customersList) {
        customersList.sort(Comparator.comparing(
                customers::getName,
                String.CASE_INSENSITIVE_ORDER
        ));
        
        return customersList;
    }

    /*
     * #######################
     * Search Customer by Name
     * #######################
     */
    @Override
    public void searchRecByName(ArrayList<customers> searchList) {

        String searchName = inputter.getString(
                "Input a customer name for searching: ",
                "Invalid input",
                false
        );
        
        searchList.sort(Comparator.comparing(
                customers::getName,
                String.CASE_INSENSITIVE_ORDER
        ));

        for (customers customers : this) {
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
    public customers searchRecById(String inputCustomerId) {

        String searchId = inputCustomerId.toLowerCase();

        for (customers customers : this) {
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
    public void displayRec(ArrayList<customers> customerList) {

        List<customers> sortedCustomerList = sortRec(customerList);
        
        String header = String.format(
                """
                
            -----------------------------------------------------------------------------
            Code     | Customer Name            | Phone         | Email
            -----------------------------------------------------------------------------
            """
        );

        String footer = String.format(
                """
            -----------------------------------------------------------------------------
            """
        );

        if (sortedCustomerList.isEmpty()) {
            System.out.print(header);
            System.out.println("No data in system");
            System.out.println(footer);
        } else {
            System.out.print(header);

            for (customers customers : sortedCustomerList) {
                System.out.print(customers.display());
            }

            System.out.println(footer);
        }
    }
}
