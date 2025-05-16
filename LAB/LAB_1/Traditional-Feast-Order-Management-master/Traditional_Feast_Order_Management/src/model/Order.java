
package model;


public class Order {
    // thuộc tính của đơn hàng 
    private String order_Id; 
    private String cus_Id;
    private String menu_Id;
    private String eventDate;
    private int numberOfTable;
    private double totalCost;
   
    
    // constructor 

    public Order() {
    }

    public Order(String order_Id, String cus_Id, String menu_Id, String eventDate, int numberOfTable, double totalCost) {
        this.order_Id = order_Id;
        this.cus_Id = cus_Id;
        this.menu_Id = menu_Id;
        this.eventDate = eventDate;
        this.numberOfTable = numberOfTable;
        this.totalCost = totalCost;
    }
    
    
    //  getter và setter 

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public String getCus_Id() {
        return cus_Id;
    }

    public void setCus_Id(String cus_Id) {
        this.cus_Id = cus_Id;
    }

    public String getMenu_Id() {
        return menu_Id;
    }

    public void setMenu_Id(String menu_Id) {
        this.menu_Id = menu_Id;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCosst(double totalCost) {
        this.totalCost = totalCost;
    }
    
    // hàm in thông tin 
    
    public String toString (){
        String str = String.format("%-12s| %-12s| %-12s| %-12s| %3d| %4f", 
               order_Id , cus_Id , menu_Id , eventDate , numberOfTable , totalCost );
        return str;
    }
}
