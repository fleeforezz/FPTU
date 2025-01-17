
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
public class Part3 {

    public static void main(String[] args) {
                String[] list = new String[3];
        
                Scanner sc = new Scanner(System.in);
        
                for (int i = 0; i < list.length; i++) {
                    System.out.print("Enter list of name: ");
                    list[i] = sc.nextLine();
                }
                
                for (int i = 0; i < list.length; i++) {
                    String lowerCaseCoverter = list[i].toUpperCase();
                    char firstLetter = lowerCaseCoverter.charAt(0);
                    
                    System.out.print(firstLetter + lowerCaseCoverter.toLowerCase().substring(1) + " ");
                }

//        /* String */
//        String s = "nGuyeN xUan SoN";
//        System.out.println(s.toUpperCase()); // Viet hoa
//        System.out.println(s.toLowerCase()); // viet thuong
//        System.out.println(s);
//        s = s.toUpperCase();
//        System.out.println(s);
//        System.out.println(s.length()); // so tu trong string
//        String[] names1 = s.split(" "); // tach phan tu trong string
//        System.out.println(names1[0]); // lay dau dau trong string
//
//        String s1 = s.substring(5, 7); // lay phan tu bat dau tu vi tri 5 va ket thuc o vi tri 7
//        System.out.println(s1);
//
//        String s2 = s.substring(1); // lay het phan tu trong string tru phan tu dau
//        System.out.println(s2);
//
//        /* part3 */
//        int n = 3;
//        String[] list = new String[n];
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < n; i++) {
//            System.out.println("Enter a name: ");
//            sc = new Scanner(System.in);
//            list[i] = sc.nextLine();
//        }
//
//        // process
//        for (int i = 0; i < n; i++) {
//            String names[] = list[i].split(" ");
//            for (int j = 0; j < names.length; j++) {
//                names[j] = names[j].substring(0, 1).toUpperCase() + names[j].substring(1).toLowerCase();
//            }
//            list[i] = String.join(" ", names);
//        }
//
//        // output
//        for (int i = 0; i < n; i++) {
//            System.out.println(list[i]);
//        }
    }
}
