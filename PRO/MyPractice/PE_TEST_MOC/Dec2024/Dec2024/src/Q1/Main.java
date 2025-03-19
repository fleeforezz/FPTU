package Q1;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jso
 */
public class Main {

    public static void main(String[] args) {
        House h = new House("asiahouse", 120);

        Scanner sc = new Scanner(System.in);
        int choice = 0;

//        System.out.print("Enter type: ");
//        h.setType(sc.nextLine());
//
//        System.out.print("Enter area: ");
//        sc = new Scanner(System.in);
//        h.setArea(sc.nextInt());

        do {
            System.out.println("1. Test getType()");
            System.out.println("1. Test getArea()");

            System.out.print("Enter TC(1 or 2): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(h.getType());
                    break;
                case 2:
                    System.out.println(h.getArea());
                    break;
                default:
                    break;
            }

        } while (choice > 0 && choice <= 2);
    }
}
