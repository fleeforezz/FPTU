/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jso
 */
public class rooms {

    private String roomId;
    private String roomName;
    private String roomType;
    private double dailyRate;
    private int capacity;
    private String furnitureDescription;

    public rooms() {
    }

    public rooms(String roomId, String roomName, String roomType, double dailyRate, int capacity, String furnitureDescription) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.dailyRate = dailyRate;
        this.capacity = capacity;
        this.furnitureDescription = furnitureDescription;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFurnitureDescription() {
        return furnitureDescription;
    }

    public void setFurnitureDescription(String furnitureDescription) {
        this.furnitureDescription = furnitureDescription;
    }

    /*
     * #################
     * Display room info
     * #################
     */
    public String display() {
        return String.format(
                """
                Room ID: %s
                Room Name: %s
                Room Type: %s
                Daily Rate: %f
                Capacity: %s
                Furniture Description: %s
                """,
                roomId, roomName, roomType, dailyRate, capacity, furnitureDescription);
    }

}
