/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.report_controller;
import controller.reservation_controller;
import controller.room_controller;
import model.guests;
import model.rooms;
import utils.acceptable;
import utils.inputter;

/**
 *
 * @author jso
 */
public class Room_Management_System {

    public static void main(String[] args) {
        int choice;

        room_controller room_controller = new room_controller();
        reservation_controller reservation_controller = new reservation_controller();
        report_controller report_controller = new report_controller();

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
                        System.out.println(
                                "\nGuest registed successfully for room "
                                + isGuestAdded.getDesiredRoomId()
                        );
                        System.out.println(
                                "Rental from "
                                + isGuestAdded.getStartDate()
                                + " for "
                                + isGuestAdded.getNumOfRentalDays()
                                + " days"
                        );
                    } else {
                        System.out.println("There's something wrong while add guest information!!! Please try again");
                    }
                    break;
                case 4:
                    // Update guest stay information
                    String nationalId = inputter.getString(
                            "Input national Id: ",
                            "Input must be includes 12 digits",
                            acceptable.NATIONAL_ID_VALID,
                            false
                    );

                    guests isReservationUpdated = reservation_controller.updateRec(nationalId);
                    if (isReservationUpdated != null) {
                        System.out.println("Guest information updated for ID: " + nationalId);
                    }

                    break;
                case 5:
                    // Search guest by national Id
                    reservation_controller.displaySearchedGuest(room_controller);
                    break;
                case 6:
                    // Delete guest reservation before arrival
                    String nationalIdForCancel;
                    while (true) {
                        nationalIdForCancel = inputter.getString(
                                "Input national Id: ",
                                "Input must be includes 12 digits",
                                acceptable.NATIONAL_ID_VALID,
                                false
                        );

                        guests guest = reservation_controller.searchRecById(nationalIdForCancel);
                        if (guest == null) {
                            System.out.println("No guest found with national ID: " + nationalIdForCancel);
                            break;
                        }

                        rooms room = room_controller.searchRecById(guest.getDesiredRoomId());
                        if (room == null) {
                            System.out.println("No room found with room ID: " + guest.getDesiredRoomId());
                            break;
                        }

                        reservation_controller.displayReservationDetail(guest, room, nationalIdForCancel);

                        boolean isRemove = reservation_controller.removeRec(nationalIdForCancel);

                        if (isRemove) {
                            System.out.println("The booking associated with ID: " + nationalIdForCancel + " has been successfully canceled.");
                        } else {
                            System.out.println("Ignored to cancel the booking.");
                        }
                        break;
                    }
                    break;
                case 7:
                    // List vacant rooms
                    room_controller.displayVacantRooms(reservation_controller);
                    break;
                case 8:
                    // Monthly revenue report
                    report_controller.monthlyRevenueReport(reservation_controller, room_controller);
                    break;
                case 9:
                    // Revenue report by room type
                    report_controller.revenueReportByRoomType(reservation_controller, room_controller);
                    break;
                case 10:
                    // Save guest information
                    String confirmation = inputter.getString(
                            "Do you want to save to file? (Y/yes or N/no): ",
                            "Invalid input",
                            false
                    ).trim().toUpperCase();

                    switch (confirmation) {
                        case "Y":
                            reservation_controller.saveToFile();
                            break;
                        case "N":
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                case 11:
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice >= 1 && choice <= 10);
    }
}
