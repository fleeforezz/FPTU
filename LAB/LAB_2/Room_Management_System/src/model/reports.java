/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jso
 */
public class reports {

    private String reportId;
    private String roomId;
    private String roomName;
    private String roomType;
    private double dailyRate;
    private double amount;

    public reports() {
    }

    public reports(String reportId, String roomId, String roomName, String roomType, double dailyRate, double amount) {
        this.reportId = reportId;
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.dailyRate = dailyRate;
        this.amount = amount;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String displayFull() {
        return String.format(
                """
                %-7s | %-16s | %-8s | %10.2f | %10.2f
                """,
                roomId, roomName, roomType, dailyRate, amount
        );
    }
    
    public String displayByRoomType() {
        return String.format(
                """
                %-8s | %10.2f
                """,
                roomType, amount
        );
    }
}
