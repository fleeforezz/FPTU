/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Tester {
    public static void main(String[] args) {
        ICalculator c = new CasioFX500MS();
        
        ICalculator c1 = new DeliW1710();
        
        CasioFX500MS c3 = new CasioFX500MS();
    }
}
