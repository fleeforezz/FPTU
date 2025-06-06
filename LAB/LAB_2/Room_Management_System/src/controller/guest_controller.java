/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.I_List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.guests;
import utils.acceptable;
import utils.dataSource;

/**
 *
 * @author jso
 */

public class guest_controller extends ArrayList<guests> implements I_List<guests>, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String FILE_PATH = dataSource.getGUEST_FILE_PATH();

    @Override
    public boolean addRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updatRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<guests> loadRecFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            
            String line;
            boolean isLoaded = true;
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(acceptable.DATETIME_FORMAT);
            
            while ((line = br.readLine()) != null) {                
                String[] field = line.split(";");
                
                String reservationId = field[0].trim();
                int nationalId = Integer.parseInt(field[1].trim());
                String fullname = field[2].trim();
                LocalDate birthdate = LocalDate.parse(field[3].trim(), dateFormatter);
                String gender = field[4].trim();
                int phoneNumber = Integer.parseInt(field[5].trim());
                String desiredRoomId = field[6].trim();
                int numOfRentalDays = Integer.parseInt(field[7].trim());
                LocalDate startDate = LocalDate.parse(field[8].trim(), dateFormatter);
                
                isLoaded = this.add(new guests(reservationId, nationalId, fullname, birthdate, gender, phoneNumber, desiredRoomId, numOfRentalDays, startDate));
            }
            
            if (isLoaded) {
                System.out.println("Guest file loaded: " + this.size() + " records");
            }
            
        } catch (IOException e) {
            System.out.println("There's an error while loading file: " + e.getMessage());
        }
        
        return this;
    }

    @Override
    public List<guests> sortRec(ArrayList<guests> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void searchRecByName(ArrayList<guests> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public guests searchRecById(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayrec(ArrayList<guests> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
