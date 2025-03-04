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
public class Statue extends Item {

    private int weight;
    public String colour;

    public Statue() {
    }

    public Statue(int value, String colour, int weight, String creator) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void output() {
        this.output();
        System.out.println("Weight: " + this.getWeight());
        System.out.println("Colour: " + this.getColour());
    }

    public void input() {
        this.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Weight: ");
        weight = sc.nextInt();

        System.out.print("Input colour: ");
        sc = new Scanner(System.in);
        colour = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Statue{" + "weight=" + weight + ", colour=" + colour + '}';
    }

}
