/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Customer {
    private String customerId;
    private String customerName;
    private int roleInSystem;

    public Customer() {
    }

    public Customer(String customerId, String customerName, int roleInSystem) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.roleInSystem = roleInSystem;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRoleInSystem() {
        return roleInSystem;
    }

    public void setRoleInSystem(int roleInSystem) {
        this.roleInSystem = roleInSystem;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", roleInSystem=" + roleInSystem + '}';
    }
    
    
}
