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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.guests;
import model.rooms;
import utils.dataSource;

/**
 *
 * @author jso
 */
public class room_controller extends ArrayList<rooms> implements I_List<rooms>, Serializable {

    private static final long serialVersionUID = 1L;

    private String FILE_PATH = dataSource.getACTIVE_ROOM_LIST_FILE_PATH();

    @Override
    public rooms addRec() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public rooms updateRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<rooms> loadRecFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            
            while ((line = br.readLine()) != null) {
                String[] field = line.split(";");

                
                String roomId = field[0].trim();
                String roomName = field[1].trim();
                String roomType = field[2].trim();
                double dailyRate = Double.parseDouble(field[3].trim());
                int capacity = Integer.parseInt(field[4].trim());
                String furnitureDescription = field[5].trim();

                this.add(new rooms(roomId, roomName, roomType, dailyRate, capacity, furnitureDescription));
            }

        } catch (IOException e) {
            System.out.println("There's an error while loading file: " + e.getMessage());
        }

        return this;
    }

    @Override
    public List<rooms> sortRec(ArrayList<rooms> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void searchRecByName(ArrayList<rooms> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public rooms searchRecById(String code) {

        for (rooms room : this) {
            if (room.getRoomId().trim().equals(code.trim())) {
                return room;
            }
        }

        return null;
    }

    @Override
    public void displayrec(ArrayList<rooms> recList) {

        String header = String.format(
                """
                \n
                RoomID  | Room Name        | Type     | Rate    | Capacity | Furniture  
                --------+------------------+----------+---------+----------+--------------------------------
                """
        );

        String footer = String.format(
                """
                --------------------------------------------------------------------------------------------
                """
        );

        if (recList.isEmpty()) {
            System.out.print(header);
            System.out.println("Room list is currently empty, not loaded yet.");
            System.out.print(footer);
        } else {
            System.out.print(header);
            for (rooms room : recList) {
                System.out.print(room.display());
            }
            System.out.print(footer);
        }

    }

    public void displayVacantRooms(reservation_controller guestList) {
        String header = String.format(
                """
                \n
                RoomID  | Room Name        | Type     | Rate    | Capacity | Furniture  
                --------+------------------+----------+---------+----------+--------------------------------
                """
        );

        String footer = String.format(
                """
                --------------------------------------------------------------------------------------------
                """
        );
        
        boolean isAnyVacant = false;
        
        System.out.print(header);
        for (rooms room : this) {
            boolean isVacant = true;
            for (guests guest : guestList) {
                if (room.getRoomId().equalsIgnoreCase(guest.getDesiredRoomId())) {
                    isVacant = false;
                    break;
                }
            }
            
            if (isVacant) {
                System.out.print(room.display());
                isAnyVacant = true;
            }
        }
        if (!isAnyVacant) {
            System.out.print("All rooms have currently been rented out - no room available");
        }
        System.out.print(footer);
    }

    @Override
    public void saveToFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
