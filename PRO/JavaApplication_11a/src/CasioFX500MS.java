/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class CasioFX500MS implements ICalculator, ISort {

    @Override
    public double add(int a, int b) {
        return a+b;
    }

    @Override
    public double substract(int a, int b) {
        return a-b;
    }

    @Override
    public void x() {
        System.out.println("123");
    }

    @Override
    public void sortAsc() {
        System.out.println("1");
    }

    @Override
    public void sortDecs() {
        System.out.println("2");
    }
    
}
