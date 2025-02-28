/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jso
 */
public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;  
    }

}
