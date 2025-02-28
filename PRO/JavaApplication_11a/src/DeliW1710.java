/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class DeliW1710 implements ICalculator{

    @Override
    public double add(int a, int b) {
        return b + a;
    }

    @Override
    public double substract(int a, int b) {
        return a - b;
    }

    @Override
    public void x() {
        System.out.println("ABC");
    }
    
}
