/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class Validation {

    public static String getString(String welcome, String msg, boolean allowEmpty) {
        String result;
        Scanner sc = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.print(welcome);
            result = sc.nextLine().trim();

            // Nếu cho phép nhập trống và người dùng không nhập gì -> Trả về chuỗi rỗng
            if (allowEmpty && result.isEmpty()) {
                return "";
            }

            // Nếu không cho phép nhập trống và người dùng để trống -> In thông báo
            if (result.isEmpty()) {
                System.out.println(msg);
            } else {
                break; // Kết thúc vòng lặp nếu nhập hợp lệ
            }
        }
        return result;
    }

    public static boolean isValidInput(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be empty!");
            return false;
        }

        // Biểu thức chính quy cho phép ký tự Unicode (bao gồm cả dấu) và khoảng trắng
        Pattern pattern = Pattern.compile("^[\\p{L}\\s]+$", Pattern.UNICODE_CHARACTER_CLASS);

        if (!pattern.matcher(input).matches()) {
            System.out.println(fieldName + " can only contain letters (including accented letters)!");
            return false;
        }

        return true;
    }

    public static int getInt(String welcome, int min, int max, int maxAttempts) {
        Scanner sc = new Scanner(System.in);
        int wrongAttempts = 0;
        System.out.println("You have "+ maxAttempts + " attempts to enter choice correctly.");
        while (true) {
            // Hiển thị thông báo với số lần còn lại
            System.out.print(welcome + " (" + (maxAttempts - wrongAttempts - 1) + "/" + maxAttempts + " attempts): ");

            try {
                String input = sc.nextLine();

                // Kiểm tra xem input có phải là số hay không
                if (!input.matches("-?\\d+")) {
                    throw new NumberFormatException("Input must be a number.");
                }

                int number = Integer.parseInt(input);

                // Kiểm tra số trong phạm vi
                if (number < min || number > max) {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                    wrongAttempts++;
                } else {
                    return number; // Nếu nhập hợp lệ, trả về số nhập vào
                }

            } catch (NumberFormatException e) {
                System.out.println("Input must be a valid number!");
                wrongAttempts++;
            }

            // Kiểm tra nếu số lần nhập sai vượt quá giới hạn
            if (wrongAttempts >= maxAttempts) {
                System.out.println("Too many invalid attempts. Returning to the menu.");
                throw new RuntimeException("Exceeded maximum attempts.");
            }
        }
    }

    public static double getDouble(String welcome, double min) {
        boolean check = true;
        double number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                if (number < min) {
                    System.out.println("Number must be larger than " + min);
                } else {
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (check);
        return number;
    }

}
