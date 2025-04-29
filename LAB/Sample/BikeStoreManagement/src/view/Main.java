/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import services.ProductService;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        ProductService ps = new ProductService();
        int maxAttempts = 5;

        while (true) {
            try {
                while (true) {
                    try {
                        System.out.println("=====================================================");
                        System.out.println("         \u001B[1;36mBIKE STORES MANAGEMENT SYSTEM\u001B[0m         ");
                        System.out.println("=====================================================");
                        System.out.println(" \u001B[1;32m1.\u001B[0m \u001B[1;37mAdd\u001B[0m");
                        if (!ps.isEmpty()) {
                            System.out.println(" \u001B[1;32m2.\u001B[0m \u001B[1;37mSearch\u001B[0m");
                            System.out.println(" \u001B[1;32m3.\u001B[0m \u001B[1;37mUpdate\u001B[0m");
                            System.out.println(" \u001B[1;32m4.\u001B[0m \u001B[1;37mDelete\u001B[0m");
                            System.out.println(" \u001B[1;32m5.\u001B[0m \u001B[1;37mSave to file\u001B[0m");
                            System.out.println(" \u001B[1;32m6.\u001B[0m \u001B[1;37mPrint products from file\u001B[0m");
                        }
                        System.out.println(" \u001B[1;32m7.\u001B[0m \u001B[1;37mExit the program\u001B[0m");
                        System.out.println("=====================================================");
                        int wrongAttempts = 0;
                        int choice = -1;

                        // Gửi thông báo nhập choice với số lần còn lại
                        String prompt = "Enter your choice";

                        // Gọi hàm getInt và hiển thị số lần còn lại cho đến khi người dùng nhập đúng
                        choice = Validation.getInt(prompt, 1, 7, maxAttempts);

                        switch (choice) {
                            case 1:
                                ps.addProduct();
                                break;
                            case 2:
                                ps.searchProduct();
                                break;
                            case 3:
                                ps.updateProduct();
                                break;
                            case 4:
                                ps.deleteProduct();
                                break;
                            case 5:
                                ps.saveFile();
                                break;
                            case 6:
                                ps.printAllProducts();
                                break;
                            case 7:
                                System.out.println("Exit the program!");
                                return;
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage()); // Thông báo lỗi và quay lại menu chính
                        break; // Thoát khỏi vòng lặp nếu vượt quá số lần nhập sai
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()); // Quay lại menu chính
            }
        }
    }

}
