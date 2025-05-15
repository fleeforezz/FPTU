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
public class CeramicProduct extends Product{
    private String type;

    public CeramicProduct() {
    }

    public CeramicProduct(String type) {
        this.type = type;
    }

    public CeramicProduct(String type, String code, String name, String make, double price) {
        super(code, name, make, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CeramicProduct{" + "type=" + type + '}';
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose To
        System.out.println(", type=" + type+ '}');
    }

    @Override
    public boolean create() {
        boolean check= false;
        try {
            super.create();
            this.type= Utils.getString("Input type: ");
            check= true;
        } catch (Exception e) {
        }
        return check;
        //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
}
