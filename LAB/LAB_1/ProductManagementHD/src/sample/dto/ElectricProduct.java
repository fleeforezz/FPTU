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
public class ElectricProduct extends Product {

    private int guaranty;
    private double voltage;
    private double power;

    public ElectricProduct() {
    }

    public ElectricProduct(String code) {
        super.setCode(code);
    }

    public ElectricProduct(String code, String name, String make, double price) {
        super(code, name, make, price);
    }

    public ElectricProduct(int guaranty, double voltage, double power) {
        this.guaranty = guaranty;
        this.voltage = voltage;
        this.power = power;
    }

    public ElectricProduct(int guaranty, double voltage, double power, String code, String name, String make, double price) {
        super(code, name, make, price);
        this.guaranty = guaranty;
        this.voltage = voltage;
        this.power = power;
    }

    public int getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(int guaranty) {
        this.guaranty = guaranty;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public void display() {
        super.display(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("guaranty=" + guaranty + ", voltage=" + voltage + ", power=" + power + '}');
    }

    @Override
    public boolean create() {
        boolean check = false;
        try {
            super.create();
            this.guaranty = Utils.getInt("Input guaranty: ", Utils.MIN, Utils.MAX);
            voltage = Utils.getDouble("Input voltage: ", Utils.MIN, Utils.MAX);
            power = Utils.getDouble("Input power: ", Utils.MIN, Utils.MAX);
            check = true;
        } catch (Exception e) {
        }
        return check;
        //To change body of generated methods, choose Tools | Templates.

    }

}
