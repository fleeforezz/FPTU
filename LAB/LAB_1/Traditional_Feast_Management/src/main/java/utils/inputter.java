/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author jso
 */
public class inputter {

    public static final int MIN = 1;
    public static final int MAX = 200;

    /*
        ##########
        Get String
        ##########
     */
    public static String getString(String welcomeMessage, String errorMessage, boolean allowEmptyInput) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        String result;

        while (true) {
            System.out.print(welcomeMessage);
            result = sc.nextLine().trim();

            if (allowEmptyInput && result.isEmpty()) {
                return "";
            }

            if (result.isEmpty()) {
                System.out.println(errorMessage);
                continue;
            }

            return result;
        }
    }

    /*
        #####################
        Get String with regex
        #####################
     */
    public static String getString(String welcomeMessage, String errorMessage, String regex, boolean allowEmptyInput) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        String result;

        while (true) {
            System.out.print(welcomeMessage);
            result = sc.nextLine().trim();

            if (allowEmptyInput && result.isEmpty()) {
                return "";
            }

            if (result.isEmpty()) {
                System.out.println("Input cannot be empty");
            }

            if (!result.matches(regex)) {
                System.out.println(errorMessage);
                continue;
            }

            return result;
        }
    }

    /*
        #######
        Get Int
        #######
     */
    public static int getInt(String welcomeMessage, int min, int max, boolean allowEmptyInput) {

        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print(welcomeMessage);
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                return 0;
            }
            
            try {
                int number = Integer.parseInt(input);

                if (number < min || number > max) {
                    System.out.println("Input must be between: " + min + " and " + max + ".");
                    continue;
                }
                
                return number;

            } catch (NumberFormatException e) {
                System.out.println("Input must be a valid integer.");
            }
        }
    }

    /*
        ##########
        Get Double
        ##########
     */
    public static double getDouble(String welcome, int min, int max) {
        boolean check = true;
        double number = 0;

        do {

        } while (check || number > max || number < min);

        return number;
    }

    /*
        ###############
        Ask to continue
        ###############
     */
    public static void askToContinue(Runnable action) {
        String decision = getString(
                "Do want to continues or go back? (Y/y | N/n): ",
                "Input cannot be empty",
                false
        ).trim().toUpperCase();

        switch (decision) {
            case "Y":
                action.run();
                break;
            case "N":
                System.out.println("Returning to main menu");
                break;
            default:
                System.out.println("Invalid choice !!! Only (Y/y | N/n) are allowed");
        }
    }

    /*
        #################
        Confirm save file
        #################
     */
    public static void confirmSaveFile(String recordName, Object listToSave, String FILE_PATH) {
        String decision = getString(
                "Do you want to save this " + recordName + " to file ? (Y/y | N/n): ",
                "Input must not be empty",
                false
        ).trim().toUpperCase();

        switch (decision) {
            case "Y":
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                    oos.writeObject(listToSave);
                    System.out.println("\nCustomers saved successfully to file !!! \n");
                } catch (IOException e) {
                    System.out.println("Error saving customers to file: " + e.getMessage());
                }
                break;
            case "N":
                break;
            default:
                System.out.println("Invalid choice !!! Only (Y/y | N/n) are allowed");
        }
    }
}
