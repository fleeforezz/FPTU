/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.I_List;
import model.setMenu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import utils.dataSource;

/**
 *
 * @author jso
 */
public class setMenuController extends ArrayList<setMenu> implements I_List<setMenu> {

    dataSource dataSource = new dataSource();
    
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
    public boolean removeRec(setMenu code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<setMenu> loadRecFromFile() {

        File file = new File(dataSource.getSET_MENU_FILE_PATH());

        if (!file.exists()) {
            System.out.println("Cannot read data from FeastMenu.csv. Please check it.");
            return this;
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(dataSource.getSET_MENU_FILE_PATH()), StandardCharsets.UTF_8));) {
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

                this.add(new setMenu(id, name, price, ingredients));

            }

            System.out.println("Feast Menu loaded: " + this.size() + " record");

        } catch (IOException e) {
            System.out.println("Error while loading Feast Menu from file: " + e.getMessage());
        }

        return this;
    }

    @Override
    public List<setMenu> sortRec(ArrayList<setMenu> recList) {

        Collections.sort(recList, new Comparator<setMenu>() {
            public int compare(setMenu obj1, setMenu obj2) {
                return obj1.getPrice() > obj2.getPrice() ? 1 : -1;
            }
        });

        return recList;
    }

    @Override
    public void searchRecByName(ArrayList<setMenu> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public setMenu searchRecById(String id) {
        
        String searchId = id.toLowerCase();
        
        for (setMenu setMenu : this) {
            if (setMenu.getId().toLowerCase().matches(searchId)) {
                return setMenu;
            }
        }
        
        return null;
    }

    @Override
    public void displayRec(ArrayList<setMenu> setMenuList) {
        
        sortRec(setMenuList);
        
        String header = String.format("""

                -----------------------------------------------------------------------------
                List of Set Menus for ordering party:
                -----------------------------------------------------------------------------
                """);

        String footer = String.format("""
                -----------------------------------------------------------------------------
                """);

        if (setMenuList.isEmpty()) {
            System.out.print(header);
            System.out.println("No data in system");
            System.out.println(footer);
        } else {
            System.out.print(header);

            for (setMenu feastMenu : setMenuList) {
                System.out.print(feastMenu.display());
            }
        }
    }

}
