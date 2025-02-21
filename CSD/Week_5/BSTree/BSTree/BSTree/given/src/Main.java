// =========================================================
// Do NOT modify this file 
// =========================================================

import java.io.*;
import java.util.*;
class Main {
   public static void main(String args[]) throws Exception {
    BSTree t = new BSTree();
    int choice;
    Scanner sca = new Scanner(System.in);
    System.out.println();
    System.out.println(" 1. Test f1 (2 mark)");
    System.out.println(" 2. Test f2 (2 mark)");
    System.out.println(" 3. Test f3 (2 mark)");
    System.out.println(" 4. Test f4 (1 mark)");
	System.out.println(" 5. Test f5 (1 mark)");
    System.out.println(" 6. Test f6 (1 mark)");
    System.out.println(" 7. Test f7 (1 mark)");
    System.out.println(" 0. Exit");
    System.out.print("    Your selection (0 -> 7): ");
    choice = sca.nextInt();
    sca.nextLine();
    if(choice==0) return;
    switch(choice) {
       case 1: t.f1();
               System.out.println("Your output:");
               Lib.viewFile("f1.txt");
               break;
       case 2: t.f2();
               System.out.println("Your output:");
               Lib.viewFile("f2.txt");
               break;
       case 3: t.f3();
               System.out.println("Your output:");
               Lib.viewFile("f3.txt");
               break;
       case 4: t.f4();
               System.out.println("Your output:");
               Lib.viewFile("f4.txt");			         
               break;
       case 5: t.f5();
               System.out.println("Your output:");
               Lib.viewFile("f5.txt");
               break;
       case 6: t.f6();
               System.out.println("Your output:");
               Lib.viewFile("f6.txt");
               break;
		case 7: t.f7();
               System.out.println("Your output:");
               Lib.viewFile("f7.txt");
       default: System.out.println("Wrong selection");
    }
     
    System.out.println();
   
   }      
 }
