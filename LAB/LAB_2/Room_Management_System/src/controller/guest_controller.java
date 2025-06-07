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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import model.guests;
import utils.acceptable;
import utils.dataSource;
import utils.inputter;

/**
 *
 * @author jso
 */

public class guest_controller extends ArrayList<guests> implements I_List<guests>, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String FILE_PATH = dataSource.getGUEST_FILE_PATH();
    
    /*
     * ####################################
     * Check if input date is in the future
     * ####################################
     */
    public boolean checkFutureDate(LocalDateTime inputData) {
        LocalDateTime now = LocalDateTime.now();
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(acceptable.DATETIME_FORMAT);
        
        try {
            if (inputData.isAfter(now)) {
                return true;
            } else {
                System.out.println("Input data must be in the future.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format date. Please try again.");
        }
        
        return false;
    }

    /*
     * #############
     * Add new Guest
     * #############
     */
    @Override
    public guests addRec() {
        
        String reservationId = inputter.generateCode();
        
        int nationalId = inputter.getInt(
                "Input National Id: ", 
                1, 12,
                false
        );
        
        String fullname = inputter.getString(
                "Input guest fullname: ", 
                "Input must be between 2 and 25 characters long and must start with a letter", 
                acceptable.FULLNAME_VALID,
                true
        );
        
        LocalDateTime birthdate = inputter.getLocalDateTime(
                "Input guest birthdate: ", 
                "Wrong birthdate format (Must be dd/MM/yyyy)", 
                acceptable.DATETIME_FORMAT,
                true
        );
        
        String gender = inputter.getString(
                "Input gender: ", 
                "Input must be (Male, Female) only", 
                acceptable.GENDER_VALID, 
                false
        );
        
        int phoneNumber = inputter.getInt(
                "Input guest phone number", 
                "Input must be ", 
                acceptable.PHONE_VALID, 
                1, 10,
                false
        );
        
        String desiredRoomId = inputter.getString(
                "Input Desirec Room Id", 
                "Input must be 5 character long and starting with a letter followed by digits", 
                acceptable.DESIRED_ROOM_ID_VALID,
                true
        );
        
        int numberOfRentalDay = inputter.getInt(
                "Input number of rental days", 
                inputter.MIN, inputter.MAX, 
                false
        );
        
        LocalDateTime startDate;
        while (true) {            
            startDate = inputter.getLocalDateTime(
                    "Input start date", 
                    "Wrong birthdate format (Must be dd/MM/yyyy)", 
                    acceptable.DATETIME_FORMAT,
                    false
            );
            
            boolean isValidFutureDate = checkFutureDate(startDate);
            
            if (isValidFutureDate) {
                break;
            }
        }
        
        guests guest = new guests();
        guest.setReservationId(reservationId);
        guest.setNationalId(nationalId);
        guest.setFullname(fullname);
        guest.setBirthdate(birthdate);
        guest.setGender(gender);
        guest.setPhoneNumber(phoneNumber);
        guest.setDesiredRoomId(desiredRoomId);
        guest.setNumOfRentalDays(numberOfRentalDay);
        guest.setStartDate(startDate);
        
        this.add(guest);
        
        return guest;
        
    }

    @Override
    public boolean updateRec(String code) {
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
                LocalDateTime birthdate = LocalDateTime.parse(field[3].trim(), dateFormatter);
                String gender = field[4].trim();
                int phoneNumber = Integer.parseInt(field[5].trim());
                String desiredRoomId = field[6].trim();
                int numOfRentalDays = Integer.parseInt(field[7].trim());
                LocalDateTime startDate = LocalDateTime.parse(field[8].trim(), dateFormatter);
                
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
