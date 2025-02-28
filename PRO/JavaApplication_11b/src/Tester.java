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
        Circle c = new Circle(10,10, 5);
        System.out.println(c.area());
        
        Shape s1 = new Circle(10, 10, 5);
        System.out.println(s1.area());
        
        Shape s2 = new Shape(0, 0) {
            @Override
            public double area() {
                return 0;
            }
        };
    }
}
