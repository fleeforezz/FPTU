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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jso
 */
public class CustomersController extends ArrayList<Customers> implements I_List<Customers> {

    private static final String FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\Customers.dat";

    @Override
    public boolean addRec() {
        boolean check;
        String customerID = "";

        do {
            check = true;
            
            customerID = Utils.getString("Input Customer Code: ", "Input must not be empty");

            Customers existCustomers = searchRecById(customerID);

            if (existCustomers != null) {
                System.out.println("Customer already exists !");
                check = true;
            } else if (!Acceptable.idValid(customerID, Acceptable.CUS_VALID_ID)) {
                System.out.println("Customer ID must start with C,G,K and 4 number after that");
                check = true;
            } else {
                check = false;
            }

        } while (check);
        
        String customerName = Utils.getString("Input name: ", Acceptable.NAME_VALID);

        return true;
    }

    @Override
    public boolean updateRec(Customers code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeRec(Customers code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Customers> loadRecFromFile() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        Customers customers = null;
        List list = new ArrayList();

        try {
            fis = new FileInputStream(FILE_PATH);
            ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                customers = (Customers) ois.readObject();
                list.add(customers);
            }

            System.out.println("List: " + list.toString());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error load file, file not found");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(CustomersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        Collections.sort(list);

        return list;
    }

    @Override
    public void sortRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

    @Override
    public void displayRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean readFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean saveToFile() {

        boolean result = false;
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
