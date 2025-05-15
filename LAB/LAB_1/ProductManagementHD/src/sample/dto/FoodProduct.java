/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import sample.utils.Utils;

/**
 *
 * @author hoadoan
 */
public class FoodProduct extends Product {

    private String productDate;
    private String expiredDate;

    public FoodProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
        System.out.println(", productDate=" + productDate + ", expiredDate=" + expiredDate + '}');
    }

    public FoodProduct(String productDate, String expiredDate) {
        this.productDate = productDate;
        this.expiredDate = expiredDate;
    }

    public FoodProduct(String productDate, String expiredDate, String code, String name, String make, double price) {
        super(code, name, make, price);
        this.productDate = productDate;
        this.expiredDate = expiredDate;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public boolean create() {
        boolean check = false;
        try {
            super.create();
            productDate = Utils.getString("Input productDate: ");
            expiredDate = Utils.getString("Input expiredDate: ");
            check = true;
        } catch (Exception e) {
        }
        return check;
        //To change body of generated methods, choose Tools | Templates.

    }

}
