/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class ElectronicProduct extends Product {
    private String quantity;
    private String voltage;
    private String power;

    public ElectronicProduct() {
    }

    public ElectronicProduct(String code, String name, String manufacturer, double price, String quantity, String voltage, String power) {
        super(code, name, manufacturer, price);
        this.quantity = quantity;
        this.voltage = voltage;
        this.power = power;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() + quantity + ", " + voltage + ", " + power;
    }
    
    
}
