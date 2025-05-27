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
public class orders {

    private String orderId;
    private String customerId;
    private String setMenuId;
    private int numberOfTables;
    private Date eventDate;

    public orders() {
    }

    public orders(String orderId, String customerId, String setMenuId, int numberOfTables, Date eventDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.setMenuId = setMenuId;
        this.numberOfTables = numberOfTables;
        this.eventDate = eventDate;
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
}
