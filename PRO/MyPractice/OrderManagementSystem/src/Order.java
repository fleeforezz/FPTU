
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jso
 */
public class Order implements Business<Order> {

    private String orderId;
    private String createdDate;
    private String customerName;
    private String customerAddress;
    private final List orderList = new ArrayList<>();

    private int isUpdate = 0;

    public Order() {
    }

    public Order(String orderId, String createdDate, String customerName, String customerAddress) {
        this.orderId = orderId;
        this.createdDate = createdDate;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", createdDate=" + createdDate + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", orderList=" + orderList.size() + '}';
    }

    @Override
    public int addRec(Order order) {
        boolean isAdd = orderList.add(order);
        if (isAdd) {
            return 1;
        }

        return 0;
    }

    @Override
    public int updateRec(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listAll() {
        for (Object object : orderList) {
            if (object != null) {
                System.out.println(object);
            } else {
                System.out.println("The list is empty");
            }
        }
    }

    @Override
    public Order getRecById(Order obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
