/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utils.acceptable;

/**
 *
 * @author jso
 */
public class guests {

    private String reservationId;
    private String nationalId;
    private String fullname;
    private LocalDate birthdate;
    private String gender;
    private int phoneNumber;
    private String desiredRoomId;
    private int numOfRentalDays;
    private LocalDate startDate;
    private LocalDate checkOutDate;
    private int deleted = 0;

    public guests() {
    }

    public guests(
            String reservationId, String nationalId,
            String fullname, LocalDate birthdate,
            String gender, int phoneNumber,
            String desiredRoomId, int numOfRentalDays,
            LocalDate startDate, LocalDate checkOutDate
    ) {
        this.reservationId = reservationId;
        this.nationalId = nationalId;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.desiredRoomId = desiredRoomId;
        this.numOfRentalDays = numOfRentalDays;
        this.startDate = startDate;
        this.checkOutDate = checkOutDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesiredRoomId() {
        return desiredRoomId;
    }

    public void setDesiredRoomId(String desiredRoomId) {
        this.desiredRoomId = desiredRoomId;
    }

    public int getNumOfRentalDays() {
        return numOfRentalDays;
    }

    public void setNumOfRentalDays(int numOfRentalDays) {
        this.numOfRentalDays = numOfRentalDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getDelete() {
        return deleted;
    }

    // Soft delete a guest
    public void deleteGuest() {
        this.deleted = 1;
    }

    /*
     * ##############
     * To file String
     * ##############
     */
    public String toFileString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(acceptable.DATETIME_FORMAT);
        return reservationId + ";"
                + nationalId + ";"
                + fullname + ";"
                + birthdate.format(formatter) + ";"
                + gender + ";"
                + phoneNumber + ";"
                + desiredRoomId + ";"
                + numOfRentalDays + ";"
                + startDate.format(formatter) + ";"
                + checkOutDate.format(formatter) + ";"
                + deleted;
    }

    /*
     * ##################
     * Display guest info
     * ##################
     */
    public String display() {
        return String.format(
                """
                  Fullname        : %s
                  Phone Number    : %s
                  Birth Day       : %s
                  Gender          : %s
                -------------------------------------------------------------------------------------
                  Rental room     : %s
                  Start date      : %s
                  Rental days     : %s
                  Check out       : %s
                -------------------------------------------------------------------------------------
                """,
                fullname, phoneNumber, birthdate, gender, desiredRoomId, startDate, numOfRentalDays, checkOutDate);
    }
}
