// =========================================================
// Do NOT modify this file 
// =========================================================

import java.io.*;
import java.util.*;

class Main {

    public static void main(String args[]) throws Exception {

        MyList t = new MyList();

        //Display the menu contains a list of possibble choices
        printMenu();

        Scanner sca = new Scanner(System.in);
        int choice = sca.nextInt();
        sca.nextLine();

        switch (choice) {
            case 0:
                return;
            case 1:
                t.f1();
                System.out.println("Your output:");
                Lib.viewFile("f1.txt");
                break;
            case 2:
                t.f2();
                System.out.println("Your output:");
                Lib.viewFile("f2.txt");
                break;
            case 3:
                t.f3();
                System.out.println("Your output:");
                Lib.viewFile("f3.txt");
                break;
            case 4:
                t.f4();
                System.out.println("Your output:");
                Lib.viewFile("f4.txt");
                break;
            case 5:
                t.f5();
                System.out.println("Your output:");
                Lib.viewFile("f5.txt");
                break;
            case 6:
                t.f6();
                System.out.println("Your output:");
                Lib.viewFile("f6.txt");
                break;
            case 7:
                t.f7();
                System.out.println("Your output:");
                Lib.viewFile("f7.txt");
                break;
            case 8:
                t.f8();
                System.out.println("Your output:");
                Lib.viewFile("f8.txt");
                break;
            case 9:
                t.f9();
                System.out.println("Your output:");
                Lib.viewFile("f9.txt");
                break;
            case 10:
                t.f10();
                System.out.println("Your output:");
                Lib.viewFile("f10.txt");
                break;

            default:
                System.out.println("Invalid choice");
        }

        System.out.println();
    }

    private static void printMenu() {
        System.out.println("=============MENU=============");
        System.out.println("1. Test f1 ");
        System.out.println("2. Test f2 ");
        System.out.println("3. Test f3 ");
        System.out.println("4. Test f4 ");
        System.out.println("5. Test f5 ");
        System.out.println("6. Test f6 ");
        System.out.println("7. Test f7 ");
        System.out.println("8. Test f8 ");
        System.out.println("9. Test f9 ");
        System.out.println("10. Test f10 ");
        System.out.println("0. Exit");
        System.out.println("==============================");
        System.out.print("Enter your choice [0 --> 10]: ");
    }
}
