/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Scanner;

/**
 *
 * @author jso
 */
public class Main {

    public static void main(String[] args) {
//        Lift l = new Lift();
//        SpecLift s = new SpecLift();
        Lift l = new Lift("modern", 1);
        SpecLift s = new SpecLift("modern", 50, 1);

        Scanner sc = new Scanner(System.in);
        int choice = 0;

//        System.out.print("Enter type: ");
//        l.setType(sc.nextInt());
//        s.setType(sc.nextInt());
//
//        System.out.print("Enter load: ");
//        sc = new Scanner(System.in);
//        s.setLoad(sc.nextInt());

        do {
            System.out.println("1. Test toString()");
            System.out.println("2. Test setData()");
            System.out.println("3. Test getValue()");

            System.out.print("Enter TC(1,2,3): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(l.toString());
                    System.out.println(s.toString());
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        } while (choice > 0 && choice <= 3);
    }
}
