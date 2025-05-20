/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TFM.utils;

import java.util.Scanner;

/**
 *
 * @author jso
 */
public class Utils {

    public static final int MIN = 1;
    public static final int MAX = 200;

    /*
        ##########
        Get String
        ##########
     */
    public static String getString(String welcomeMessage, String errorMessage) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        String result;

        while (true) {
            System.out.print(welcomeMessage);
            result = sc.nextLine().trim();

            if (result.isEmpty()) {
                System.out.println(errorMessage);
                continue;
            }

            return result;
        }
    }
    
    /*
        ##########
        Get String with regex
        ##########
     */
    public static String getString(String welcomeMessage, String errorMessage, String regex) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        String result;

        while (true) {
            System.out.print(welcomeMessage);
            result = sc.nextLine().trim();

            if (result.isEmpty()) {
                System.out.println("Input must not be empty");
                continue;
            }
            
            if (!result.matches(regex)) {
                System.out.println(errorMessage);
                continue;
            }

            return result;
        }
    }

    /*
        #############
        Update String
        #############
     */
    public static String updateString(String welcome, String oldData) {
        String result = oldData;

        Scanner sc = new Scanner(System.in);

        System.out.print(welcome);
        String tmp = sc.nextLine();

        if (!tmp.isEmpty()) {
            result = tmp;
        }

        return result;
    }

    /*
        #######
        Get Int
        #######
     */
    public static int getInt(String welcome, int min, int max) {
        
        Scanner sc = new Scanner(System.in);

        boolean check = true;
        int number = 0;

        do {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number");
            }
        } while (check || number > max || number < min);

        return number;
    }

    /*
        #############
        Update Int
        #############
     */
    public static int updateInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;

        do {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.print(welcome);
                String tmp = sc.nextLine();

                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input must be a number");
            }
        } while (check || number > max || number < min);

        return number;
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
}
