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
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import model.guests;
import model.rooms;
import utils.acceptable;
import utils.dataSource;
import utils.inputter;
import static utils.inputter.getString;

/**
 *
 * @author jso
 */
public class reservation_controller extends ArrayList<guests> implements I_List<guests>, Serializable {

    private static final long serialVersionUID = 1L;

    private String FILE_PATH = dataSource.getRESERVATION_FILE_PATH();

    /*
     * ####################################################
     * Check if is there any guest already booked that room
     * ####################################################
     */
//    public boolean isRoomBooked(String inputRoomId) {
//        for (guests guest : this) {
//            if (guest.getDesiredRoomId().equalsIgnoreCase(inputRoomId)) {
//                System.out.println("Room " + inputRoomId + " has been booked");
//                return true;
//            }
//        }
//
//        return false;
//    }

    /*
     * ####################################
     * Check if input date is in the future
     * ####################################
     */
    public boolean checkFutureDate(LocalDate inputData) {
        LocalDate now = LocalDate.now();

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
     * #################
     * Get Checkout date
     * #################
     */
    public LocalDate getCheckOutDate(LocalDate inputStartDate, int inputNumOfRentalDate) {

        LocalDate checkOutDate = inputStartDate.plusDays(inputNumOfRentalDate);

        return checkOutDate;
    }

    /*
     * ####################################################
     * Check if is there any guest booked room on that days
     * ####################################################
     */
    public boolean checkBookedDate(LocalDate checkInDate, LocalDate checkOutDate) {

        for (guests guest : this) {
            LocalDate guestCheckIn = guest.getStartDate();
            LocalDate guestCheckOut = getCheckOutDate(guestCheckIn, guest.getNumOfRentalDays());
            boolean isOverLapping = !(checkOutDate.isBefore(guestCheckIn) || checkInDate.isAfter(guestCheckOut));

            if (isOverLapping) {
                System.out.println("Your selected date has been booked.");
                return true;
            }
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

        String desiredRoomId;
        while (true) {
            desiredRoomId = inputter.getString(
                    "Input Desired Room Id: ",
                    "Input must be 5 character long and starting with a letter followed by digits",
                    acceptable.DESIRED_ROOM_ID_VALID,
                    true
            );

            room_controller room_controller = new room_controller();
            room_controller.loadRecFromFile();
            rooms isRoomExist = room_controller.searchRecById(desiredRoomId);
//            boolean isRoomBooked = isRoomBooked(desiredRoomId);

            if (isRoomExist != null) {
//                if (!isRoomBooked) {
//                    break;
//                }
                break;
            } else {
                System.out.println("Room " + desiredRoomId + " does not exist!!!");
            }

        }

        LocalDate startDate;
        int numberOfRentalDay;
        while (true) {
            startDate = inputter.getLocalDate(
                    "Input start date: ",
                    "Wrong birthdate format (Must be dd/MM/yyyy)",
                    acceptable.DATETIME_FORMAT,
                    false
            );

            boolean isValidFutureDate = checkFutureDate(startDate);

            if (!isValidFutureDate) {
                continue;
            }

            numberOfRentalDay = inputter.getInt(
                    "Input number of rental days: ",
                    inputter.MIN, inputter.MAX,
                    false
            );

            boolean isOverlappingBookedDate = checkBookedDate(startDate, getCheckOutDate(startDate, numberOfRentalDay));

            if (!isOverlappingBookedDate) {
                break;
            }
        }

        LocalDate checkOutDate = getCheckOutDate(startDate, numberOfRentalDay);

        String reservationId = inputter.generateCode();

        String nationalId;
        while (true) {
            nationalId = inputter.getString(
                    "Input national Id: ",
                    "Input must be includes 12 digits",
                    acceptable.NATIONAL_ID_VALID,
                    false
            );

            if (searchRecById(nationalId) == null) {
                break;
            } else {
                System.out.println("NationalID already exist.");
            }
        }

        String fullname = inputter.getString(
                "Input guest fullname: ",
                "Input must be between 2 and 25 characters long and must start with a letter",
                acceptable.FULLNAME_VALID,
                false
        );

        LocalDate birthdate = inputter.getLocalDate(
                "Input guest birthdate: ",
                "Wrong birthdate format (Must be dd/MM/yyyy)",
                acceptable.DATETIME_FORMAT,
                false
        );

        String gender = inputter.getString(
                "Input gender: ",
                "Input must be (Male, Female) only",
                acceptable.GENDER_VALID,
                false
        );

        String phoneNumber = inputter.getString(
                "Input guest phone number: ",
                "Invalid phone number format",
                acceptable.PHONE_VALID,
                false
        );

        guests guest = new guests();
        guest.setReservationId(reservationId);
        guest.setNationalId(nationalId);
        guest.setFullname(fullname);
        guest.setBirthdate(birthdate);
        guest.setGender(gender);
        guest.setPhoneNumber(Integer.parseInt(phoneNumber));
        guest.setDesiredRoomId(desiredRoomId);
        guest.setNumOfRentalDays(numberOfRentalDay);
        guest.setStartDate(startDate);
        guest.setCheckOutDate(checkOutDate);

        this.add(guest);

        inputter.confirmSaveFile("Reservation", this, FILE_PATH);

        return guest;

    }

    @Override
    public boolean updateRec(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeRec(String code) {

        boolean removeStatus = true;
        guests guest = searchRecById(code);

        if (guest == null) {
            System.out.println("\nBooking details for ID " + code + " could not be found.");
            return false;
        } else {
            if (checkFutureDate(guest.getStartDate())) {
                String decision = getString(
                        "Do you really want to cancel this reservation? (Y/y | N/n): ",
                        "Input cannot be empty",
                        false
                ).trim().toUpperCase();

                switch (decision) {
                    case "Y":
                        guest.deleteGuest();
                        inputter.confirmSaveFile("Reservation", this, FILE_PATH);
                        removeStatus = true;
                        break;
                    case "N":
                        removeStatus = false;
                        break;
                    default:
                        System.out.println("Invalid choice !!! Only (Y/y | N/n) are allowed");
                }
            } else {
                System.out.println("The room booking for this guest cannot be cancelled");
                removeStatus = false;
            }
        }

        return removeStatus;
    }

    @Override
    public List<guests> loadRecFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(acceptable.DATETIME_FORMAT);

            while ((line = br.readLine()) != null) {
                String[] field = line.split(";");

                String reservationId = field[0].trim();
                String nationalId = field[1].trim();
                String fullname = field[2].trim();
                LocalDate birthdate = LocalDate.parse(field[3].trim(), dateFormatter);
                String gender = field[4].trim();
                int phoneNumber = Integer.parseInt(field[5].trim());
                String desiredRoomId = field[6].trim();
                int numOfRentalDays = Integer.parseInt(field[7].trim());
                LocalDate startDate = LocalDate.parse(field[8].trim(), dateFormatter);
                LocalDate checkOutDate = LocalDate.parse(field[9].trim(), dateFormatter);
                int deleted = Integer.parseInt(field[10].trim());

                this.add(new guests(reservationId, nationalId, fullname, birthdate, gender, phoneNumber, desiredRoomId, numOfRentalDays, startDate, checkOutDate, deleted));
            }

        } catch (IOException e) {
            System.out.println("There's an error while loading file: " + e.getMessage());
        }

        return this;
    }

    @Override
    public List<guests> sortRec(ArrayList<guests> recList
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void searchRecByName(ArrayList<guests> recList
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public guests searchRecById(String code) {
        for (guests guest : this) {
            if (guest.getNationalId().equalsIgnoreCase(code) && guest.getDelete() == 0) {
                return guest;
            }
        }

        return null;
    }

    public void displaySearchedGuest(room_controller roomList) {
        String nationalId = inputter.getString(
                "Input national Id: ",
                "Input must be includes 12 digits",
                acceptable.NATIONAL_ID_VALID,
                false
        );

        guests guest = searchRecById(nationalId);
        if (guest == null) {
            System.out.println("No guest found with the requested ID: " + nationalId);
            inputter.askToContinue(() -> displaySearchedGuest(roomList));
            return;
        }

        rooms room = roomList.searchRecById(guest.getDesiredRoomId());
        if (room == null) {
            System.out.println("No room found with room ID: " + guest.getDesiredRoomId());
        }
        
        displayReservationDetail(guest, room, nationalId);
        
        inputter.askToContinue(() -> displaySearchedGuest(roomList));
        
    }

    public void displayReservationDetail(guests guest, rooms room, String nationalId) {

        guests currentGuest = searchRecById(nationalId);

        String roomDetailInfo = room.subMenuForReservation();

        String header = String.format(
                """
                \n
                -------------------------------------------------------------------------------------
                Guest information [National ID: %s]
                -------------------------------------------------------------------------------------
                """,
                currentGuest.getNationalId()
        );

        String footer = String.format(
                """
                -------------------------------------------------------------------------------------
                """
        );

        if ((guest == null && room == null) || currentGuest.getDelete() == 1) {
            System.out.print(header);
            System.out.println("No data in the system");
            System.out.println(footer);
        } else {
            System.out.print(header);
            System.out.println(currentGuest.display());
            if (!roomDetailInfo.isEmpty()) {
                System.out.println(roomDetailInfo);
            }
            System.out.println(footer);
        }

    }

    @Override
    public void displayrec(ArrayList<guests> recList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
