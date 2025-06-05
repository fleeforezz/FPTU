/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author jso
 */
public class guests {

    private String reservationId;
    private int nationalId;
    private String fullname;
    private Date birthdate;
    private String gender;
    private int phoneNumber;
    private String desiredRoomId;
    private int numOfRentalDays;
    private Date startDate;

    public guests() {
    }

    public guests(String reservationId, int nationalId, String fullname, Date birthdate, String gender, int phoneNumber, String desiredRoomId, int numOfRentalDays, Date startDate) {
        this.reservationId = reservationId;
        this.nationalId = nationalId;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.desiredRoomId = desiredRoomId;
        this.numOfRentalDays = numOfRentalDays;
        this.startDate = startDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
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

    

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /*
     * ##################
     * Display guest info
     * ##################
     */
    public String display() {
        return String.format(
                """
                National ID: %s
                Fullname: %s
                BirthDate: %s
                Gender: %s
                Phone Number: %s
                Desired Room ID: %s
                Number of rental days: %s
                Start date: %s
                """,
                nationalId, fullname, birthdate, gender, phoneNumber, desiredRoomId, numOfRentalDays, startDate);
    }
}
