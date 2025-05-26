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
import model.orders;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jso
 */
public class ordersController extends ArrayList<orders> implements I_List<orders> {

    // Katana Laptop
    public static final String FILE_PATH = "D:\\Code-Stuff\\Github_Landing\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\feast_order_service.dat";

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
        String header = String.format("""
                                      -----------------------------------------------------------------------------
                                      Customer order information [Order ID: %s]
                                      -----------------------------------------------------------------------------
                                      """);
        
        String footer = String.format("""
                                      -----------------------------------------------------------------------------
                                      """);
        
        if (ordersList.isEmpty()) {
            System.out.println(header);
            System.out.println("There are no order yet !!!");
            System.out.println(footer);
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
