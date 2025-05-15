package sample.dto;

import sample.utils.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
public abstract class Product {
    private String code;
    private String name;
    private String make;
    private double price;

    @Override
    public boolean equals(Object obj) {
        Product p= (Product) obj;
        return this.code.equals(p.code);
    }

    public Product() {
    }

    public Product(String code, String name, String make, double price) {
        this.code = code;
        this.name = name;
        this.make = make;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void display(){
        System.out.print("Product{" + "code=" + code + ", name=" + name + ", make=" + make + ", price=" + price  );
    }

    public boolean create(){
        boolean check= false;
        try {
            this.name= Utils.getString("Input name: ");
            this.make= Utils.getString("Input make: ");
            this.price= Utils.getDouble("Input price: ", Utils.MIN, Utils.MAX);
            check= true;
        } catch (Exception e) {
        }
        return check;
    }

}
