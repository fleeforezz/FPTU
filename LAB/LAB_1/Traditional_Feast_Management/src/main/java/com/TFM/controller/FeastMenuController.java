/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TFM.controller;

import com.TFM.business.I_List;
import com.TFM.model.FeastMenu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jso
 */
public class FeastMenuController extends ArrayList<FeastMenu> implements I_List<FeastMenu> {

    private static final String FILE_PATH = "D:\\Cabinet\\Github\\FPTU\\LAB\\LAB_1\\Traditional_Feast_Management\\src\\main\\java\\data\\FeastMenu.csv";

    @Override
    public boolean addRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeRec(FeastMenu code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<FeastMenu> loadRecFromFile() {
        
        File file = new File(FILE_PATH);
        
        if (!file.exists()) {
            System.out.println("Cannot read data from FeastMenu.csv. Please check it.");
            return this;
        }
        
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILE_PATH), StandardCharsets.UTF_8));) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] fields = line.split(",");
                String id = fields[0].trim();
                String name = fields[1].trim();
                double price = Double.parseDouble(fields[2].trim());
                String ingredients = fields[3].trim();

                this.add(new FeastMenu(id, name, price, ingredients));

            }

            System.out.println("Feast Menu loaded: " + this.size() + " record");

        } catch (IOException e) {
            System.out.println("Error while loading Feast Menu from file: " + e.getMessage());
        }

        return this;
    }

    @Override
    public void loadRecFromFileAndAddToList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<FeastMenu> sortRec(ArrayList<FeastMenu> recList) {
        Comparator orderAcendByPrice = new Comparator<FeastMenu>() {
            @Override
            public int compare(FeastMenu o1, FeastMenu o2) {
                return o1.getPrice() > o2.getPrice() ? 1 : -1;
            }
        };
        
        Collections.sort(recList, orderAcendByPrice);
        
        return recList;
    }

    @Override
    public void searchRecByName(ArrayList<FeastMenu> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FeastMenu searchRecById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayRec(ArrayList<FeastMenu> feastMenuList) {
        String header = String.format("""

                -----------------------------------------------------------------------------
                List of Set Menus for ordering party:
                -----------------------------------------------------------------------------
                """);

        String footer = String.format("""
                -----------------------------------------------------------------------------
                """);

        if (feastMenuList.isEmpty()) {
            System.out.print(header);
            System.out.println("No data in system");
            System.out.println(footer);
        } else {
            System.out.print(header);

            for (FeastMenu feastMenu : feastMenuList) {
                System.out.print(feastMenu.display());
            }
        }
    }

    @Override
    public boolean saveToFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
