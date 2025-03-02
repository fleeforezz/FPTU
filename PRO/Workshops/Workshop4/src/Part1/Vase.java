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
public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int value, String material, int height, String creator) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    public void outputVase() {
        output();
        System.out.println("Height: " + this.getHeight());
        System.out.println("Material: " + this.getMaterial());
    }
    
    public void inputVase() {
        input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input height: ");
        this.height = sc.nextInt();
        
        System.out.print("Input material: ");
        sc = new Scanner(System.in);
        this.material = sc.nextLine();
    }
    
    
}
