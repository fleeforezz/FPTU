/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part3;

/**
 *
 * @author jso
 */
public class Tester {
    public static void main(String[] args) {
        Guitar obj1 = new Guitar();
        Guitar obj2 = new Guitar("G123", 2000, "Sony", "Model123", "hardWood", "softWood");
        
        System.out.println("State of obj1: ");
        obj1.createSound();
        
        System.out.println("State of obj2: ");
        obj2.createSound();
        
        System.out.println("set price = 3000 of obj1");
        obj1.setPrice(3000);
        System.out.println("get price of obj1: " + obj1.getPrice());
    }
}
