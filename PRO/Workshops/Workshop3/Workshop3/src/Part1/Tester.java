/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

/**
 *
 * @author jso
 */
public class Tester {
    public static void main(String[] args) {
        Car c = new Car();
        
        c.pressStartButton();
        c.pressAcceleratorButton();
        c.output();
        
        Car c2 = new Car("red", 100, true, true);
        
        c2.pressAcceleratorButton();
        c2.setColour("black");
        System.out.println("Colour of c3: " + c2.getColour());
        c2.output();
    }
}
