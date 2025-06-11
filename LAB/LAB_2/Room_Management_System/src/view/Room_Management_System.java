/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.reservation_controller;
import controller.room_controller;
import java.util.Scanner;
import model.guests;
import utils.inputter;

/**
 *
 * @author jso
 */
public class Room_Management_System {

    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        
        room_controller room_controller = new room_controller();
        reservation_controller reservation_controller = new reservation_controller();

        do {
            System.out.println("\n");
            System.out.println("--------------------------------------------");
            System.out.println("Room Management System");
            System.out.println("--------------------------------------------");
            System.out.println("  1. Import room data");
            System.out.println("  2. Display available room list");
            System.out.println("  3. Enter guest information");
            System.out.println("  4. Update guest stay information");
            System.out.println("  5. Search guest by national Id");
            System.out.println("  6. Delete guest reservation before arrival");
            System.out.println("  7. List vacant rooms");
            System.out.println("  8. Monthly revenue report");
            System.out.println("  9. Revenue report by room type");
            System.out.println("  10. Save guest information");
            System.out.println("  11. Exit");
 
            choice = inputter.getInt("Enter your choice: ", 1, 11, false);
            System.out.println("--------------------------------------------");

            switch (choice) {
                case 1:
                    // Import room data
                    if (room_controller.loadRecFromFile() != null) {
                        System.out.println("Room list loaded: " + room_controller.size() + " records");
                    } else {
                        System.out.println("Room list is empty !!!");
                    }
                    
                    // Import reservation data
                    if (reservation_controller.loadRecFromFile() != null) {
                        System.out.println("Reservation list loaded: " + reservation_controller.size() + " records");
                    } else {
                        System.out.println("Reservation list is empty !!!");
                    }
                    break;
                case 2:
                    // Display available room list
                    room_controller.displayrec(room_controller);
                    break;
                case 3:
                    // Enter guest information
                    guests isGuestAdded = reservation_controller.addRec();
                    
                    if (isGuestAdded != null) {
                        System.out.println("\nGuest registed successfully for room " + isGuestAdded.getDesiredRoomId());
                        System.out.println("Rental from " + isGuestAdded.getStartDate() + " for " + isGuestAdded.getNumOfRentalDays() + " days");
                    } else {
                        System.out.println("There's something wrong while add guest information!!! Please try again");
                    }
                    break;
                case 4:
                    // Update guest stay information
                    break;
                case 5:
                    // Search guest by national Id
                    break;
                case 6:
                    // Delete guest reservation before arrival
                    break;
                case 7:
                    // List vacant rooms
                    break;
                case 8:
                    // Monthly revenue report
                    break;
                case 9:
                    // Revenue report by room type
                    break;
                case 10:
                    // Save guest information
                    break;
                case 11: 
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice >= 1 && choice <= 10);
    }
}
