/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

import java.util.Scanner;

/**
 *
 * @author jso
 */
public class Painting extends Item {

    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(int height, String creator, int width, int value, boolean isWatercolour, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    public void output() {
        this.output();
        System.out.println("Height: " + this.getHeight());
        System.out.println("Width: " + this.getWidth());
        System.out.println("isWatercolour: " + this.isWatercolour);
        System.out.println("isFramed: " + this.isFramed);
    }

    public void input() {
        this.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input height: ");
        height = sc.nextInt();

        System.out.print("Input width: ");
        sc = new Scanner(System.in);
        width = sc.nextInt();

        System.out.print("Input IsWaterColour: ");
        isWatercolour = sc.nextBoolean();

        System.out.print("Input IsFramed: ");
        isFramed = sc.nextBoolean();
    }

    @Override
    public String toString() {
        return "Painting{" + "height=" + height + ", width=" + width + ", isWatercolour=" + isWatercolour + ", isFramed=" + isFramed + '}';
    }

}
