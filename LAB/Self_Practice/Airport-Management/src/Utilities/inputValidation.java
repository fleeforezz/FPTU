package Utilities;

import java.util.Scanner;

public class inputValidation {


    /*
    *########## 
    * String
    *##########
    */
    public static String getString(String welcome, String msg, boolean allowEmpty) {

        String result;

        Scanner sc = new Scanner(System.in, "UTF-8");

        while (true) {
            System.out.print(welcome);
            result = sc.nextLine().trim();

            if (allowEmpty && result.isEmpty()) {
                return "";
            }

            if (!result.isEmpty()) {
                System.out.println(msg);
            } else {
                break;
            }
        }

        return result;
    }

    /*
    *########## 
    * Integer
    *##########
    */
    public static int getInt(String welcome, int min, int max, int maxAttempts) {

        Scanner sc = new Scanner(System.in);

        int wrongAttempts = 0;

        System.out.println("You have " + maxAttempts + " attemps to enter correctly");

        while (true) {
            System.out.println(welcome + " (" + (maxAttempts - wrongAttempts - 1) + "/" + maxAttempts + " attemps): ");

            try {
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
