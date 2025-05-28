/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jso
 */
public class orders implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String orderId;
    private String customerId;
    private String setMenuId;
    private int numberOfTables;
    private Date eventDate;
    private double totalCost;

    public orders() {
    }

    public orders(String orderId, String customerId, String setMenuId, int numberOfTables, Date eventDate, double totalCost) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.setMenuId = setMenuId;
        this.numberOfTables = numberOfTables;
        this.eventDate = eventDate;
        this.totalCost = totalCost;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSetMenuId() {
        return setMenuId;
    }

    public void setSetMenuId(String setMenuId) {
        this.setMenuId = setMenuId;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    
}
